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

public class ShopNPC implements Listener{
    public void createNPC( Player p){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, KitPvPCore.getInstance().getConfig().getString("NPC.shopName"));
        npc.spawn(p.getLocation());
        setRandomSkin(npc);
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();
        if (npc.getName().equals(KitPvPCore.getInstance().getConfig().getString("NPC.shopName"))) {
            String command = "shop";
            player.performCommand(command);
        }
    }

    public static void setRandomSkin(NPC npc) {
        UUID uuid = UUID.randomUUID();
        npc.data().set("player-skin", uuid.toString());
    }
}
