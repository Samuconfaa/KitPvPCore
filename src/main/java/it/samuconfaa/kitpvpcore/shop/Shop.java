package it.samuconfaa.kitpvpcore.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
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

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
       Inventory inv = e.getInventory();
       if(inv.getHolder() == null && "Negozio".equals(inv.getName())) {
           e.setCancelled(true);


           Player p = (Player) e.getWhoClicked();
           int slot = e.getRawSlot();
           if (slot == 11) {
               Generale.openGenerale(p);
           } else if (slot == 13) {
               Pozioni.openPozioni(p);
           } else if (slot == 15) {
               Libri.openLibri(p);
           }
       }
    }
}
