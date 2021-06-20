package com.HauvongMC.Items;

import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetEXP;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class FriendsItems {
    private static ItemStack addfriend, removefriend, sort, search, clear;



    public void FriendsItems() {
        ItemStack itemStack = new ItemStack(Material.BOOK_AND_QUILL, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aThêm bạn");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp để thêm một người này vào");
        itemLore.add("§7danh sách bạn bè của bạn.");
        itemLore.add("§7");
        itemLore.add("§7Bạn bè có thể xem những gì mỗi");
        itemLore.add("§7khi họ có mặt tại");
        itemLore.add("§7máy chủ, và có thể xem");
        itemLore.add("§7mỗi người trực tuyến.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        addfriend = itemStack;
        //remove friend
        itemStack = new ItemStack(Material.BARRIER, 1);
        itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cXóa bạn");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp vào để xóa bỏ");
        itemLore.add("§7người này trong danh sách");
        itemLore.add("§7bạn bè.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        removefriend = itemStack;
        //search
        itemStack = new ItemStack(Material.SIGN, 1);
        itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTìm kiếm người chơi");
        itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        search = itemStack;
        //clear
        itemStack = new ItemStack(Material.BARRIER, 1);
        itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXóa kết quả tìm kiếm");
        itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        clear = itemStack;
    }

    public static ItemStack player(String player) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta itemMeta  = (SkullMeta) itemStack.getItemMeta();
        itemMeta.setOwner(player);
        itemMeta.setDisplayName(GetPlayerData.getInfo(player, "Prefix") + GetPlayerData.getInfo(player, "Name"));
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Cấp LuckyMCVN: §6" + SetEXP.getLevel(player));
        itemLore.add("§7Điểm thành tích: §e" + GetPlayerData.getInfo(player, "Achievement_Points"));
        String guild = "§clỗi";
        String testguild = GetPlayerData.getInfo(player, "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Guild: §b" + guild);
        itemLore.add("§7");
        String status = "§cNgoại tuyến";
        if (Integer.parseInt(GetPlayerData.getInfo(player, "Online_Status")) == 1) {
            status = "§aTrực tuyến";
        }
        itemLore.add("§7Trạng thái: " + status);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getaddfriend() {
        ItemStack itemStack = new ItemStack(Material.BOOK_AND_QUILL, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aThêm bạn");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp để thêm một người này vào");
        itemLore.add("§7danh sách bạn bè của bạn.");
        itemLore.add("§7");
        itemLore.add("§7Bạn bè có thể xem những gì mỗi");
        itemLore.add("§7khi họ có mặt tại");
        itemLore.add("§7máy chủ, và có thể xem");
        itemLore.add("§7mỗi người trực tuyến.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getRemovefriend() {
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cXóa bạn");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp vào để xóa bỏ");
        itemLore.add("§7người này trong danh sách");
        itemLore.add("§7bạn bè.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getSearch() {
        ItemStack itemStack = new ItemStack(Material.SIGN, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTìm kiếm người chơi");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getClear() {
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXóa kết quả tìm kiếm");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
