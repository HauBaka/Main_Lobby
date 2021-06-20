package com.HauvongMC.Events.MenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.SubMenu.PunchMessagesMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.RankColorMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.StatusMenu;
import com.HauvongMC.Menu.myprofilemenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AppearancesMenuEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Tùy chỉnh giao diện")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aMàu rank MVP+")) {
                    RankColorMenu.openMain(p, true);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    myprofilemenu.openMain(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aHiệu ứng đấm Staff")) {
                    PunchMessagesMenu.openMain(p, true);
                } else if  (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrạng thái")) {
                    StatusMenu.openMain(p, true);
                }
            }
        }
    }
}
