package fr.alekesi.arenaffa;

import fr.alekesi.arenaffa.events.FallDamageEvent;
import fr.alekesi.arenaffa.events.JoinEvent;
import fr.alekesi.arenaffa.manager.Register;
import fr.alekesi.arenaffa.utils.Biomes;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class main extends JavaPlugin {
    private static main instance;
    private final Map<UUID, FastBoard> boards = new HashMap<>();



    private void updateBoard(FastBoard board) {
        board.updateLines(
                "",
                "Players: " + getServer().getOnlinePlayers().size(),
                "",
                "Kills: " + board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                ""
        );
    }
    @Override
    public void onEnable() {
        Bukkit.dispatchCommand( Bukkit. getConsoleSender ( ) , "fill -10 200 10 10 200 -10 barrier");
        instance = this;
        Biomes.init();
        Register.RegisterAll();
        System.out.println("Arena FFA operationnel");

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0,0);
        wb.setSize(100);



    }


    public static main getInstance() {
        return instance;
    }
    @Override
    public void onDisable() {
        System.out.println("Arena FFA non operationnel");
    }
}
