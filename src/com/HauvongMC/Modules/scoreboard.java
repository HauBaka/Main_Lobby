package com.HauvongMC.Modules;

import com.HauvongMC.Listener.BungeeListener;
import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;
import com.yapzhenyie.GadgetsMenu.GadgetsMenu;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import java.util.HashMap;

public class scoreboard {
    private Scoreboard scoreboard;
    private Player player;
    private static int state;
    private HashMap<Player, Integer> taskid1 = new HashMap<>();
    private HashMap<Player, Integer> taskid2 = new HashMap<>();
    public scoreboard(Player p) {
        this.scoreboard = p.getScoreboard();
        this.player = p;
        state = 0;
    }
    private static int players;
    private static int Mysterydust;
    private static String rank, Achievements;
    private void canceltask(Player player) {
        Bukkit.getScheduler().cancelTask(taskid2.get(player));
        Bukkit.getScheduler().cancelTask(taskid1.get(player));
    }

    private static ScoreHelper scoreboardAPI;
    public static void start() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            scoreboardAPI = ScoreHelper.createScore(player);
            //ScoreboardAPI scoreboardAPI = new ScoreboardAPI(player);
            scoreboardAPI.setTitle("§e§lLUCKYMCVN");

                    BungeeListener bungeeListener = new BungeeListener();
                    bungeeListener.GetnumberofPlayer(player, "ALL");
                    PlayerManager playerManager = GadgetsMenu.getPlayerManager(player);
                    bungeeListener.GetnumberofPlayer(player, "ALL");
                    players = BungeeListener.getNumber();
                    rank = GetPlayerData.getInfo(player.getName(), "Prefix").substring(0,2) + GetPlayerData.getInfo(player.getName(), "Rank");
                    Mysterydust = playerManager.getMysteryDust();
                    Achievements = GetPlayerData.getInfo(player.getName(), "Achievement_Points");

