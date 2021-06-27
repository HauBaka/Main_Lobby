package com.HauvongMC.Cmd.FunCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("admin")) {

            List<String> lmao = new ArrayList<>();
            lmao.add("§cBusy busy busy busy busy ...");
            lmao.add("§cI am worried with you doing this ...");
            lmao.add("§cHello World!");
            lmao.add("§cTry doing this 33 more times, it might work!");
            lmao.add("§cCurrently progressing, please try again shortly!");
            lmao.add("§cProgess: 40");
            lmao.add("§cIs there anybody out there?");
            lmao.add("§cHold on, I can't do everything at once!");
            lmao.add("§cTry harder.");
            int index = ThreadLocalRandom.current().nextInt(lmao.size());
            sender.sendMessage(lmao.get(index));
        }
        return true;
    }
}