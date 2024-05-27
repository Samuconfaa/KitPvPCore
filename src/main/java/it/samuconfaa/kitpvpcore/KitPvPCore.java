package it.samuconfaa.kitpvpcore;

import it.samuconfaa.kitpvpcore.commands.*;
import it.samuconfaa.kitpvpcore.config.ConfigurationManager;
import it.samuconfaa.kitpvpcore.config.UtilConfig;
import it.samuconfaa.kitpvpcore.events.*;
import it.samuconfaa.kitpvpcore.statistiche.PlaceHolder;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getPluginManager;

public final class KitPvPCore extends JavaPlugin {
    private static Economy econ = null;
    public static List<UUID> playerlist = new ArrayList<>();
    public static UtilConfig settings;
    public static KitPvPCore instance;
    public static ConfigurationManager configManager;
    private GUIListener guiListener;


    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigurationManager(this);
        guiListener = new GUIListener(this);
        loadCommands();
        loadEvents();
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceHolder().register();
        }
        if (!setupEconomy()) {
            getLogger().severe("Vault non è installato o nessun plugin economico è trovato!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.createYML();
    }

    public void loadCommands() {
        getCommand("build").setExecutor(new build(this));
        getCommand("fix").setExecutor(new fix(this));
        getCommand("reload").setExecutor(new reload(this));
        getCommand("stats").setExecutor(new stats(this));
        getCommand("drop").setExecutor(new DropCommand(this));
    }

    public void loadEvents() {
        PluginManager pm = getPluginManager();
        pm.registerEvents(new block(), this);
        pm.registerEvents(new FIXlist(), this);
        pm.registerEvents(new join(), this);
        pm.registerEvents(new onKill(), this);
        pm.registerEvents(new FIXlist(), this);
        pm.registerEvents(guiListener, this);
        pm.registerEvents(new BroadCast(), this);
    }

    public void createYML() {
        settings = new UtilConfig(this, "config.yml", null);
        settings.saveDefaultConfig();
    }

    public static KitPvPCore getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static void removeMoney(Player player, double amount) {
        if (econ != null) {
            econ.withdrawPlayer(player, amount);
        }
    }

    public static double checkMoney(Player player) {
        if (econ != null) {
            return econ.getBalance(player);
        }
        return 0;
    }

    public static void giveMoney(Player player, double amount) {
        if (econ != null) {
            econ.depositPlayer(player, amount);
        }
    }
    public GUIListener getGuiListener() {
        return guiListener;
    }
}
