package com.HauvongMC.Menu;

import com.HauvongMC.Items.FriendsItems;
import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Items.PartyItems;
import com.HauvongMC.Items.RecentPlayersItems;
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

public class recentplayersmenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, boolean search, String player) {
        //header
         inventory = Bukkit.createInventory(p, 54, "Người chơi gần đây");
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
            inventory.setItem(i, MenuItems.getBlue());
        }
        //body
        inventory.setItem(18, RecentPlayersItems.getClearcache());
        inventory.setItem(26, RecentPlayersItems.getSearch());
         listrecents = GetPlayerData.getInfo(p.getName(), "Recent_Players");
         players = listrecents.split(", ");
         Ps = Arrays.asList(players);
        if (search == true) {
            if (Ps.contains(player+"-Skywars") || Ps.contains(player+"-Bedwars")) {
                String server = "null";
                if (Ps.contains(player+"-Skywars")) server = "Skywars";
                if (Ps.contains(player+"-Bedwars")) server = "Bedwars";
                inventory.setItem(27, RecentPlayersItems.player(player, server));
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
            inventory.setItem(26, RecentPlayersItems.getClearsearch());
        } else {
            if (players[0] != "" && players.length >= 1) {
                int slot = 27;
                for (int i =0; i < players.length; i++) {
                    String[] info = players[i].split("-");//player = info[0], server = info[1]
                    inventory.setItem(slot, RecentPlayersItems.player(info[0], info[1]));
                    slot++;
                    if (slot > 54) {
                        break;
                    }
                }
            }
        }
        p.openInventory(inventory);
    }

    public static void searchPlayer(Player p) {
        p.closeInventory();
        p.sendMessage("§aNhập tên người chơi");
        Main.chatinput.replace(p, 4);
    }
}
