package com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents;

import com.HauvongMC.API.Reflection;
import com.HauvongMC.API.Reflection.JSONMessage;
import com.HauvongMC.API.Reflection.JSONMessage.ClickEventType;
import com.HauvongMC.API.Reflection.JSONMessage.HoverEventType;
import com.HauvongMC.API.Reflection.JSONMessage.ChatExtra;
import com.HauvongMC.Menu.SubMenu.AppearancesMenu;
import com.HauvongMC.Menu.SubMenu.SubMenu.PunchMessagesMenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PunchMessagesEvents implements Listener {
    @EventHandler
    public void invclick(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Hiệu ứng đấm Staff")) {
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    AppearancesMenu.openMain(p);
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cĐặt lại hiệu ứng đấm STAFF")) {
                    SetPlayerData.SetInfo(p.getName(), "players", "Punch_Message", "");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                    p.sendMessage("§aĐã xóa Hiệu ứng đấm Staff!");
                    PunchMessagesMenu.openMain(p, true);
                }
                if (event.getSlot() < 44) {
                    if (event.isLeftClick()) {
                        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
                        if (rank.equalsIgnoreCase("Default")
                                || rank.equalsIgnoreCase("VIP")
                                || rank.equalsIgnoreCase("VIP+")
                                || rank.equalsIgnoreCase("MVP")) {
                            p.sendMessage("§cBạn phải là §bMVP§c+ hoặc cao hơn mới có thể sử dụng!");
                        } else {
                            String currentselect = GetPlayerData.getInfo(p.getName(), "Punch_Message");
                            String displayname = i.getItemMeta().getDisplayName();
                            displayname = displayname.replace("§c", "").replace(" Punch Message", "");
                            String name = "";
                            switch (displayname) {
                                default:
                                    name = "Loving";
                                    break;
                                case "Phân":
                                    name = "Boop";
                                    break;
                                case "Bóng tuyết":
                                    name = "SnowBall";
                                    break;
                                case "Ngoạn mục":
                                    name = "Glorious";
                                    break;
                            }
                            if (!(currentselect.equalsIgnoreCase(name))) {
                                SetPlayerData.SetInfo(p.getName(), "players", "Punch_Message", name);
                                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                                p.sendMessage("§aĐã chọn " + displayname + " Hiệu ứng đấm Staff!");
                                PunchMessagesMenu.openMain(p, true);
                            } else {
                                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                                p.sendMessage("§cM đã chọn " + displayname + " Hiệu ứng đấm Staff rồi!");
                            }
                        }
                    } else {
                        String displayname = i.getItemMeta().getDisplayName();
                        displayname = displayname.replace("§c", "").replace(" Punch Message", "");
                        String name = "";
                        switch (displayname) {
                            default:
                                name = "Loving";
                                break;
                            case "Phân":
                                name = "Boop";
                                break;
                            case "Bóng tuyết":
                                name = "SnowBall";
                                break;
                            case "Ngoạn mục":
                                name = "Glorious";
                                break;
                        }
                        String vl;
                        switch (name) {
                            default:
                                vl = " ";
                                break;
                            case "Loving":
                                vl = " §7vì ghen mà đánh ";
                                break;
                            case "Boop":
                                vl = " §7đã ném §d§lPhân§r §7vào mặt ";
                                break;
                            case "SnowBall":
                                vl = " §7đã ném §f§lbóng tuyết§7 vào mặt ";
                                break;
                            case "Glorious":
                                vl = " §7đã giáng cú đấm §6ngoạn mục§r ";
                                break;
                        }
                        p.closeInventory();
                        JSONMessage text = new JSONMessage("");
                        ChatExtra goback = new ChatExtra("§eNhấp vào đây để quay lại menu Hiệu ứng đấm Staff!");
                        goback.addClickEvent(ClickEventType.RUN_COMMAND, "/punchmessagesmenu");
                        goback.addHoverEvent(HoverEventType.SHOW_TEXT, "§aQuay lại menu Hiệu ứng đấm Staff");
                        text.addExtra(goback);
                        p.sendMessage("§7Xem mẫu: " + p.getDisplayName() + vl + p.getDisplayName() + " §7khiến cho " + p.getDisplayName() + " §7bay lên cao tút trời xanh");
                        Reflection.sendChatPacket(p, text.toString());
                    }
                }
            }
        }
    }
}