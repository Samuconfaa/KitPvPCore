package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.config.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Sound;

import java.util.ArrayList;
import java.util.List;

public class FIXlist implements Listener {
    public static void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, ConfigurationManager.GUIsize(), ConfigurationManager.GUIname());

        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta Manvil = anvil.getItemMeta();
        Manvil.setDisplayName(ConfigurationManager.anvilName());
        List<String> lore = new ArrayList<>();
        lore.add(ConfigurationManager.lore1());
        lore.add(ConfigurationManager.lore2());
        lore.add(ConfigurationManager.lore3() + ConfigurationManager.price());
        Manvil.setLore(lore);
        anvil.setItemMeta(Manvil);
        gui.setItem(ConfigurationManager.anvilPos(), anvil);

        ItemStack vetro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) ConfigurationManager.glassColor());
        ItemMeta meta = vetro.getItemMeta();
        meta.setDisplayName(ConfigurationManager.glassName());
        vetro.setItemMeta(meta);

        for (int i = 0; i < ConfigurationManager.GUIsize(); i++) {
            if (i != ConfigurationManager.anvilPos()) {
                gui.setItem(i, vetro);
            }
        }

        player.openInventory(gui);
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem().getItemStack();

        if (item.getType() == Material.ANVIL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if (inv != null && inv.getHolder() == null && ConfigurationManager.GUIname().equals(inv.getName())) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            Location location = player.getLocation();
            int slot = e.getRawSlot();
            if (slot == ConfigurationManager.anvilPos()) {
                if (KitPvPCore.checkMoney(player) >= ConfigurationManager.price()) {
                    repairAllItems(player);

                } else {
                    player.sendMessage(ConfigurationManager.nomoney());

                }
            }
        }
    }

    private void repairAllItems(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                item.setDurability((short) 0);
            }
        }


        KitPvPCore.removeMoney(player, ConfigurationManager.price());
    }
}
