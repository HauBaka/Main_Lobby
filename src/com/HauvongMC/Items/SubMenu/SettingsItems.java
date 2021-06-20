package com.HauvongMC.Items.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SettingsItems {
    private static ItemStack chat, privacy, lobby, api, chatvisibility, guildchatvisibility, joinmessage,
            publicprofanity, partyprofanity, guildprofanity, pmprofanity, partysound, guildsound, privatesound, chatalert
            , playervisibility, darkmode, privatemessageprivacy, friendrequestprivacy, partyinviteprivacy, guildinviteprivacy;
    public void SettingsItems() {
        String clicktoedit = "§eNhấp để chỉnh lại cài đặt của bạn!";
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        itemLore.add(clicktoedit);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aCài đặt Chat");
        itemStack.setItemMeta(itemMeta);
        chat = itemStack;
        //privacy
        itemStack = new ItemStack(Material.BARRIER);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add(clicktoedit);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aCài đặt Riêng tư");
        itemStack.setItemMeta(itemMeta);
        privacy = itemStack;
        //Lobby
        itemStack = new ItemStack(Material.NETHER_STAR);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add(clicktoedit);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aPrivacy Cài đặt");
        itemStack.setItemMeta(itemMeta);
        lobby = itemStack;
        //API
        itemStack = new ItemStack(Material.STRING);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add(clicktoedit);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aPrivacy Cài đặt");
        itemStack.setItemMeta(itemMeta);
        api = itemStack;
        //chat visibility
        itemStack = new ItemStack(Material.PAPER);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi khả năng xem");
        itemLore.add("§7chat.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aChế độ hiển thị Chat");
        itemStack.setItemMeta(itemMeta);
        chatvisibility = itemStack;
        //guid chat visibility
        itemStack = new ItemStack(Material.PAPER);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi khả năng xem");
        itemLore.add("§7băng đảng chat.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aChế độ hiển thị Băng đảng Chat");
        itemStack.setItemMeta(itemMeta);
        guildchatvisibility = itemStack;
        //lobby join message
        itemStack = new ItemStack(Material.PAPER);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi tin nhắn vào");
        itemLore.add("§7sảnh.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTin nhắn vào sảnh (Cá nhân)");
        itemStack.setItemMeta(itemMeta);
        joinmessage = itemStack;
        //public profanity level
        itemStack = new ItemStack(Material.ANVIL);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi chế độ lọc");
        itemLore.add("§7tin nhắn để chat văn");
        itemLore.add("§7minh hơn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aLọc chat chung");
        itemStack.setItemMeta(itemMeta);
        publicprofanity = itemStack;
        //party profanity level
        itemStack = new ItemStack(Material.ANVIL);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi chế độ lọc");
        itemLore.add("§7tin nhắn để chat văn");
        itemLore.add("§7minh hơn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aLọc chat tổ đội");
        itemStack.setItemMeta(itemMeta);
        partyprofanity = itemStack;
        //guild profanity level
        itemStack = new ItemStack(Material.ANVIL);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi chế độ lọc");
        itemLore.add("§7tin nhắn để chat văn");
        itemLore.add("§7minh hơn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aLọc chat băng đảng");
        itemStack.setItemMeta(itemMeta);
        guildprofanity = itemStack;
        //pm profanity level
        itemStack = new ItemStack(Material.ANVIL);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi chế độ lọc");
        itemLore.add("§7tin nhắn để chat văn");
        itemLore.add("§7minh hơn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aLọc chat PM");
        itemStack.setItemMeta(itemMeta);
        pmprofanity = itemStack;
        //party message sound
        itemStack = new ItemStack(Material.NOTE_BLOCK);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh âm thanh ting");
        itemLore.add("§7khi bạn nhận được tin nhắn");
        itemLore.add("§7từ tổ đội.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aÂm thanh tin nhắn tổ đội");
        itemStack.setItemMeta(itemMeta);
        partysound = itemStack;
        //guild message sound
        itemStack = new ItemStack(Material.NOTE_BLOCK);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh âm thanh ting");
        itemLore.add("§7khi bạn nhận được tin nhắn");
        itemLore.add("§7từ băng đảng.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aÂm thanh tin nhắn băng đảng");
        itemStack.setItemMeta(itemMeta);
        guildsound = itemStack;
        //private message sound
        itemStack = new ItemStack(Material.NOTE_BLOCK);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh âm thanh ting");
        itemLore.add("§7khi bạn nhận được tin nhắn");
        itemLore.add("§7từ PM.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aÂm thanh tin nhắn PM");
        itemStack.setItemMeta(itemMeta);
        privatesound = itemStack;
        //chatalert sound
        itemStack = new ItemStack(Material.JUKEBOX);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Tùy chỉnh âm thanh ting");
        itemLore.add("§7khi bạn nhận được tin nhắn");
        itemLore.add("§7kèm tên của bạn.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aThông báo chat");
        itemStack.setItemMeta(itemMeta);
        chatalert = itemStack;
        //player visibility
        itemStack = new ItemStack(Material.JUKEBOX);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi khả năng nhìn thấy");
        itemLore.add("§7người chơi.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aHiển thị người chơi");
        itemStack.setItemMeta(itemMeta);
        playervisibility = itemStack;
        //darkmode
        itemStack = new ItemStack(Material.JUKEBOX);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Chuyển đổi thời gian sảnh");
        itemLore.add("§7theo sáng hoặc đêm");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cChế độ sảnh tối");
        itemStack.setItemMeta(itemMeta);
        darkmode = itemStack;

    }

    public static ItemStack getChatalert() {
        return chatalert;
    }

    public static ItemStack getChatvisibility() {
        return chatvisibility;
    }

    public static ItemStack getDarkmode() {
        return darkmode;
    }

    public static ItemStack getGuildchatvisibility() {
        return guildchatvisibility;
    }

    public static ItemStack getGuildprofanity() {
        return guildprofanity;
    }

    public static ItemStack getGuildsound() {
        return guildsound;
    }

    public static ItemStack getJoinmessage() {
        return joinmessage;
    }

    public static ItemStack getPartyprofanity() {
        return partyprofanity;
    }

    public static ItemStack getPartysound() {
        return partysound;
    }

    public static ItemStack getPmprofanity() {
        return pmprofanity;
    }

    public static ItemStack getPlayervisibility() {
        return playervisibility;
    }

    public static ItemStack getPrivatesound() {
        return privatesound;
    }

    public static ItemStack getPublicprofanity() {
        return publicprofanity;
    }

    public static ItemStack getFriendrequestprivacy() {
        return friendrequestprivacy;
    }

    public static ItemStack getGuildinviteprivacy() {
        return guildinviteprivacy;
    }

    public static ItemStack getPartyinviteprivacy() {
        return partyinviteprivacy;
    }

    public static ItemStack getPrivatemessageprivacy() {
        return privatemessageprivacy;
    }


    public static ItemStack getApi() {
        return api;
    }

    public static ItemStack getChat() {
        return chat;
    }

    public static ItemStack getLobby() {
        return lobby;
    }

    public static ItemStack getPrivacy() {
        return privacy;
    }
}
