package com.HauvongMC.Events;

import com.HauvongMC.API.Reflection;
import com.HauvongMC.API.Reflection.JSONMessage;
import com.HauvongMC.API.Reflection.JSONMessage.ClickEventType;
import com.HauvongMC.API.Reflection.JSONMessage.HoverEventType;
import com.HauvongMC.API.Reflection.JSONMessage.ChatExtra;
import com.HauvongMC.Items.JoinItem;
import com.HauvongMC.Main;
import com.HauvongMC.Modules.Join.Head_Status;
import com.HauvongMC.Modules.PlayerVisibility;
import com.HauvongMC.Players.GetPlayerData;

import com.nametagedit.plugin.NametagEdit;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener {
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        //lmao
        p.setFoodLevel(20);
        p.setHealth(20);
        //set up profile
        //display name
        p.setDisplayName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName());
        p.setPlayerListName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName() + " " + GetPlayerData.getInfo(p.getName(), "Suffix"));
        //tag name
        NametagEdit.getApi().setNametag(p, GetPlayerData.getInfo(p.getName(), "Prefix"), " " + GetPlayerData.getInfo(p.getName(), "Suffix"));
        //join message
        Joinmessage(p);
        //set item
        p.getInventory().clear();
        p.getInventory().setItem(0, JoinItem.getGamemenu());
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setDisplayName("§aHồ sơ §7(Nhấp chuột phải)");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Chuột phải để mở nhiệm vụ, xem thành tích,");
        itemLore.add("§7kích hoạt tăng vàng và nhiều thứ nữa!");
        head.setLore(itemLore);
        head.setOwner(p.getName());
        itemStack.setItemMeta(head);
        p.getInventory().setItem(1, itemStack);
        p.getInventory().setHeldItemSlot(0);
        //setexp
        p.setLevel(0);
        p.setExp(0);
        //new SetEXP().SetEXP(p);
        //add effect
        for (PotionEffect effect : p.getActivePotionEffects())
            p.removePotionEffect(effect.getType());
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 0));;
        //chat input
        Main.chatinput.put(p, 0);
        //gamemode
        p.setGameMode(GameMode.ADVENTURE);
        //visibility
        PlayerVisibility.getPlayer(p);
        Main.playervisibility_delay.put(p, false);
        //
        event.setJoinMessage("");
        //head status
        Head_Status.add(p);
        //tp to spawn
        if (GetPlayerData.getInfo(p.getName(), "Fly").equalsIgnoreCase("1")) {
            p.setAllowFlight(true);
            p.setFlying(true);
            Location location = Main.getSpawn().clone();
            p.teleport(location.add(0, 2, 0));
        } else {
            p.teleport(Main.getSpawn());
        }
        if (GetPlayerData.getInfo(p.getName(), "Rule").equalsIgnoreCase("0")) Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ib open rulejoin " + p.getName());
        //Nick.getNick(p);
    }

    private void Joinmessage(Player p)  {
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("VIP") && rank.equalsIgnoreCase("VIP+") && rank.equalsIgnoreCase("MVP") && rank.equalsIgnoreCase("MVP+")) {
            String guild = "§clỗi";
            String testguild = GetPlayerData.getInfo(p.getName(), "Guild");
            if (testguild != null && testguild != "")  {
                guild = testguild;
            }
            JSONMessage text = new JSONMessage("");
            ChatExtra accept = new ChatExtra(p.getDisplayName() + "§6 đã vào sảnh!");
            accept.addClickEvent(ClickEventType.RUN_COMMAND, "/profile  " + p.getName());
            accept.addHoverEvent(HoverEventType.SHOW_TEXT, p.getDisplayName()
                    + "\n§7Cấp độ LuckyMCVN: §6" + p.getLevel()
                    + "\n§7Điểm thành tích: §e" + 0
                    + "\n§7Băng đảng: §b" + guild
                    + "\n\n§eNhấp để xem hồ sơ của " + p.getDisplayName() + "§e!");
            text.addExtra(accept);
            for (Player p1 : Bukkit.getOnlinePlayers()) {
                Reflection.sendChatPacket(p1, text.toString());
            }
        } else if (rank.equalsIgnoreCase("MVP++") && rank.equalsIgnoreCase("YOUTUBE") && p.isOp()) {
            String guild = "§clỗi";
            String testguild = GetPlayerData.getInfo(p.getName(), "Guild");
            if (testguild != null && testguild != "")  {
                guild = testguild;
            }
            JSONMessage text = new JSONMessage("");
            ChatExtra accept = new ChatExtra("§b>§c>§a>  " +p.getDisplayName() + "§6 đã vào sảnh! §a<§c<§b<");
            accept.addClickEvent(ClickEventType.RUN_COMMAND, "/profile  " + p.getName());
            accept.addHoverEvent(HoverEventType.SHOW_TEXT, p.getDisplayName()
                    + "\n§7Cấp độ LuckyMCVN: §6" + p.getLevel()
                    + "\n§7Điểm thành tích: §e" + 0
                    + "\n§7Băng đảng: §b" + guild
                    + "\n\n§eNhấp để xem hồ sơ của " + p.getDisplayName() + "§e!");
            text.addExtra(accept);
            for (Player p1 : Bukkit.getOnlinePlayers()) {
                Reflection.sendChatPacket(p1, text.toString());
            }
        }
    }
}