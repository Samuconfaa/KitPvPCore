package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.statistiche.Manager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onKill implements Listener {
    private final KitPvPCore plugin;

    public onKill(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player vittima = e.getEntity().getKiller();
            Player killer = e.getEntity();
            double taglia = Manager.getBounty(vittima);
            //vittima
            Manager.setBounty(vittima, 0);
            Manager.resetKillStreak(vittima);
            Manager.increaseDeaths(vittima);

            //killer
            Manager.increaseBounty(killer, plugin.getConfig().getInt("bounty"));
        }
    }
}
