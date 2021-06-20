package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Listener.BungeeListener;
import com.HauvongMC.Menu.friendsmenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.HVPlayer;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetRank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("rank")) {
            if (!(sender instanceof Player)) {
                if (args.length == 2) {
                    String target = args[0];
                    String rank = args[1];
                    List<String> ranks = new ArrayList<>();
                    ranks.add("Default");
                    ranks.add("VIP");
                    ranks.add("VIP+");
                    ranks.add("MVP");
                    ranks.add("MVP+");
                    ranks.add("MVP++");
                    ranks.add("Helper");
                    ranks.add("Police");
                    ranks.add("Builder");
                    ranks.add("YOUTUBE");
                    ranks.add("Moderator");
                    ranks.add("Admin");
                    ranks.add("Owner");
                    if (!(ranks.contains(rank))) {
                        sender.sendMessage("§cRank " + rank + " không hoạt động!");
                        sender.sendMessage("§7Hãy thử một trong số chúng:");
                        sender.sendMessage("§e " + ranks);
                        return false;
                    }
                    SetPlayerData.setRank(target, rank);
                    sender.sendMessage("§a" + target + " đã được nhận được " + rank);
                    Player p1 = Bukkit.getPlayer(target);
                    if (p1 != null) {
                        p1.setDisplayName(GetPlayerData.getInfo(target, "Prefix") + p1.getName());
                        p1.sendMessage("§aBạn đã trở thành " + rank);
                    }
                }
                return false;
            }
            Player p = ((Player) sender).getPlayer();
            HVPlayer player = new HVPlayer(p);
            if (player.getName().equalsIgnoreCase("HauvongMC") || player.getRank().equalsIgnoreCase("Admin") || player.getRank().equalsIgnoreCase("Owner")) {
                if (args.length == 2) {
                    String target = args[0];
                    String rank = args[1];
                    List<String> ranks = new ArrayList<>();
                    ranks.add("Default");
                    ranks.add("VIP");
                    ranks.add("VIP+");
                    ranks.add("MVP");
                    ranks.add("MVP+");
                    ranks.add("MVP++");
                    ranks.add("Helper");
                    ranks.add("Police");
                    ranks.add("Builder");
                    ranks.add("YOUTUBE");
                    ranks.add("Moderator");
                    ranks.add("Admin");
                    ranks.add("Owner");
                    if (!(ranks.contains(rank))) {
                        p.sendMessage("§cRank " + rank + " không hoạt động!");
                        p.sendMessage("§7Hãy thử một trong số chúng:");
                        p.sendMessage("§e " + ranks);
                        return false;
                    }
                    SetPlayerData.setRank(target, rank);
                    p.sendMessage("§a" + target + " đã được nhận được " + rank);
                    Player p1 = Bukkit.getPlayer(target);
                    if (p1 != null) {
                        p1.setDisplayName(GetPlayerData.getInfo(target, "Prefix") + p1.getName());
                        p1.sendMessage("§aBạn đã trở thành " + rank);
                    }
                }
            } else {
                p.sendMessage("§cBạn không được phép làm điều này!");
                return false;
            }
        }
        return true;
    }
}