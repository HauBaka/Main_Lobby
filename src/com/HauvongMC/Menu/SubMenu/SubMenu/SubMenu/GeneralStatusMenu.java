package com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu;

import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GeneralStatusMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps, Itemlore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;

    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "Chung");
        String clicktoselect = "§eNhấp để chọn", selected = "§aĐã chọn";
        String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
        //
         itemStack = new ItemStack(Material.NAME_TAG);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("");
        itemLore.add("§7Xem mẫu:");
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        long firstjoin = Long.parseLong(GetPlayerData.getInfo(p.getName(), "First_Join"));
        String date = simpleDateFormat.format(firstjoin);
        String[] split = date.split("/");
        String month;
        switch (split[1]) {
            default:
                month = "Tháng 1";
                break;
            case "02":
                month = "Tháng 2";
                break;
            case "03":
                month = "Tháng 3";
                break;
            case "04":
                month = "Tháng 4";
                break;
            case "05":
                month = "Tháng 5";
                break;
            case "06":
                month = "Tháng 6";
                break;
            case "07":
                month = "Tháng 7";
                break;
            case "08":
                month = "Tháng 8";
                break;
            case "09":
                month = "Tháng 9";
                break;
            case "10":
                month = "Tháng 10";
                break;
            case "11":
                month = "Tháng 11";
                break;
            case "12":
                month = "Tháng 12";
                break;
        }
        itemLore.add("§bLần đầu tham gia máy chủ:§6 " + split[0] + " " + month + " " + split[2]);
        itemLore.add("");
        if (p.getLevel() < 30) {
            itemLore.add("§cYêu cầu §3Cấp độ LuckyMCVN 30");
        } else {
            if (currentselect.equalsIgnoreCase("First Joined")) {
                itemLore.add(selected);
            } else itemLore.add(clicktoselect);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cLần đầu tham gia máy chủ");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(10, itemStack);
        //
        String ping = "";
        int playerping = ((CraftPlayer) p).getHandle().ping;
        if (playerping < 100) ping = "§a" + playerping;
        else if (playerping < 200) ping = "§e" + playerping;
        else ping = "§c" + playerping;
        itemStack = new ItemStack(Material.NAME_TAG);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("");
        itemLore.add("§7Mẫu:");
        itemLore.add("§bPing: " + ping);
        itemLore.add("");
        if (p.getLevel() < 35) {
            itemLore.add("§cYêu cầu §3Cấp độ LuckyMCVN 35");
        } else {
            if (currentselect.equalsIgnoreCase("Ping")) {
                itemLore.add(selected);
            } else itemLore.add(clicktoselect);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aPing");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(11, itemStack);
        //
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
        //
        p.openInventory(inventory);
    }
}
