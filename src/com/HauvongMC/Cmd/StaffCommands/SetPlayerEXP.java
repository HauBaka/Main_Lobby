package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Players.HVPlayer;
import com.HauvongMC.Players.SetEXP;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPlayerEXP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("SetPlayerExp")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            HVPlayer player = new HVPlayer(p);
            if (p.getName().equalsIgnoreCase("HauvongMC") || player.getRank().equalsIgnoreCase("Admin") || player.getRank().equalsIgnoreCase("Owner")) {
                if (args.length != 2) {
                    p.sendMessage("§c/SetPlayerEXP [player] [exp]");
                    return false;
                }
                p.sendMessage("§a" + args[0] +"'s Network exp was set to " + args[1]);
                SetPlayerData.SetInfo(args[0], "players", "Network_EXP", args[1]);
                if (Bukkit.getPlayer(args[0]) != null) {
                    new SetEXP().SetEXP(Bukkit.getPlayer(args[0]));
                }
                return true;
            }
        }
        return false;
    }
}
