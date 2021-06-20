package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Players.HVPlayer;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPlayerDataCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("SetPlayerData")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            HVPlayer player = new HVPlayer(p);
            if (player.getName().equalsIgnoreCase("HauvongMC") || player.getRank().equalsIgnoreCase("Admin") || player.getRank().equalsIgnoreCase("Owner")) {
                if (args.length == 4) {
                    String text = args[3];
                    text = text.replace("_", " ");
                    SetPlayerData.SetInfo(args[0], args[1], args[2], text);
                    p.sendMessage("§a" + args[0] + "'s " + args[2] + " data was set to " + text + " in database " + args[1]);
                    return true;
                } else if (args.length > 4) {
                    String text = "";
                    for (int i = 3; i < args.length; i ++) {
                        text = text + "_" + args[i];
                    }
                    p.performCommand("/SetPlayerData " + args[0] + " " + args[1] + " " + args[2] + " " + text);
                    return true;
                }
            }
            p.sendMessage("§cYou are not allowed to do this!");
            return false;
        }
        return true;
    }
}
