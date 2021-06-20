package com.HauvongMC.Modules.Join;

import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;

import java.text.SimpleDateFormat;


public class Head_Status {
    public static void add(Player p) {
        String status = GetPlayerData.getInfo(p.getName(), "Head_Status");
        String vl = "";
        if (!status.equalsIgnoreCase("") && !status.equalsIgnoreCase(null) && GetPlayerData.getInfo(p.getName(), "Head_Status_Toggle").equalsIgnoreCase("1")) {
            boolean changename = false;
            if (status.equalsIgnoreCase("Boop!")) {
                vl = "§d§lBoop!";
            } else if (status.equalsIgnoreCase("Đừng làm phiền")) {
                vl = "§cĐừng làm phiền";
            } else if (status.equalsIgnoreCase("First Joined")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                long firstjoin = Long.parseLong(GetPlayerData.getInfo(p.getName(), "First_Join"));
                String date = simpleDateFormat.format(firstjoin);
                String[] split = date.split("/");
                String month;
                switch (split[1]) {
                    default:
                        month = "Tháng 1";
                        break;
                    case "02":
                        month = "Tháng 2";
                        break;
                    case "03":
                        month = "Tháng 3";
                        break;
                    case "04":
                        month = "Tháng 4";
                        break;
                    case "05":
                        month = "Tháng 5";
                        break;
                    case "06":
                        month = "Tháng 6";
                        break;
                    case "07":
                        month = "Tháng 7";
                        break;
                    case "08":
                        month = "Tháng 8";
                        break;
                    case "09":
                        month = "Tháng 9";
                        break;
                    case "10":
                        month = "Tháng 10";
                        break;
                    case "11":
                        month = "Tháng 11";
                        break;
                    case "12":
                        month = "Tháng 12";
                        break;
                }
                vl = "§bLần đầu tham gia:§6 " + split[0] + " " + month + " " + split[2];
            } else if (status.equalsIgnoreCase("Ping")){
                changename = true;
                vl = "§bPing:§6 ...";
            } else if (status.equalsIgnoreCase("Cấp độ Skywars")) {
                vl = "§b" + status + ": §6" + GetPlayerData.getInfo2(p.getName(), "Name", "g_profile", "level");
            } else if (status.equalsIgnoreCase("Skywars Giết")) {
                int kills = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kSolo"))  + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kTeam")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kMega"));
                vl = "§b" + status + ": §6" + kills;
            } else if (status.equalsIgnoreCase("Skywars Thắng")) {
                int wins = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo"))  + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wTeam")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wMega"));
                vl = "§b" + status + ": §6" + wins;
            } else if (status.equalsIgnoreCase("Skywars Souls")) {
                vl = "§b" + status + ": §6" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "souls");
            } else {
                vl = "§b" + status;
            }
            ArmorStand armorStand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0, 1.15, 0), EntityType.ARMOR_STAND);
            armorStand.setSmall(true);
            armorStand.setCanPickupItems(false);
            armorStand.setArms(false);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStand.setCustomName(vl);
            armorStand.setCustomNameVisible(true);
            armorStand.setMetadata("Head_Status", new FixedMetadataValue(Main.getPlugin(), "true"));
            Main.head_status.put(p, armorStand);
            follow(p, changename);
        }
    }



    private static void follow(Player p, boolean changename) {
        ArmorStand armorStand = Main.head_status.get(p);
        if (changename == true) {
            int task1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
                @Override
                public void run() {
                    if (GetPlayerData.getInfo(p.getName(), "Head_Status").equalsIgnoreCase("Ping")) {
                        int playerping = ((CraftPlayer) p).getHandle().ping;
                        if (playerping < 100) armorStand.setCustomName("§bPing: §a" + playerping + "ms");
                        else if (playerping < 200) armorStand.setCustomName("§bPing: §e" + playerping + "ms");
                        else armorStand.setCustomName("§bPing: §c" + playerping + "ms");
                    }
                }
            }, 0,  20);
            Main.head_status1.put(p, task1);
        }
        int task2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable(){
            @Override
            public void run() {
                armorStand.teleport(p.getLocation().add(0, 1.15, 0));
            }
        }, 0,  0);
        Main.head_status2.put(p, task2);
    }

    public static void removeHeadStatus(Player p) {
        ArmorStand armorStand = Main.head_status.get(p);
        if (armorStand != null) {
            armorStand.remove();
            if (Main.head_status1.get(p) != null) {
                Bukkit.getScheduler().cancelTask(Main.head_status1.get(p));
                Main.head_status1.remove(p);
            }
            Bukkit.getScheduler().cancelTask(Main.head_status2.get(p));
            Main.head_status2.remove(p);
        }
    }
}
