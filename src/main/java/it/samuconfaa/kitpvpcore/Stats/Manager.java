package it.samuconfaa.kitpvpcore.Stats;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Manager {
    private final Map<UUID, Integer> kills = new HashMap<>();
    private final Map<UUID, Integer> deaths = new HashMap<>();
    private final Map<UUID, Integer> streaks = new HashMap<>();
    private final Map<UUID, Integer> bounties = new HashMap<>();
    private final File statsFile;
    private final FileConfiguration statsConfig;

    public Manager() {
        statsFile = new File(KitPvPCore.getInstance().getDataFolder(), "stats.yml");
        statsConfig = YamlConfiguration.loadConfiguration(statsFile);
        loadStats();
    }

    public void incrementKills(Player p) {
        UUID uuid = p.getUniqueId();
        kills.put(uuid, kills.getOrDefault(uuid, 0) + 1);
        saveStats();
    }

    public void incrementDeaths(Player p) {
        UUID uuid = p.getUniqueId();
        deaths.put(uuid, deaths.getOrDefault(uuid, 0) + 1);
        saveStats();
    }

    public void incrementStreak(Player p) {
        UUID uuid = p.getUniqueId();
        streaks.put(uuid, streaks.getOrDefault(uuid, 0) + 1);
        saveStats();
    }

    public void incrementBounty(Player p) {
        UUID uuid = p.getUniqueId();
        bounties.put(uuid, bounties.getOrDefault(uuid, 0) + KitPvPCore.getInstance().getConfig().getInt("Bounty"));
        saveStats();
    }

    public void resetBounty(Player p) {
        bounties.put(p.getUniqueId(), 0);
        saveStats();
    }

    public void resetStreak(Player p) {
        streaks.put(p.getUniqueId(), 0);
        saveStats();
    }

    public void checkPlayer(Player p) {
        UUID uuid = p.getUniqueId();
        kills.putIfAbsent(uuid, 0);
        deaths.putIfAbsent(uuid, 0);
        streaks.putIfAbsent(uuid, 0);
        bounties.putIfAbsent(uuid, 0);
    }

    public int getKills(Player p) {
        return kills.getOrDefault(p.getUniqueId(), 0);
    }

    public int getDeaths(Player p) {
        return deaths.getOrDefault(p.getUniqueId(), 0);
    }

    public int getStreak(Player p) {
        return streaks.getOrDefault(p.getUniqueId(), 0);
    }

    public int getBounty(Player p) {
        return bounties.getOrDefault(p.getUniqueId(), 0);
    }

    public void setKills(UUID uuid, int amount) {
        kills.put(uuid, amount);
        saveStats();
    }

    public void setDeaths(UUID uuid, int amount) {
        deaths.put(uuid, amount);
        saveStats();
    }

    public void setStreak(UUID uuid, int amount) {
        streaks.put(uuid, amount);
        saveStats();
    }

    public void setBounty(UUID uuid, int amount) {
        bounties.put(uuid, amount);
        saveStats();
    }

    public void saveStats() {
        for (UUID uuid : kills.keySet()) {
            String playerPath = "players." + uuid.toString();
            statsConfig.set(playerPath + ".kills", kills.get(uuid));
            statsConfig.set(playerPath + ".deaths", deaths.get(uuid));
            statsConfig.set(playerPath + ".streaks", streaks.get(uuid));
            statsConfig.set(playerPath + ".bounties", bounties.get(uuid));
        }
        try {
            statsConfig.save(statsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStats() {
        if (statsFile.exists()) {
            for (String uuidString : statsConfig.getConfigurationSection("players").getKeys(false)) {
                UUID uuid = UUID.fromString(uuidString);
                kills.put(uuid, statsConfig.getInt("players." + uuidString + ".kills"));
                deaths.put(uuid, statsConfig.getInt("players." + uuidString + ".deaths"));
                streaks.put(uuid, statsConfig.getInt("players." + uuidString + ".streaks"));
                bounties.put(uuid, statsConfig.getInt("players." + uuidString + ".bounties"));
            }
        }
    }
}
