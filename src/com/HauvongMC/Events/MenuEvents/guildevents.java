package com.HauvongMC.Events.MenuEvents;

import com.HauvongMC.Main;
import com.HauvongMC.Menu.guildmenu;
import com.HauvongMC.Modules.Guild.Guild;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class guildevents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("Guild") && event.getSlot() > 17) {
            ItemStack i = event.getCurrentItem();
            Player p = (Player) event.getWhoClicked();
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau")) {//friend menu
                    List<String> lore = i.getItemMeta().getLore();
                    String lastlore = lore.get(lore.size() - 1);
                    int page = Integer.parseInt(lastlore.replace("§7Sang trang ", ""));
                    guildmenu.openMain(p, page);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang trước")) {//friend menu
                    List<String> lore = i.getItemMeta().getLore();
                    String lastlore = lore.get(lore.size() - 1);
                    int page = Integer.parseInt(lastlore.replace("§7Quay lại trang ", ""));
                    guildmenu.openMain(p, page);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aDiscord của băng đảng")) {//friend menu
                    String guild = GetPlayerData.getInfo(p.getName(), "Guild");
                    if (guild == null || guild.equalsIgnoreCase("")) {
                        sendmessage(p, "§cBạn chưa gia nhập băng đảng nào!");
                    } else {
                        sendmessage(p, "§eLink Discord của băng đảng §6" + guild + "§e:", "§b" + Guild.getDiscord(guild));
                    }
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aMời người chơi")) {//friend menu
                    p.closeInventory();
                    p.sendMessage("§eSử dụng: /g invite [người chơi]");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aCài đặt băng đảng")) {//friend menu
                    p.sendMessage("§cLười làm quááááááááááááááááááá!");
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cTạo băng đảng")) {//friend menu
                    Main.chatinput.replace(p, 12);
                    p.sendMessage("§eSử dụng: /g create [tên băng đảng]");
                    p.closeInventory();
                } else if ((i.getItemMeta().getDisplayName() != "" && i.getItemMeta().getDisplayName() != "§a" && event.getSlot() > 35)) {
                    String displayname = i.getItemMeta().getDisplayName();
                    displayname = displayname.replace("§7", "");
                    String[] name = displayname.split(" ");
                    p.performCommand("profile " + name[name.length - 1]);
                    ItemStack itemStack = new ItemStack(Material.ARROW, 1);
                    ItemMeta itemMeta =  itemStack.getItemMeta();
                    itemMeta.setDisplayName("§aQuay lại");
                    List<String> itemLore  = new ArrayList<>();
                    itemLore.add("§7Đến Băng đảng");
                    itemMeta.setLore(itemLore);
                    itemStack.setItemMeta(itemMeta);
                    p.getOpenInventory().setItem(49, itemStack);
                }
            }
        }
    }

    private static void sendmessage(Player p, String message) {
        p.sendMessage("§b---------------------------------------------");
        p.sendMessage(message);
        p.sendMessage("§b---------------------------------------------");
    }
    private static void sendmessage(Player p, String message, String message2) {
        p.sendMessage("§b---------------------------------------------");
        p.sendMessage(message);
        p.sendMessage(message2);
        p.sendMessage("§b---------------------------------------------");
    }
}
