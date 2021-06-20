package com.HauvongMC.Items;

import com.HauvongMC.Modules.Guild.Guild;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetEXP;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class GuildItems {
    private static ItemStack inviteplayer, settings, discord, finder, create, search, itemStack;
    private static ItemMeta itemMeta;
    private static List<String> itemLore;
    private static SkullMeta head;
    public void GuildItems() {
        //create
         itemStack = new ItemStack(Material.BOOK, 1);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("§7Chỉ có những người chơi");
        itemLore.add("§7sở hữu §aVIP§c+§7 hoặc cao hơn");
        itemLore.add("§7mới có thể tạo băng đảng, bất kì ai");
        itemLore.add("§7cũng có thể tham gia vào");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cTạo băng đảng");
        itemStack.setItemMeta(itemMeta);
        create = itemStack;
        //finder
        itemStack = new ItemStack(Material.PAPER, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Tìm một Guild tham gia có thể tham gia");
        itemLore.add("§7dựa trên yêu thích trò chơi");
        itemLore.add("§7của bạn.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để xem!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTìm băng đảng");
        itemStack.setItemMeta(itemMeta);
        finder = itemStack;
        //search
        itemStack = new ItemStack(Material.BOOK, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Nhấp vào đây để tìm kiếm các băng đảng");
        itemLore.add("§7mà bạn có thể tham gia vào");
        itemLore.add("§7LuckyMCVN website!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTìm kiếm các băng đảng");
        itemStack.setItemMeta(itemMeta);
        search = itemStack;
        //invite
        itemStack = new ItemStack(Material.BOOK_AND_QUILL, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Nhấp vào đây để mời một");
        itemLore.add("§7người chơi vào băng đảng của bạn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aMời người chơi");
        itemStack.setItemMeta(itemMeta);
        inviteplayer = itemStack;
        //settings
        itemStack = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chỉnh sửa cài đặt chẳng hạn như tag của bạn,");
        itemLore.add("§7quyền và công cụ tìm băng đảng");
        itemLore.add("§7và các tùy chọn.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để cài đặt!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aCài đặt băng đảng");
        itemStack.setItemMeta(itemMeta);
        settings = itemStack;
        //settings
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Discoord");
        itemLore = new ArrayList<>();
        itemLore.add("§7Bang hội của bạn có bất hòa");
        itemLore.add("§7Thành viên của băng đảng");
        itemLore.add("§7có thể tham gia.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để xem Link Discord");
        itemMeta.setLore(itemLore);
        head.setDisplayName("§aDiscord của băng đảng");
        itemStack.setItemMeta(head);
        discord = itemStack;
        //search
        itemStack = new ItemStack(Material.SIGN, 1);
        itemMeta  = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTìm kiếm người chơi");
        itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        search = itemStack;
    }

    public static ItemStack getCreate() {
         itemStack = new ItemStack(Material.BOOK, 1);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("§7Chỉ có những người chơi");
        itemLore.add("§7sở hữu §aVIP§c+§7 hoặc cao hơn");
        itemLore.add("§7mới có thể tạo băng đảng, bất kì ai");
        itemLore.add("§7cũng có thể tham gia vào");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cTạo băng đảng");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getDiscord() {
         itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
         head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Discoord");
         itemLore = new ArrayList<>();
        itemLore.add("§7Bang hội của bạn có bất hòa");
        itemLore.add("§7Thành viên của băng đảng");
        itemLore.add("§7có thể tham gia.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để xem Link Discord");
        head.setLore(itemLore);
        head.setDisplayName("§aDiscord của băng đảng");
        itemStack.setItemMeta(head);
        return itemStack;
    }

    public static ItemStack getFinder() {
         itemStack = new ItemStack(Material.PAPER, 1);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("§7Tìm một Guild tham gia có thể tham gia");
        itemLore.add("§7dựa trên yêu thích trò chơi");
        itemLore.add("§7của bạn.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để xem!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTìm băng đảng");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getInviteplayer() {
         itemStack = new ItemStack(Material.BOOK_AND_QUILL, 1);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("§7Nhấp vào đây để mời một");
        itemLore.add("§7người chơi vào băng đảng của bạn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aMời người chơi");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getSearch() {
         itemStack = new ItemStack(Material.BOOK, 1);
         itemMeta = itemStack.getItemMeta();
          itemLore = new ArrayList<>();
        itemLore.add("§7Nhấp vào đây để tìm kiếm các băng đảng");
        itemLore.add("§7mà bạn có thể tham gia vào");
        itemLore.add("§7LuckyMCVN website!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTìm kiếm các băng đảng");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack player(String player) {
         itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
         head  = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(player);
        head.setDisplayName(GetPlayerData.getInfo(player, "Prefix") + GetPlayerData.getInfo(player, "Name"));
         itemLore  = new ArrayList<>();
        itemLore.add("§7Cấp LuckyMCVN: §6" + SetEXP.getLevel(player));
        itemLore.add("§7Điểm thành tích: §e" + GetPlayerData.getInfo(player, "Achievement_Points"));
        String guild = "§clỗi";
        String testguild = GetPlayerData.getInfo(player, "Guild");
        System.out.println(testguild);
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Guild: §b" + guild);
        String rank = "§bĐàn Em";
        if (Guild.getOwner(testguild).equalsIgnoreCase(player)) rank = "§cĐại Ca";
        itemLore.add("§7Chức vụ: " + rank);
        itemLore.add("§7");
        String status = "§cNgoại tuyến";
        if (Integer.parseInt(GetPlayerData.getInfo(player, "Online_Status")) == 1) {
            status = "§aTrực tuyến";
        }
        itemLore.add("§7Trạng thái: " + status);
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return itemStack;
    }
    public static ItemStack getSettings() {
         itemStack = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("§7Chỉnh sửa cài đặt chẳng hạn như tag của bạn,");
        itemLore.add("§7quyền và công cụ tìm băng đảng");
        itemLore.add("§7và các tùy chọn.");
        itemLore.add("");
        itemLore.add("§eNhấp vào để cài đặt!");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aCài đặt băng đảng");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
