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
            double taglia = Manager.getBounty(vittima);
            //vittima
            Manager.setBounty(vittima, 0);
            Manager.resetKillStreak(vittima);
            Manager.increaseDeaths(vittima);

            //killer
            Manager.increaseBounty(killer, KitPvPCore.getInstance().getConfig().getInt("bounty"));
            Manager.increaseKills(killer);
            Manager.increaseKillStreak(killer);
            KitPvPCore.giveMoney(killer,KitPvPCore.getInstance().getConfig().getInt("kill-rewards.money"));
            int i = Manager.getBounty(killer);
            if(i != 0) {
                KitPvPCore.giveMoney(killer, i);
                for(Player player : Bukkit.getOnlinePlayers()){
                    player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_THUNDER, 1.0f, 1.0f);
                }
            }
            BroadCast.broadcastMessage(KitPvPCore.getInstance().getConfig().getString("messages.kill")
                    .replace((CharSequence) "%player%", (CharSequence) killer)
                    .replace((CharSequence) "%victim%", (CharSequence) vittima));
        }
    }
}
