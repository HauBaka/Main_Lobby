package com.HauvongMC.Items.SubMenu.SubMenu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StatusItems {
    private static ItemStack mvppp, general, skywars, bedwars, reset, toggleon, toggleoff;
    public void StatusItems() {
        String clicktoview = "§eNhấp để xem!";
        //
        ItemStack itemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore= new ArrayList<>();
        itemLore.add(clicktoview);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aTrạng thái dành cho §6MVP§c++");
        itemStack.setItemMeta(itemMeta);
        mvppp = itemStack;
        //
        itemStack = new ItemStack(Material.EMERALD, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemLore.add(clicktoview);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aChung");
        itemStack.setItemMeta(itemMeta);
        general = itemStack;
        //
        itemStack = new ItemStack(Material.EYE_OF_ENDER, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemLore.add("§7Xenm trạng thái cho Skywars");
        itemLore.add("");
        itemLore.add(clicktoview);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aSkyWars");
        itemStack.setItemMeta(itemMeta);
        skywars = itemStack;
        //
        itemStack = new ItemStack(Material.BED, 1);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemLore.add("§7Xenm trạng thái cho Bed Wars");
        itemLore.add("");
        itemLore.add(clicktoview);
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§aBed Wars");
        itemStack.setItemMeta(itemMeta);
        bedwars = itemStack;
        //
        itemStack = new ItemStack(Material.STAINED_GLASS, 1, (short) 14);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§cĐặt lại trạng thái");
        itemStack.setItemMeta(itemMeta);
        reset = itemStack;
        //
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 10);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("§7Khi bạn vào sảnh sẽ có 1 dòng");
        itemLore.add("§7trạng thái đi theo trên đầu bạn.");
        itemLore.add("§7Đối với bạn nó có thể đi theo chậm");
        itemLore.add("§7nhưng đừng lo vì đó là nguyên nhân do");
        itemLore.add("§7độ trễ mạng, những người khác nhìn");
        itemLore.add("§7sẽ thấy nó đi theo bạn khá mượt");
        itemLore.add("");
        itemLore.add("§aĐã bật");
        itemMeta.setDisplayName("§aChuyển đổi chế độ trạng thái");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        toggleon = itemStack;
        //
        itemStack = new ItemStack(Material.INK_SACK, 1, (short) 8);
        itemMeta = itemStack.getItemMeta();
        itemLore= new ArrayList<>();
        itemMeta.setLore(itemLore);
        itemLore.add("§7Khi bạn vào sảnh sẽ có 1 dòng");
        itemLore.add("§7trạng thái đi theo trên đầu bạn.");
        itemLore.add("§7Đối với bạn nó có thể đi theo chậm");
        itemLore.add("§7nhưng đừng lo vì đó là nguyên nhân do");
        itemLore.add("§7độ trễ mạng, những người khác nhìn");
        itemLore.add("§7sẽ thấy nó đi theo bạn khá mượt");
        itemLore.add("");
        itemLore.add("§cĐã tắt");
        itemMeta.setDisplayName("§aChuyển đổi chế độ trạng thái");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);
        toggleoff = itemStack;
    }

    public static ItemStack getBedwars() {
        return bedwars;
    }

    public static ItemStack getGeneral() {
        return general;
    }

    public static ItemStack getMvppp() {
        return mvppp;
    }

    public static ItemStack getSkywars() {
        return skywars;
    }

    public static ItemStack getReset() {
        return reset;
    }

    public static ItemStack getToggleoff() {
        return toggleoff;
    }

    public static ItemStack getToggleon() {
        return toggleon;
    }
}
