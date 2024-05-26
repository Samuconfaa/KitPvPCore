package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class build implements CommandExecutor {
    private final KitPvPCore plugin;

    public build(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.player-only", "Only players can use this command."));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("kitpvp.build")) {
            player.sendMessage(plugin.getConfig().getString("messages.nopermission", "You do not have permission to use this command."));
            return true;
        }

        if (KitPvPCore.playerlist.contains(player.getUniqueId())) {
            player.sendMessage(plugin.getConfig().getString("messages.build-disable", "Build mode disabled."));
            KitPvPCore.playerlist.remove(player.getUniqueId());
        } else {
            player.sendMessage(plugin.getConfig().getString("messages.build-enable", "Build mode enabled."));
            KitPvPCore.playerlist.add(player.getUniqueId());
        }
        return true;
    }
}
