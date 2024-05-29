package it.samuconfaa.kitpvpcore.commands;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class NPCListCommand implements CommandExecutor {
    private final KitPvPCore plugin;

    public NPCListCommand(KitPvPCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("kitpvp.npc"))
            if (!(sender instanceof Player)) {
                sender.sendMessage(KitPvPCore.getInstance().getConfig().getString("messages.player-only"));
                return true;
            }

        Player player = (Player) sender;
        Collection<NPC> npcs = (Collection<NPC>) CitizensAPI.getNPCRegistry().sorted();
        if (npcs.isEmpty()) {
            player.sendMessage("No NPC in this world.");
            return true;
        }

        player.sendMessage("Elenco degli NPC nel mondo:");
        for (NPC npc : npcs) {
            player.sendMessage("ID: " + npc.getId() + ", Name: " + npc.getName());
        }

        return true;
    }
}

