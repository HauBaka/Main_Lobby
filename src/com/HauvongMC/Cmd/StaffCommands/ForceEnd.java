package com.HauvongMC.Cmd.StaffCommands;

import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.injector.BukkitUnwrapper;
import com.comphenix.protocol.reflect.FuzzyReflection;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.lang.reflect.InvocationTargetException;

public class ForceEnd implements Listener, CommandExecutor {
    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("ForceEnd")) {
            if (sender instanceof Player) {
                displayCredits((Player) sender);
            } else {
                sender.sendMessage(ChatColor.RED + "Must be a player.");
            }
            return true;
        }
        return true;
    }


    private void displayCredits(Player player) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
        BukkitUnwrapper unwrapper = new BukkitUnwrapper();
        Object nms = unwrapper.unwrapItem(player);

        PacketContainer useBed = new PacketContainer(Packets.Server.BED);
        useBed.getIntegers().
                write(0, 4).
                write(0, 0);

        FuzzyReflection.fromObject(nms).getFieldByName("viewingCredits").set(nms, true);
        ProtocolLibrary.getProtocolManager().sendServerPacket(player, useBed);
    }
}