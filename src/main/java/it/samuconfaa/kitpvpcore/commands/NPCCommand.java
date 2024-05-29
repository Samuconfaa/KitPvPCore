package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import it.samuconfaa.kitpvpcore.NPC.*;

import java.util.List;

public class NPCCommand implements CommandExecutor {
    private KitPvPCore plugin;
    public NPCCommand(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender se, Command command, String s, String[] a) {
        if(se instanceof Player){
            Player p = (Player) se;
            if(p.hasPermission("kitpvp.npc")){
                if(a.length != 1 && a.length != 2 ){
                    return false;
                }else if(a[0].equalsIgnoreCase("fix")){
                    FixNPC.createNPC(p);
                    return true;
                }else if(a[0].equalsIgnoreCase("drop")){
                    DropNPC.createNPC(p);
                    return true;
                }else if(a[0].equalsIgnoreCase("shop")){
                    ShopNPC.createNPC(p);
                    return true;
                }else if(a[0].equalsIgnoreCase("remove")){
                    int id = Integer.parseInt(a[1]);
                    removeNPC(p, id);
                }
            }else {
                p.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.noperission"));
            }
        }else {
            se.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.player-only"));
        }



        return true;
    }
    public static void removeNPC(Player player, int npcId) {
        NPC npc = CitizensAPI.getNPCRegistry().getById(npcId);
        if (npc != null) {
            npc.despawn();
            npc.destroy();
            player.sendMessage(KitPvPCore.getInstance().getConfig().getString("NPC.removedNPC"));
        } else {
            player.sendMessage(KitPvPCore.getInstance().getConfig().getString("NPC.noNPC"));
        }
    }
}


