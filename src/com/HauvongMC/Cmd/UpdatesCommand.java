package com.HauvongMC.Cmd;

import com.HauvongMC.Menu.UpdatesMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpdatesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("updates")) {
            if (!(sender instanceof Player)) return false;
            if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            UpdatesMenu.openMain(((Player) sender).getPlayer(), 0);
        }
        return false;
    }
}
