package com.HauvongMC.Events.MenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.ProfileViewer;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ViewerSocialMediaEvent implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack i = event.getCurrentItem();
        if (event.getInventory().getName().contains("Mạng xã hội của ")) {
            if (i != null && i.hasItemMeta()) {
                String name = event.getInventory().getName().replace("Mạng xã hội của ", "");
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cYoutube")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Youtube: §e" + GetPlayerData.getInfo(name, "YoutubeURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§7Instagram")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Instagram:§e " + GetPlayerData.getInfo(name, "InstagramURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§5Twitch")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Twitch:§e " + GetPlayerData.getInfo(name, "TwitchURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§3Discord")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Discord:§e " + GetPlayerData.getInfo(name, "DiscordURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§3Discord")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Discord:§e " + GetPlayerData.getInfo(name, "DiscordURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§bTwitter")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Twitter:§e " + GetPlayerData.getInfo(name, "TwitterURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Diễn đàn")) {
                    p.sendMessage("");
                    p.sendMessage("§cLink Diễn đàn:§e " + GetPlayerData.getInfo(name, "ForumURL"));
                    p.sendMessage("");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    ProfileViewer.openMain(p, name);
                }
            }
        }
    }
}