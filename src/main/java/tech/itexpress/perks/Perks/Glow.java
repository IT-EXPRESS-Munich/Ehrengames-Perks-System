package tech.itexpress.perks.Perks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Glow extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin aktivieren
    }

    public void onDisable() {
        // Plugin deaktivieren
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("glow")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setGlowing(true);
                player.sendMessage(ChatColor.GREEN + "Du leuchtest jetzt!");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Dieser Befehl kann nur von einem Spieler ausgeführt werden!");
                return false;
            }
        }
        return false;
    }
}
