package com.HauvongMC.Events;

import com.HauvongMC.Main;
import com.HauvongMC.Modules.Join.Head_Status;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerQuit implements Listener {
    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event) {
        Main.playervisibility_delay.remove(event.getPlayer());
        SetPlayerData.SetInfo(event.getPlayer().getName(), "players", "Online_Status", "0");
        Head_Status.removeHeadStatus(event.getPlayer());
        event.setQuitMessage("");
    }
}
