package com.HauvongMC.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class JoinItem {
    private static ItemStack gamemenu, playerprofile, playertoggleon, playertoggleoff, lobbyselector;
    public JoinItem() {
        //gamemenu
        ItemStack itemStack = new ItemStack(Material.COMPASS, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aTrò chơi §7(Nhấp chuột phải)");
        List<String> itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp chuột phải để mở danh sách các trò chơi!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        gamemenu = itemStack;
        //myprofile
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();

        head.setDisplayName("§aHồ sơ §7(Nhấp chuột phải)");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp chuột phải để xem các nhiệm vụ, thành tích,");
        itemLore.add("§7kích hoạt tăng vàng và hơn thế nữa!");
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        playerprofile = itemStack;
        //playertoggleoff
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§fNgười chơi: §cẨn §7(Nhấp chuột phải)");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp chuột phải để hiển thị người chơi!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        playertoggleoff = itemStack;
        //playertoggleon
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§fNgười chơi: §aHiện §7(Nhấp chuột phải)");
        itemLore  = new ArrayList<>();
        itemLore.add("§7Nhấp chuột phải để ẩn người chơi!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        playertoggleon = itemStack;
        //lobbyselector
        itemStack = new ItemStack(Material.NETHER_STAR, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aSảnh chờ §7(Nhấp chuột phải)");
        itemLore  = new ArrayList<>();
        itemStack.setItemMeta(itemMeta);
        lobbyselector = itemStack;
    }

    public static ItemStack getGamemenu() { return gamemenu; }
    public static ItemStack getPlayertoggleoff() { return playertoggleoff; }
    public static ItemStack getPlayertoggleon() { return playertoggleon; }
    public ItemStack getLobbyselector() { return lobbyselector; }
    public static ItemStack getPlayerprofile() { return playerprofile;}
}
