package it.samuconfaa.kitpvpcore.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BroadCast implements Listener {
    public static void broadcastMessage(String s){
        Bukkit.getServer().broadcastMessage(s);
    }
}
