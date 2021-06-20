package com.HauvongMC.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

import static com.HauvongMC.Main.updates;

public class UpdatesMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous, back;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, int pages) {
        slot = 9;
        int previus = pages - 1;
        int next = pages + 1;
        //
         back = new ItemStack(Material.ARROW, 1);
         itemMeta =  back.getItemMeta();
        itemMeta.setDisplayName("§aQuay lại");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Quay lại trang " + previus);
        itemMeta.setLore(itemLore);
        back.setItemMeta(itemMeta);
        //
        ItemStack gonext = new ItemStack(Material.ARROW, 1);
        itemMeta =  back.getItemMeta();
        itemMeta.setDisplayName("§aTrang sau");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Tới trang " + next);
        itemMeta.setLore(itemLore);
        gonext.setItemMeta(itemMeta);
        //
        inventory = Bukkit.createInventory(p, 54, "LuckyMCVN Updates | Page " + pages);
        int currentindex = pages * 28;
        if (pages >= 1) inventory.setItem(45, back);
        for (int i = currentindex; i < updates.size(); i++) {
            slot++;
            if (slot == 17 || slot == 26 || slot == 35) slot+=2;
            if (slot >= 44) {
                inventory.setItem(53, gonext);

            } else {
                inventory.setItem(slot, updates.get(i));
            }
        }
        p.openInventory(inventory);
    }
}
