package com.HauvongMC.Menu.SubMenu;

import com.HauvongMC.Items.SubMenu.SettingsItems;
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

public class SettingsMenu {
    private static Inventory inventory;
    private static ItemStack itemStack, info, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, infolore, previouslore, Ps;
    private static ItemMeta itemMeta, nextmeta, infometa, previousItemMeta;
    private static String guild, testguild, friend, rank, listrecents, name;
    private static String[] friends, players;
    private static int start, slot;

    private static String enabled = "§7Nhấp để tắt!";
    private static String disabled = "§7Nhấp để bật!";
    private static String currentstate = "§7Cấp độ hiện tại: ";
    private static  String clicktochange = "§eNhấp để chuyển sang ";
    private static  String strong = "§aCao";
    private static  String weak = "§6Thấp";
    public static void openMain(Player p, boolean goback) {
         inventory = Bukkit.createInventory(p, 54, "Cài đặt & Tàng hình");
        int Party_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Party_Message_Sounds")); //0 = off, 1 = on
        int Guild_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Message_Sounds")); //0 = off, 1 = on
        int Private_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Private_Message_Sounds")); //0 = off, 1 = on
        int Join_Message = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Join_Message")); //0 = off, 1 = on
        int Public_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Public_Profanity_Level")); //0 = high, 1 = weak
        int Party_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Party_Profanity_Level"));//0 = off, 1 = high, 2= weak
        int Guild_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Profanity_Level"));//0 = off, 1 = high, 2= weak
        int PM_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "PM_Profanity_Level"));//0 = off, 1 = high, 2= weak
        int Chat_Visibility = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Chat_Visibility"));//0 = off, 1 = on
        int Guild_Chat_Visibility = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Chat_Visibility"));//0 = off, 1 = on
        int Chat_Alerts = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Chat_Alerts"));//0 = off, 1 = on
        //sound
        inventory.setItem(18, SettingsItems.getPartysound());
        if (Party_Message_Sounds == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getPartysound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(27, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
            String name = SettingsItems.getPartysound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(27, itemStack);
        }
        /**************************************************/
        inventory.setItem(19, SettingsItems.getGuildsound());
        if (Guild_Message_Sounds == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getGuildsound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(28, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getGuildsound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(28, itemStack);
        }
        /**************************************************/
        inventory.setItem(20, SettingsItems.getPrivatesound());
        if (Private_Message_Sounds == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getPrivatesound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(29, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getPrivatesound().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(29, itemStack);
        }
        /**************************************************/
        //chat
        inventory.setItem(21, SettingsItems.getChatalert());
        if (Chat_Alerts == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getChatalert().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(30, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getChatalert().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(30, itemStack);
        }
        /**************************************************/
        inventory.setItem(22, SettingsItems.getJoinmessage());
         rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (Join_Message == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(disabled);
            if (rank.equalsIgnoreCase("Default") || rank.equalsIgnoreCase("VIP") ||
                    rank.equalsIgnoreCase("VIP+") || rank.equalsIgnoreCase("MVP")) {
                itemLore.add("");
                itemLore.add("§cYêu cầu §bMVP§c+");
            }
            itemMeta.setLore(itemLore);
             name = SettingsItems.getJoinmessage().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(31, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(enabled);
            if (rank.equalsIgnoreCase("Default") || rank.equalsIgnoreCase("VIP") ||
                    rank.equalsIgnoreCase("VIP+") || rank.equalsIgnoreCase("MVP")) {
                itemLore.add("");
                itemLore.add("§cYêu cầu §bMVP§c+");
            }
            itemMeta.setLore(itemLore);
             name = SettingsItems.getJoinmessage().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(31, itemStack);
        }
        /**************************************************/
        inventory.setItem(23, SettingsItems.getPublicprofanity());
        if (Public_Profanity_Level == 0 ){//strong
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + strong);
            itemLore.add("");
            itemLore.add(clicktochange + weak + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPublicprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(32, itemStack);
        } else {//weak
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + weak);
            itemLore.add("");
            itemLore.add(clicktochange + strong + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPublicprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(32, itemStack);
        }
        /**************************************************/
        inventory.setItem(24, SettingsItems.getPartyprofanity());
        if (Party_Profanity_Level == 0 ){//off
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + "§cTắt");
            itemLore.add("");
            itemLore.add(clicktochange + strong + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPartyprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(33, itemStack);
        } else if (Party_Profanity_Level == 1 ){//strong
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + strong);
            itemLore.add("");
            itemLore.add(clicktochange + weak + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPartyprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(33, itemStack);
        } else {//weak
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + weak);
            itemLore.add("");
            itemLore.add(clicktochange + "§cTắt§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPartyprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(33, itemStack);
        }
        /**************************************************/
        inventory.setItem(25, SettingsItems.getGuildprofanity());
        if (Guild_Profanity_Level == 0 ){//off
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + "§cTắt");
            itemLore.add("");
            itemLore.add(clicktochange + strong + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getGuildprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(34, itemStack);
        } else if (Guild_Profanity_Level == 1 ){//strong
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + strong);
            itemLore.add("");
            itemLore.add(clicktochange + weak + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getGuildprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(34, itemStack);
        } else {//weak
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + weak);
            itemLore.add("");
            itemLore.add(clicktochange + "§cTắt§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getGuildprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(34, itemStack);
        }
        /**************************************************/
        inventory.setItem(26, SettingsItems.getPmprofanity());
        if (PM_Profanity_Level == 0 ){//off
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + "§cTắt");
            itemLore.add("");
            itemLore.add(clicktochange + strong + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPmprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(35, itemStack);
        } else if (PM_Profanity_Level == 1 ){//strong
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + strong);
            itemLore.add("");
            itemLore.add(clicktochange + weak + "§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPmprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(35, itemStack);
        } else {//weak
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 14);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(currentstate + weak);
            itemLore.add("");
            itemLore.add(clicktochange + "§cTắt§e!");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(SettingsItems.getPmprofanity().getItemMeta().getDisplayName());
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(35, itemStack);
        }
        /**************************************************/
        inventory.setItem(37, SettingsItems.getChatvisibility());
        if (Chat_Visibility == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getChatvisibility().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(46, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
            String name = SettingsItems.getChatvisibility().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(46, itemStack);
        }
        /**************************************************/
        inventory.setItem(43, SettingsItems.getGuildchatvisibility());
        if (Guild_Chat_Visibility == 0 ){
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
             itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add(disabled);
            itemMeta.setLore(itemLore);
             name = SettingsItems.getGuildchatvisibility().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§c" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(52, itemStack);
        } else {
             itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
             itemMeta = itemStack.getItemMeta();
             itemLore = new ArrayList<>();
            itemLore.add(enabled);
            itemMeta.setLore(itemLore);
            String name = SettingsItems.getGuildchatvisibility().getItemMeta().getDisplayName();
            name = name.replace("§a", "");
            itemMeta.setDisplayName("§a" + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(52, itemStack);
        }
        /**************************************************/
        if (goback == true) {
             itemStack = new ItemStack(Material.ARROW, 1);
             itemMeta =  itemStack.getItemMeta();
            itemMeta.setDisplayName("§aQuay lại");
            itemLore  = new ArrayList<>();
            itemLore.add("§7Quay lại hồ sơ của tôi");
            itemMeta.setLore(itemLore);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(49, itemStack);
        }
        p.openInventory(inventory);
    }
}
