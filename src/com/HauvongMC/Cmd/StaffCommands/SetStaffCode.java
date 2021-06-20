package com.HauvongMC.Cmd.StaffCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.io.IOException;

public class SetStaffCode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("SetStaffCode")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            PermissionUser permissionUser = PermissionsEx.getUser(p);
            if (permissionUser.has("haudepzai") || p.isOp()) {
                File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "config.yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("newkey")) {
                        config.set("StaffCode", args[1]);
                        try {
                            config.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                } else if (args.length == 1) {
                    String code = config.getString("StaffCode");
                    if (!(args[0].equalsIgnoreCase(code))) {
                        p.kickPlayer("SAD");
                    } else {
                        config.set("StaffCheck." + p.getName(), 1);
                    }
                }
            }
            p.kickPlayer(":(\nThis command is not for fun \n:)");
        }
        return false;
    }
}
