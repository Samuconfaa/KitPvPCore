package it.samuconfaa.kitpvpcore.Stats;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class StatsCommand implements CommandExecutor {
    private final KitPvPCore plugin;
    private final Manager statsManager;

    public StatsCommand(KitPvPCore plugin, Manager statsManager) {
        this.plugin = plugin;
        this.statsManager = statsManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.player-only"));
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            // Comando /stats per vedere le proprie statistiche
            showPlayerStats(player, player);
        } else if (args.length == 1) {
            // Comando /stats [player] per vedere le statistiche di un altro player
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer != null && targetPlayer.isOnline()) {
                showPlayerStats(player, targetPlayer);
            } else {
                player.sendMessage(plugin.getConfig().getString("messages.nonOnlinePlayer"));
            }
        } else if (args.length == 3) {
            // Comando /stats [player] [kill, deaths, streak, bounty] [amount] per impostare le statistiche di un altro player
            if (player.hasPermission("kitpvp.statsother")) {
                Player targetPlayer = Bukkit.getPlayer(args[0]);
                if (targetPlayer != null && targetPlayer.isOnline()) {
                    setPlayerStat(player, targetPlayer, args[1], args[2]);
                } else {
                    player.sendMessage(plugin.getConfig().getString("messages.nonOnlinePlayer"));
                }
            } else {
                player.sendMessage("Usage: /stats [player] [kill, deaths, streak, bounty] [amount]");
            }plugin.getConfig().getString("messages.nopermission");
        }

        return true;
    }

    private void showPlayerStats(Player viewer, Player target) {
        List<String> message = KitPvPCore.getInstance().getConfig().getStringList("stats.message");

        for (String line : message) {
            line = line.replace("{PLAYER}", target.getName());
            line = line.replace("{KILLS}", String.valueOf(statsManager.getKills(target)));
            line = line.replace("{DEATHS}", String.valueOf(statsManager.getDeaths(target)));
            line = line.replace("{STREAK}", String.valueOf(statsManager.getStreak(target)));
            line = line.replace("{BOUNTY}", String.valueOf(statsManager.getBounty(target)));

            viewer.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
    }

    private void setPlayerStat(Player sender, Player target, String statType, String amount) {
        try {
            int statAmount = Integer.parseInt(amount);
            UUID targetUUID = target.getUniqueId();
            switch (statType.toLowerCase()) {
                case "kill":
                    statsManager.checkPlayer(target);
                    statsManager.setKills(targetUUID, statAmount);
                    sender.sendMessage(target.getName() + "'s kills set to " + statAmount);
                    break;
                case "deaths":
                    statsManager.checkPlayer(target);
                    statsManager.setDeaths(targetUUID, statAmount);
                    sender.sendMessage(target.getName() + "'s deaths set to " + statAmount);
                    break;
                case "streak":
                    statsManager.checkPlayer(target);
                    statsManager.setStreak(targetUUID, statAmount);
                    sender.sendMessage(target.getName() + "'s streak set to " + statAmount);
                    break;
                case "bounty":
                    statsManager.checkPlayer(target);
                    statsManager.setBounty(targetUUID, statAmount);
                    sender.sendMessage(target.getName() + "'s bounty set to " + statAmount);
                    break;
                default:
                    sender.sendMessage("OPTIONS: kill, deaths, streak, bounty");
            }
        } catch (NumberFormatException e) {
            sender.sendMessage("Please enter a valid number.");
        }
    }
}
