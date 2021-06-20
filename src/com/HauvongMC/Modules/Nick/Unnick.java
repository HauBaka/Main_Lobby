package com.HauvongMC.Modules.Nick;

import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import com.nametagedit.plugin.NametagEdit;
import net.dev.eazynick.api.NickManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unnick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player p = ((Player) commandSender).getPlayer();
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Youtube") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner") ||
                rank.equalsIgnoreCase("Helper") || rank.equalsIgnoreCase("Police") || rank.equalsIgnoreCase("Moderator")) {
            NickManager manager = new NickManager(p);
            String prefix = GetPlayerData.getInfo(p.getName(), "Prefix");
            String suffix = GetPlayerData.getInfo(p.getName(), "Suffix");
            manager.setName(p.getName());
            manager.updatePlayer(false);
            manager.setTabPrefix(suffix);
            manager.setTabPrefix(prefix);
            p.setDisplayName(prefix + p.getName());
            p.setPlayerListName(prefix + prefix + suffix);
            NametagEdit.getApi().setNametag(p, prefix, suffix);
            SetPlayerData.SetInfo(p.getName(), "players","Nick", "false");
            p.sendMessage("§aBạn đã quay lại làm bạn của ngày xưa :P");
        } else p.sendMessage("§cBạn không có quyền sử dụng lệnh này!");
        return false;
    }
}
