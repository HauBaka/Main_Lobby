package com.HauvongMC.Menu.SubMenu.SubMenu;

import com.HauvongMC.Items.SubMenu.SubMenu.StatusItems;
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

public class StatusMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps, Itemlore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "Trạng thái");
        inventory.setItem(3, StatusItems.getMvppp());
        inventory.setItem(4, StatusItems.getGeneral());
        inventory.setItem(10, StatusItems.getSkywars());
        inventory.setItem(11, StatusItems.getBedwars());
        inventory.setItem(48, StatusItems.getReset());
        if (GetPlayerData.getInfo(p.getName(), "Head_Status_Toggle").equalsIgnoreCase("0")) {
            inventory.setItem(50, StatusItems.getToggleoff());
        } else inventory.setItem(50, StatusItems.getToggleon());
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
             itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại Tùy chỉnh giao diện");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(49, itemStack);
        }
        p.openInventory(inventory);
    }
}
