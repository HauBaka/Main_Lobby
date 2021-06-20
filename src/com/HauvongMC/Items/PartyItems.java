package com.HauvongMC.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PartyItems {
    private static ItemStack bedrock;
    public void PartyItems() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§cChưa có");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        bedrock = itemStack;
    }

    public static ItemStack getBedrock() {
        ItemStack itemStack = new ItemStack(Material.BEDROCK, 0);
        ItemMeta itemMeta =  itemStack.getItemMeta();
        itemMeta.setDisplayName("§cChưa có");
        List<String> itemLore  = new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
