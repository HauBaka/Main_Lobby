package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Menu.friendsmenu;
import com.HauvongMC.Menu.guildmenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class friendmenuEvent implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (i != null && i.hasItemMeta()) {
            if (event.getInventory().getName().equalsIgnoreCase("Bạn bè")) {
                 if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aThêm bạn")) {
                    friendsmenu.addFriend(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cXóa bạn")) {
                    friendsmenu.removeFriend(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTìm kiếm người chơi")) {
                    friendsmenu.searchFriend(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cKhông có kết quả!") || i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXóa kết quả tìm kiếm")) {
                    friendsmenu.openMain(p, false, "", 1);
                } else if ((i.getItemMeta().getDisplayName() != "" && i.getItemMeta().getDisplayName() != "§a" && event.getSlot() > 26)) {
                    String displayname = i.getItemMeta().getDisplayName();
                    displayname = displayname.replace("§7", "");
                    String[] name = displayname.split(" ");
                    p.performCommand("profile " + name[name.length - 1]);
                     ItemStack itemStack = new ItemStack(Material.ARROW, 1);
                     ItemMeta itemMeta =  itemStack.getItemMeta();
                     itemMeta.setDisplayName("§aQuay lại");
                     List<String> itemLore  = new ArrayList<>();
                     itemLore.add("§7Đến Bạn bè");
                     itemMeta.setLore(itemLore);
                     itemStack.setItemMeta(itemMeta);
                     p.getOpenInventory().setItem(49, itemStack);
                } else if ((i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau"))) {
                     List<String> lore = i.getItemMeta().getLore();
                     String lastlore = lore.get(lore.size() - 1);
                     int page = Integer.parseInt(lastlore.replace("§7Sang trang ", ""));
                     friendsmenu.openMain(p, false, null, page);
                } else if ((i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang trước"))) {
                     List<String> lore = i.getItemMeta().getLore();
                     String lastlore = lore.get(lore.size() - 1);
                     int page = Integer.parseInt(lastlore.replace("§7Quay lại trang ", ""));
                     friendsmenu.openMain(p, false, null, page);
                 }
            }
        }
    }
}
