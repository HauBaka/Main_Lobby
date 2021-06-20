package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.AppearancesMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.RankColorMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RankColorEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Màu rank MVP+")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    AppearancesMenu.openMain(p);
                } else {
                    List<String> lore = i.getItemMeta().getLore();
                    if (lore.get(lore.size() - 1).equalsIgnoreCase("§eNhấp để chọn!")) {
                        String name = i.getItemMeta().getDisplayName();
                        name = name.replace("§c", "");
                        p.sendMessage("§aĐã chọn " + name +"!");
                        name = name.replace("Màu ", "");
                        String value;
                        switch (name) {
                            default:
                                value = "§c";
                                break;
                            case "vàng đậm":
                                value = "§6";
                                break;
                            case "xanh":
                                value = "§a";
                                break;
                            case "vàng":
                                value = "§e";
                                break;
                            case "hồng nhạt":
                                value = "§d";
                                break;
                            case "trắng":
                                value = "§f";
                                break;
                            case "xanh biển":
                                value = "§b";
                                break;
                            case "xanh lá đậm":
                                value = "§2";
                                break;
                            case "đỏ đậm":
                                value = "§4";
                                break;
                            case "xanh biển đậm":
                                value = "§3";
                                break;
                            case "hồng đậm":
                                value = "§5";
                                break;
                            case "xám đậm":
                                value = "§8";
                                break;
                            case "đen":
                                value = "§0";
                                break;
                            case "xanh biển đậm đậm":
                                value = "§1";
                                break;
                        }
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                        SetPlayerData.SetInfo(p.getName(), "players", "Plus_Color", value);
                        SetPlayerData.setRank(p.getName(), GetPlayerData.getInfo(p.getName(), "Rank"));
                        p.setDisplayName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName() + GetPlayerData.getInfo(p.getName(), "Suffix"));
                        p.setPlayerListName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName() + GetPlayerData.getInfo(p.getName(), "Suffix"));
                        RankColorMenu.openMain(p, true);
                    }
                }
            }
        }
    }
}