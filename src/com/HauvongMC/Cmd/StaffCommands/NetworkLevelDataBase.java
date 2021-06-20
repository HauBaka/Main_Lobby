package com.HauvongMC.Cmd.StaffCommands;

import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.HVPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.*;

public class NetworkLevelDataBase implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("NetworkLevelDataBase")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            //NetworkLevelDataBase add 15000
            //NetworkLevelDataBase set [lv] [exp]
            HVPlayer player = new HVPlayer(p);
            if (p.getName().equalsIgnoreCase("HauvongMC") || player.getRank().equalsIgnoreCase("Admin") || player.getRank().equalsIgnoreCase("Owner")) {
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("add")) {
                        int XP = Integer.parseInt(args[1]);
                        Connection connection = Main.getConnection();
                        try {
                            PreparedStatement rowQuery = connection.prepareStatement("SELECT Level FROM networklevel ORDER BY Level DESC LIMIT 10000");
                            ResultSet rs = rowQuery.executeQuery();
                            int maxlv =0 ;
                            if (rs.next()) {
                                maxlv = rs.getInt("Level");
                            }
                            maxlv++;
                            int totalxp = XP + getTotalXP(maxlv);
                            Statement sql = connection.createStatement();
                            sql.executeUpdate("INSERT INTO networklevel (Level, XP, TotalXP) VALUES (" + maxlv + ", " + XP + ", " + totalxp + ")");
                            p.sendMessage("§aAdded LV: " + maxlv + " , XP: " + XP + ", TotalXP: " + totalxp + " " + getTotalXP(maxlv));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        return true;
                    }
                    p.sendMessage("§c/NetworkLevelDataBase add [XP]");
                    return false;
                }
                p.sendMessage("§You don't have permission to use this command!");
                return false;

            }
        }
        return true;
    }

    private int getTotalXP(int Level) {
        int value = 0;
        Level--;
        if (Level == 0) {
            return 0;
        }
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + Level + "'");
            ResultSet rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = value + rs.getInt("TotalXP");
                return value;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }
}
