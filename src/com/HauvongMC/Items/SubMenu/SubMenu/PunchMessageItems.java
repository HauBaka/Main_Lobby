package com.HauvongMC.Items.SubMenu.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PunchMessageItems {
    private static ItemStack loving, boop, snowball, glorious;
    public PunchMessageItems() {
        String rightclick = "§7Chuột-phải để xem mẫu!", require = "§cYêu cầu §bMVP§c+", messagex2 = "§7là tin nhắn hiển thị khi", punch = "§7bạn đánh STAFF ở sảnh.", punchmessage = "§8Hiệu ứng đấm STAFF";
        ItemStack itemStack = new ItemStack(Material.INK_SACK, 1, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add(punchmessage);
        itemLore.add("");
        itemLore.add("§7Chọn đánh ghen");
        itemLore.add(messagex2);
        itemLore.add(punch);
        itemLore.add("");
        itemLore.add(rightclick);
        itemLore.add("");
        itemLore.add(require);
        itemMeta.setDisplayName("§cYêu thw");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        loving = itemStack;
        //boop
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 9);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add(punchmessage);
        itemLore.add("");
        itemLore.add("§7Chọn ném phân");
        itemLore.add(messagex2);
        itemLore.add(punch);
        itemLore.add("");
        itemLore.add(rightclick);
        itemLore.add("");
        itemLore.add(require);
        itemMeta.setDisplayName("§cPhân");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        boop = itemStack;
        //snowball
        itemStack = new ItemStack(Material.SNOW_BALL, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add(punchmessage);
        itemLore.add("");
        itemLore.add("§7Chọn ném bóng tuyết vào mặt");
        itemLore.add(messagex2);
        itemLore.add(punch);
        itemLore.add("");
        itemLore.add(rightclick);
        itemLore.add("");
        itemLore.add(require);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cBóng tuyết");
        itemStack.setItemMeta(itemMeta);
        snowball = itemStack;
        //glorious
        itemStack = new ItemStack(Material.GOLD_INGOT, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add(punchmessage);
        itemLore.add("");
        itemLore.add("§7Chọn cú đấm ngoạn mục");
        itemLore.add(messagex2);
        itemLore.add(punch);
        itemLore.add("");
        itemLore.add(rightclick);
        itemLore.add("");
        itemLore.add(require);
        itemMeta.setDisplayName("§cNgoạn mục");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        glorious = itemStack;
    }

    public static ItemStack getBoop() {
        return boop;
    }

    public static ItemStack getGlorious() {
        return glorious;
    }

    public static ItemStack getLoving() {
        return loving;
    }

    public static ItemStack getSnowball() {
        return snowball;
    }
}
