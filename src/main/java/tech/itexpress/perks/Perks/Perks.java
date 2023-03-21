package tech.itexpress.perks.Perks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.perks.GUI.PerksGUI;

public class Perks extends JavaPlugin implements Listener, CommandExecutor {

    private static Perks instance;
    private PerksGUI perksGUI;

    private Perks() {}

    public static Perks getInstance() {
        if (instance == null) {
            instance = new Perks();
        }
        return instance;
    }

    public void onEnable() {
        // Plugin aktivieren
        perksGUI = new PerksGUI();
        getServer().getPluginManager().registerEvents(perksGUI, this);
        this.getCommand("perks").setExecutor(this);
    }

    public void onDisable() {
        // Plugin deaktivieren
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("perks")) {
            if (sender instanceof Player) {
                perksGUI.openInventory((Player) sender);
                return true;
            } else {
                sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
                return false;
            }
        }
        return false;
    }
}
