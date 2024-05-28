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

public class Pozioni implements Listener {

    public static void openPozioni(Player p) {
        Inventory Pozioni = Bukkit.createInventory(p, 27, "Pozioni");

        ItemStack velocita = new ItemStack(Material.POTION, 1, (short) 8226);
        ItemMeta metaVelocita = velocita.getItemMeta();
        metaVelocita.setDisplayName("Pozione di Velocità II");
        metaVelocita.setLore(Collections.singletonList("Prezzo: €2100"));
        velocita.setItemMeta(metaVelocita);
        Pozioni.setItem(11, velocita);

        ItemStack forza = new ItemStack(Material.POTION, 1, (short) 8233); // Pozione di Forza II
        ItemMeta metaForza = forza.getItemMeta();
        metaForza.setDisplayName("Pozione di Forza II");
        metaForza.setLore(Collections.singletonList("Prezzo: €5000"));
        forza.setItemMeta(metaForza);
        Pozioni.setItem(12, forza);

        ItemStack resistenzaFuoco = new ItemStack(Material.POTION, 1, (short) 8195); // Pozione di Resistenza al Fuoco
        ItemMeta metaResistenzaFuoco = resistenzaFuoco.getItemMeta();
        metaResistenzaFuoco.setDisplayName("Pozione di Resistenza al Fuoco");
        metaResistenzaFuoco.setLore(Collections.singletonList("Prezzo: €700"));
        resistenzaFuoco.setItemMeta(metaResistenzaFuoco);
        Pozioni.setItem(13, resistenzaFuoco);

        ItemStack splashLentezza = new ItemStack(Material.SPLASH_POTION, 1, (short) 16394); // Pozione Splash di Lentezza
        ItemMeta metaSplashLentezza = splashLentezza.getItemMeta();
        metaSplashLentezza.setDisplayName("Pozione Splash di Lentezza");
        metaSplashLentezza.setLore(Collections.singletonList("Prezzo: €4500"));
        splashLentezza.setItemMeta(metaSplashLentezza);
        Pozioni.setItem(14, splashLentezza);

        ItemStack splashAvvelenamento = new ItemStack(Material.SPLASH_POTION, 1, (short) 16388); // Pozione Splash di Avvelenamento
        ItemMeta metaSplashAvvelenamento = splashAvvelenamento.getItemMeta();
        metaSplashAvvelenamento.setDisplayName("Pozione Splash di Avvelenamento");
        metaSplashAvvelenamento.setLore(Collections.singletonList("Prezzo: €4500"));
        splashAvvelenamento.setItemMeta(metaSplashAvvelenamento);
        Pozioni.setItem(15, splashAvvelenamento);

        ItemStack freccia = new ItemStack(Material.ARROW);
        ItemMeta metaf = freccia.getItemMeta();
        metaf.setDisplayName("Torna Indietro");
        freccia.setItemMeta(metaf);
        Pozioni.setItem(26, freccia);

        p.openInventory(Pozioni);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv.getHolder() == null && "Negozio".equals(inv.getName())) {
            e.setCancelled(true);


            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == 11) {
                ItemStack velocita = new ItemStack(Material.POTION, 1, (short) 8226);
                p.getInventory().addItem(velocita);
                KitPvPCore.removeMoney(p, 2100);
            } else if (slot == 12) {
                ItemStack forza = new ItemStack(Material.POTION, 1, (short) 8233);
                p.getInventory().addItem(forza);
                KitPvPCore.removeMoney(p, 5000);
            } else if (slot == 13) {
                ItemStack resistenzaFuoco = new ItemStack(Material.POTION, 1, (short) 8195);
                p.getInventory().addItem(resistenzaFuoco);
                KitPvPCore.removeMoney(p, 700);
            } else if (slot == 14) {
                ItemStack splashLentezza = new ItemStack(Material.SPLASH_POTION, 1, (short) 16394);
                p.getInventory().addItem(splashLentezza);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 15) {
                ItemStack splashAvvelenamento = new ItemStack(Material.SPLASH_POTION, 1, (short) 16388);
                p.getInventory().addItem(splashAvvelenamento);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 26) {
                Shop.openShop(p);
            }
        }
    }
}
