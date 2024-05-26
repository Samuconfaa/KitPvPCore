package it.samuconfaa.kitpvpcore.config;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UtilConfig {
    private final JavaPlugin plugin;
    private final String configName;
    private final String folder;
    private final File configurationFile;
    private FileConfiguration configuration;
    private static FileConfiguration config;
    private static File configFile;

    public UtilConfig(JavaPlugin plugin, String configName, String folderName) {
        if (plugin == null) {
            throw new IllegalStateException("Plugin must not be null!");
        }
        this.plugin = plugin;
        this.configName = configName;
        this.folder = folderName;
        if (this.folder == null) {
            this.configurationFile = new File(plugin.getDataFolder(), configName);
        } else {
            this.configurationFile = new File(plugin.getDataFolder() + "/" + this.folder, configName);
        }
    }

    public FileConfiguration getConfiguration() {
        if (this.configuration == null) {
            this.reloadConfig();
        }
        return this.configuration;
    }

    public File getFile() {
        return this.configurationFile;
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    public void saveConfig() {
        if (this.configuration != null && this.configurationFile != null) {
            try {
                this.getConfiguration().save(this.configurationFile);
            } catch (IOException ex) {
                this.plugin.getLogger().info("Configuration save failed!");
            }
        }
    }

    public void saveDefaultConfig() {
        if (!this.configurationFile.exists()) {
            this.plugin.saveResource(this.configName, false);
        }
    }

    public void deleteConfig() {
        this.configurationFile.delete();
    }
}
