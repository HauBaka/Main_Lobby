package com.HauvongMC.Listener;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import org.bukkit.entity.Player;

import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;

public class PAPIHook extends PlaceholderExpansion {
  
  public boolean persist() {
    return true;
  }
  
  public String getIdentifier() {
    return "lobby";
  }
  
  public String getAuthor() {
    return "HauVongMC";
  }
  
  public String getVersion() {
    return Main.getPlugin().getDescription().getVersion();
  }
  
  public boolean canRegister() {
    return true;
  }
  
  public String onPlaceholderRequest(Player p, String identifier) {
    if (p == null)
      return ""; 
    if (identifier.equalsIgnoreCase("rank"))
        return "" + GetPlayerData.getInfo(p.getName(), "Prefix").substring(0,2) + GetPlayerData.getInfo(p.getName(), "Rank");
    return null;
  }
}
