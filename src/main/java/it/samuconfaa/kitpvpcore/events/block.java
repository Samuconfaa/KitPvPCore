package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class block implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!KitPvPCore.playerlist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.sendMessage(KitPvPCore.getInstance().getConfig().getString("not-allowed-place"));
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!KitPvPCore.playerlist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.sendMessage(KitPvPCore.getInstance().getConfig().getString("not-allowed-break"));
        } else {
            event.setCancelled(false);
        }
    }



    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        KitPvPCore.playerlist.remove(player.getUniqueId());
    }
}
