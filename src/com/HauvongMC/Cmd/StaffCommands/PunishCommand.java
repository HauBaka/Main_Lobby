package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Menu.PunishMenu;
import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (label.equalsIgnoreCase("Punish")) {
            Player p = ((Player) sender).getPlayer();
            String rank = GetPlayerData.getInfo(p.getName(), "Rank");
            if (rank.equalsIgnoreCase("Police") || rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner")) {
                if (args.length > 0) {
                    Player p1 = Bukkit.getPlayer(args[0]);
                    if (p1 != null) {
                        PunishMenu.openMain(p, p1);
                    } else p.sendMessage("§cKhông tìm thấy người chơi " + args[0]);
                }
            } else p.sendMessage("§cBạn không có quyền sử dụng lệnh này");
        }
        return false;
    }
}
