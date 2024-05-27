package it.samuconfaa.kitpvpcore.statistiche;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.jetbrains.annotations.NotNull;

import org.bukkit.entity.Player;

public class PlaceHolder extends PlaceholderExpansion{
    @Override
    public @NotNull String getIdentifier() {
        return "playerstats";
    }

    @Override
    public @NotNull String getAuthor() {
        return "IlTuoNome";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (player == null) {
            return null;
        }

        PlayerStats stats = Manager.getPlayerStats(player);

        switch (identifier) {
            case "kills":
                return String.valueOf(stats.getKills());
            case "deaths":
                return String.valueOf(stats.getDeaths());
            case "killstreak":
                return String.valueOf(stats.getKillStreak());
            case "bounty":
                if(Manager.getBounty(player) != 0) {
                    return String.valueOf(stats.getBounty());
                }
            default:
                return null;
        }
    }
}

