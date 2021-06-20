package com.HauvongMC.Menu.SubMenu;

import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Items.SubMenu.AppearancesItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class AppearancesMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p) {
        inventory = Bukkit.createInventory(p, 36, "Tùy chỉnh giao diện");
        inventory.setItem(11, AppearancesItems.getRankcolor());
        inventory.setItem(13, AppearancesItems.getPunchmessage());
        inventory.setItem(15, AppearancesItems.getStatus());
        inventory.setItem(31, MenuItems.getBack());
        p.openInventory(inventory);
    }
}
