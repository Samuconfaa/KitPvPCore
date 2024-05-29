package it.samuconfaa.kitpvpcore.Stats;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceHolder extends PlaceholderExpansion{
    private final Manager statsManager;
    private final KitPvPCore plugin;

    public PlaceHolder(KitPvPCore plugin, Manager statsManager) {
        this.statsManager = statsManager;
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String getAuthor() {
        return "Samuconfaa";
    }

    @Override
    public String getIdentifier() {
        return "kitpvp";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }


        if (identifier.equals("kills")) {
            return String.valueOf(statsManager.getKills(player));
        }
        if (identifier.equals("streak")) {
            return String.valueOf(statsManager.getStreak(player));
        }
        if (identifier.equals("bounty")) {
            return String.valueOf(statsManager.getBounty(player));
        }
        if (identifier.equals("deaths")) {
            return String.valueOf(statsManager.getDeaths(player));
        }

        return null;
    }
}
