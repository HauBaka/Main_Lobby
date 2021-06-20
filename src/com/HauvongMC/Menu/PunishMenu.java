package com.HauvongMC.Menu;

import com.HauvongMC.Players.GetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class PunishMenu {
    public static void openMain(Player p, Player target) {
        Inventory inventory = Bukkit.createInventory(p, 54, "Punish " + target.getName());
        //profile
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner(target.getName());
        head.setDisplayName(target.getDisplayName());
        List<String> itemLore  = new ArrayList<>();
        String guild = "§cnull";
        String testguild = GetPlayerData.getInfo(target.getName(), "Guild");
        if (testguild != null && testguild != "")  {
            guild = testguild;
        }
        itemLore.add("§7Điểm thành tựu:§e " + GetPlayerData.getInfo(target.getName(), "Achievement_Points"));
        itemLore.add("§7Băng đảng: §b" + guild);
        head.setLore(itemLore);
        itemStack.setItemMeta(head);
        inventory.setItem(0, itemStack);
        //border
        int[] red = {1, 2, 3, 4, 5, 6, 7, 9, 18, 27, 36, 45};
        int[] blue = {8, 17, 26, 35, 44, 53, 52, 51, 49, 47, 46};
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
        for (int i = 0; i< red.length; i++) inventory.setItem(red[i], itemStack);
        itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        for (int i = 0; i< blue.length; i++) inventory.setItem(blue[i], itemStack);
        //
        List<String> reason = new ArrayList<>();
        reason.add("KillAura");
        reason.add("Fly");
        reason.add("Scaffold");
        reason.add("Reach");
        reason.add("AutoClicker");
        reason.add("Nói tục");
        reason.add("Xúc phạm Staff");
        reason.add("Spamming");
        reason.add("Quảng cáo");
        reason.add("Team-Up");
        int slot = 10;
        for (int i = 0; i < reason.size(); i++) {
            itemStack = new ItemStack(Material.PAPER);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§a" + reason.get(i));
            slot+=2;
            if (slot == 18 || slot == 26 || slot == 36) slot+=2;
        }
        //cancel
        itemStack = new ItemStack(Material.WOOL, 1, (short) 14);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cHủy");
        inventory.setItem(48, itemStack);
        //accept
        itemStack = new ItemStack(Material.WOOL, 1, (short) 5);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§aChơi nó!");
        inventory.setItem(50, itemStack);
        p.openInventory(inventory);
    }
}
