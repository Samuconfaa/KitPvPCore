package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {
    private final KitPvPCore plugin;

    public reload(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
