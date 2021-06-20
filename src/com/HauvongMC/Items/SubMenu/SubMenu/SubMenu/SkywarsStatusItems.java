package com.HauvongMC.Items.SubMenu.SubMenu.SubMenu;

import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SkywarsStatusItems {
    private static ItemStack level, kills, wins, souls;
    public SkywarsStatusItems(Player p) {
        String requires = "§cYêu cầu §aVIP";
        String clicktoselect = "§eNhấp để chọn";
        String selected = "§aĐã chọn";
        String currentselect = GetPlayerData.getInfo(p.getName(), "Head_Status");
        String rank = GetPlayerData.getInfo(p.getName(), "Rank");
        //level
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = new ArrayList<>();
        String name = "Cấp độ Skywars";
        itemLore.add("");
        itemLore.add("§7Xem mẫu:");
        itemLore.add("§b" + name + ": §6" + GetPlayerData.getInfo2(p.getName(), "Name", "g_profile", "level"));
        itemLore.add("");
        if (currentselect.equalsIgnoreCase(name)) {
            itemLore.add(selected);
        } else {
            if (!rank.equalsIgnoreCase("Default")) {
                itemLore.add(clicktoselect);
            } else itemLore.add(requires);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        this.level = itemStack;
        //kills
        itemStack = new ItemStack(Material.PAPER, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        name = "Skywars Giết";
        itemLore.add("");
        itemLore.add("§7Xem mẫu:");
        int kills = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kSolo"))  + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kTeam")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "kMega"));
        itemLore.add("§b" + name + ": §6" + kills);
        itemLore.add("");
        if (currentselect.equalsIgnoreCase(name)) {
            itemLore.add(selected);
        } else {
            if (!rank.equalsIgnoreCase("Default")) {
                itemLore.add(clicktoselect);
            } else itemLore.add(requires);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        this.kills = itemStack;
        //wins
        itemStack = new ItemStack(Material.PAPER, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        name = "Skywars Thắng";
        itemLore.add("");
        itemLore.add("§7Xem mẫu:");
        int wins = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wSolo"))  + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wTeam")) + Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "wMega"));
        itemLore.add("§b" + name + ": §6" + wins);
        itemLore.add("");
        if (currentselect.equalsIgnoreCase(name)) {
            itemLore.add(selected);
        } else {
            if (!rank.equalsIgnoreCase("Default")) {
                itemLore.add(clicktoselect);
            } else itemLore.add(requires);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        this.wins = itemStack;
        //souls
        itemStack = new ItemStack(Material.PAPER, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        name = "Skywars Souls";
        itemLore.add("");
        itemLore.add("§7Xem mẫu:");
        itemLore.add("§b" + name + ": §6" + GetPlayerData.getInfo2(p.getName(), "Name", "g_sw", "souls"));
        itemLore.add("");
        if (currentselect.equalsIgnoreCase(name)) {
            itemLore.add(selected);
        } else {
            if (!rank.equalsIgnoreCase("Default")) {
                itemLore.add(clicktoselect);
            } else itemLore.add(requires);
        }
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§c" + name);
        itemStack.setItemMeta(itemMeta);
        this.souls = itemStack;
    }

    public static ItemStack getKills() {
        return kills;
    }

    public static ItemStack getLevel() {
        return level;
    }

    public static ItemStack getSouls() {
        return souls;
    }

    public static ItemStack getWins() {
        return wins;
    }
}
