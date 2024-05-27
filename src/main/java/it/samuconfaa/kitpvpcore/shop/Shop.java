package it.samuconfaa.kitpvpcore.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop implements Listener {
    public void openGUI(Player p){
        Inventory shop = Bukkit.createInventory(p, 36, "Shop");

        ItemStack mele = new ItemStack(Material.GOLDEN_APPLE, 16, (short) 1);

        ItemStack ossidiana = new ItemStack(Material.OBSIDIAN,8);

        ItemStack ragna = new ItemStack(Material.WEB)
    }
}
