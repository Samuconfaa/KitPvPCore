package it.samuconfaa.kitpvpcore.statistiche;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    private static Map<Player, PlayerStats> playerStatsMap;

    public Manager() {
        playerStatsMap = new HashMap<>();
    }

    public static void addPlayer(Player player) {
        playerStatsMap.put(player, new PlayerStats());
    }

    public static void removePlayer(Player player) {
        playerStatsMap.remove(player);
    }

    public static void increaseKills(Player player) {
        getPlayerStats(player).increaseKills();
    }

    public static void decreaseKills(Player player) {
        getPlayerStats(player).decreaseKills();
    }

    public static int getKills(Player player) {
        return getPlayerStats(player).getKills();
    }

    public static void increaseDeaths(Player player) {
        getPlayerStats(player).increaseDeaths();
    }

    public static void decreaseDeaths(Player player) {
        getPlayerStats(player).decreaseDeaths();
    }

    public static int getDeaths(Player player) {
        return getPlayerStats(player).getDeaths();
    }

    public static void increaseKillStreak(Player player) {
        getPlayerStats(player).increaseKillStreak();
    }

    public static void resetKillStreak(Player player) {
        getPlayerStats(player).resetKillStreak();
    }

    public static int getKillStreak(Player player) {
        return getPlayerStats(player).getKillStreak();
    }

    public static void setBounty(Player player, int bounty) {
        getPlayerStats(player).setBounty(bounty);
    }

    public static void increaseBounty(Player player, int amount) {
        getPlayerStats(player).increaseBounty(amount);
    }

    public static void decreaseBounty(Player player, int amount) {
        getPlayerStats(player).decreaseBounty(amount);
    }

    public static int getBounty(Player player) {
        return getPlayerStats(player).getBounty();
    }

    public static PlayerStats getPlayerStats(Player player) {
        return playerStatsMap.get(player);
    }
}

class PlayerStats {
    private static int kills;
    private static int deaths;
    private static int killStreak;
    private static int bounty;

    public PlayerStats() {
        kills = 0;
        deaths = 0;
        killStreak = 0;
        bounty = 0;
    }

    public static void increaseKills() {
        kills++;
    }

    public static void decreaseKills() {
        if (kills > 0) {
            kills--;
        }
    }

    public static int getKills() {
        return kills;
    }

    public static void increaseDeaths() {
        deaths++;
    }

    public static void decreaseDeaths() {
        if (deaths > 0) {
            deaths--;
        }
    }

    public static int getDeaths() {
        return deaths;
    }

    public static void increaseKillStreak() {
        killStreak++;
    }

    public static void resetKillStreak() {
        killStreak = 0;
    }

    public static int getKillStreak() {
        return killStreak;
    }

    public static void setBounty(int newBounty) {
        bounty = newBounty;
    }

    public static void increaseBounty(int amount) {
        bounty += amount;
    }

    public static void decreaseBounty(int amount) {
        if (bounty >= amount) {
            bounty -= amount;
        }
    }

    public static int getBounty() {
        return bounty;
    }


}

