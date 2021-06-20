package com.HauvongMC.Modules;

import com.HauvongMC.Items.JoinItem;
import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.entity.Player;

public class PlayerVisibility {
    private static String check;
    public static void getPlayer(Player p) {
         check = GetPlayerData.getInfo(p.getName(), "PlayerVisibility");//0 = off. 1 = on
        for (Player player : Main.getSpawn().getWorld().getPlayers()) {
            if (player != p && GetPlayerData.getInfo(player.getName(), "PlayerVisibility").equalsIgnoreCase("0")) player.hidePlayer(p);
            if (check.equalsIgnoreCase("0") && player != null) {
                p.hidePlayer(player);
            }
        }
        if (GetPlayerData.getInfo(p.getName(), "PlayerVisibility").equalsIgnoreCase("1")) {
            p.getInventory().setItem(7, JoinItem.getPlayertoggleon());
        } else {
            p.getInventory().setItem(7, JoinItem.getPlayertoggleoff());
        }
    }
}
