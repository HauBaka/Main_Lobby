package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.SubMenu.StatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.GeneralStatusMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GeneralStatusEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Chung")) {
            if (i != null && i.hasItemMeta()) {
                String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cLần đầu tham gia máy chủ")) {
                    if (p.getLevel() > 30) {
                        if (!(currentselect.equalsIgnoreCase("First Joined"))) {
                            p.sendMessage("§aĐã chọn trạng thái Lần đầu tham gia máy chủ");
                            SetPlayerData.SetInfo(p.getName(), "players", "Head_Status", "First Joined");
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                            GeneralStatusMenu.openMain(p, true);
                        } else {
                            p.sendMessage("§cM đã chọn trạng thái Lần đầu tham gia máy chủ rồi!");
                            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        }
                    } else {
                        p.sendMessage("§cYêu cầu §3Cấp độ LuckyMCVN 30");
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                    }
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aPing")) {
                    if (p.getLevel() > 35) {
                        if (!(currentselect.equalsIgnoreCase("Ping"))) {
                            p.sendMessage("§aĐã chọn trạng thái Ping");
                            SetPlayerData.SetInfo(p.getName(), "players", "Head_Status", "Ping");
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                            GeneralStatusMenu.openMain(p, true);
                        } else {
                            p.sendMessage("§cM đã chọn Ping Status rồi!");
                            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        }
                    } else {
                        p.sendMessage("§cYêu cầu §3Cấp độ LuckyMCVN 35");
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                    }
                }else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    StatusMenu.openMain(p, true);
                }
            }
        }
    }
}