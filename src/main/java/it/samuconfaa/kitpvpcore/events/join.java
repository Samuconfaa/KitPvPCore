package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import it.samuconfaa.kitpvpcore.statistiche.Manager;

public class join implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String[] messages = KitPvPCore.getInstance().getConfig().getStringList("join-events.messages").toArray(new String[0]);
        for (String message : messages) {
            event.getPlayer().sendMessage(message.replace("{PLAYER}", event.getPlayer().getName()));
        }
        Manager.addPlayer(p);
    }
}
