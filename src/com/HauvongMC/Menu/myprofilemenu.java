package com.HauvongMC.Menu;

import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetEXP;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class myprofilemenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank;
    private static String[] friends;
    private static int start, slot;
    public static void openMain(Player p) {
         inventory = Bukkit.createInventory(p, 54, "Hồ sơ của tôi");
         itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
         head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(p.getName());
        head.setDisplayName(p.getDisplayName());
         itemLore  = new ArrayList<>();
         guild = "§cnull";
         testguild = GetPlayerData.getInfo(p.getName(), "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Cấp Độ LuckyMCVN:§6 " + p.getLevel());
        itemLore.add("§7Điểm thành tựu:§e " + GetPlayerData.getInfo(p.getName(), "Achievement_Points"));
        itemLore.add("§7Băng đảng: §b" + guild);
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        inventory.setItem(2, itemStack);
        inventory.setItem(3, MenuItems.getFriends());
        inventory.setItem(4, MenuItems.getParty());
        inventory.setItem(5, MenuItems.getGuild());
        inventory.setItem(6, MenuItems.getRecentplayers());
        for (int i = 9; i < 18; i++) {
            inventory.setItem(i, MenuItems.getOrange());
        }
        inventory.setItem(20, MenuItems.getHousing());
        inventory.setItem(21, MenuItems.getSocialmedia());
        //
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(p.getName());
        head.setDisplayName("§aThông tin nhân vật");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Rank: " + GetPlayerData.getInfo(p.getName(), "Prefix").substring(0,2) + GetPlayerData.getInfo(p.getName(), "Rank"));
        itemLore.add("§7Level: §6" + p.getLevel());
        itemLore.add("§7Kinh nghiệm để sang cấp tiếp theo:§6 " + SetEXP.getNextLVEXP(p));
        itemLore.add("§7Điểm thành tựu: §e" + GetPlayerData.getInfo(p.getName(), "Achievement_Points"));
        PlayerManager playerManager = new PlayerManager(p.getUniqueId());
        itemLore.add("§7Bụi bí ẩn: §b" + playerManager.getMysteryDust());
        itemLore.add("§7Nhiệm vụ đã hoàn thành: §60");
        itemLore.add("§7Karma: §d" + GetPlayerData.getInfo(p.getName(), "Karma"));
        itemLore.add("§7Vàng LuckyMCVN: §6" + GetPlayerData.getInfo(p.getName(), "Gold"));
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem cửa hàng LuckyMCVN!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        //
        inventory.setItem(22, itemStack);
        inventory.setItem(23, MenuItems.getStatsviewer());
        inventory.setItem(24, MenuItems.getCoinbooster());
        inventory.setItem(29, MenuItems.getAppearances());
        inventory.setItem(30, MenuItems.getAchievements());
        //
        itemStack = new ItemStack(Material.BEDROCK, 0);
         itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aCấp độ LuckyMCVN");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Chơi game và hoàn thành nhiệm vụ");
        itemLore.add("§7bạn sẽ nhận được §3Kinh nghiệm LuckyMCVN§7,");
        itemLore.add("§7được dùng để lên level, sẽ");
        itemLore.add("§7có được các đặc quyền và phần thưởng mới!");
        itemLore.add("§7");
        itemLore.add(SetEXP.getLVProgressBar(p));
        itemLore.add("§7");
        itemLore.add("§7Kinh nghiệm để sang cấp tiếp theo: §3" + SetEXP.getNextLVEXP(p));
        itemLore.add("§7");
        itemLore.add("§eNhấp để xem phần thưởng!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        //
        inventory.setItem(31, itemStack);
        //
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
        //
        inventory.setItem(32, itemStack);
        inventory.setItem(33, MenuItems.getSettings());
        inventory.setItem(39, MenuItems.getRecentgames());
        //
        itemStack = new ItemStack(Material.BEDROCK, 0);
        itemMeta =  itemStack.getItemMeta();
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setDisplayName("§aCửa hàng LuckyMCVN");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Xem cửa hàng LuckyMCVN");
        itemLore.add("§7ngay đây!");
        itemLore.add("");
        itemLore.add("§7Vàng LuckyMCVN của bạn:§6 " + GetPlayerData.getInfo(p.getName(), "Gold"));
        itemLore.add("§7");
        itemLore.add("§eNhấp vào để xem!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        //
        inventory.setItem(41, itemStack);
        p.openInventory(inventory);
    }
}
