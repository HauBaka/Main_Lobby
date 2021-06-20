package com.HauvongMC.Menu;

import com.HauvongMC.Main;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class GameMenu implements Listener {
    private static Inventory inventory;
    private static ItemStack itemStack, next, previous;
    private static SkullMeta head;
    private static List<String> itemLore, f, nextlore, previouslore;
    private static ItemMeta itemMeta, nextmeta, previousItemMeta;
    private static String guild, testguild, friend;
    private static String[] friends;
    private static int start, slot;
    public static void openMain(Player p, boolean check) {
         inventory = Bukkit.createInventory(p, 54, "Game Menu");
         itemStack = new ItemStack(Material.BOOKSHELF);
         itemMeta = itemStack.getItemMeta();
         itemLore = new ArrayList<>();
        itemLore.add("");
        itemLore.add("§7Return to the Main Lobby.");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aMain Lobby");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(9, itemStack);
        //
        itemStack = new ItemStack(Material.EYE_OF_ENDER);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§8Survival");
        itemLore.add("");
        itemLore.add("§7FAKE GAMEMODE ON HYPIXEL");
        itemLore.add("");
        itemLore.add("§a► Click to Connect!");
        String text = "§7%bungee_Skywars% currently playing!";
        text = PlaceholderAPI.setPlaceholders(p, text);
        itemLore.add(text);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aSkyWars");
        itemStack.setItemMeta(itemMeta);
        //inventory.setItem(11, itemStack);
        //
        p.openInventory(inventory);
        loop(p);
    }
    private static void loop(Player p) {
        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            int lmao = 0;
            @Override
            public void run() {
                if ((p.getOpenInventory().getTitle().equalsIgnoreCase("Game Menu"))) {
                    ItemStack itemStack1 = new ItemStack(Material.EYE_OF_ENDER);
                    ItemMeta itemMeta1 = itemStack1.getItemMeta();
                    List<String> itemLore1 = new ArrayList<>();
                    itemLore1.add("§8Survival");
                    itemLore1.add("");
                    itemLore1.add("§7FAKE GAMEMODE ON HYPIXEL");
                    itemLore1.add("");
                    switch (lmao) {
                        default:
                            itemLore1.add("§a  Click to Connect!");
                            //itemStack1 = new ItemStack(Material.ENDER_PEARL);
                            lmao = 1;
                            break;
                        case 1:
                            itemLore1.add("§a► Click to Connect!");
                            lmao = 0;
                            break;
                    }
                    String text1 = "§7%bungee_Skywars% currently playing!";
                    text1 = PlaceholderAPI.setPlaceholders(p, text1);
                    itemLore1.add(text1);
                    itemMeta1.setLore(itemLore1);
                    itemMeta1.setDisplayName("§aSkyWars");
                    itemStack1.setItemMeta(itemMeta1);
                    p.getOpenInventory().setItem(11, itemStack1);
                } else canceltask(Main.taskid_gamemenu.get(p));
            }
        }, 0, 10);
        Main.taskid_gamemenu.put(p, taskID);

    }

    private static void canceltask(int taskID) {
        Bukkit.getScheduler().cancelTask(taskID);
        Main.taskid_gamemenu.remove(taskID);
    }


}
