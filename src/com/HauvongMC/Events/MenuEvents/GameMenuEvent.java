package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Listener.BungeeListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class GameMenuEvent implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (i != null && i.hasItemMeta()) {
            if (event.getInventory().getName().equalsIgnoreCase("Game Menu")) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyWars")) {
                    BungeeListener bungeeListener = new BungeeListener();
                    p.sendMessage("§aSending you to Skywars");
                    bungeeListener.SendtoServer(p, "Skywars");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aMain Lobby")) {
                    BungeeListener bungeeListener = new BungeeListener();
                    p.sendMessage("§aSending you to Lobby");
                    bungeeListener.SendtoServer(p, "Lobby");
                }
            }
        }
    }
}
