package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Players.HVPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Kaboom implements CommandExecutor {
    public static List<Player> kabooms = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("kaboom")) {
            if (!(sender instanceof Player)) return false;
            Player player = ((Player) sender).getPlayer();
            HVPlayer hvplayer = new HVPlayer(player);
            if (hvplayer.getName().equalsIgnoreCase("HauvongMC") || hvplayer.getRank().equalsIgnoreCase("Admin") || hvplayer.getRank().equalsIgnoreCase("Owner")) {
                if (args.length >= 1) {
                    if (args[0].equalsIgnoreCase("All")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            sender.sendMessage("§aBay nào " + p.getName() + "§a!");
                            launch(p);
                        }
                    } else if (args[0].equalsIgnoreCase("world")) {
                        for (Player p : player.getWorld().getPlayers()) {
                            sender.sendMessage("§aBay nào " + p.getName() + "§a!");
                            launch(p);
                        }
                    } else {
                        Player p = Bukkit.getPlayer(args[0]);
                        if (p == null) {
                            player.sendMessage("§cNgười chơi " + args[0] + " không trực tuyến!");
                            return false;
                        }
                        sender.sendMessage("§aBay nào " + p.getName() + "§a!");
                        launch(p);
                    }
                } else ((Player) sender).performCommand("kaboom world");
            } else {
                player.sendMessage("§cBạn phải là ADMIN trở lên để sử dụng lệnh này!");
                return false;
            }
        }
        return true;
    }


    private void launch(Player p) {
        p.setVelocity(new Vector(0.0D, 64.0D, 0.0D));
        p.getWorld().strikeLightningEffect(p.getLocation());
        if (!kabooms.contains(p))
            kabooms.add(p);
    }


}
