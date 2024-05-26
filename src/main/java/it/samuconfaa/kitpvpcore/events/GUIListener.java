package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.config.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIListener implements Listener {

    public String meleN = ConfigurationManager.meleName();
    public  String frecciaN = ConfigurationManager.frecciaName();
    public  String cannaN = ConfigurationManager.cannaName();

    private final KitPvPCore plugin;
    private final Map<Player, Boolean> goldenApplePickupStatus = new HashMap<>();
    private final Map<Player, Boolean> cannaPickupStatus = new HashMap<>();
    private final Map<Player, Boolean> arrowPickupStatus = new HashMap<>();

    public GUIListener(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        if (inventory.getHolder() == null && ConfigurationManager.guiName().equals(inventory.getName())) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            if (slot == ConfigurationManager.melePos()) {
                boolean isEnabledMela = goldenApplePickupStatus.getOrDefault(player, true);
                goldenApplePickupStatus.put(player, !isEnabledMela);
                openGui(player);
            } else if (slot == ConfigurationManager.frecciaPos()) {
                boolean isEnabledFreccia = arrowPickupStatus.getOrDefault(player, true);
                arrowPickupStatus.put(player, !isEnabledFreccia);
                openGui(player);
            } else if (slot == ConfigurationManager.cannaPos()) {
                boolean isEnabledCanna = cannaPickupStatus.getOrDefault(player, true);
                cannaPickupStatus.put(player, !isEnabledCanna);
                openGui(player);
            }
        }
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem().getItemStack();

        if (item.getType() == Material.GOLDEN_APPLE && !goldenApplePickupStatus.getOrDefault(player, true)) {
            event.setCancelled(true);
        } else if (item.getType() == Material.ARROW && !arrowPickupStatus.getOrDefault(player, true)) {
            event.setCancelled(true);
        } else if (item.getType() == Material.FISHING_ROD && !cannaPickupStatus.getOrDefault(player, true)) {
            event.setCancelled(true);
        }
    }

    public void openGui(Player player) {
        Inventory gui = Bukkit.createInventory(null, ConfigurationManager.altezzaGUI(), ConfigurationManager.guiName());

        ItemStack mele = createItem(Material.GOLDEN_APPLE, meleN, goldenApplePickupStatus.getOrDefault(player, true));
        gui.setItem(ConfigurationManager.melePos(), mele);

        ItemStack freccia = createItem(Material.ARROW, frecciaN, arrowPickupStatus.getOrDefault(player, true));
        gui.setItem(ConfigurationManager.frecciaPos(), freccia);

        ItemStack canna = createItem(Material.FISHING_ROD,cannaN, cannaPickupStatus.getOrDefault(player, true));
        gui.setItem(ConfigurationManager.cannaPos(), canna);

        ItemStack vetro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) ConfigurationManager.glassColor());
        ItemMeta meta = vetro.getItemMeta();
        meta.setDisplayName(ConfigurationManager.glass());
        vetro.setItemMeta(meta);

        for (int i = 0; i < ConfigurationManager.altezzaGUI(); i++) {
            if (i != ConfigurationManager.melePos() && i != ConfigurationManager.frecciaPos() && i != ConfigurationManager.cannaPos()) {
                gui.setItem(i, vetro);
            }
        }

        player.openInventory(gui);
    }

    private ItemStack createItem(Material material, String name, boolean isEnabled) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        List<String> lore = new ArrayList<>();
        if(isEnabled){
            lore.add(ConfigurationManager.enable());
        }else{
            lore.add(ConfigurationManager.disable());
        }
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

}
