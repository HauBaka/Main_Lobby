package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            String rank = GetPlayerData.getInfo(p.getName(), "Rank");
            if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner")) {
                Location loc = p.getLocation();
                File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "config.yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                config.set("Spawn.world", loc.getWorld().getName());
                config.set("Spawn.x", loc.getX());
                config.set("Spawn.y", loc.getY());
                config.set("Spawn.z", loc.getZ());
                config.set("Spawn.yaw", loc.getYaw());
                config.set("Spawn.pitch", loc.getPitch());
                try {
                    config.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.getWorld().playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
                p.sendMessage("§aSpawn set!");
                return true;
            }
            p.sendMessage("§cYou don't have permission to use this command!");
        }
        return true;
    }
}
