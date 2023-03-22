package tech.itexpress.perkssystem.perks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tech.itexpress.perkssystem.gui.PerksGUI;

public class Perks implements CommandExecutor {

    private PerksGUI perksGUI;

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
