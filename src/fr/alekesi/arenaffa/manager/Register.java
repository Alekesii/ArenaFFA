package fr.alekesi.arenaffa.manager;

import fr.alekesi.arenaffa.events.FallDamageEvent;
import fr.alekesi.arenaffa.events.JoinEvent;
import fr.alekesi.arenaffa.items.StartItem;
import fr.alekesi.arenaffa.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Register {

        private static void RegisterListener(Listener L, JavaPlugin J){
            J.getServer().getPluginManager().registerEvents(L,J);

        }
        public static void RegisterAll(){
            RegisterListener(new JoinEvent(), main.getInstance());
            RegisterListener(new FallDamageEvent(), main.getInstance());
            RegisterListener(new StartItem(), main.getInstance());

        }
    }


