package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.SubMenu.StatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.SkywarsStatusMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SkywarsStatusEvents  implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("SkyWars")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    StatusMenu.openMain(p, true);
                } else {
                    if (!GetPlayerData.getInfo(p.getName(), "Rank").equalsIgnoreCase("Default")) {
                        String name = i.getItemMeta().getDisplayName().replace("§c", "");
                        String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
                        if (name.equalsIgnoreCase(currentselect)) {
                            p.sendMessage("§cM đã chọn " + name + " Status rồi!");
                            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        } else {
                            SetPlayerData.SetInfo(p.getName(), "players", "Head_Status", name);
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                            p.sendMessage("§aĐã chọn " + name + " Status");
                            SkywarsStatusMenu.openMain(p, true);
                        }
                    } else {
                        p.sendMessage("§cBạn phải có rank VIP hoặc cao hơn để sử dụng!");
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                    }
                }
            }
        }
    }
}