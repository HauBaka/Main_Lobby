package com.HauvongMC.Items.SubMenu;

import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaItems {
    private static ItemStack twitter, youtube, instagram, twitch, discord, forum;
    public  SocialMediaItems(Player p) {
        String twitterurl = GetPlayerData.getInfo(p.getName(), "TwitterURL");
        String youtubeurl = GetPlayerData.getInfo(p.getName(), "YoutubeURL");//
        String instagramurl = GetPlayerData.getInfo(p.getName(), "InstagramURL");//
        String twitchurl = GetPlayerData.getInfo(p.getName(), "TwitchURL");//
        String discordurl = GetPlayerData.getInfo(p.getName(), "DiscordURL");//
        String forumurl = GetPlayerData.getInfo(p.getName(), "ForumURL");
        if (twitterurl == "") {
            twitterurl = " §cTrống";
        }
        if (youtubeurl == "") {
            youtubeurl = " §cTrống";
        }
        if (instagramurl == "") {
            instagramurl = " §cTrống";
        }
        if (twitchurl == "") {
            twitchurl = " §cTrống";
        }
        if (discordurl == "") {
            discordurl = " §cTrống";
        }
        if (forumurl == "") {
            forumurl = " §cTrống";
        }
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("nek0skeppy");
        head.setDisplayName("§bTwitter");
        List<String> itemLore  = new ArrayList<>();
        if (twitterurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + twitterurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + twitterurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        twitter = itemStack;
        //youtube
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Mieczul_Bass_YT");
        head.setDisplayName("§cYoutube");
        itemLore  = new ArrayList<>();
        if (youtubeurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + youtubeurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + youtubeurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        itemLore.add("§caccounts!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        youtube = itemStack;
        //instagram
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Ibszi");
        head.setDisplayName("§7Instagram");
        itemLore  = new ArrayList<>();
        if (instagramurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + instagramurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + instagramurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        instagram = itemStack;
        //twitch
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("aglauj");
        head.setDisplayName("§5Twitch");
        itemLore  = new ArrayList<>();
        if (twitchurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + twitchurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + twitchurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        twitch = itemStack;
        //discord
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Discoord");
        head.setDisplayName("§3Discord");
        itemLore  = new ArrayList<>();
        if (discordurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + discordurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + discordurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        discord = itemStack;
        //forum
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("HauvongMC");
        head.setDisplayName("§6Diễn đàn");
        itemLore  = new ArrayList<>();
        if (forumurl == " §cTrống") {
            itemLore.add("§7Hiện tại:" + forumurl);
        } else {
            itemLore.add("§7Hiện tại:");
            itemLore.add("§e" + forumurl);
        }
        itemLore.add("§7");
        itemLore.add("§eChuột-trái để thay đổi!");
        itemLore.add("§eChuột-phải để xóa!");
        itemLore.add("§7");
        itemLore.add("§cMọi người đều có thể thấy");
        itemLore.add("§ctài khoản mạng xã hội");
        itemLore.add("§ccủa bạn!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        forum = itemStack;
    }
    public  SocialMediaItems(String p) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("nek0skeppy");
        head.setDisplayName("§bTwitter");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        twitter = itemStack;
        //youtube
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Mieczul_Bass_YT");
        head.setDisplayName("§cYoutube");
        itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        youtube = itemStack;
        //instagram
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Ibszi");
        head.setDisplayName("§7Instagram");
        itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        instagram = itemStack;
        //twitch
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("aglauj");
        head.setDisplayName("§5Twitch");
        itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        twitch = itemStack;
        //discord
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("Discoord");
        head.setDisplayName("§3Discord");
        itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        discord = itemStack;
        //forum
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("HauvongMC");
        head.setDisplayName("§6Diễn đàn");
        itemLore  = new ArrayList<>();
        itemLore.add("§eNhấp để xem!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        forum = itemStack;
    }
    public ItemStack getDiscord() {
        return discord;
    }

    public ItemStack getTwitch() {
        return twitch;
    }

    public ItemStack getTwitter() {
        return twitter;
    }

    public ItemStack getYoutube() {
        return youtube;
    }

    public ItemStack getForum() {
        return forum;
    }

    public ItemStack getInstagram() {
        return instagram;
    }
}
