package com.HauvongMC.Menu.SubMenu.SubMenu;

import com.HauvongMC.Items.SubMenu.SubMenu.PunchMessageItems;
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

public class PunchMessagesMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;


    private static String selected = "§aĐã chọn";
    private static String clicktoselect = "§eNhấp để chọn!";
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "Hiệu ứng đấm Staff");
         rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Default")
            || rank.equalsIgnoreCase("VIP")
            || rank.equalsIgnoreCase("VIP+")
            || rank.equalsIgnoreCase("MVP")) {
            new PunchMessageItems();
            inventory.setItem(10, PunchMessageItems.getLoving());
            inventory.setItem(11, PunchMessageItems.getBoop());
            inventory.setItem(12, PunchMessageItems.getGlorious());
            inventory.setItem(13, PunchMessageItems.getSnowball());
        } else {
            String currentselect = GetPlayerData.getInfo(p.getName(), "Punch_Message");
            new PunchMessageItems();
             itemStack = PunchMessageItems.getLoving();
             itemMeta = itemStack.getItemMeta();
             itemLore = itemMeta.getLore();
            if (currentselect.equalsIgnoreCase("Loving")) {
                itemLore.set(itemLore.size() -1, selected);
            } else itemLore.set(itemLore.size() -1, clicktoselect);
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(10, itemStack);
            //boop
            itemStack = PunchMessageItems.getBoop();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            if (currentselect.equalsIgnoreCase("Boop")) {
                itemLore.set(itemLore.size() -1, selected);
            } else itemLore.set(itemLore.size() -1, clicktoselect);
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(11, itemStack);
            //glorious
            itemStack = PunchMessageItems.getGlorious();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            if (currentselect.equalsIgnoreCase("Glorious")) {
                itemLore.set(itemLore.size() -1, selected);
            } else itemLore.set(itemLore.size() -1, clicktoselect);
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(12, itemStack);
            //snowball
            itemStack = PunchMessageItems.getSnowball();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            if (currentselect.equalsIgnoreCase("SnowBall")) {
                itemLore.set(itemLore.size() -1, selected);
            } else itemLore.set(itemLore.size() -1, clicktoselect);
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(13, itemStack);
        }
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
            itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại tùy chỉnh giao diện");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(49, itemStack);
        }
         itemStack = new ItemStack(Material.BARRIER, 1);
         itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§cĐặt lại hiệu ứng đấm STAFF");
        itemLore  = new ArrayList<>();
        String currentselect = GetPlayerData.getInfo(p.getName(), "Punch_Message");
        if (currentselect.equalsIgnoreCase("") || currentselect.equalsIgnoreCase(null)) {
            currentselect = "§cTrống";
        }
        itemLore.add("§eĐang chọn: §b" + currentselect);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(48, itemStack);
        //
        itemStack = new ItemStack(Material.BOOK, 1);
        itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aHiệu ứng đấm STAFF");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Hiệu ứng đấm STAFF như");
        itemLore.add("§7(§9Helpers§7,§2 Moderators§7, và");
        itemLore.add("§cAdmins§7) là chức năng chỉ dành cho");
        itemLore.add("§7tất cả người chơi có rank §bMVP§c+§7 và §6MVP§c++§7.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(50, itemStack);
        p.openInventory(inventory);
    }
}
