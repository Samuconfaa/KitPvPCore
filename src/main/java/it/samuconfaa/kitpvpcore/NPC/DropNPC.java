package it.samuconfaa.kitpvpcore.NPC;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class DropNPC implements Listener {



    public static void createNPC(Player p){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, KitPvPCore.getInstance().getConfig().getString("NPC.dropName"));
        npc.spawn(p.getLocation());
        ShopNPC.setRandomSkin(npc);
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();
        if (npc.getName().equals(KitPvPCore.getInstance().getConfig().getString("NPC.dropName"))) {
            String command = "drop";
            player.performCommand(command);
        }
    }


}
