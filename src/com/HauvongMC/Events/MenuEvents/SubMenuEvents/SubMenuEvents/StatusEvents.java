package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.Menu.SubMenu.AppearancesMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.StatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.GeneralStatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.MVPPPStatusMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.SubMenu.SkywarsStatusMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class StatusEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Trạng thái")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrạng thái dành cho §6MVP§c++")) {
                    MVPPPStatusMenu.openMain(p, true);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cĐặt lại trạng thái")) {
                    SetPlayerData.SetInfo(p.getName(), "players", "Head_Status", "");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aChuyển đổi chế độ trạng thái")) {
                    if (GetPlayerData.getInfo(p.getName(), "Head_Status_Toggle").equalsIgnoreCase("0")) {
                        SetPlayerData.SetInfo(p.getName(), "players", "Head_Status_Toggle", "1");
                    } else SetPlayerData.SetInfo(p.getName(), "players", "Head_Status_Toggle", "0");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    StatusMenu.openMain(p, true);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    AppearancesMenu.openMain(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aChung")) {
                    GeneralStatusMenu.openMain(p, true);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aSkyWars")) {
                    if (GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo") == null) {
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                        p.sendMessage("§cVui lòng vào máy chủ SkyWars để chúng tôi có thể thêm thông tin của bạn vào dữ liệu máy chủ.");
                    } else SkywarsStatusMenu.openMain(p, true);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aBed Wars")) {
                    p.sendMessage("§cĐợi khi nào ad hứng thì ad thêm vô cho...");
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                }
            }
        }
    }
}