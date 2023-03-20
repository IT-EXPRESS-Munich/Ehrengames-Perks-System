package tech.itexpress.perks;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.perks.Perks.Glow;

public class loader extends JavaPlugin {

    private Glow glowPlugin;

    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        glowPlugin = new Glow();
        pluginManager.registerEvents(glowPlugin, this);
        getLogger().info("GlowPlugin wurde geladen.");
    }

    public void onDisable() {
        glowPlugin.onDisable();
        getLogger().info("GlowPlugin wurde deaktiviert.");
    }
}
