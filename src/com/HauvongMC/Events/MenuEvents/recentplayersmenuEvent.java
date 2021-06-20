package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.friendsmenu;
import com.HauvongMC.Menu.recentplayersmenu;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class recentplayersmenuEvent implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (i != null && i.hasItemMeta()) {
            if (event.getInventory().getName().equalsIgnoreCase("Người chơi gần đây")) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXóa người chơi gần đây")) {
                    SetPlayerData.SetInfo(p.getName(), "players", "Recent_Players", "");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTìm kiếm người chơi")) {
                    recentplayersmenu.searchPlayer(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXóa kết quả tìm kiếm") || i.getItemMeta().getDisplayName().equalsIgnoreCase("§cKhông có kết quả!")) {
                    recentplayersmenu.openMain(p, false, "");
                } else if ((i.getItemMeta().getDisplayName() != "" && i.getItemMeta().getDisplayName() != "§a" && event.getSlot() > 26)) {
                    String displayname = i.getItemMeta().getDisplayName();
                    displayname = displayname.replace("§7", "");
                    String[] name = displayname.split("");
                    p.performCommand("/profile " + name[1]);
                }
            }
        }
    }
}
