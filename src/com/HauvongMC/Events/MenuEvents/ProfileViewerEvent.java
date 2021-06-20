package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.SubMenu.ViewerSocialMediaMenu;
import com.HauvongMC.Menu.friendsmenu;
import com.HauvongMC.Menu.guildmenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ProfileViewerEvent implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack i = event.getCurrentItem();
        if (event.getInventory().getName().contains("Hồ sơ của ") && (!event.getInventory().getName().equalsIgnoreCase("Hồ sơ của tôi"))) {
            String name = event.getInventory().getName().replace("Hồ sơ của ", "");
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aMạng xã hội của " + name)) {
                    ViewerSocialMediaMenu.openMain(p, name);
                } else if (i.getType().equals(Material.PAPER)) {
                    p.sendMessage("§cSử dụng /report [người chơi] [nguyên nhân]");
                } else if (i.getType().equals(Material.SLIME_BALL)) {
                    p.sendMessage("§cSử dụng /g invite [người chơi]");
                } else if (i.getType().equals(Material.DIAMOND)) {
                    p.performCommand("/party invite " + name);
                } else if (i.getType().equals(Material.ARROW)) {
                    List<String> lore = i.getItemMeta().getLore();
                    if (lore.get(lore.size() -1).equalsIgnoreCase("§7Đến Bạn bè")) {
                        friendsmenu.openMain(p, false, null, 1);
                    } else if (lore.get(lore.size() -1).equalsIgnoreCase("§7Đến Băng đảng")) {
                        guildmenu.openMain(p, 1);
                    }
                }
            }
        }
    }
}
