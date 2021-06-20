package com.HauvongMC.Players;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;


public class HVPlayer {
    private String name, rank, displayname, guild;
    private Player player;
    private List<String> friends;
    private Inventory inventory;
    public HVPlayer(Player p) {
        this.player = p;
        this.name = p.getName();
        this.displayname = GetPlayerData.getInfo(name, "DisplayName");
        this.rank = GetPlayerData.getInfo(name, "Rank");
        this.guild = GetPlayerData.getInfo(name, "Guild");
        this.friends = Arrays.asList(GetPlayerData.getInfo(name, "Friends").split(", "));
        this.inventory = p.getInventory();
    }

    public String getName() { return name; }

    public String getRank() { return rank; }
}
