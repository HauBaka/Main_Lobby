package com.HauvongMC.Events;

import com.HauvongMC.Items.JoinItem;
import com.HauvongMC.Main;
import com.HauvongMC.Menu.myprofilemenu;
import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LobbyEvent implements Listener {
    @EventHandler
    public void EntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        if (event.getEntity() instanceof Player) {
            ((Player) event.getEntity()).setHealth(20);
            event.setCancelled(true);
        } else if (event.getEntity() instanceof Sheep) {
            event.setCancelled(true);
            Sheep sheep = (Sheep) event.getEntity();
            List<DyeColor> color = new ArrayList<>();
            color.add(DyeColor.BLUE);
            color.add(DyeColor.RED);
            color.add(DyeColor.LIME);
            color.add(DyeColor.ORANGE);
            color.add(DyeColor.PURPLE);
            color.add(DyeColor.WHITE);
            color.add(DyeColor.LIGHT_BLUE);
            color.add(DyeColor.BROWN);
            color.add(DyeColor.CYAN);
            color.add(DyeColor.GREEN);
            color.add(DyeColor.MAGENTA);
            color.add(DyeColor.SILVER);
            color.add(DyeColor.YELLOW);
            color.add(DyeColor.PINK);
            color.add(DyeColor.GRAY);
            int index = ThreadLocalRandom.current().nextInt(color.size());
            sheep.setColor(color.get(index));
            sheep.getWorld().playSound(sheep.getLocation(), Sound.SHEEP_IDLE, 0.3f, 0.5f);
            sheep.setVelocity(new Vector(0.0D, 1.3D, 0.0D));
        }
    }

    @EventHandler
    public void hunger(FoodLevelChangeEvent event) {
        if (!(event.getEntity().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void blockbreak(BlockBreakEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        Player p = event.getPlayer();
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner"))  {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void dmg(EntityDamageByEntityEvent event) {
        if (!(event.getEntity().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        if (event.getDamager().getType().equals(EntityType.PLAYER) &&
                event.getEntity().getType().equals(EntityType.PLAYER) &&
                event.getEntity().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName())) {
            Player p = (Player) event.getEntity();
            Player p1 = (Player) event.getDamager();
            String rank = GetPlayerData.getInfo(p.getName(), "Rank");//victim
            String rank1 = GetPlayerData.getInfo(p1.getName(), "Rank");//enemy
            if (rank == null || rank1 == null) return;
            if (!(rank1.equalsIgnoreCase("Default")) && !(rank1.equalsIgnoreCase("VIP")) && !(rank1.equalsIgnoreCase("VIP+")) && !(rank1.equalsIgnoreCase("MVP"))) {
                if (rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner") || rank.equalsIgnoreCase("Helper") || rank.equalsIgnoreCase("Police")) {
                    String name = GetPlayerData.getInfo(p1.getName(), "Punch_Message");
                    if (name != null && !(name.equalsIgnoreCase(""))) {
                        p.setVelocity(new Vector(0.0D, 64.0D, 0.0D));
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        switch (name) {
                            default:
                                name = "Loving";
                                break;
                            case "Phân":
                                name = "Boop";
                                break;
                            case "Bóng tuyết":
                                name = "SnowBall";
                                break;
                            case "Ngoạn mục":
                                name = "Glorious";
                                break;
                        }
                        String vl;
                        switch (name) {
                            default:
                                vl = " ";
                                break;
                            case "Loving":
                                vl = " §7vì ghen mà đánh ";
                                break;
                            case "Boop":
                                vl = " §7đã ném §d§lPhân§r §7vào mặt ";
                                break;
                            case "SnowBall":
                                vl = " §7đã ném §f§lbóng tuyết§7 vào mặt ";
                                break;
                            case "Glorious":
                                vl = " §7đã giáng cú đấm §6ngoạn mục§r ";
                                break;
                        }
                        String p_displayanme = GetPlayerData.getInfo(p.getName(), "Prefix") + p.getName();
                        String p1_displayname = GetPlayerData.getInfo(p1.getName(), "Prefix") + p1.getName();
                        for (Player p3 : p.getWorld().getPlayers()) {
                            p3.sendMessage(p1_displayname + vl + p_displayanme + " §7khiến cho " + p_displayanme + " §7bay lên cao tút trời xanh");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void blockplace(BlockPlaceEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        Player p = event.getPlayer();
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner"))  {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void interact(PlayerInteractEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        Player p = event.getPlayer();
        ItemStack i = p.getItemInHand();
        if(event.getAction().equals(Action.PHYSICAL)){
            if(event.getClickedBlock().getType() == Material.STONE_PLATE){
                Vector unitVector = new Vector(p.getLocation().getDirection().getX(), 0, p.getLocation().getDirection().getZ());
                unitVector = unitVector.normalize();
                p.setVelocity(unitVector.multiply(10));
                event.setCancelled(false);
                return;
            }
        }
        if (i != null && i.hasItemMeta()) {
            if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aHồ sơ §7(Nhấp chuột phải)")) {
                myprofilemenu.openMain(event.getPlayer());
                event.setCancelled(true);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrò chơi §7(Nhấp chuột phải)")) {
                //GameMenu.openMain(event.getPlayer());
                p.performCommand("dm open server");
                event.setCancelled(true);
            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§fNgười chơi: §cẨn §7(Nhấp chuột phải)")) {
                if (Main.playervisibility_delay.get(p) == false) {
                    SetPlayerData.SetInfo(p.getName(), "players", "PlayerVisibility", "1");
                    p.getInventory().setItem(7, JoinItem.getPlayertoggleon());
                    p.sendMessage("§aNgười chơi đã hiện!");
                    for (Player player : Main.getSpawn().getWorld().getPlayers()) {
                        if (player != p) {
                            p.showPlayer(player);
                        }
                    }
                    Main.playervisibility_delay.replace(p, true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            Main.playervisibility_delay.replace(p, false);
                        }
                    }, 60);
                } else {
                    p.sendMessage("§cVui lòng đợi 3s để sử dụng lại");
                }

            } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§fNgười chơi: §aHiện §7(Nhấp chuột phải)")) {
                if (Main.playervisibility_delay.get(p) == false) {
                    SetPlayerData.SetInfo(p.getName(), "players", "PlayerVisibility", "0");
                    p.getInventory().setItem(7, JoinItem.getPlayertoggleoff());
                    p.sendMessage("§cNgười chơi đã ẩn!");
                    for (Player player : Main.getSpawn().getWorld().getPlayers()) {
                        if (player != p) {
                            p.hidePlayer(player);
                        }
                    }
                    Main.playervisibility_delay.replace(p, true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            Main.playervisibility_delay.replace(p, false);
                        }
                    }, 60);
                } else {
                    p.sendMessage("§cVui lòng đợi 3s để sử dụng lại");
                }
            }
        }
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner"))  {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        if (!(e.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        if (e.getRightClicked() instanceof ArmorStand) {
            e.setCancelled(true);
        }
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equalsIgnoreCase("§aHồ sơ §7(Nhấp chuột phải)")) {
            myprofilemenu.openMain(p);
            e.setCancelled(true);
        } else if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrò chơi §7(Nhấp chuột phải)")) {
            //GameMenu.openMain(p);
            p.performCommand("dm open server");

            e.setCancelled(true);
        } else if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equalsIgnoreCase("§fNgười chơi: §cẨn §7(Nhấp chuột phải)")) {
            if (Main.playervisibility_delay.get(p) == false) {
                SetPlayerData.SetInfo(p.getName(), "players", "PlayerVisibility", "1");
                p.getInventory().setItem(7, JoinItem.getPlayertoggleon());
                p.sendMessage("§aNgười chơi đã hiện!");
                for (Player player : Main.getSpawn().getWorld().getPlayers()) {
                    if (player != p) {
                        p.showPlayer(player);
                    }
                }
                Main.playervisibility_delay.replace(p, true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        Main.playervisibility_delay.replace(p, false);
                    }
                }, 60);
            } else {
                p.sendMessage("§cVui lòng đợi 3s để sử dụng lại");
            }

        } else if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equalsIgnoreCase("§fNgười chơi: §aHiện §7(Nhấp chuột phải)")) {
            if (Main.playervisibility_delay.get(p) == false) {
                SetPlayerData.SetInfo(p.getName(), "players", "PlayerVisibility", "0");
                p.getInventory().setItem(7, JoinItem.getPlayertoggleoff());
                p.sendMessage("§cNgười chơi đã ẩn!");
                for (Player player : Main.getSpawn().getWorld().getPlayers()) {
                    if (player != p) {
                        p.hidePlayer(player);
                    }
                }
                Main.playervisibility_delay.replace(p, true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        Main.playervisibility_delay.replace(p, false);
                    }
                }, 60);
            } else {
                p.sendMessage("§cVui lòng đợi 3s để sử dụng lại");
            }
        }
    }

    @EventHandler
    public void drop(PlayerDropItemEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        Player p = event.getPlayer();
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner"))  {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void pickup(PlayerPickupItemEvent event) {
        if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName()))) {
            return;
        }
        Player p = event.getPlayer();
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner"))  {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void fire(BlockBurnEvent event) {
        event.setCancelled(true);
    }


    @EventHandler
    public void INVClick(InventoryClickEvent event) {
        if (event.getWhoClicked().getWorld().getName().equalsIgnoreCase(Main.getSpawn().getWorld().getName())) {
            String invname = event.getInventory().getName();
       /* if (invname.equalsIgnoreCase("My Profile")
                || invname.equalsIgnoreCase("Friends")
                || invname.equalsIgnoreCase("Party")
                || invname.equalsIgnoreCase("Guild")
                || invname.equalsIgnoreCase("Recent Players")
                || invname.equalsIgnoreCase("Social Media")
                || invname.equalsIgnoreCase("Stats Viewer")
                || invname.equalsIgnoreCase("Customize Appearances")
                || invname.equalsIgnoreCase("Rank Color")
                || invname.equalsIgnoreCase("Punch Messages")
                || invname.equalsIgnoreCase("Status")
                || invname.equalsIgnoreCase("MVP++'s Status")) {
        }*/
            if (invname.equalsIgnoreCase("container.crafting") || invname.equalsIgnoreCase("container.inventory")
                    || invname.equalsIgnoreCase("container.chest")
                    || invname.equalsIgnoreCase("container.chestdouble")) {
                event.setCancelled(false);
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
	private void onWeather(WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}

    @EventHandler
    public void worldchange(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        if (e.getPlayer().getWorld() == Main.getSpawn().getWorld()) {
            for (Player p : Main.getSpawn().getWorld().getPlayers()) {
                if (player != p) {
                    if (GetPlayerData.getInfo(p.getName(), "PlayerVisibility").equalsIgnoreCase("1")) {
                        p.showPlayer(player);
                    } else {
                        p.hidePlayer(player);
                    }
                    if (GetPlayerData.getInfo(player.getName(), "PlayerVisibility").equalsIgnoreCase("1")) {
                        player.showPlayer(p);
                    } else {
                        player.hidePlayer(p);
                    }
                }
            }
        } else {
            for (Player p : player.getWorld().getPlayers()) {
                p.showPlayer(player);
                player.showPlayer(p);
            }
        }
    }

}
