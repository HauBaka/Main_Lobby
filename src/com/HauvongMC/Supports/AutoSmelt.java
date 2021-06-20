package com.HauvongMC.Supports;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class AutoSmelt implements Listener {
    public int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
    @EventHandler
    public void onInteract(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Material drop = Material.AIR;
        ItemStack hand = player.getItemInHand();
        PermissionUser permissionUser = PermissionsEx.getUser(event.getPlayer());
        if (permissionUser.has("autosmelt.mine")) {
            switch (block.getType()) {
                case GOLD_ORE:
                    drop = Material.GOLD_INGOT;
                    break;
                case IRON_ORE:
                    drop = Material.IRON_INGOT;
                    break;
                case DIAMOND_ORE:
                    drop = Material.DIAMOND;
                    break;
                default:
                    drop = Material.AIR;
                    break;
            }
            if (!drop.equals(Material.AIR) && !block.getDrops(hand).isEmpty()) {
                hand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
                block.breakNaturally(new ItemStack(Material.AIR));
                block.getWorld().dropItemNaturally(block.getLocation().add(0.5D, 0.5D, 0.5D), new ItemStack(drop, getRandom(1, 2)));
            }
        }
    }
}

