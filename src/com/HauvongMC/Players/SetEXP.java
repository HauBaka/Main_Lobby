package com.HauvongMC.Players;

import com.HauvongMC.Main;
import org.bukkit.entity.Player;

import java.sql.*;


public class SetEXP {
    public void SetEXP(Player p) {
        double network_level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Network_EXP"));
        int lv = 0;
        int lv2 = 0;
        double xp = 0, xp1 = 0;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT Level FROM networklevel ORDER BY Level DESC LIMIT 10000");
            ResultSet rs = rowQuery.executeQuery();
            int maxlv =0 ;
            if (rs.next()) {
                maxlv = rs.getInt("Level");
            }
            maxlv++;
            for (int i = 0; i < maxlv; i++) {
                rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + i + "'");
                rs = rowQuery.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("TotalXP") >= network_level) {
                        lv = i -1;
                        lv2 = i;
                        break;
                    }
                }
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp1 = rs.getInt("TotalXP");
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv2 + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp = rs.getInt("XP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double progress = (network_level-xp1) / xp;
        if (progress >= 1)  {
            progress = 0;
            lv++;
        }
        p.setLevel(lv);
        p.setExp((float) progress);
    }


    public static int getNextLVEXP(Player p) {
        double network_level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Network_EXP"));
        int lv = 0;
        int lv2 = 0;
        double xp = 0, xp1 = 0;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT Level FROM networklevel ORDER BY Level DESC LIMIT 10000");
            ResultSet rs = rowQuery.executeQuery();
            int maxlv =0 ;
            if (rs.next()) {
                maxlv = rs.getInt("Level");
            }
            maxlv++;
            for (int i = 0; i < maxlv; i++) {
                rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + i + "'");
                rs = rowQuery.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("TotalXP") >= network_level) {
                        lv = i -1;
                        lv2 = i;
                        break;
                    }
                }
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp1 = rs.getInt("TotalXP");
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv2 + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp = rs.getInt("TotalXP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int lmao = (int) (xp - network_level);
        return lmao;
    }

    public static String getLVProgressBar(Player p) {
        double chance = getChance(p);
        String text = "";
        for (double i = 0; i < 40; i++) {
            double lmao = (i / 40.0) * 100.0;
            if (lmao < chance) {
                text += "§3|";
            } else text+= "§7|";
        }
        return "§3LuckyMCVN Level§a " + p.getLevel() + " " + text + " §3" + (int) chance + "%";
    }

    public static int getChance(Player p) {
        double network_level = Integer.parseInt(GetPlayerData.getInfo(p.getName(), "Network_EXP"));
        int lv = 0;
        int lv2 = 0;
        double xp = 0, xp1 = 0;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT Level FROM networklevel ORDER BY Level DESC LIMIT 10000");
            ResultSet rs = rowQuery.executeQuery();
            int maxlv =0 ;
            if (rs.next()) {
                maxlv = rs.getInt("Level");
            }
            maxlv++;
            for (int i = 0; i < maxlv; i++) {
                rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + i + "'");
                rs = rowQuery.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("TotalXP") >= network_level) {
                        lv = i -1;
                        lv2 = i;
                        break;
                    }
                }
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp1 = rs.getInt("TotalXP");
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv2 + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp = rs.getInt("XP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double progress = (network_level-xp1) / xp;
        if (progress >= 1)  {
            progress = 0;
            lv++;
        }
        return (int) (progress*100);
    }

    public static int getLevel(String player) {
        double network_level = Integer.parseInt(GetPlayerData.getInfo(player, "Network_EXP"));
        int lv = 0;
        int lv2 = 0;
        double xp = 0, xp1 = 0;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT Level FROM networklevel ORDER BY Level DESC LIMIT 10000");
            ResultSet rs = rowQuery.executeQuery();
            int maxlv =0 ;
            if (rs.next()) {
                maxlv = rs.getInt("Level");
            }
            maxlv++;
            for (int i = 0; i < maxlv; i++) {
                rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + i + "'");
                rs = rowQuery.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("TotalXP") >= network_level) {
                        lv = i -1;
                        lv2 = i;
                        break;
                    }
                }
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp1 = rs.getInt("TotalXP");
            }
            rowQuery = connection.prepareStatement("SELECT * FROM `networklevel` WHERE Level = '" + lv2 + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                xp = rs.getInt("XP");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double progress = (network_level-xp1) / xp;
        if (progress >= 1)  {
            progress = 0;
            lv++;
        }
        return (int) (progress*100);
    }
}
