package tech.itexpress.perks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Ehrengames_Perks extends JavaPlugin implements Listener, CommandExecutor {

    private List<Perk> perks = new ArrayList<>();
    private Map<String, PerkAction> perkActions = new HashMap<>();

    @Override
    public void onEnable() {
        // Register perks
        perks.add(new Perk("Double XP", "Verdoppelt die XP, die du verdienst.", 2, "ehrengames.perks.doublexp"));
        perks.add(new Perk("Schnelleres Laufen", "Erhöht deine Laufgeschwindigkeit um 25%.", 1, "ehrengames.perks.speed"));
        perks.add(new Perk("Fly", "Erlaubt dem Spieler, zu fliegen.", null, "ehrengames.perks.fly"));
        perks.add(new Perk("Glow", "Der Spieler bekommt eine leuchtende Umrandung.", null, "ehrengames.perks.glow"));
        perks.add(new Perk("Speed", "Erhöht die Laufgeschwindigkeit des Spielers.", null, "ehrengames.perks.speed"));
        perks.add(new Perk("Fastbreak", "Erhöht die Abbau-Geschwindigkeit von Blöcken.", null, "ehrengames.perks.fastbreak"));
        perks.add(new Perk("Nofall", "Verhindert Schaden durch Fallschäden.", null, "ehrengames.perks.nofall"));
        perks.add(new Perk("Nohunger", "Spieler hat keinen Hunger mehr.", null, "ehrengames.perks.nohunger"));

        // Register perk actions
        perkActions.put("ehrengames.perks.doublexp", new DoubleXPPerkAction());
        perkActions.put("ehrengames.perks.speed", new SpeedPerkAction());
        perkActions.put("ehrengames.perks.fly", new FlyPerkAction());
        perkActions.put("ehrengames.perks.glow", new GlowPerkAction());
        perkActions.put("ehrengames.perks.fastbreak", new FastBreakPerkAction());
        perkActions.put("ehrengames.perks.nofall", new NoFallPerkAction());
        perkActions.put("ehrengames.perks.nohunger", new NoHungerPerkAction());

        // Register events and commands
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("perks").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("perks")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von Spielern ausgeführt werden.");
            return true;
        }

        Player player = (Player) sender;
        Inventory menu = Bukkit.createInventory(null, 9, "Perks");

        for (Perk perk : perks) {
            if (player.hasPermission(perk.getPermission())) {
                ItemStack item = new ItemStack(perk.getMaterial());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(perk.getName());
                List<String> lore = new ArrayList<>();
                lore.add(perk.getDescription());
                if (perk.getValue() != null) {
                    lore.add("Wert: " + perk.getValue());
                }
                meta.setLore(lore);
                item.setItemMeta(meta);
                menu.addItem(item);
            }
        }

        player.openInventory(menu);
        return true;
