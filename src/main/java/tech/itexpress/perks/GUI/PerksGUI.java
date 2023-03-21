package tech.itexpress.perks.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PerksGUI implements Listener {

    private static Inventory inventory;

    public static void openInventory(Player player) {
        if (inventory == null) {
            inventory = Bukkit.createInventory(null, 9, "Perks");
            ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName("Schwerter");
            List<String> lore1 = new ArrayList<>();
            lore1.add("Erhöht den Schaden mit Schwerten um 50%");
            meta1.setLore(lore1);
            item1.setItemMeta(meta1);

            ItemStack item2 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName("Rüstungen");
            List<String> lore2 = new ArrayList<>();
            lore2.add("Verringert den erlittenen Schaden um 25%");
            meta2.setLore(lore2);
            item2.setItemMeta(meta2);

            inventory.setItem(3, item1);
            inventory.setItem(5, item2);
        }
        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(inventory)) {
            if (event.getCurrentItem() != null) {
                ItemStack item = event.getCurrentItem();
                if (item.getType().equals(Material.DIAMOND_SWORD)) {
                    // Handle the sword perk
                    event.getWhoClicked().sendMessage("Sword perk activated!");
                    event.setCancelled(true);
                } else if (item.getType().equals(Material.DIAMOND_HELMET)) {
                    // Handle the armor perk
                    event.getWhoClicked().sendMessage("Armor perk activated!");
                    event.setCancelled(true);
                }
            }
        }
    }
}
