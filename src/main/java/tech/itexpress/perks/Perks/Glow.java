package tech.itexpress.perks.Perks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Glow implements Listener {

    private static Glow instance;

    private Glow() {}

    public static Glow getInstance() {
        if (instance == null) {
            instance = new Glow();
        }
        return instance;
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
