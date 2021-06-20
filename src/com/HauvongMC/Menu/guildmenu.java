package com.HauvongMC.Menu;

import com.HauvongMC.Items.GuildItems;
import com.HauvongMC.Items.MenuItems;
import com.HauvongMC.Modules.Guild.Guild;
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

public class guildmenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank;
    private static String[] friends;
    private static int start, slot;
    public static void openMain(Player p, int pages) {
        //header
         inventory = Bukkit.createInventory(p, 54, "Guild");
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
        itemLore.add("§7LuckyMCVN Level:§6 " + p.getLevel());
        itemLore.add("§7Achievement Points:§e " + GetPlayerData.getInfo(p.getName(), "Achievement_Points"));
        itemLore.add("§7Guild: §b" + guild);
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
        //body
        if (guild.equalsIgnoreCase("§cnull")) {
            inventory.setItem(29, GuildItems.getCreate());
            inventory.setItem(31, GuildItems.getFinder());
            inventory.setItem(33, GuildItems.getSearch());
        } else {
            inventory.setItem(18, GuildItems.getInviteplayer());
            //
             info = new ItemStack(Material.ITEM_FRAME, 1);
             infometa = info.getItemMeta();
             infolore = new ArrayList<>();
            infolore.add("§7Tên: §6" + guild);
            infolore.add("§7Đại ca: " + GetPlayerData.getInfo(Guild.getOwner(guild), "Prefix") + Guild.getOwner(guild));
            infolore.add("§7Thành viên:§e " + Guild.getMembers(guild).size());
            rank = "§eĐàn Em";
            if (Guild.getOwner(guild).equalsIgnoreCase(p.getName())) rank = "§cĐại Ca";
            infolore.add("§7Chức vụ của bạn: " + rank);
            infometa.setLore(infolore);
            infometa.setDisplayName("§aThông tin băng đảng");
            info.setItemMeta(infometa);
            inventory.setItem(19, info);
            //
            inventory.setItem(20, GuildItems.getSettings());
            inventory.setItem(21, GuildItems.getDiscord());
            int start = pages*17-17;
            if (pages != 1) {
                start++;
                 previous = new ItemStack(Material.ARROW, 1);
                 previousItemMeta = previous.getItemMeta();
                previouslore = new ArrayList<>();
                previouslore.add(" ");
                pages--;
                previouslore.add("§7Quay lại trang " + pages);
                previousItemMeta.setLore(previouslore);
                previousItemMeta.setDisplayName("§aTrang trước");
                previous.setItemMeta(previousItemMeta);
                inventory.setItem(27, previous);
                pages++;
            }
            List<String> members = Guild.getMembers(GetPlayerData.getInfo(p.getName(), "Guild"));
            slot = 36;
            for (int i = start; i < members.size(); i++) {
                inventory.setItem(slot, GuildItems.player(members.get(i)));
                slot++;
                if (slot > 53) {
                    ItemStack next = new ItemStack(Material.ARROW, 1);
                    ItemMeta nextmeta = next.getItemMeta();
                    List<String> nextlore = new ArrayList<>();
                    nextlore.add(" ");
                    pages++;
                    nextlore.add("§7Sang trang " + pages);
                    nextmeta.setLore(nextlore);
                    nextmeta.setDisplayName("§aTrang sau");
                    next.setItemMeta(nextmeta);
                    inventory.setItem(35, next);
                    break;
                }
            }
        }
        p.openInventory(inventory);
    }
}
