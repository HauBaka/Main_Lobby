package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Listener.BungeeListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChangeServer implements CommandExecutor {
    private BungeeListener bungeeListener = new BungeeListener();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("switchserver") || label.equalsIgnoreCase("ss") || label.equalsIgnoreCase("changeserver") || label.equalsIgnoreCase("cs")) {
            if (!(sender instanceof Player)) return false;
            if (((Player) sender).getWorld().getName().equalsIgnoreCase("world")) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            Player p = ((Player) sender).getPlayer();
            PermissionUser permissionUser = PermissionsEx.getUser(p);
            if (args.length == 1) {
                if (permissionUser.has("Changeserver.server")) {
                    bungeeListener.SendtoServer(p, args[0]);
                    p.sendMessage("§aSending you to " + args[0]);
                    return true;
                }
                p.sendMessage("§cBạn đéo có quyền sử dụng lệnh này");
            } else if (args.length == 2) {
                if (permissionUser.has("Changserver.server.player")) {
                    bungeeListener.SendtoServer(Bukkit.getPlayer(args[1]), args[0]);
                    Bukkit.getPlayer(args[1]).sendMessage("Thg " + p.getName() + " ném m sang server " + args[0]);
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
