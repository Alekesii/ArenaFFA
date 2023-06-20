package fr.alekesi.arenaffa.events;

import fr.alekesi.arenaffa.FastBoard;
import fr.alekesi.arenaffa.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player= e.getPlayer();
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
        Player p = e.getPlayer();
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        e.setJoinMessage(ChatColor.BLUE + p.getDisplayName() + " a rejoint l'arène");
        Location loc = new Location(p.getWorld(), 0 ,202, 0, 0 ,0);
        p.teleport(loc);
        ItemBuilder startItem = new ItemBuilder(Material.IRON_AXE, 1).setName("§e§lArena").setLore("§8rejoindre l'arena");

        player.getInventory().addItem(startItem.toItemStack());
    }
}
