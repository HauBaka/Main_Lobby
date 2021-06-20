package com.HauvongMC.Cmd.FunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class removearenabrawl implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("removearenabrawl")) {
            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("§fok");
        }
        return true;
    }
}