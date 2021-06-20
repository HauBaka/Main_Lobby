package com.HauvongMC.Items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {
    private static ItemStack back,friends, party, guild, recentplayers, orange, purple, blue, green, gray, housing, socialmedia, quest,  statsviewer, recentgames, coinbooster, appearances, achievements, settings, store;
    public void MenuItems() {
        //friends
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("GirthyBacon");
        head.setDisplayName("§aBạn bè");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xem danh sách bạn bè");
        itemLore.add("§7của bạn, và thăm hỏi");
        itemLore.add("§7những đứa đang online!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        friends = itemStack;
        //party
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("PotatoJonson");
        head.setDisplayName("§aTổ đội");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Tạo một tổ đội và tham gia với");
        itemLore.add("§7những người chơi khác để chơi");
        itemLore.add("§7để chơi game chung!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        party = itemStack;
        //guild
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("ddosen");
        head.setDisplayName("§aBăng đảng");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Thành lập một băng đảng riêng,");
        itemLore.add("§7cùng với các đàn em phát triển");
        itemLore.add("§7xây dựng một");
        itemLore.add("§7băng đảng lớn mạnh.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        guild = itemStack;
        //recentplayers
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("agus0607");
        head.setDisplayName("§aNgười chơi gần đây");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Xem những người chơi mà bạn");
        itemLore.add("§7đã chơi chung gần đây.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        recentplayers = itemStack;
        //socialmedia
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("nek0skeppy");
        head.setDisplayName("§aMạng xã hội");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp để chỉnh sửa link Mạng");
        itemLore.add("§7Xã Hội của bạn.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        socialmedia = itemStack;
        //orange
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        this.orange = itemStack;
        //purple
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        purple = itemStack;
        //blue
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        blue = itemStack;
        //green
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        green = itemStack;
        //gray
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        gray = itemStack;
        //housing
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aQuay về Nhà");
        itemStack.setItemMeta(itemMeta);
        housing = itemStack;
        //statsviewer
        itemStack = new ItemStack(Material.PAPER, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXem hồ sơ");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Hiển thị Hồ Sơ của bạn trong mỗi");
        itemLore.add("§7game.");
        itemLore.add("§7");
        itemLore.add("§7Người chơi có rank §bMVP§7 hoặc cao hơn");
        itemLore.add("§7có thể sử dụng §f /stats (tên)§7 để xem");
        itemLore.add("§7Hồ Sơ của những người chơi khác");
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem Hồ Sơ của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        statsviewer = itemStack;
        //coinsbooster
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTăng vàng");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Kích hoạt tăng vàng của bạn và cả");
        itemLore.add("§7máy chủ để nhận thêm vàng.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để kích hoạt!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        coinbooster = itemStack;
        //appearcances
        itemStack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§aTùy chỉnh giao diện");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh những giao diện đi");
        itemLore.add("§7kèm với bạn, ban sẽ thật ngầu lòi.");
        itemLore.add("§7");
        itemLore.add("§f● Màu rank MVP+");
        itemLore.add("§f● Hiệu ứng đấm STAFF");
        itemLore.add("§f● Trạng thái");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem!");
        leatherArmorMeta.setLore(itemLore);
        itemStack.setItemMeta(leatherArmorMeta);
        appearances = itemStack;
        //Achievements
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aThành tựu");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Kiểm tra tiến độ và đã mở khóa");
        itemLore.add("§7thành tích và tăng points.");
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem thành tích của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        achievements = itemStack;
        //settings
        itemStack = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aCài đặt & Tàng hình");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Cho phép bạn chỉnh sửa và kiểm soát");
        itemLore.add("§7cài đặt cá nhân khác nhau.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để chỉnh sửa cài đặt của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        settings = itemStack;
        //settings
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTrận đấu gần đây");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Xem bạn đã chơi gần đây");
        itemLore.add("§7đã chơi trò chơi gì.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        recentgames = itemStack;
        //quests
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aNhiện vụ và thử thách");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Hoàn thành nhiệm vụ và thử thách");
        itemLore.add("§7sẽ thưởng cho bạn §6Vàng§7, §3Kinh Nghiệm");
        itemLore.add("§3LuckyMCVN§7 và hơn thế nữa!");
        itemLore.add("");
        itemLore.add("§7Bạn có thể hoàn thành tối đa §a10");
        itemLore.add("§7thử thách mỗi ngày.");
        itemLore.add("§7");
        itemLore.add("§7Các thử thách đã hoàn thành hôm nay: §a0");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem Nhiệm vụ & Thử thách!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        quest = itemStack;
        //back
        itemStack = new ItemStack(Material.ARROW, 1);
        itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aQuay lại");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Đến Hồ sơ của tôi");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        back = itemStack;
    }


    public static ItemStack getBack() {
        ItemStack itemStack = new ItemStack(Material.ARROW, 1);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aQuay lại");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Đến Hồ sơ của tôi");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getFriends() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("GirthyBacon");
        head.setDisplayName("§aBạn bè");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xem danh sách bạn bè");
        itemLore.add("§7của bạn, và thăm hỏi");
        itemLore.add("§7những đứa đang online!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return  itemStack   ;
    }
    public static ItemStack getParty() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("PotatoJonson");
        head.setDisplayName("§aTổ đội");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Tạo một tổ đội và tham gia với");
        itemLore.add("§7những người chơi khác để chơi");
        itemLore.add("§7để chơi game chung!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return itemStack;
    }
    public static ItemStack getGuild() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("ddosen");
        head.setDisplayName("§aBăng đảng");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Thành lập một băng đảng riêng,");
        itemLore.add("§7cùng với các đàn em phát triển");
        itemLore.add("§7xây dựng một");
        itemLore.add("§7băng đảng lớn mạnh.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return itemStack;
    }
    public static ItemStack getRecentplayers() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("agus0607");
        head.setDisplayName("§aNgười chơi gần đây");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xem những người chơi mà bạn");
        itemLore.add("§7đã chơi chung gần đây.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return itemStack;
    }
    public static ItemStack getOrange() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getPurple() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getBlue() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getGreen() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getGray() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getHousing() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aQuay về Nhà");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getSocialmedia() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("nek0skeppy");
        head.setDisplayName("§aMạng xã hội");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp để chỉnh sửa link Mạng");
        itemLore.add("§7Xã Hội của bạn.");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        return itemStack;
    }
    public static ItemStack getStatsviewer() {
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aXem hồ sơ");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Hiển thị Hồ Sơ của bạn trong mỗi");
        itemLore.add("§7game.");
        itemLore.add("§7");
        itemLore.add("§7Người chơi có rank §bMVP§7 hoặc cao hơn");
        itemLore.add("§7có thể sử dụng §f /stats (tên)§7 để xem");
        itemLore.add("§7Hồ Sơ của những người chơi khác");
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem Hồ Sơ của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getCoinbooster() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTăng vàng");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Kích hoạt tăng vàng của bạn và cả");
        itemLore.add("§7máy chủ để nhận thêm vàng.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để kích hoạt!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getAppearances() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§aTùy chỉnh giao diện");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh những giao diện đi");
        itemLore.add("§7kèm với bạn, ban sẽ thật ngầu lòi.");
        itemLore.add("§7");
        itemLore.add("§f● Màu rank MVP+");
        itemLore.add("§f● Hiệu ứng đấm STAFF");
        itemLore.add("§f● Trạng thái");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem!");
        leatherArmorMeta.setLore(itemLore);
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }
    public static ItemStack getAchievements() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aThành tựu");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Kiểm tra tiến độ và đã mở khóa");
        itemLore.add("§7thành tích và tăng points.");
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem thành tích của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getSettings() {
        ItemStack itemStack = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aCài đặt & Tàng hình");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Cho phép bạn chỉnh sửa và kiểm soát");
        itemLore.add("§7cài đặt cá nhân khác nhau.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để chỉnh sửa cài đặt của bạn!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getRecentgames() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTrận đấu gần đây");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Xem bạn đã chơi gần đây");
        itemLore.add("§7đã chơi trò chơi gì.");
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getQuest() { return quest; }
}
