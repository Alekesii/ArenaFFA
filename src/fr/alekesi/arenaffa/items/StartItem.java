package fr.alekesi.arenaffa.items;

import fr.alekesi.arenaffa.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartItem implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it != null && it.getItemMeta().getDisplayName() == "§e§lArena") {
            player.setGameMode(GameMode.SURVIVAL);
            Random randomX = new Random();
            int nbX;
            nbX = randomX.nextInt(49);
            Random randomZ = new Random();
            int nbZ;
            nbZ = randomZ.nextInt(49);
            Location rtp = new Location(player.getWorld(),nbX, 100,nbZ, 0, 0);
            player.teleport(rtp);
            player.getInventory().clear();
            ItemBuilder cobbleBlock = new ItemBuilder(Material.COBBLESTONE, 64);
            ItemBuilder swordArena = new ItemBuilder(Material.DIAMOND_SWORD, 1).addEnchant(Enchantment.DAMAGE_ALL, 3 );
            ItemBuilder helmetArena = new ItemBuilder(Material.DIAMOND_HELMET, 1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2 );
            ItemBuilder chestplateArena = new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2 );
            ItemBuilder leggingsArena = new ItemBuilder(Material.IRON_LEGGINGS, 1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3 );
            ItemBuilder bootsArena = new ItemBuilder(Material.DIAMOND_BOOTS, 1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2 );
            ItemBuilder lavaBucket = new ItemBuilder(Material.LAVA_BUCKET, 1);
            ItemBuilder waterBucket = new ItemBuilder(Material.WATER_BUCKET, 1);
            List<Integer> lBucketsList = Arrays.asList(3,30,21,12);
            for (Integer lbucket : lBucketsList) {
                player.getInventory().setItem(lbucket, lavaBucket.toItemStack());
            }
            List<Integer> wBucketsList = Arrays.asList(8,17,26,35);
            for (Integer wbucket : wBucketsList) {
                player.getInventory().setItem(wbucket, waterBucket.toItemStack());
            }
            List<Integer> CobbelList = Arrays.asList(1,9,10,11,18,19,20,27,28,29);
            for (Integer cobble : CobbelList) {
                player.getInventory().setItem(cobble, cobbleBlock.toItemStack());
            }
            player.getInventory().setItem(0,swordArena.toItemStack());
            player.getInventory().setItem(39,helmetArena.toItemStack());
            player.getInventory().setItem(38,chestplateArena.toItemStack());
            player.getInventory().setItem(37,leggingsArena.toItemStack());
            player.getInventory().setItem(36,bootsArena.toItemStack());




        }
    }
}
