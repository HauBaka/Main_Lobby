package com.HauvongMC.Items.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;

import java.util.ArrayList;
import java.util.List;

public class AppearancesItems {
    private static ItemStack rankcolor, punchmessage, status;
    public void AppearancesItems() {
        ItemStack itemStack  = new ItemStack(Material.INK_SACK, 1, (short) 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§7Người chơi rank §bMVP§c+");
        itemLore.add("§7có thể mở khóa và chuyển đổi");
        itemLore.add("§7màu dấu + của họ.");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aMàu rank MVP+");
        itemStack.setItemMeta(itemMeta);
        rankcolor = itemStack;
        //punchmessage
        itemStack  = new ItemStack(Material.MAP, 1);
        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
        mapMeta.setScaling(false);
        itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh tin nhắn khi");
        itemLore.add("§7bạn đấm vào STAFF");
        itemLore.add("");
        itemLore.add("§cHiệu ứng đấm Staff ở lobby chỉ dành");
        itemLore.add("§ccho người chơi rank §bMVP§c+");
        itemLore.add("§choặc được tặng từ");
        itemLore.add("§cAdmin");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        mapMeta.setLore(itemLore);
        mapMeta.setDisplayName("§aHiệu ứng đấm Staff");
        itemStack.setItemMeta(mapMeta);
        punchmessage = itemStack;
        //status
        itemStack  = new ItemStack(Material.NAME_TAG, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Đặt một trạng thái hiển thị");
        itemLore.add("§7trên đầu bạn khi vào sảnh");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTrạng thái");
        itemStack.setItemMeta(itemMeta);
        status = itemStack;
    }

    public static ItemStack getRankcolor() {
        ItemStack itemStack  = new ItemStack(Material.INK_SACK, 1, (short) 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§7Người chơi rank §bMVP§c+");
        itemLore.add("§7có thể mở khóa và chuyển đổi");
        itemLore.add("§7màu dấu + của họ.");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aMàu rank MVP+");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getPunchmessage() {
        ItemStack itemStack  = new ItemStack(Material.MAP, 1);
        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
        mapMeta.setScaling(false);
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh tin nhắn khi");
        itemLore.add("§7bạn đấm vào STAFF");
        itemLore.add("");
        itemLore.add("§cHiệu ứng đấm Staff ở lobby chỉ dành");
        itemLore.add("§ccho người chơi rank §bMVP§c+");
        itemLore.add("§choặc được tặng từ");
        itemLore.add("§cAdmin");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        mapMeta.setLore(itemLore);
        mapMeta.setDisplayName("§aHiệu ứng đấm Staff");
        itemStack.setItemMeta(mapMeta);
        return itemStack;
    }

    public static ItemStack getStatus() {
        ItemStack itemStack  = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String>  itemLore = new ArrayList<>();
        itemLore.add("§7Đặt một trạng thái hiển thị");
        itemLore.add("§7trên đầu bạn khi vào sảnh");
        itemLore.add("");
        itemLore.add("§eNhấp để thay đổi!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTrạng thái");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
