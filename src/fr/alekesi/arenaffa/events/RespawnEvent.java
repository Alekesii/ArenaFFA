package fr.alekesi.arenaffa.events;

import fr.alekesi.arenaffa.FastBoard;
import fr.alekesi.arenaffa.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RespawnEvent implements Listener {
    @EventHandler
    public void PlayerRespawn(PlayerRespawnEvent event)    {
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.RED + "Arena FFA");

        board.updateLines(
                "",
                "> Pseudo: "+ "§l§f"+ player.getDisplayName(),
                "",
                "> Joueurs: " + ChatColor.BOLD+ Bukkit.getServer().getOnlinePlayers().size(),
                "",
                "> Kills: " + ChatColor.BOLD + board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                "",
                "credits : " +ChatColor.BLUE + "§lalekesi"
        );
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        Location loc = new Location(player.getWorld(), 0 ,202, 0, 0 ,0);
        ItemBuilder startItem = new ItemBuilder(Material.IRON_AXE, 1).setName("§e§lArena").setLore("§8rejoindre l'arena");
        player.getInventory().setItem(0,startItem.toItemStack());
        event.setRespawnLocation(loc);

    }
}

