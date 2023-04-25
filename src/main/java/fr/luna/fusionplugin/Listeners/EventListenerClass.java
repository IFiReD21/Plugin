package fr.luna.fusionplugin.Listeners;

import fr.luna.fusionplugin.Player.PlayerStats;
import fr.luna.fusionplugin.Player.PlayerUtility;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class EventListenerClass implements Listener {

    //TODO : NEED TO UPDATE INVENTORY
    @EventHandler
    public void OnClickInventory(InventoryClickEvent e){

        PlayerStats ps = PlayerUtility.getPlayerStats((Player) e.getWhoClicked());

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Vos Statistiques") && e.getCurrentItem() != null){
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§4Strength":
                    ps.setStrengthlvl(ps.getStrengthlvl()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta force !");
                    System.out.println(ps.getStrengthlvl() + "STR" + "" + ps.getSpeedlvl() + "SPE" +  "" + ps.getArmorlvl() + "RES");
                    ps.updateStats((Player) e.getWhoClicked(),PlayerUtility.getPlayerStats((Player) e.getWhoClicked()));
                    return;

                case "§4Health":
                    ps.setHealthlvl(ps.getHealthlvl()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta vie !");
                    ps.updateStats((Player) e.getWhoClicked(),PlayerUtility.getPlayerStats((Player) e.getWhoClicked()));
                    return;

                case "§4Speed":
                    ps.setSpeedlvl((int) (ps.getSpeedlvl()+1));
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta vitesse !");
                    ps.updateStats((Player) e.getWhoClicked(),PlayerUtility.getPlayerStats((Player) e.getWhoClicked()));
                    return;

                case "§4Resistance":
                    ps.setArmorlvl(ps.getArmorlvl()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta resistance !");
                    ps.updateStats((Player) e.getWhoClicked(),PlayerUtility.getPlayerStats((Player) e.getWhoClicked()));
                    return;
                default: break;
            }
        }

    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){

        PlayerStats ps = new PlayerStats();
        File f = new File(PlayerUtility.getFolderPath(e.getPlayer()) + "/stats.yml");

        if(f.exists()){
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
            ps.setHealthlvl(cfg.getInt("stats.health"));
            ps.setSpeedlvl(cfg.getInt("stats.speed"));
            ps.setArmorlvl(cfg.getInt("stats.resistance"));
            ps.setStrengthlvl(cfg.getInt("stats.strength"));
        }else{
            ps.setHealthlvl(0);
            ps.setStrengthlvl(0);
            ps.setSpeedlvl(0);
            ps.setArmorlvl(0);

        }

        PlayerUtility.setPlayerStats(e.getPlayer(),ps);
        ps.updateStats(e.getPlayer(),ps);

    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){

        PlayerStats ps = PlayerUtility.getPlayerStats(e.getPlayer());
        File f = new File(PlayerUtility.getFolderPath(e.getPlayer()) + "/stats.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
        cfg.set("stats.health", ps.getHealthlvl());
        cfg.set("stats.speed", ps.getSpeedlvl());
        cfg.set("stats.resistance", ps.getArmorlvl());
        cfg.set("stats.strength", ps.getStrengthlvl());

        try {
            cfg.save(f);
        } catch (IOException exce){
            exce.printStackTrace();
        }

        PlayerUtility.setPlayerStats(e.getPlayer(),null);

    }
}
