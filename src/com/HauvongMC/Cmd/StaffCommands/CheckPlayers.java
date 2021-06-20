package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Players.HVPlayer;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return  false;

        Player p = ((Player) sender).getPlayer();
        HVPlayer player = new HVPlayer(p);
        if (player.getName().equalsIgnoreCase("HauvongMC") || player.getRank().equalsIgnoreCase("Admin") || player.getRank().equalsIgnoreCase("Owner")) {
            if (args.length == 1) {
                String text = "%bungee_" + args[0] + "% players in server " + args[0];
                text = PlaceholderAPI.setPlaceholders(p, text);
                p.sendMessage(text);
                return true;
            } else {
                p.sendMessage("§cYou must be Admin or higher to use this command!");
                return false;
            }
        }
        return false;
    }
}
