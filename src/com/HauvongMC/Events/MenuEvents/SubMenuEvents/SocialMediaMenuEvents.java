package com.HauvongMC.Events.MenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.socialmediamenu;
import com.HauvongMC.Menu.myprofilemenu;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SocialMediaMenuEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Mạng xã hội")) {
            if (i != null && i.hasItemMeta()) {
                if (event.isLeftClick()) {
                    if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§bTwitter")) {
                        socialmediamenu.setTwitter(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cYoutube")) {
                        socialmediamenu.setYoutube(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§7Instagram")) {
                        socialmediamenu.setInstagram(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§5Twitch")) {
                        socialmediamenu.setTwitch(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§3Discord")) {
                        socialmediamenu.setDiscord(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Forum")) {
                        socialmediamenu.setForum(p);
                    }
                } else if (event.isRightClick()) {
                    if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§bTwitter")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "TwitterURL", "");
                        socialmediamenu.openMain(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cYoutube")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "YoutubeURL", "");
                        socialmediamenu.openMain(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§7Instagram")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "InstagramURL", "");
                        socialmediamenu.openMain(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§5Twitch")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "TwitchURL", "");
                        socialmediamenu.openMain(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§3Discord")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "DiscordURL", "");
                        socialmediamenu.openMain(p);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Diễn đàn")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "ForumURL", "");
                        socialmediamenu.openMain(p);
                    }
                }
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    SetPlayerData.SetInfo(p.getName(), "players", "TwitterURL", "");
                    myprofilemenu.openMain(p);
                }
            }
        }
    }
}
