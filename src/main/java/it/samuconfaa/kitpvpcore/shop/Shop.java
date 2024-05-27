package it.samuconfaa.kitpvpcore.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop implements Listener {
    public static void openShop(Player p){
        Inventory Shop = Bukkit.createInventory(p, 27, "Negozio");

        ItemStack Generale = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metag = Generale.getItemMeta();
        metag.setDisplayName("Generale");
        Generale.setItemMeta(metag);
        Shop.setItem(11, Generale);


        ItemStack Pozioni = new ItemStack(Material.POTION);
        ItemMeta meta = Generale.getItemMeta();
        meta.setDisplayName("Pozioni");
        Pozioni.setItemMeta(meta);
        Shop.setItem(13, Pozioni);

        ItemStack Libri = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metal = Generale.getItemMeta();
        metal.setDisplayName("Libri");
        Libri.setItemMeta(metal);
        Shop.setItem(15, Libri);

        p.openInventory(Shop);
    }
}
