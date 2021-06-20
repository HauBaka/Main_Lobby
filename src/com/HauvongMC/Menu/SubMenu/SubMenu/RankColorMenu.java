package com.HauvongMC.Menu.SubMenu.SubMenu;

import com.HauvongMC.Items.SubMenu.SubMenu.RankColorItems;
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

public class RankColorMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps, Itemlore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 45, "Màu rank MVP+");
        String clicktoselect = "§eNhấp để chọn!";
        String selected = "§aĐã chọn";
        if (GetPlayerData.getInfo(p.getName(), "Rank").equalsIgnoreCase("MVP+") || GetPlayerData.getInfo(p.getName(), "Rank").equalsIgnoreCase("MVP++")) {
            new RankColorItems().RankColorItems();
             itemStack = RankColorItems.getRed();
             itemMeta = itemStack.getItemMeta();
             Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§c")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(10, itemStack);
            //orange
            itemStack = RankColorItems.getOrange();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§6")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(11, itemStack);
            //green
            itemStack = RankColorItems.getGreen();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§a")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(12, itemStack);
            //yellow
            itemStack = RankColorItems.getYellow();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§e")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(13, itemStack);
            //light purple
            itemStack = RankColorItems.getLightpurple();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§d")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(14, itemStack);
            //white
            itemStack = RankColorItems.getWhite();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§f")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(15, itemStack);
            //blue
            itemStack = RankColorItems.getBlue();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§b")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(16, itemStack);
            //dark green
            itemStack = RankColorItems.getDarkgreen();
            itemMeta = itemStack.getItemMeta();
            Itemlore = itemMeta.getLore();
            if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§2")) {
                Itemlore.set(Itemlore.size() -1, selected);
            } else {
                Itemlore.set(Itemlore.size() -1, clicktoselect);
            }
            itemMeta.setLore(Itemlore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(19, itemStack);
            //dark red
            if (p.getLevel() >= 10) {
                itemStack = RankColorItems.getDarkred();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§4")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(20, itemStack);
            } else {
                itemStack = RankColorItems.getDarkred();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(20, itemStack);
            }
            //dark aqua
            if (p.getLevel() >=15) {
                itemStack = RankColorItems.getDarkaqua();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§3")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(21, itemStack);
            } else {
                itemStack = RankColorItems.getDarkaqua();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(21, itemStack);
            }
            //dark purple
            if (p.getLevel() >=20) {
                itemStack = RankColorItems.getDarkpurple();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§5")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(22, itemStack);
            } else {
                itemStack = RankColorItems.getDarkpurple();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(22, itemStack);
            }
            //dark gray
            if (p.getLevel() >=30) {
                itemStack = RankColorItems.getDarkgray();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§8")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(23, itemStack);
            } else {
                itemStack = RankColorItems.getDarkgray();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(23, itemStack);
            }
            //black
            if (p.getLevel() >= 50) {
                itemStack = RankColorItems.getBlack();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§0")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(24, itemStack);
            } else {
                itemStack = RankColorItems.getBlack();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(24, itemStack);
            }
            //dark blue
            if (p.getLevel() >= 80) {
                itemStack = RankColorItems.getDarkblue();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                if (GetPlayerData.getInfo(p.getName(), "Plus_Color").equalsIgnoreCase("§1")) {
                    Itemlore.set(Itemlore.size() -1, selected);
                } else {
                    Itemlore.set(Itemlore.size() -1, clicktoselect);
                }
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(25, itemStack);
            } else {
                itemStack = RankColorItems.getDarkblue();
                itemMeta = itemStack.getItemMeta();
                Itemlore = itemMeta.getLore();
                Itemlore.remove(Itemlore.size() - 1);
                Itemlore.remove(Itemlore.size() - 1);
                itemMeta.setLore(Itemlore);
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(25, itemStack);
            }
        } else {
            new RankColorItems().RankColorItems();
            inventory.setItem(10, RankColorItems.getRed());
            inventory.setItem(11, RankColorItems.getOrange());
            inventory.setItem(12, RankColorItems.getGreen());
            inventory.setItem(13, RankColorItems.getYellow());
            inventory.setItem(14, RankColorItems.getLightpurple());
            inventory.setItem(15, RankColorItems.getWhite());
            inventory.setItem(16, RankColorItems.getBlue());
            inventory.setItem(19, RankColorItems.getDarkgreen());
            inventory.setItem(20, RankColorItems.getDarkred());
            inventory.setItem(21, RankColorItems.getDarkaqua());
            inventory.setItem(22, RankColorItems.getDarkpurple());
            inventory.setItem(23, RankColorItems.getDarkgray());
            inventory.setItem(24, RankColorItems.getBlack());
            inventory.setItem(25, RankColorItems.getDarkblue());
        }
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
             itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại Tùy chỉnh giao diện");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(40, itemStack);
        }
        p.openInventory(inventory);
    }
}
