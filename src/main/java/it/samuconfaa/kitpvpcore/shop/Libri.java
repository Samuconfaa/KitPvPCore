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

public class Libri implements Listener {

    public static void openLibri(Player p) {
        Inventory Libri = Bukkit.createInventory(p, 27, "Libri");

        ItemStack affilatezza = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaAffilatezza = affilatezza.getItemMeta();
        metaAffilatezza.setDisplayName("Libro di Affilatezza IV");
        metaAffilatezza.setLore(Collections.singletonList("Prezzo: €4500"));
        affilatezza.setItemMeta(metaAffilatezza);
        Libri.setItem(10, affilatezza);

        ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaProtezione = protezione.getItemMeta();
        metaProtezione.setDisplayName("Libro di Protezione IV");
        metaProtezione.setLore(Collections.singletonList("Prezzo: €4500"));
        protezione.setItemMeta(metaProtezione);
        Libri.setItem(11, protezione);

        ItemStack indistruttibilita = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaIndistruttibilita = indistruttibilita.getItemMeta();
        metaIndistruttibilita.setDisplayName("Libro di Indistruttibilità III");
        metaIndistruttibilita.setLore(Collections.singletonList("Prezzo: €4500"));
        indistruttibilita.setItemMeta(metaIndistruttibilita);
        Libri.setItem(12, indistruttibilita);

        ItemStack aspettoDiFuoco = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaAspettoDiFuoco = aspettoDiFuoco.getItemMeta();
        metaAspettoDiFuoco.setDisplayName("Libro di Aspetto di Fuoco III");
        metaAspettoDiFuoco.setLore(Collections.singletonList("Prezzo: €4500"));
        aspettoDiFuoco.setItemMeta(metaAspettoDiFuoco);
        Libri.setItem(13, aspettoDiFuoco);

        ItemStack infinita = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaInfinita = infinita.getItemMeta();
        metaInfinita.setDisplayName("Libro di Infinità I");
        metaInfinita.setLore(Collections.singletonList("Prezzo: €4500"));
        infinita.setItemMeta(metaInfinita);
        Libri.setItem(14, infinita);

        ItemStack freccia = new ItemStack(Material.ARROW);
        ItemMeta metaf = freccia.getItemMeta();
        metaf.setDisplayName("Torna Indietro");
        freccia.setItemMeta(metaf);
        Libri.setItem(26, freccia);

        p.openInventory(Libri);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv.getHolder() == null && "Libri".equals(inv.getTitle())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == 10) {
                ItemStack affilatezza = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(affilatezza);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 11) {
                ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(protezione);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 12) {
                ItemStack indistruttibilita = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(indistruttibilita);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 13) {
                ItemStack aspettoDiFuoco = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(aspettoDiFuoco);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 14) {
                ItemStack infinita = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(infinita);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 26) {
                Shop.openShop(p);
            }
        }
    }
}
