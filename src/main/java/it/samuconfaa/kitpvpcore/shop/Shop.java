package it.samuconfaa.kitpvpcore.shop;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop implements Listener {
    public static void openShop(Player p) {
        Inventory shop = Bukkit.createInventory(p, 27, KitPvPCore.getInstance().getConfig().getString("xx"));

        ItemStack generale = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaGenerale = generale.getItemMeta();
        metaGenerale.setDisplayName("Generale");
        generale.setItemMeta(metaGenerale);
        shop.setItem(11, generale);

        ItemStack pozioni = new ItemStack(Material.POTION);
        ItemMeta metaPozioni = pozioni.getItemMeta();
        metaPozioni.setDisplayName("Pozioni");
        pozioni.setItemMeta(metaPozioni);
        shop.setItem(13, pozioni);

        ItemStack libri = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaLibri = libri.getItemMeta();
        metaLibri.setDisplayName("Libri");
        libri.setItemMeta(metaLibri);
        shop.setItem(15, libri);

        p.openInventory(shop);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();

        if (inv != null && inv.equals(KitPvPCore.getInstance().getConfig().getString("xx"))) {
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
