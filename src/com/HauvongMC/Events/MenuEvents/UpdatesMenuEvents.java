package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.UpdatesMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class UpdatesMenuEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (i != null && i.hasItemMeta()) {
            if (event.getInventory().getName().contains("LuckyMCVN Updates")) {
                int pages = Integer.parseInt(event.getInventory().getName().replace("LuckyMCVN Updates | Page ", ""));
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cĐóng")) {
                    p.closeInventory();
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    pages--;
                    UpdatesMenu.openMain(p, pages);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau")) {
                    pages++;
                    UpdatesMenu.openMain(p, pages);
                }
            }
        }
    }
}