package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Listener.BungeeListener;
import org.bukkit.command.CommandExecutor;

public class ChangeServer
implements CommandExecutor {
    private BungeeListener bungeeListener = new BungeeListener();

    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, java.lang.String label, java.lang.String[] args) {
        if (label.equalsIgnoreCase("switchserver") || label.equalsIgnoreCase("ss") || label.equalsIgnoreCase("changeserver") || label.equalsIgnoreCase("cs")) {
            if (!(sender instanceof org.bukkit.entity.Player)) {
                return false;
            }
            org.bukkit.entity.Player p = ((org.bukkit.entity.Player)sender).getPlayer();
            if (args.length == 1) {
                this.bungeeListener.SendtoServer(p, args[0]);
                p.sendMessage("§aĐang chuyển bạn đến máy chủ " + args[0]);
                return true;
            }
            if (args.length == 2) {
                if (p.hasPermission("Changserver.server.player")) {
                    this.bungeeListener.SendtoServer(org.bukkit.Bukkit.getPlayer((java.lang.String)args[1]), args[0]);
                    org.bukkit.Bukkit.getPlayer((java.lang.String)args[1]).sendMessage("Thg " + p.getName() + " ném m sang server " + args[0]);
                    return true;
                }
                p.sendMessage("§cBạn đéo có quyền sử dụng lệnh này");
            } else {
                p.sendMessage("§9--------------------------------------------------");
                p.sendMessage("§aChange Server Commands:");
                p.sendMessage("§e/" + label + " (server) §7- §bChuyển máy chủ");
                p.sendMessage("§e/" + label + " (server) (player) §7-§b Chyển máy chủ của 1 thg ml nào đó");
                p.sendMessage("§9--------------------------------------------------");
            }
        }
        return true;
    }
}