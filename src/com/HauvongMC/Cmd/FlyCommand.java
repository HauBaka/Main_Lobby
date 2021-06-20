package com.HauvongMC.Cmd;

import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import net.dev.eazynick.utilities.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fly")) {
            if (! (sender instanceof Player)) return false;
            if (!(((Player) sender).getWorld().getName().equalsIgnoreCase("world"))) {
                sender.sendMessage("§cLệnh chỉ có thể sử dụng ở sảnh!");
                return false;
            }
            Player p = ((Player) sender).getPlayer();
            if (p.hasPermission("hauvongmc.fly")) {
                if (GetPlayerData.getInfo(p.getName(), "Fly").equalsIgnoreCase("0")) {
                    SetPlayerData.SetInfo(p.getName(), "players", "Fly", "1");
                    p.sendMessage("§aĐã bật chế độ bay!");
                    p.setAllowFlight(true);
                } else {
                    SetPlayerData.SetInfo(p.getName(), "players", "Fly", "0");
                    p.sendMessage("§aĐã tắt chế độ bay!");
                    p.setAllowFlight(false);
                }
            } else {
                p.sendMessage("§cBạn không có quyền sử dụng lệnh này!");
                return false;
            }
        }
        return true;
    }
}