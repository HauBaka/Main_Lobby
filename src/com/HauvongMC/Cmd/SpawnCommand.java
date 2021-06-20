package com.HauvongMC.Cmd;

import com.HauvongMC.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("stuck")) {
            if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            Player p = ((Player) sender).getPlayer();
            p.teleport(Main.getSpawn());
        }
        return true;
    }
}
