package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import it.samuconfaa.kitpvpcore.NPC.*;

public class NPCCommand implements CommandExecutor {
    private KitPvPCore plugin;
    public NPCCommand(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender se, Command command, String s, String[] a) {
        if(se instanceof Player){
            Player p = (Player) se;
            if(p.hasPermission("kit.npc")){
                if(a.length != 1){
                    return false;
                }else if(a[0].equalsIgnoreCase("fix")){
                    FixNPC.createNPC(p);
                    return true;
                }else if(a[0].equalsIgnoreCase("drop")){
                    DropNPC.createNPC(p);
                    return true;
                }else if(a[0].equalsIgnoreCase("shop")){
                    FixNPC.createNPC(p);
                    return true;
                }
            }else {
                p.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.noperission"));
            }
        }else {
            se.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.player-only"));
        }



        return true;
    }
}
