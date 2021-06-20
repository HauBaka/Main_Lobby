package com.HauvongMC.Menu.SubMenu;

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
import java.util.List;

public class StatsViewer {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p ) {
         inventory = Bukkit.createInventory(p, 54, "Xem hồ sơ");
        //skywars
         itemStack = new ItemStack(Material.ENDER_PEARL);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        if (GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo") == null) {
            itemLore.add("§7Tổng Thắng:§a ???");
            itemLore.add("§7Solo Thắng: §a???");
            itemLore.add("§7Team Thắng: §a???");
            itemLore.add("§7Ranked Thắng: §a???");
            itemLore.add("§7");
            itemLore.add("§7Tổng Giết: §a???");
            itemLore.add("§7Solo Giết: §a???");
            itemLore.add("§7Team Giết: §a???");
            itemLore.add("§7Ranked Giết: §a???");
            itemLore.add("§7");
            itemLore.add("§7Điểm Ranked: §a???");
            itemLore.add("§7Top Ranked: §a#???");
            itemLore.add("§7");
            itemLore.add("§7Souls: §a???");
            itemLore.add("§7");
            itemLore.add("§cVui lòng vào máy chủ SkyWars để");
            itemLore.add("§cchúng tôi có thể thêm thông tin");
            itemLore.add("§ccủa bạn vào dữ liệu máy chủ.");
        } else {
            int wins = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wTeam")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wMega"));
            itemLore.add("§7Tổng Thắng:§a " + wins);
            itemLore.add("§7Solo Thắng: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo"));
            itemLore.add("§7Team Thắng: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wTeam"));
            itemLore.add("§7Ranked Thắng: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wMega"));
            itemLore.add("§7");
            itemLore.add("§7Tổng giết: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kSolo"));
            itemLore.add("§7Solo Giết: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kSolo"));
            itemLore.add("§7Team Giết: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kTeam"));
            itemLore.add("§7Ranked Giết: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kMega"));
            itemLore.add("§7");
            itemLore.add("§7Điểm Ranked: §a0");
            itemLore.add("§7Top Ranked: §a#None");
            itemLore.add("§7");
            itemLore.add("§7Souls: §a" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "souls"));
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aHồ sơ SkyWars");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(10, itemStack);
        inventory.setItem(49, MenuItems.getBack());
        p.openInventory(inventory);
    }
}
