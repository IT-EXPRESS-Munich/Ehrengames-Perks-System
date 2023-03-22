package tech.itexpress.perkssystem;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.perkssystem.gui.PerksGUI;
import tech.itexpress.perkssystem.perks.Glow;
import tech.itexpress.perkssystem.perks.Perks;

public class Loader extends JavaPlugin {

    public static Loader INSTANCE;

    private PerksGUI perkGUI;

    @Override
    public void onEnable() {
        INSTANCE = this;

        perkGUI = new PerksGUI();

        // EVENT REGISTER (LISTENER)
        Bukkit.getPluginManager().registerEvents(new PerksGUI(), this);

        // COMMAND REGISTER (GLOW, PERKS)
        this.getCommand("perks").setExecutor(new Perks());
        this.getCommand("glow").setExecutor(new Glow());

        // START MESSAGE
        getLogger().info("Perks wurden geladen.");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("Perks wurden deaktiviert.");
        super.onDisable();
    }
}
