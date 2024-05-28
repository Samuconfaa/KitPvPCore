package it.samuconfaa.kitpvpcore.events;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.statistiche.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onKill implements Listener {


    @EventHandler
    public void onKill(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player vittima = e.getEntity().getKiller();
            Player killer = e.getEntity();

            //vittima

            Manager.addDeath(vittima);

            //killer

            Manager.addKill(killer);
            KitPvPCore.giveMoney(killer,KitPvPCore.getInstance().getConfig().getInt("kill-rewards.money"));


            BroadCast.broadcastMessage(KitPvPCore.getInstance().getConfig().getString("messages.kill")
                    .replace((CharSequence) "%player%", (CharSequence) killer)
                    .replace((CharSequence) "%victim%", (CharSequence) vittima));
        }
    }
}