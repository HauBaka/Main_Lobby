package com.HauvongMC.Supports;

import com.HauvongMC.Main;
import org.bukkit.DyeColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;


public class AutoLapis implements Listener {

    @EventHandler
    public void OpenINV(InventoryOpenEvent event) {
        if (event.getInventory() instanceof EnchantingInventory) {
            ItemStack lapis;
            Dye d = new Dye();
            d.setColor(DyeColor.BLUE);
            lapis = d.toItemStack();
            lapis.setAmount(3);
            lapis.getItemMeta().setDisplayName("Lapis Lazuli");
            event.getInventory().setItem(1, lapis);
        }
    }

    @EventHandler
    public void OpenINV(InventoryCloseEvent event) {
        if (event.getInventory() instanceof EnchantingInventory) {
            event.getInventory().setItem(1, null);
        }
    }


    @EventHandler
    public void OpenINV(InventoryClickEvent event) {
        if (event.getInventory() instanceof EnchantingInventory) {
            if (event.getSlot() == 1) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void enchantItemEvent(EnchantItemEvent e) {
        if (e.getInventory() instanceof  EnchantingInventory) {
            ItemStack lapis;
            Dye d = new Dye();
            d.setColor(DyeColor.BLUE);
            lapis = d.toItemStack();
            lapis.setAmount(3);
            lapis.getItemMeta().setDisplayName("Lapis Lazuli");
            e.getInventory().setItem(1, lapis);
        }
    }
}