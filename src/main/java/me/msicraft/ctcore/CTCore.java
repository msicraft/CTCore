package me.msicraft.ctcore;

import me.msicraft.ctcore.Event.EquipmentRelatedEvent;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CTCore extends JavaPlugin {

    private static CTCore plugin;

    public static CTCore getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        createConfigFiles();

        getServer().getPluginManager().registerEvents(new EquipmentRelatedEvent(this), this);
    }

    @Override
    public void onDisable() {
    }

    private void createConfigFiles() {
        File configf = new File(getDataFolder(), "config.yml");
        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        FileConfiguration config = new YamlConfiguration();
        try {
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
