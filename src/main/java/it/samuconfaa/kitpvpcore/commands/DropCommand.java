package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.events.GUIListener;
import it.samuconfaa.kitpvpcore.config.ConfigurationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropCommand implements CommandExecutor {
    private final KitPvPCore plugin;
    public DropCommand(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
         if (strings.length == 0) {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    plugin.getGuiListener().openGui(player);
                    return true;
                }
            return true;
        }
        return false;
    }
}
