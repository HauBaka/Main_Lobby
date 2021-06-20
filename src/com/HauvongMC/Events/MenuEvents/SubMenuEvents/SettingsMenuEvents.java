package com.HauvongMC.Events.MenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.SettingsMenu;
import com.HauvongMC.Menu.myprofilemenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SettingsMenuEvents implements Listener {
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Cài đặt & Tàng hình")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    myprofilemenu.openMain(p);
                } else  {
                    String name = i.getItemMeta().getDisplayName();
                    name = name.replace("§c", "").replace("§a", "").replace("§6", "");
                    if (name.equalsIgnoreCase("Âm thanh tin nhắn tổ đội")) {
                        int Party_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Party_Message_Sounds"));
                        Party_Message_Sounds++;
                        if (Party_Message_Sounds == 2) Party_Message_Sounds = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Party_Message_Sounds", Party_Message_Sounds +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    } else if (name.equalsIgnoreCase("Âm thanh tin nhắn băng đảng")) {
                        int Guild_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Message_Sounds"));
                        Guild_Message_Sounds++;
                        if (Guild_Message_Sounds == 2) Guild_Message_Sounds = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Guild_Message_Sounds", Guild_Message_Sounds +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    } else if (name.equalsIgnoreCase("Âm thanh tin nhắn PM")) {
                        int Private_Message_Sounds = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Private_Message_Sounds"));
                        Private_Message_Sounds++;
                        if (Private_Message_Sounds == 2) Private_Message_Sounds = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Private_Message_Sounds", Private_Message_Sounds +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Tin nhắn vào sảnh (Cá nhân)")) {
                        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
                        if (rank.equalsIgnoreCase("Default") || rank.equalsIgnoreCase("VIP") ||
                                rank.equalsIgnoreCase("VIP+") || rank.equalsIgnoreCase("MVP")) {
                            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        } else {
                            int Join_Message = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Join_Message"));
                            Join_Message++;
                            if (Join_Message == 2) Join_Message = 0;
                            SetPlayerData.SetInfo(p.getName(), "players", "Join_Message", Join_Message +"");
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                        }
                    }  else if (name.equalsIgnoreCase("Lọc chat chung")) {
                        int Public_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Public_Profanity_Level"));
                        Public_Profanity_Level++;
                        if (Public_Profanity_Level == 2) Public_Profanity_Level = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Public_Profanity_Level", Public_Profanity_Level +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Lọc chat tổ đội")) {
                        int Party_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Party_Profanity_Level"));
                        Party_Profanity_Level++;
                        if (Party_Profanity_Level == 3) Party_Profanity_Level = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Party_Profanity_Level", Party_Profanity_Level +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Lọc chat băng đảng")) {
                        int Guild_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Profanity_Level"));
                        Guild_Profanity_Level++;
                        if (Guild_Profanity_Level == 3) Guild_Profanity_Level = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Guild_Profanity_Level", Guild_Profanity_Level +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Lọc chat PM")) {
                        int PM_Profanity_Level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "PM_Profanity_Level"));
                        PM_Profanity_Level++;
                        if (PM_Profanity_Level == 3) PM_Profanity_Level = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "PM_Profanity_Level", PM_Profanity_Level +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Chế độ hiển thị Chat")) {
                        int Chat_Visibility = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Chat_Visibility"));
                        Chat_Visibility++;
                        if (Chat_Visibility == 2) Chat_Visibility = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Chat_Visibility", Chat_Visibility +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Chế độ hiển thị Băng đảng Chat")) {
                        int Guild_Chat_Visibility = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Guild_Chat_Visibility"));
                        Guild_Chat_Visibility++;
                        if (Guild_Chat_Visibility == 2) Guild_Chat_Visibility = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Guild_Chat_Visibility", Guild_Chat_Visibility +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }  else if (name.equalsIgnoreCase("Thông báo chat")) {
                        int Chat_Alerts = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Chat_Alerts"));
                        Chat_Alerts++;
                        if (Chat_Alerts == 2) Chat_Alerts = 0;
                        SetPlayerData.SetInfo(p.getName(), "players", "Chat_Alerts", Chat_Alerts +"");
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    }
                    SettingsMenu.openMain(p, true);
                }
            }
        }
    }
}
