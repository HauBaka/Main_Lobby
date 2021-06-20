package com.HauvongMC.Menu;

import com.HauvongMC.Items.MenuItems;
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

public class ProfileViewer {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank;
    private static String[] friends;
    private static int start, slot;
    public static void openMain(Player p, String target) {
        String name = GetPlayerData.getInfo(target, "Name");
        if (name.equalsIgnoreCase(p.getName())) {
            myprofilemenu.openMain(p);
            return;
        }
        if (name != null && !(name.equalsIgnoreCase(""))) {
             inventory = Bukkit.createInventory(p, 54, "Hồ sơ của " + name);
             itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
             head = (SkullMeta) itemStack.getItemMeta();
            head.setOwner(name);
            head.setDisplayName(GetPlayerData.getInfo(name, "Prefix") + name);
             itemLore  = new ArrayList<>();
             guild = "§cnull";
             testguild = GetPlayerData.getInfo(name, "Guild");
            if (testguild != null && testguild != "")  {
                guild = testguild;
            }
            itemLore.add("§7Điểm thành tựu:§e " + GetPlayerData.getInfo(name, "Achievement_Points"));
            itemLore.add("§7Băng đảng: §b" + guild);
            head.setLore(itemLore);
            itemStack.setItemMeta(head);
            inventory.setItem(0, itemStack);
            //
            itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            head = (SkullMeta) itemStack.getItemMeta();
            head.setOwner(p.getName());
            head.setDisplayName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName());
            itemLore  = new ArrayList<>();
            guild = "§cnull";
            testguild = GetPlayerData.getInfo(p.getName(), "Guild");
            if (testguild != null && testguild != "")  {
                guild = testguild;
            }
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
                inventory.setItem(i, MenuItems.getGreen());
            }
            //social media
            itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            head = (SkullMeta) itemStack.getItemMeta();
            head.setOwner("Ibszi");
            head.setDisplayName("§aMạng xã hội của " + name);
            itemLore  = new ArrayList<>();
            itemLore.add("§7Nhấp vào để xem các link");
            itemLore.add("§7Mạng Xã Hội của " + name);
            head.setLore(itemLore);
            itemStack.setItemMeta(head);
            inventory.setItem(21, itemStack);
            //report
            itemStack = new ItemStack(Material.PAPER, 1);
             itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§aTố cáo " + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(22, itemStack);
            //party
            itemStack = new ItemStack(Material.DIAMOND, 1);
            itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§aMời vào nhóm");
            itemLore  = new ArrayList<>();
            itemLore.add("§7Nhấp để mời " + name);
            itemLore.add("§7vào nhóm của bạn.");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);

            inventory.setItem(23, itemStack);
            //friend
             friend = GetPlayerData.getInfo(p.getName(), "Friends");
             friends = friend.split(", ");
             f = Arrays.asList(friends);
            if (f.contains(target)) {
                itemStack = new ItemStack(Material.REDSTONE_BLOCK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§cXóa khỏi danh sách bạn bè");
                itemLore  = new ArrayList<>();
                itemLore.add("§7Nhấp để xóa " + name);
                itemLore.add("§7khỏi danh sách bạn bè.");
                itemMeta.setLore(itemLore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(30, itemStack);
            } else {
                itemStack = new ItemStack(Material.BOOK_AND_QUILL, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§aThêm bạn");
                itemLore  = new ArrayList<>();
                itemLore.add("§7Nhấp để thêm " + name);
                itemLore.add("§7vào danh sách bạn bè.");
                itemMeta.setLore(itemLore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(30, itemStack);
            }
            if (guild.equalsIgnoreCase("§cnull")) {
                ItemStack glass = MenuItems.getGray();
                ItemMeta glassmeta = glass.getItemMeta();
                glassmeta.setDisplayName("§aMời vào băng đảng");
                glass.setItemMeta(glassmeta);
                inventory.setItem(31, glass);
            } else {
                String themguild = GetPlayerData.getInfo(target, "Guild");
                if (themguild == null || themguild.equalsIgnoreCase("")) {
                    itemStack = new ItemStack(Material.SLIME_BALL, 1);
                    itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName("§aMời vào băng đảng");
                    itemLore  = new ArrayList<>();
                    itemLore.add("§7Nhấp để mời " + name);
                    itemLore.add("§7vào băng đảng.");
                    itemMeta.setLore(itemLore);
                    itemStack.setItemMeta(itemMeta);
                    inventory.setItem(30, itemStack);
                } else {
                    ItemStack glass = MenuItems.getGray();
                    ItemMeta glassmeta = glass.getItemMeta();
                    glassmeta.setDisplayName("§cMời vào băng đảng");
                    List<String> glasslore = new ArrayList<>();
                    glasslore.add("§7Bạn không thể mời " + target);
                    glasslore.add("§7vào băng đảng của bạn vì người chơi đó");
                    glasslore.add("§7đang ở trong 1 băng đảng!");
                    glassmeta.setLore(glasslore);
                    glass.setItemMeta(glassmeta);
                    inventory.setItem(31, glass);
                }
            }
            p.openInventory(inventory);
        } else p.sendMessage("§cKhông tìm thấy người chơi " + target);
    }
}
