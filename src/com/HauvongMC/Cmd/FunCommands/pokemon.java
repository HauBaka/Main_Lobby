package com.HauvongMC.Cmd.FunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pokemon implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("pokemon")) {
            sender.sendMessage("§3Gotta catch 'em all!");
        }
        return true;
    }
}