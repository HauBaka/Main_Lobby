package com.HauvongMC.Cmd.FunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class hello implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("hello") || label.equalsIgnoreCase("hi")) {
            sender.sendMessage("§aWhy hello there.");
        }
        return true;
    }
}