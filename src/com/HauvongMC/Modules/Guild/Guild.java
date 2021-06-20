package com.HauvongMC.Modules.Guild;

import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
    private static Connection connection;
    private static Statement sql;
    private static PreparedStatement rowQuery;
    private static ResultSet rs;
    public static void addMember(String guild, String member) {
         connection = Main.getConnection();
        try {
             sql = connection.createStatement();
            sql.executeUpdate("UPDATE guilds SET Members = '" + GetPlayerData.getInfo2(guild, "Name", "guilds", "Members") + member + ", " + "' WHERE Name = '" + guild + "'");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void removeMember(String guild, String member) {
         connection = Main.getConnection();
        try {
             sql = connection.createStatement();
            sql.executeUpdate("UPDATE guilds SET Members = '" + GetPlayerData.getInfo2(guild, "Name", "guilds", "Members").replace(member + ", ", "") + "' WHERE Name = '" + guild + "'");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<String> getMembers(String guild) {
        List<String> value = new ArrayList<>();
         connection = Main.getConnection();
        try {
             rowQuery = connection.prepareStatement("SELECT * FROM `guilds` WHERE Name = '" + guild + "'");
             rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = Arrays.asList(rs.getString("Members").split(", "));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    public static List<String> getRequests(String guild) {
        List<String> value = new ArrayList<>();
         connection = Main.getConnection();
        try {
             rowQuery = connection.prepareStatement("SELECT * FROM `guilds` WHERE Name = '" + guild + "'");
             rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = Arrays.asList(rs.getString("Requests").split(", "));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }
    public static void addRequests(String guild, String member) {
         connection = Main.getConnection();
        try {
            String list = "";
            for (String request : getRequests(guild)) {
                list += request + ", ";
            }
             sql = connection.createStatement();
            sql.executeUpdate("UPDATE guilds SET Requests = '" + list + member + ", " + "' WHERE Name = '" + guild + "'");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void removeRequests(String guild, String member) {
         connection = Main.getConnection();
        try {
            String list = "";
            for (String request : getRequests(guild)) {
                list += request + ", ";
            }
             sql = connection.createStatement();
            sql.executeUpdate("UPDATE guilds SET Requests = '" + list.replace(member + ", ", "") + "' WHERE Name = '" + guild + "'");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String  getOwner(String guild) {
        String  value = null;
        connection = Main.getConnection();
        try {
            rowQuery = connection.prepareStatement("SELECT * FROM `guilds` WHERE Name = '" + guild + "'");
            rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = rs.getString("Owner");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    public static String  getDiscord(String guild) {
        String  value = null;
         connection = Main.getConnection();
        try {
             rowQuery = connection.prepareStatement("SELECT * FROM `guilds` WHERE Name = '" + guild + "'");
             rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = rs.getString("DiscordURL");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    public static void removeGuild(String guild) {
         connection = Main.getConnection();
        for (String member : Guild.getMembers(guild)) {
            SetPlayerData.SetInfo(member, "players", "Suffix", "");
        }
        try {
             sql = connection.createStatement();
            sql.executeUpdate("DELETE FROM guilds WHERE Name='" + guild +"'");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<String> getMotd(String guild) {
        List<String> value = new ArrayList<>();
         connection = Main.getConnection();
        try {
             rowQuery = connection.prepareStatement("SELECT * FROM `guilds` WHERE Name = '" + guild + "'");
             rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = Arrays.asList(rs.getString("Motd").split(", "));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

}
