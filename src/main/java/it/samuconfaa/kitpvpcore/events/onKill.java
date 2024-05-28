package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.Stats.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class onKill implements Listener {
    private final Manager manager;

    public onKill(Manager manager) {
        this.manager = manager;
    }


    @EventHandler
    public void onKill(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player vittima = e.getEntity().getKiller();
            Player killer = e.getEntity();
            double taglia = manager.getTaglia(vittima);
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            //vittima
            manager.incrementDeaths(vittima);
            manager.resetTaglia(vittima);
            manager.resetStreak(vittima);


            //killer
            manager.incrementKills(killer);
            manager.incrementStreak(killer);
            KitPvPCore.giveMoney(killer,KitPvPCore.getInstance().getConfig().getInt("kill-rewards.money"));
            if(taglia != 0){
                KitPvPCore.giveMoney(killer, taglia);
            }
            if(randomNumber == 0){
                manager.incrementTaglia(killer);
            }

            BroadCast.broadcastMessage(KitPvPCore.getInstance().getConfig().getString("messages.kill")
                    .replace((CharSequence) "%player%", (CharSequence) killer)
                    .replace((CharSequence) "%victim%", (CharSequence) vittima));
        }
    }
}