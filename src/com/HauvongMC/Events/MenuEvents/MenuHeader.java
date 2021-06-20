package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MenuHeader implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        if (i != null && i.hasItemMeta()) {
            Player p = (Player) event.getWhoClicked();
            if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aBạn bè")) {//friend menu
                friendsmenu.openMain(p, false, "", 1);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase(p.getDisplayName())) {//main menu
                myprofilemenu.openMain(p);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTổ đội")) {//party menu
                partymenu.openMain(p);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aBăng đảng")) {//party menu
                guildmenu.openMain(p, 1);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aNgười chơi gần đây")) {//party menu
                recentplayersmenu.openMain(p, false, "");
            }
        }
    }

}
