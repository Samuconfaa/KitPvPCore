package it.samuconfaa.kitpvpcore.shop;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.Listener;

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

        ItemStack atterraggioMorbido = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaAtterraggioMorbido = atterraggioMorbido.getItemMeta();
        metaAtterraggioMorbido.setDisplayName("Libro di Atterraggio Morbido IV");
        metaAtterraggioMorbido.setLore(Collections.singletonList("Prezzo: €4500"));
        atterraggioMorbido.setItemMeta(metaAtterraggioMorbido);
        Libri.setItem(15, atterraggioMorbido);

        ItemStack impatto = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaImpatto = impatto.getItemMeta();
        metaImpatto.setDisplayName("Libro di Impatto I");
        metaImpatto.setLore(Collections.singletonList("Prezzo: €4500"));
        impatto.setItemMeta(metaImpatto);
        Libri.setItem(16, impatto);

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
        if (inv.getHolder() == null && "Negozio".equals(inv.getName())) {
            e.setCancelled(true);


            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == 11) {
                ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(protezione);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 12) {
                ItemStack ind = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(ind);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 13) {
                ItemStack adf = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(adf);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 14) {
                ItemStack inf = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(inf);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 15) {
                ItemStack am = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(am);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 16) {
                ItemStack imp = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(imp);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 10) {
                ItemStack sh = new ItemStack(Material.ENCHANTED_BOOK);
                p.getInventory().addItem(sh);
                KitPvPCore.removeMoney(p, 2200);
            } else if (slot == 26) {
                Shop.openShop(p);
            }
        }
    }
}
