package tech.itexpress.perks;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.perks.GUI.PerksGUI;

public class loader extends JavaPlugin {

    private PerksGUI perkGUI;

    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        perkGUI = new PerksGUI();
        pluginManager.registerEvents(perkGUI, this);
        this.getCommand("perks").setExecutor((CommandExecutor) perkGUI);
        // Registrieren des Commands
        getLogger().info("Perks wurden geladen.");
    }

    public void onDisable() {
        getLogger().info("Perks wurden deaktiviert.");
    }
}
