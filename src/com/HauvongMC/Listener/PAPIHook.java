package com.HauvongMC.Listener;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import org.bukkit.entity.Player;

import com.HauvongMC.Main;
import com.HauvongMC.Players.GetPlayerData;

public class PAPIHook extends PlaceholderExpansion {
  private String rank;
  
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
  
  public String getRank(Player p) {
	  PermissionUser user = PermissionsEx.getPermissionManager().getUser(p);
	    if (user.inGroup("Default")) {
	      return "§7Default"; 
	    }
	    if (user.inGroup("VIP")) {
	      return "§aVIP"; 
	    }
	    if (user.inGroup("VIP+")) {
	      return "§aVIP§6+"; 
	    }
	    if (user.inGroup("MVP")) {
	      return "§bMVP"; 
	    }
	    if (user.inGroup("MVP+")) {
	      return "§bMVP§c+"; 
	    }
	    if (user.inGroup("MVP++")) {
	    	return "§6MVP§c++"; 
	    }
	    if (user.inGroup("POLICE")) {
	      return "§cPOLICE"; 
	    }
	    if (user.inGroup("BUILDER")) {
	      return "§6BUILDER"; 
	    }
	    if (user.inGroup("ADMIN")) {
	      return "§cADMIN"; 
	    }
	    if (user.inGroup("YOUTUBE")) {
	      return "§cYOUTUBE";
	    }
		return null;
	}
  
  public String onPlaceholderRequest(Player p, String identifier) {
    if (p == null)
      return ""; 
    if (identifier.equalsIgnoreCase("rank"))
        return getRank(p); 
    
    return null;
  }
}
