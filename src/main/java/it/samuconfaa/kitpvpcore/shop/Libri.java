package it.samuconfaa.kitpvpcore.shop;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Libri implements Listener {

    public static void openLibri(Player p) {
        Inventory Libri = Bukkit.createInventory(p, 27, KitPvPCore.getInstance().getConfig().getString("shopName.libri"));

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
        if (inv != null && inv.getName().equals(KitPvPCore.getInstance().getConfig().getString("shopName.libri"))) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == 10&& KitPvPCore.checkMoney(p) >= 4500) {
                ItemStack affilatezza = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) affilatezza.getItemMeta();
                meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 4, true);
                affilatezza.setItemMeta(meta);
                p.getInventory().addItem(affilatezza);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 11&& KitPvPCore.checkMoney(p) >= 4500) {
                ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protezione.getItemMeta();
                meta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                protezione.setItemMeta(meta);
                p.getInventory().addItem(protezione);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 12&& KitPvPCore.checkMoney(p) >= 4500) {
                ItemStack indistruttibilita = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) indistruttibilita.getItemMeta();
                meta.addStoredEnchant(Enchantment.DURABILITY, 3, true);
                indistruttibilita.setItemMeta(meta);
                p.getInventory().addItem(indistruttibilita);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 13&& KitPvPCore.checkMoney(p) >= 4500) {
                ItemStack aspettoDiFuoco = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) aspettoDiFuoco.getItemMeta();
                meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 2, true);
                aspettoDiFuoco.setItemMeta(meta);
                p.getInventory().addItem(aspettoDiFuoco);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 14&& KitPvPCore.checkMoney(p) >= 4500) {
                ItemStack infinita = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) infinita.getItemMeta();
                meta.addStoredEnchant(Enchantment.ARROW_INFINITE, 1, true);
                infinita.setItemMeta(meta);
                p.getInventory().addItem(infinita);
                KitPvPCore.removeMoney(p, 4500);
            } else if (slot == 26) {
                Shop.openShop(p);
            }
        }
    }
}
