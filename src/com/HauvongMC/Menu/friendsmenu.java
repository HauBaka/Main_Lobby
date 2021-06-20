package com.HauvongMC.Menu;

import com.HauvongMC.Items.FriendsItems;
import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class friendsmenu {
    private static Inventory inventory;
    private static ItemStack itemStack, next, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, nextlore, previouslore;
    private static ItemMeta itemMeta, nextmeta, previousItemMeta;
    private static String guild, testguild, friend;
    private static String[] friends;
    private static int start, slot;
    public static void openMain(Player p, boolean search, String player, int pages) {
        //header
        inventory = Bukkit.createInventory(p, 54, "Bạn bè");
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(p.getName());
        head.setDisplayName(p.getDisplayName());
        itemLore  = new ArrayList<>();
        guild = "§cnull";
        testguild = GetPlayerData.getInfo(p.getName(), "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Cấp Độ LuckyMCVN:§6 " + p.getLevel());
        itemLore.add("§7Điểm thành tựu:§e " + GetPlayerData.getInfo(p.getName(), "Achievement_Points"));
        itemLore.add("§7Băng đảng: §b" + guild);
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        inventory.setItem(2, itemStack);
        inventory.setItem(3, MenuItems.getFriends());
        inventory.setItem(4, MenuItems.getParty());
        inventory.setItem(5, MenuItems.getGuild());
        inventory.setItem(6, MenuItems.getRecentplayers());
        for (int i = 9; i < 18; i++) {
            inventory.setItem(i, MenuItems.getPurple());
        }
        //body
        inventory.setItem(18, FriendsItems.getaddfriend());
        inventory.setItem(19, FriendsItems.getRemovefriend());
        inventory.setItem(26, FriendsItems.getSearch());
        //set player
        friend = GetPlayerData.getInfo(p.getName(), "Friends");
        friends = friend.split(", ");
        f = Arrays.asList(friends);
        start = pages*27-27;
        if (pages != 1) {
             previous = new ItemStack(Material.ARROW, 1);
             previousItemMeta = previous.getItemMeta();
            previouslore = new ArrayList<>();
            previouslore.add(" ");
            pages--;
            previouslore.add("§7Quay lại trang " + pages);
            previousItemMeta.setLore(previouslore);
            previousItemMeta.setDisplayName("§aTrang trước");
            previous.setItemMeta(previousItemMeta);
            inventory.setItem(9, previous);
            pages++;
        }
        if (search == false) {
            if (friends.length >= 1 && !(friends[0].equalsIgnoreCase(""))) {
                slot = 27;
                for (int i = start; i < friends.length; i++) {
                    inventory.setItem(slot, FriendsItems.player(friends[i]));
                    slot++;
                    if (slot > 53) {
                         next = new ItemStack(Material.ARROW, 1);
                         nextmeta = next.getItemMeta();
                        nextlore = new ArrayList<>();
                        nextlore.add(" ");
                        pages++;
                        nextlore.add("§7Sang trang " + pages);
                        nextmeta.setLore(nextlore);
                        nextmeta.setDisplayName("§aTrang sau");
                        next.setItemMeta(nextmeta);
                        inventory.setItem(17, next);
                        break;
                    }
                }
            }
        } else if (search == true) {
            if (f.contains(player)) {
                slot = 27;
                inventory.setItem(slot, FriendsItems.player(player));
            } else {
                itemStack = new ItemStack(Material.GLASS_BOTTLE, 1);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§cKhông có kết quả!");
                itemLore = new ArrayList<>();
                itemLore.add("§7Không có kết quả nào khớp với");
                itemLore.add("§7'" + player + "'!");
                itemMeta.setLore(itemLore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(40, itemStack);
            }
            inventory.setItem(26, FriendsItems.getClear());
        }
        p.openInventory(inventory);
    }

    public static void addFriend(Player p) {
        p.closeInventory();
        p.sendMessage("§aNhập tên người chơi");
        Main.chatinput.replace(p, 2);
    }

    public static void removeFriend(Player p) {
        p.closeInventory();
        p.sendMessage("§aNhập tên người chơi");
        Main.chatinput.replace(p, 3);
    }
    public static void searchFriend(Player p) {
        p.closeInventory();
        p.sendMessage("§aNhập tên người chơi");
        Main.chatinput.replace(p, 1);
    }

}
