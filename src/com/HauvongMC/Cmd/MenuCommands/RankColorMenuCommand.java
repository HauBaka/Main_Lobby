package com.HauvongMC.Cmd.MenuCommands;

import com.HauvongMC.Menu.SubMenu.SubMenu.RankColorMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankColorMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("rankcolormenu")) {
            if (!(sender instanceof Player)) return false;
            if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            RankColorMenu.openMain(((Player) sender).getPlayer(), false);
            return true;
        }
        return true;
    }
}