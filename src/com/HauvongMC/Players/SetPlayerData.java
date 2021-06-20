package com.HauvongMC.Players;

import com.HauvongMC.Main;
import com.nametagedit.plugin.NametagEdit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetPlayerData {
    public static void SetupProfile(Player p) {
        Connection connection = Main.getConnection();
        try {
            Statement sql = connection.createStatement();
            Long firstjoin=  System.currentTimeMillis();
            //sql.executeUpdate("INSERT INTO players (Name, Rank,Network_EXP, Gold, Experience, Karma, First_Join, Last_Join, Online_Status, DisplayName, Suffix, Prefix, Friends, Guild, Recent_Players) VALUES ('"+ p.getName() + "', 'Default', " + 0 + ", " + 0 + ", "  + 0 + ", " + 0  + ", " + firstjoin + ", " + 0 + ", " + 1 + ", '" + p.getDisplayName() + "', '§7', '§7', '', '', '', '', '', '', '', '', '', '§c', '', '', 0)");
            sql.executeUpdate("INSERT INTO players (" +
                    "Name," + //1
                    " Rank," + //2
                    " Server," + //3
                    " Network_EXP," + //4
                    " Gold," + //5
                    " Experience," + //6ƯƯWWWWWWWWWWWW
                    " Karma," + //7
                    " First_Join," + //8
                    " Last_Join," + //9
                    " Online_Status," + //10
                    " DisplayName," + //11
                    " Suffix," + //12
                    " Prefix," + //13
                    " Friends," + //14
                    " Friend_Requests," +
                    " Guild," + //15
                    " Achievement_Points," + //16
                    " Recent_Players," + //17
                    " TwitterURL," + //18
                    " YoutubeURL, " + //19
                    " InstagramURL," + //20
                    " TwitchURL, " + //21
                    " DiscordURL," + //22
                    " ForumURL, " + //23
                    " Punch_Message," + //24
                    " Plus_Color," + //25
                    " Head_Status," + //26
                    " Head_Status_Toggle," + //27
                    " Party_Message_Sounds," + //28
                    " Guild_Message_Sounds," + //29
                    " Private_Message_Sounds," + //30
                    " Join_Message," + //31
                    " Public_Profanity_Level," + //32
                    " Party_Profanity_Level," + //33
                    " Guild_Profanity_Level," + //34
                    " PM_Profanity_Level," + //35
                    " Chat_Visibility," + //36
                    " Guild_Chat_Visibility," + //37
                    " Chat_Alerts, " + //38
                    " Fly, " + //39
                    " PlayerVisibility) VALUES (" + //40
                    "'" + p.getName() +"'" + //1
                    ", 'Default'," + //2
                    " 'Lobby'," + //3
                    " 0," + //4
                    " 0," + //5
                    " 0," + //6
                    " 0," + //7
                    " " + firstjoin + "," + //8
                    " 0," + //9
                    " 1," + //10
                    " '" + p.getName() + "'," + //11
                    " '§7'," + //12
                    " '§7'," + //13
                    " ''," + //14
                    " ''," +
                    " ''," + //15
                    " 0," + //16
                    " ''," + //17
                    " ''," + //18
                    " ''," + //19
                    " ''," + //20
                    " ''," + //21
                    " ''," + //22
                    " ''," + //23
                    " ''," + //24
                    " ''," + //25
                    " ''," + //26
                    " 0," +//27
                    " 1," +//28
                    " 1," +//29
                    " 1," +//30
                    " 1," +//31
                    " 0," +//32
                    " 0," +//33
                    " 0," +//34
                    " 0," +//35
                    " 1," +//36
                    " 1," +//37
                    " 1," + //38
                    " 0," + //39
                    " 1)"); //40
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void setRank(String player, String rank) {
        Connection connection = Main.getConnection();
        try {
            String prefix;
            switch (rank) {
                default:
                    prefix = "§7";
                    break;
                case "VIP":
                    prefix = "§a[VIP] ";
                    break;
                case "VIP+":
                    prefix = "§a[VIP§c+§a] ";
                    break;
                case "MVP":
                    prefix = "§b[MVP] ";
                    break;
                case "MVP+":
                    prefix = "§b[MVP" + GetPlayerData.getInfo(player, "Plus_Color") +  "+§b] ";
                    break;
                case "MVP++":
                    prefix = "§6[MVP" + GetPlayerData.getInfo(player, "Plus_Color") +  "++§6] ";
                    break;
                case "Helper":
                    prefix = "§9[HELPER] ";
                    break;
                case "Police":
                    prefix = "§9[POLICE] ";
                    break;
                case "Builder":
                    prefix = "§3[BUILD TEAM] ";
                    break;
                case "YOUTUBE":
                    prefix = "§c[§fYOUTUBE§c] ";
                    break;
                case "Moderator":
                    prefix = "§2[MOD] ";
                    break;
                case "Admin":
                    prefix = "§c[ADMIN] ";
                    break;
                case "Owner":
                    prefix = "§c[OWNER] ";
                    break;
            }
            Statement sql = connection.createStatement();
            SetInfo(player, "players", "Prefix", prefix);
            SetInfo(player, "players", "Rank", rank);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player + " group set " + rank);
            Player p = Bukkit.getPlayer(player);
            if (p != null && p.isOnline()) {
                NametagEdit.getApi().setNametag(p, GetPlayerData.getInfo(p.getName(), "Prefix"), "");
                p.setDisplayName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName());
                p.setPlayerListName(GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName() + GetPlayerData.getInfo(p.getName(), "Suffix"));
            }
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void SetInfo(String player, String database, String type, String value) {
        Connection connection = Main.getConnection();
        try {
            Statement sql = connection.createStatement();
            sql.executeUpdate("UPDATE " + database + " SET " + type + " = '" + value + "' WHERE Name = '" + player + "'");
            sql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
