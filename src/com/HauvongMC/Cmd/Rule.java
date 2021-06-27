package com.HauvongMC.Cmd;

import com.HauvongMC.Players.SetPlayerData;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rule implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("Rule")) {
            if (!(sender instanceof Player)) return false;
            if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("confirm")) {
                SetPlayerData.SetInfo(sender.getName(), "players", "Rule", "1");
                sender.sendMessage("§aĐã xác nhận, hi vọng bạn sẽ chấp hành những quy định trên");
                sender.sendMessage("§eBạn có thể đọc lại luật bằng cách sử dụng§c /rule");
                ((Player) sender).playSound(((Player) sender).getLocation(), Sound.LEVEL_UP, 0.5f, 0.5f);
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ib open rule " + ((Player) sender).getPlayer().getName());
            }
        }
        return true;
    }
}
