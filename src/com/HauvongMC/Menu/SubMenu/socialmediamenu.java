package com.HauvongMC.Menu.SubMenu;

import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Items.SubMenu.SocialMediaItems;
import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class socialmediamenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p) {
            SocialMediaItems socialMediaItems = new SocialMediaItems(p);
        //header
         inventory = Bukkit.createInventory(p, 54, "Mạng xã hội");
         itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
         head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(p.getName());
        head.setDisplayName(p.getDisplayName());
        itemLore  = new ArrayList<>();
         guild = "§cnull";
        String testguild = GetPlayerData.getInfo(p.getName(), "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Cấp độ LuckyMCVN:§6 " + p.getLevel());
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
        inventory.setItem(28, socialMediaItems.getTwitter());
        inventory.setItem(29, socialMediaItems.getYoutube());
        inventory.setItem(30, socialMediaItems.getInstagram());
        inventory.setItem(32, socialMediaItems.getTwitch());
        inventory.setItem(33, socialMediaItems.getDiscord());
        inventory.setItem(34, socialMediaItems.getForum());
        inventory.setItem(49, MenuItems.getBack());
        p.openInventory(inventory);
    }

    public static void setTwitter(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Twitter của bạn vào chat:");
        Main.chatinput.replace(p, 5);
    }
    public static void setYoutube(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Youtube của bạn vào chat:");
        Main.chatinput.replace(p, 6);
    }
    public static void setInstagram(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Instagram của bạn vào chat:");
        Main.chatinput.replace(p, 7);
    }
    public static void setTwitch(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Twitch của bạn vào chat:");
        Main.chatinput.replace(p, 8);
    }
    public static void setDiscord(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Discord của bạn vào chat:");
        Main.chatinput.replace(p, 9);
    }
    public static void setForum(Player p) {
        p.closeInventory();
        p.sendMessage("§6Nhập link Diễn đàn của bạn vào chat:");
        Main.chatinput.replace(p, 10);
    }
}
