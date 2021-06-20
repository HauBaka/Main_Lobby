package com.HauvongMC.Cmd.FunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class garlicbread implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("garlicbread")) {
            sender.sendMessage("§eMmm, Garlic Bread");
        }
        return true;
    }
}
