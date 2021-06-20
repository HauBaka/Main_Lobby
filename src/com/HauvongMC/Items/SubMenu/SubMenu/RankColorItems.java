package com.HauvongMC.Items.SubMenu.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RankColorItems {
    private static ItemStack red, orange, green, yellow, lightpurple, white, blue, darkgreen, darkred, darkaqua, darkpurple, darkgray, black, darkblue;
    public void RankColorItems() {
        String require = "§cYêu cầu §bMVP§c+";
        String lore1 = "§7Hiển thị trên tab, cả khi chat", lore2= "§7và tham gia sảnh.", unlockrequire = "§3Mở khóa ở cấp độ LuckyMCVN ",
                changthecoloroftheplusof = "§7Chuyển màu dấu + của §bMVP§c+", turning = ", giống như ";
        ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();
        itemMeta.setDisplayName("§cRed Rank Color");
        lore.add("§7Màu mặc định cho §bMVP§c+");
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        red = itemStack;
        //orange
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu vàng đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang vàng đậm" + turning + "§bMVP§6+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        orange = itemStack;
        //green
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xanh");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xanh" + turning + "§bMVP§a+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        green = itemStack;
        //yellow
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 11);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu vàng");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang vàng" + turning + "§bMVP§e+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        yellow = itemStack;
        //lightpurple
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 9);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu hồng nhạt");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang hồng" + turning + "§bMVP§d+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        lightpurple = itemStack;
        //white
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 15);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu trắng");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang trắng" + turning + "§bMVP§f+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        white = itemStack;
        //blue
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 12);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xanh biển");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xanh biển" + turning + "§bMVP§b+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        blue = itemStack;
        //darkgreen
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 2);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xanh lá đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xanh lá đậm" + turning + "§bMVP§2+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkgreen = itemStack;
        //darkred
        itemStack = new ItemStack(Material.REDSTONE, 1);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu đỏ đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang đỏ đậm" + turning + "§bMVP§4+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 10);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkred = itemStack;
        //darkaqua
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 6);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xanh biển đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xanh biển đậm" + turning + "§bMVP§3+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 15);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkaqua = itemStack;
        //darkpurple
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 5);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu hồng đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang hồng đậm" + turning + "§bMVP§5+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 20);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkpurple = itemStack;
        //darkgray
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xám đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xám đậm" + turning + "§bMVP§8+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 30);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkgray = itemStack;
        //black
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 0);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu đen");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang đen" + turning + "§bMVP§0+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 50);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        black = itemStack;
        //darkblue
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 4);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setDisplayName("§cMàu xanh biển đậm đậm");
        lore.add(changthecoloroftheplusof);
        lore.add("§7sang xanh biển đậm đậm" + turning + "§bMVP§1+");
        lore.add("");
        lore.add(lore1);
        lore.add(lore2);
        lore.add("");
        lore.add(unlockrequire + 80);
        lore.add("");
        lore.add(require);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        darkblue = itemStack;
    }

    public static ItemStack getBlack() {
        return black;
    }

    public static ItemStack getBlue() {
        return blue;
    }

    public static ItemStack getDarkaqua() {
        return darkaqua;
    }

    public static ItemStack getDarkblue() {
        return darkblue;
    }

    public static ItemStack getDarkgray() {
        return darkgray;
    }

    public static ItemStack getDarkgreen() {
        return darkgreen;
    }

    public static ItemStack getDarkpurple() {
        return darkpurple;
    }

    public static ItemStack getDarkred() {
        return darkred;
    }

    public static ItemStack getGreen() {
        return green;
    }

    public static ItemStack getLightpurple() {
        return lightpurple;
    }

    public static ItemStack getOrange() {
        return orange;
    }

    public static ItemStack getRed() {
        return red;
    }

    public static ItemStack getWhite() {
        return white;
    }

    public static ItemStack getYellow() {
        return yellow;
    }
}
