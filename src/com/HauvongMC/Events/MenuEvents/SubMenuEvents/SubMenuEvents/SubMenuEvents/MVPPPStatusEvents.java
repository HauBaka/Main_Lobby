package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.SubMenu.StatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.MVPPPStatusMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MVPPPStatusEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Trạng thái dành cho MVP++")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    StatusMenu.openMain(p, true);
                } else {
                    String rank = GetPlayerData.getInfo(p.getName(), "Rank");
                    if (!rank.equalsIgnoreCase("Default") && !rank.equalsIgnoreCase("VIP") && !rank.equalsIgnoreCase("VIP+") && !rank.equalsIgnoreCase("MVP") && !rank.equalsIgnoreCase("MVP+")) {
                        String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
                        String name = i.getItemMeta().getDisplayName();
                        name = name.replace("§c", "").replace("§d§l", "");
                        if (currentselect.equalsIgnoreCase(name)) {
                            p.sendMessage("§cM đã chọn trạng thái " + name + " rồi!");
                            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        } else {
                            p.sendMessage("§aĐã chọn trạng thái " + name);
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                            SetPlayerData.SetInfo(p.getName(), "players", "Head_Status", name);
                            MVPPPStatusMenu.openMain(p, true);
                        }
                    } else {
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        p.sendMessage("§cBạn phải có rank MVP++ hoặc cao hơn để sử dụng!");
                    }
                }
            }
        }
    }
}