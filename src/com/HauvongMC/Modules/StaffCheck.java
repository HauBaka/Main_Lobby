package com.HauvongMC.Modules;

import com.HauvongMC.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class StaffCheck {
    public static void startcheck(Player p) {
        if (p.isOp() || p.hasPermission("haudepzaivc")) {
            File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "config.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("StaffChat" + p.getName(), "0");
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    if (config.getString("StaffCheck." + p.getName()).equalsIgnoreCase("0") && p.isOnline()) {
                        p.kickPlayer("IDIOT");
                    }
                }
            },20*15);
        }
    }
}
