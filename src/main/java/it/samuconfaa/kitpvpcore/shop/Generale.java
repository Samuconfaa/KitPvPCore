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

import java.util.Collections;

public class Generale implements Listener {
    public static void openGenerale(Player p) {
        Inventory Generale = Bukkit.createInventory(p, 27, "Generale");

        ItemStack Spada = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metag = Spada.getItemMeta();
        metag.setDisplayName("Spada di Diamante");
        metag.setLore(Collections.singletonList("Prezzo: €800"));
        Spada.setItemMeta(metag);
        Generale.setItem(11, Spada);

        ItemStack Mela = new ItemStack(Material.GOLDEN_APPLE, 2, (short) 1);
        ItemMeta metam = Mela.getItemMeta();
        metam.setDisplayName("Mela D'Oro");
        metam.setLore(Collections.singletonList("Prezzo: €2200"));
        Mela.setItemMeta(metam);
        Generale.setItem(12, Mela);

        ItemStack Latte = new ItemStack(Material.MILK_BUCKET);
        ItemMeta metal = Latte.getItemMeta();
        metal.setDisplayName("Latte");
        metal.setLore(Collections.singletonList("Prezzo: €2200"));
        Latte.setItemMeta(metal);
        Generale.setItem(14, Latte);

        ItemStack exp = new ItemStack(Material.EXP_BOTTLE, 32);
        ItemMeta metae = exp.getItemMeta();
        metae.setDisplayName("Bottiglie di EXP");
        metae.setLore(Collections.singletonList("Prezzo: €2200"));
        exp.setItemMeta(metae);
        Generale.setItem(15, exp);

        ItemStack freccia = new ItemStack(Material.ARROW);
        ItemMeta metaf = freccia.getItemMeta();
        metaf.setDisplayName("Torna Indietro");
        freccia.setItemMeta(metaf);
        Generale.setItem(26, freccia);

        p.openInventory(Generale);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv.getHolder() == null && "Generale".equals(inv.getTitle())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == 11) {
                ItemStack Spada = new ItemStack(Material.DIAMOND_SWORD);
                p.getInventory().addItem(Spada);
                KitPvPCore.removeMoney(p, 800);
            } else if (slot == 12) {
                ItemStack Mela = new ItemStack(Material.GOLDEN_APPLE, 2, (short) 1);
                p.getInventory().addItem(Mela);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 14) {
                ItemStack Latte = new ItemStack(Material.MILK_BUCKET);
                p.getInventory().addItem(Latte);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 15) {
                ItemStack exp = new ItemStack(Material.EXP_BOTTLE, 32);
                p.getInventory().addItem(exp);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 26) {
                Shop.openShop(p);
            }
        }
    }
}
