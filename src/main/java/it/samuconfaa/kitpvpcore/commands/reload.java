package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import it.samuconfaa.kitpvpcore.config.UtilConfig;
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
        if(commandSender.hasPermission("kit.reload")){
            UtilConfig.reloadConfig();
            commandSender.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.reload"));
        }
        return true;
    }
}
