package it.samuconfaa.kitpvpcore.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Pozioni implements Listener {

    public void apriPozioniGUI(Player p) {
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
}
