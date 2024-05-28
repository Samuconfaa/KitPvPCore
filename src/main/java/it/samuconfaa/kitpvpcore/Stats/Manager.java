package it.samuconfaa.kitpvpcore.Stats;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    Map<Player, Integer> kill = new HashMap<>();
    Map<Player, Integer> morti = new HashMap<>();
    Map<Player, Integer> streak = new HashMap<>();
    Map<Player, Integer> taglia = new HashMap<>();

    public void incrementKills(Player p) {
        kill.put(p, kill.getOrDefault(p, 0) + 1);
    }

    public void incrementDeaths(Player p) {
        morti.put(p, morti.getOrDefault(p, 0) + 1);
    }


    public void incrementStreak(Player p) {
        streak.put(p, streak.getOrDefault(p, 0) + 1);
    }


    public void incrementTaglia(Player p) {
        taglia.put(p, taglia.getOrDefault(p, 0) + KitPvPCore.getInstance().getConfig().getInt("Bounty"));
    }

    public void resetTaglia(Player p){
        taglia.put(p,0);
    }

    public void resetStreak(Player p){
        streak.put(p,0);
    }

    public void checkPl(Player p) {
        kill.putIfAbsent(p, 0);
        morti.putIfAbsent(p, 0);
        streak.putIfAbsent(p, 0);
        taglia.putIfAbsent(p, 0);
    }


    public int getKills(Player p) {
        return kill.getOrDefault(p, 0);
    }

    public int getDeaths(Player p) {
        return morti.getOrDefault(p, 0);
    }

    public int getStreak(Player p) {
        return streak.getOrDefault(p, 0);
    }

    public int getTaglia(Player p) {
        return taglia.getOrDefault(p, 0);
    }
}