                    if (player.isOnline()) {
                        if (state <= 10) {
                            scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                        }
                        switch (state) {
                            case 11:
                                scoreboardAPI.setTitle("§6§lL§e§lUCKYMCVN");
                                break;
                            case 12:
                                scoreboardAPI.setTitle("§f§lL§6§lU§e§lCKYMCVN");
                                break;
                            case 13:
                                scoreboardAPI.setTitle("§f§lLU§6§lC§e§lKYMCVN");
                                break;
                            case 14:
                                scoreboardAPI.setTitle("§f§lLUC§6§lK§e§lYMCVN");
                                break;
                            case 15:
                                scoreboardAPI.setTitle("§f§lLUCK§6§lY§e§lMCVN");
                                break;
                            case 16:
                                scoreboardAPI.setTitle("§f§lLUCKY§6§lM§e§lCVN");
                                break;
                            case 17:
                                scoreboardAPI.setTitle("§f§lLUCKYM§6§lC§e§lVN");
                                break;
                            case 18:
                                scoreboardAPI.setTitle("§f§lLUCKYMC§6§lV§e§lN");
                                break;
                            case 19:
                                scoreboardAPI.setTitle("§f§lLUCKYMCV§6§lN");
                                break;
                            case 20:
                                scoreboardAPI.setTitle("§f§lLUCKYMCVN");
                                break;
                            case 21:
                                scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                                break;
                            case 22:
                                scoreboardAPI.setTitle("§f§lLUCKYMCVN");
                                break;
                            case 23:
                                scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                                break;
                        }
                        state++;
                        if (state == 24) {
                            state = 0;
                        }
                        String online = "%bungee_ALL%";
                        online = PlaceholderAPI.setPlaceholders(player, online);
                        scoreboardAPI.setSlot(10, "§3");
                        scoreboardAPI.setSlot(9, "§fRank: " + rank);
                        scoreboardAPI.setSlot(8, "§fBụi thần bí: " + ChatColor.GREEN + Mysterydust);
                        scoreboardAPI.setSlot(7, "§fĐiểm thành tích: " + ChatColor.GREEN + Achievements);
                        scoreboardAPI.setSlot(6, "§fCấp độ: " + ChatColor.GREEN + player.getLevel());
                        scoreboardAPI.setSlot(5, "§2");
                        scoreboardAPI.setSlot(4, "§fSảnh: §a#1");
                        scoreboardAPI.setSlot(3, "§fNgười chơi:§a " + online);
                        scoreboardAPI.setSlot(2, "§1");
                        scoreboardAPI.setSlot(1, "§ewww.luckymcvn.ga");
                    }
        }
    }

    public void open() {
        ScoreHelper scoreboardAPI = ScoreHelper.createScore(player);
        //ScoreboardAPI scoreboardAPI = new ScoreboardAPI(player);
        scoreboardAPI.setTitle("§e§lLUCKYMCVN");
        int task1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
            @Override
            public void run() {
                BungeeListener bungeeListener = new BungeeListener();
                bungeeListener.GetnumberofPlayer(player, "ALL");
                PlayerManager playerManager = GadgetsMenu.getPlayerManager(player);
                bungeeListener.GetnumberofPlayer(player, "ALL");
                players = BungeeListener.getNumber();
                rank = GetPlayerData.getInfo(player.getName(), "Prefix").substring(0,2) + GetPlayerData.getInfo(player.getName(), "Rank");
                Mysterydust = playerManager.getMysteryDust();
                Achievements = GetPlayerData.getInfo(player.getName(), "Achievement_Points");
            }
        }, 0,  20);
        taskid1.put(player, task1);
        int task2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
            @Override
            public void run() {
                if (player.isOnline()) {
                    if (state <= 10) {
                        scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                    }
                    switch (state) {
                        case 11:
                            scoreboardAPI.setTitle("§6§lL§e§lUCKYMCVN");
                            break;
                        case 12:
                            scoreboardAPI.setTitle("§f§lL§6§lU§e§lCKYMCVN");
                            break;
                        case 13:
                            scoreboardAPI.setTitle("§f§lLU§6§lC§e§lKYMCVN");
                            break;
                        case 14:
                            scoreboardAPI.setTitle("§f§lLUC§6§lK§e§lYMCVN");
                            break;
                        case 15:
                            scoreboardAPI.setTitle("§f§lLUCK§6§lY§e§lMCVN");
                            break;
                        case 16:
                            scoreboardAPI.setTitle("§f§lLUCKY§6§lM§e§lCVN");
                            break;
                        case 17:
                            scoreboardAPI.setTitle("§f§lLUCKYM§6§lC§e§lVN");
                            break;
                        case 18:
                            scoreboardAPI.setTitle("§f§lLUCKYMC§6§lV§e§lN");
                            break;
                        case 19:
                            scoreboardAPI.setTitle("§f§lLUCKYMCV§6§lN");
                            break;
                        case 20:
                            scoreboardAPI.setTitle("§f§lLUCKYMCVN");
                            break;
                        case 21:
                            scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                            break;
                        case 22:
                            scoreboardAPI.setTitle("§f§lLUCKYMCVN");
                            break;
                        case 23:
                            scoreboardAPI.setTitle("§e§lLUCKYMCVN");
                            break;
                    }
                    state++;
                    if (state == 24) {
                        state = 0;
                    }
                    String online = "%bungee_ALL%";
                    online = PlaceholderAPI.setPlaceholders(player, online);
                    scoreboardAPI.setSlot(10, "§3");
                    scoreboardAPI.setSlot(9, "§fRank: " + rank);
                    scoreboardAPI.setSlot(8, "§fBụi thần bí: " + ChatColor.GREEN + Mysterydust);
                    scoreboardAPI.setSlot(7, "§fĐiểm thành tích: " + ChatColor.GREEN + Achievements);
                    scoreboardAPI.setSlot(6, "§fCấp độ: " + ChatColor.GREEN + player.getLevel());
                    scoreboardAPI.setSlot(5, "§2");
                    scoreboardAPI.setSlot(4, "§fSảnh: §a#1");
                    scoreboardAPI.setSlot(3, "§fNgười chơi:§a " + online);
                    scoreboardAPI.setSlot(2, "§1");
                    scoreboardAPI.setSlot(1, "§ewww.luckymcvn.ga");
                } else canceltask(player);
            }
        }, 0,  2);
        taskid2.put(player, task2);
    }
}
