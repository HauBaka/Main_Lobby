package com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu;

import com.HauvongMC.Items.SubMenu.SubMenu.SubMenu.MVPPPStatusItems;
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

public class MVPPPStatusMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps, Itemlore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "Trạng thái dành cho MVP++");
         rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (!rank.equalsIgnoreCase("Default") && !rank.equalsIgnoreCase("VIP") && !rank.equalsIgnoreCase("VIP+") && !rank.equalsIgnoreCase("MVP") && !rank.equalsIgnoreCase("MVP+")) {
            String clicktoselect = "§eNhấp để chọn", selected = "§aĐã chọn";
            String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
            //
             itemStack = MVPPPStatusItems.getLookingto1v1();
             itemMeta = itemStack.getItemMeta();
             itemLore = itemMeta.getLore();
             name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(10, itemStack);
            //teamup
            itemStack = MVPPPStatusItems.getLookingtoteamup();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(11, itemStack);
            //chat
            itemStack = MVPPPStatusItems.getLookingtochat();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(12, itemStack);
            //chill
            itemStack = MVPPPStatusItems.getChill();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(13, itemStack);
            //guild
            itemStack = MVPPPStatusItems.getLookingforaguild();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(14, itemStack);
            //disturb
            itemStack = MVPPPStatusItems.getDonotdisturb();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(15, itemStack);
            //afk
            itemStack = MVPPPStatusItems.getAfk();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(16, itemStack);
            //grindingwins
            itemStack = MVPPPStatusItems.getGrindingwins();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(19, itemStack);
            //grindingkills
            itemStack = MVPPPStatusItems.getGrindingkills();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(20, itemStack);
            //boop
            itemStack = MVPPPStatusItems.getBoop();
            itemMeta = itemStack.getItemMeta();
            itemLore = itemMeta.getLore();
            name = itemMeta.getDisplayName();
            name = name.replace("§c", "").replace("§d§l", "");
            if (currentselect.equalsIgnoreCase(name)) {
                itemLore.set(itemLore.size() -1, selected);
            } else {
                itemLore.set(itemLore.size() -1, clicktoselect);
            }
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(21, itemStack);
        } else {
            inventory.setItem(10, MVPPPStatusItems.getLookingto1v1());
            inventory.setItem(11, MVPPPStatusItems.getLookingtoteamup());
            inventory.setItem(12, MVPPPStatusItems.getLookingtochat());
            inventory.setItem(13, MVPPPStatusItems.getChill());
            inventory.setItem(14, MVPPPStatusItems.getLookingforaguild());
            inventory.setItem(15, MVPPPStatusItems.getDonotdisturb());
            inventory.setItem(16, MVPPPStatusItems.getAfk());
            inventory.setItem(19, MVPPPStatusItems.getGrindingwins());
            inventory.setItem(20, MVPPPStatusItems.getGrindingkills());
            inventory.setItem(21, MVPPPStatusItems.getBoop());
        }
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
            itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại Trạng thái");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(49, itemStack);
        }
        p.openInventory(inventory);
    }
}
