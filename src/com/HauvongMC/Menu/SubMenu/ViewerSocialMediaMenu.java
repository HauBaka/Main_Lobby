package com.HauvongMC.Menu.SubMenu;

import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Items.SubMenu.SocialMediaItems;
import com.HauvongMC.Menu.myprofilemenu;
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

public class ViewerSocialMediaMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;
    public static void openMain(Player p, String target) {
         inventory = Bukkit.createInventory(p, 54, "Mạng xã hội của " + target);
        SocialMediaItems socialMediaItems = new SocialMediaItems(target);
         name = GetPlayerData.getInfo(target, "Name");
        if (name.equalsIgnoreCase(p.getName())) {
            myprofilemenu.openMain(p);
            return;
        }
         itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
         head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(name);
        head.setDisplayName(GetPlayerData.getInfo(name, "Prefix") + name);
         itemLore  = new ArrayList<>();
         guild = "§cnull";
         testguild = GetPlayerData.getInfo(name, "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Điểm thành tựu:§e " + GetPlayerData.getInfo(name, "Achievement_Points"));
        itemLore.add("§7Băng đảng: §b" + guild);
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        inventory.setItem(0, itemStack);
        //
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(p.getName());
        head.setDisplayName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName());
        itemLore  = new ArrayList<>();
        guild = "§cnull";
        testguild = GetPlayerData.getInfo(p.getName(), "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
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
            inventory.setItem(i, MenuItems.getGreen());
        }
        inventory.setItem(28, socialMediaItems.getTwitter());
        inventory.setItem(29, socialMediaItems.getYoutube());
        inventory.setItem(30, socialMediaItems.getInstagram());
        inventory.setItem(32, socialMediaItems.getTwitch());
        inventory.setItem(33, socialMediaItems.getDiscord());
        inventory.setItem(34, socialMediaItems.getForum());
        itemStack = new ItemStack(Material.ARROW, 1);
         itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§aQuay lại");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Đến Hồ sơ của " + name);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        p.openInventory(inventory);
    }
}
