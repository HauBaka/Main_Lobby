package com.HauvongMC.Cmd;

import com.HauvongMC.Menu.ProfileViewer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = ((Player) sender).getPlayer();
        if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
            sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
            return false;
        }
        if (args.length > 0) ProfileViewer.openMain(p, args[0]);
        else p.sendMessage("§cSử dụng /Profile [tên người chơi]");
        return false;
    }
}
