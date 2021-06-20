package com.HauvongMC.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static com.HauvongMC.Cmd.StaffCommands.Kaboom.kabooms;

public class EntityDamage implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player)event.getEntity();
            if (kabooms.contains(player)) {
                event.setCancelled(true);
                if (player.isOnGround()) kabooms.remove(player);
            }
        }
    }
}
