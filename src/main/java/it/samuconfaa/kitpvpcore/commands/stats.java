package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class stats implements CommandExecutor {
    private final KitPvPCore plugin;
    public stats(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
