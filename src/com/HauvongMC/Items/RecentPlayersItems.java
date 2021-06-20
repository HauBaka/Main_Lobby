package com.HauvongMC.Items;

import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetEXP;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class RecentPlayersItems {
    private static ItemStack clearcache, search, clearsearch;

    public static ItemStack searchplayer(String player, String server) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta itemMeta  = (SkullMeta) itemStack.getItemMeta();
        itemMeta.setOwner(player);
        itemMeta.setDisplayName(GetPlayerData.getInfo(player, "Prefix") + GetPlayerData.getInfo(player, "Name"));
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Cấp độ LuckyMCVN: §6" + SetEXP.getLevel(player));
        itemLore.add("§7Điểm thành tích: §e" + GetPlayerData.getInfo(player, "Achievement_Points"));
        String guild = "§cnull";
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
        itemLore.add("§7");
        itemLore.add("§7Đã gặp trong máy chủ: §b" + server);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void RecentPlayersItems() {
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXóa người chơi gần đây");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xóa danh sách người chơi");
        itemLore.add("§7gần đây.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        clearcache = itemStack;

        itemStack = new ItemStack(Material.SIGN, 1);
        itemMeta =  itemStack.getItemMeta();
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
        clearsearch = itemStack;
    }

    public static ItemStack getSearch() {
        ItemStack itemStack = new ItemStack(Material.SIGN, 1);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTìm kiếm người chơi");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getClearcache() {
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXóa người chơi gần đây");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xóa danh sách người chơi");
        itemLore.add("§7gần đây.");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getClearsearch() {
        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXóa kết quả tìm kiếm");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack player(String player, String server) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta itemMeta  = (SkullMeta) itemStack.getItemMeta();
        itemMeta.setOwner(player);
        itemMeta.setDisplayName(GetPlayerData.getInfo(player, "Prefix") + GetPlayerData.getInfo(player, "Name"));
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Cấp độ LuckyMCVN: §6" + SetEXP.getLevel(player));
        itemLore.add("§7Điểm thành tích: §e" + GetPlayerData.getInfo(player, "Achievement_Points"));
        String guild = "§cnull";
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
        itemLore.add("§7");
        itemLore.add("§7Đã gặp trong máy chủ: §b" + server);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
