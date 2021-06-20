package com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu;

import com.HauvongMC.Items.SubMenu.SubMenu.SubMenu.SkywarsStatusItems;
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

public class SkywarsStatusMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps, Itemlore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "SkyWars");
        new SkywarsStatusItems(p);
        if (!GetPlayerData.getInfo(p.getName(), "Rank").equalsIgnoreCase("Default")) {
            inventory.setItem(10, SkywarsStatusItems.getLevel());
            inventory.setItem(11, SkywarsStatusItems.getKills());
            inventory.setItem(12, SkywarsStatusItems.getWins());
            inventory.setItem(13, SkywarsStatusItems.getSouls());
        } else {
            inventory.setItem(10, SkywarsStatusItems.getLevel());
            inventory.setItem(11, SkywarsStatusItems.getKills());
            inventory.setItem(12, SkywarsStatusItems.getWins());
            inventory.setItem(13, SkywarsStatusItems.getSouls());
        }
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
            itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại trạng thái");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(49, itemStack);
        }
        p.openInventory(inventory);
    }
}
