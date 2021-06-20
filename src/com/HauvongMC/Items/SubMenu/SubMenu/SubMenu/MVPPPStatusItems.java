package com.HauvongMC.Items.SubMenu.SubMenu.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MVPPPStatusItems {
    private static ItemStack lookingto1v1, lookingtoteamup, lookingtochat, chill, lookingforaguild, donotdisturb, afk, grindingwins, grindingkills, boop;
    private static String preview = "§7Xem mẫu:", requires = "§cYêu cầu §6MVP§c++";
    public void MVPPPStatusItems() {
        //1v1
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Thách đấu 1v1";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        lookingto1v1 = itemStack;
        //team up
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Tìm người chơi chung";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        lookingtoteamup = itemStack;
        //chat
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Tìm người nhắn cùng";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        lookingtochat = itemStack;
        //chill
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Hãy thư giãn";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        chill = itemStack;
        //guild
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Tìm kiếm một băng đảng";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        lookingforaguild = itemStack;
        //do not distrub
        //guild
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Đừng làm phiền";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        donotdisturb = itemStack;
        //afk
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "AFK";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        afk = itemStack;
        //grindingwins
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Game là zễ~";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        grindingwins = itemStack;
        //grindingkills
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Bọn gà!";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        grindingkills = itemStack;
        //boop
        itemStack = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        name = "Boop!";
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§d§l" + name);
        itemStack.setItemMeta(itemMeta);
        boop = itemStack;
    }

    public static ItemStack getBoop() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Boop!";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§d§l" + name);
        itemStack.setItemMeta(itemMeta);
        return boop;
    }

    public static ItemStack getAfk() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "AFK";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getChill() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Hãy thư giãn";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return chill;
    }

    public static ItemStack getDonotdisturb() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Đừng làm phiền";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return donotdisturb;
    }

    public static ItemStack getGrindingwins() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Game là zễ~";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getLookingforaguild() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Tìm kiếm một băng đảng";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getGrindingkills() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Bọn gà!";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return grindingkills;
    }

    public static ItemStack getLookingto1v1() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Thách đấu 1v1";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getLookingtochat() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Tìm người nhắn cùng";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack getLookingtoteamup() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String name = "Tìm người chơi chung";
        List<String> itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("");
        itemLore.add(preview);
        itemLore.add("§b" + name);
        itemLore.add("");
        itemLore.add(requires);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
