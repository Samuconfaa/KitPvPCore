package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import it.samuconfaa.kitpvpcore.shop.Shop;

public class ShopCommand implements CommandExecutor {
    private KitPvPCore plugin;
    public ShopCommand(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender se, Command command, String s, String[] strings) {
        Player player = (Player) se;
        if(se instanceof Player){
            Shop.openGUI();
        }else {
            se.sendMessage(plugin.getInstance().getConfig().getString("messages.player-only"));
        }


        return false;
    }
}
