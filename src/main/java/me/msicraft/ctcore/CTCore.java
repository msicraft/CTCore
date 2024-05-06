package me.msicraft.ctcore;

import org.bukkit.plugin.java.JavaPlugin;

public final class CTCore extends JavaPlugin {

    private static CTCore plugin;

    public static CTCore getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {
    }

}
