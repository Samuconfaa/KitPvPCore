package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.config.ConfigurationManager;
import it.samuconfaa.kitpvpcore.events.FIXlist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fix implements CommandExecutor {
    private final KitPvPCore plugin;

    public fix(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
         if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                FIXlist.openGUI(player);
                return true;
            } else {
                sender.sendMessage(plugin.getInstance().getConfig().getString("messages.player-only"));
            }
        }
        return false;
    }
}
