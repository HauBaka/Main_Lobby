package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.SubMenu.AppearancesMenu;
import com.HauvongMC.Menu.SubMenu.SettingsMenu;
import com.HauvongMC.Menu.SubMenu.StatsViewer;
import com.HauvongMC.Menu.SubMenu.socialmediamenu;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;



public class myprofileEvent implements Listener {
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        if (i != null && i.hasItemMeta()) {
            Player p = (Player) event.getWhoClicked();
            if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aMạng xã hội")) {
                socialmediamenu.openMain(p);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXem hồ sơ")) {
                StatsViewer.openMain(p);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTùy chỉnh giao diện")) {
                AppearancesMenu.openMain(p);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aCài đặt & Tàng hình")) {
                SettingsMenu.openMain(p, true);
            } else if (i.getType() == Material.BEDROCK) {
                p.sendMessage("§cĐợi khi nào ad rảnh update thêm cho");
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
            }
        }
    }
}
