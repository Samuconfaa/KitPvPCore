package it.samuconfaa.kitpvpcore.config;

import it.samuconfaa.kitpvpcore.KitPvPCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigurationManager {
    private final KitPvPCore plugin;
    private static FileConfiguration config;
    private static File configFile;

    public ConfigurationManager(KitPvPCore plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static int price(){
        return config.getInt("price", 200);
    }
    public static int GUIsize(){
        return config.getInt("GUIsize", 270);
    }
    public static int anvilPos(){
        return config.getInt("anvilPos", 13);
    }
    public static int glassColor(){
        return config.getInt("glassColor", 7);
    }
    public static String GUIname(){
        return config.getString("GUIname", "Fabbro");
    }
    public static String anvilName(){
        return config.getString("anvilName", "§3§lFABBRO");
    }
    public static String lore1(){
        return config.getString("lore1");
    }
    public static String lore2(){
        return config.getString("lore2");
    }
    public static String lore3(){
        return config.getString("lore3");
    }
    public static String nopermission(){
        return config.getString("messages.nopermission");
    }
    public static String nomoney(){
        return config.getString("messages.nomoney");
    }
    public static String consoleCommand(){
        return config.getString("messages.consoleCommand");
    }

    public static String glassName(){
        return config.getString("glassName");
    }
    public static int altezzaGUI() {
        return config.getInt("GUIHeight", 27);
    }

    public static int glassColord() {
        return config.getInt("glassColord", 7);
    }

    public static int melePos() {
        return config.getInt("position.mele", 11);
    }

    public static int frecciaPos() {
        return config.getInt("position.freccia", 13);
    }

    public static int cannaPos() {
        return config.getInt("position.canna", 15);
    }

    public static String glass() {
        return config.getString("glassNamed");
    }

    public static String meleName(){
        return config.getString("itemname.mele");
    }
    public static String frecciaName(){
        return config.getString("itemname.freccia");
    }
    public static String cannaName(){
        return config.getString("itemname.canna");
    }
    public static String enable(){
        return config.getString("status.enable");
    }
    public static String disable(){
        return config.getString("status.disable");
    }




    public static String guiName() {
        return config.getString("nomeGUI");
    }
}


