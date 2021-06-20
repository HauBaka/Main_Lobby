package com.HauvongMC.Events;

import com.HauvongMC.API.Reflection;
import com.HauvongMC.API.Reflection.JSONMessage;
import com.HauvongMC.API.Reflection.JSONMessage.ClickEventType;
import com.HauvongMC.API.Reflection.JSONMessage.HoverEventType;
import com.HauvongMC.API.Reflection.JSONMessage.ChatExtra;
import com.HauvongMC.Listener.Bungeecord;
import com.HauvongMC.Main;
import com.HauvongMC.Menu.SubMenu.socialmediamenu;
import com.HauvongMC.Menu.friendsmenu;
import com.HauvongMC.Menu.guildmenu;
import com.HauvongMC.Menu.recentplayersmenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;



public class Chat implements Listener {
    @EventHandler
    public void PlayerChat(PlayerChatEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        event.setCancelled(true);
        Player p = event.getPlayer();
        int check = Main.chatinput.get(p);
        if (check == 0) {
            String message = event.getMessage();
            String guild = "§cnull";
            String testguild = GetPlayerData.getInfo(p.getName(), "Guild");
            if (testguild != null && testguild != "")  {
                guild = "§6" + testguild;
            }
            JSONMessage text = new JSONMessage("");
            if (GetPlayerData.getInfo(p.getName(), "Nick").equalsIgnoreCase("true")) {
                String displayname = GetPlayerData.getInfo(p.getName(), "Nick_Rank") + GetPlayerData.getInfo(p.getName(), "Nick_Name");
                ChatExtra chatExtra = new ChatExtra(displayname);
                chatExtra.addClickEvent(ClickEventType.RUN_COMMAND, "/profile  " + p.getName());
                chatExtra.addHoverEvent(HoverEventType.SHOW_TEXT, displayname
                        + "\n§7Cấp độ: §6" + p.getLevel()
                        + "\n§7Điểm thành tích: §e" + GetPlayerData.getInfo(p.getName(), "Achievement_Points")
                        + "\n§7Băng đảng: §b" + guild
                        + "\n\n§eNhấp để xem hồ sơ của " + displayname + "§e!");
                ChatExtra chatmessage = new ChatExtra(": " + message);
                text.addExtra(chatExtra);
                text.addExtra(chatmessage);
                for (Player p1 : Bukkit.getOnlinePlayers()) {
                    Reflection.sendChatPacket(p1, text.toString());
                }
            } else {
                ChatExtra chatExtra = new ChatExtra(p.getDisplayName());
                chatExtra.addClickEvent(ClickEventType.RUN_COMMAND, "/profile  " + p.getName());
                chatExtra.addHoverEvent(HoverEventType.SHOW_TEXT, p.getDisplayName()
                        + "\n§7Cấp độ: §6" + p.getLevel()
                        + "\n§7Điểm thành tích: §e" + GetPlayerData.getInfo(p.getName(), "Achievement_Points")
                        + "\n§7Băng đảng: §b" + guild
                        + "\n\n§eNhấp để xem hồ sơ của " + p.getDisplayName() + "§e!");
                ChatExtra chatmessage = new ChatExtra(": " + message);
                text.addExtra(chatExtra);
                text.addExtra(chatmessage);
                for (Player p1 : Bukkit.getOnlinePlayers()) {
                    Reflection.sendChatPacket(p1, text.toString());
                }
            }
        } else if (check == 1) {
            friendsmenu.openMain(p, true, event.getMessage(), 1);
            Main.chatinput.replace(p, 0);
        } else if (check == 2) {
            friendsmenu.openMain(p, false, "", 1);
            Main.chatinput.replace(p, 0);
            p.performCommand("/f add " + event.getMessage());
        } else if (check == 3) {
            friendsmenu.openMain(p, false, "", 1);
            Main.chatinput.replace(p, 0);
            p.performCommand("/f remove " + event.getMessage());
        } else if (check == 4) {
            recentplayersmenu.openMain(p, true, event.getMessage());
            Main.chatinput.replace(p, 0);
        } else if (check == 5) {
            SetPlayerData.SetInfo(p.getName(), "players", "TwitterURL", event.getMessage());
            p.sendMessage("§aYour Twitter link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 6) {
            SetPlayerData.SetInfo(p.getName(), "players", "YoutubeURL", event.getMessage());
            p.sendMessage("§aYour Youtube link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 7) {
            SetPlayerData.SetInfo(p.getName(), "players", "InstagramURL", event.getMessage());
            p.sendMessage("§aYour Instagram link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 8) {
            SetPlayerData.SetInfo(p.getName(), "players", "TwitchURL", event.getMessage());
            p.sendMessage("§aYour Twitch link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 9) {
            SetPlayerData.SetInfo(p.getName(), "players", "DiscordURL", event.getMessage());
            p.sendMessage("§aYour Discord link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 10) {
            SetPlayerData.SetInfo(p.getName(), "players", "ForumURL", event.getMessage());
            p.sendMessage("§aYour Forum link has been set to §6" + event.getMessage() + "§a!");
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            socialmediamenu.openMain(p);
            Main.chatinput.replace(p, 0);
        } else if (check == 11) {
            Bungeecord.send(p, "get", "/g invite "+ event.getMessage());
            p.chat("/g invite " + event.getMessage());
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            guildmenu.openMain(p, 1);
            Main.chatinput.replace(p, 0);
        } else if (check == 12) {
            p.chat("/g create " + event.getMessage());
            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
            guildmenu.openMain(p, 1);
            Main.chatinput.replace(p, 0);
        }


    }
}
