package fr.luna.fusionplugin;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import fr.luna.fusionplugin.StatsEnum;

import java.io.File;
import java.io.IOException;

public class EventListenerClass implements Listener {

    @EventHandler
    public void OnClickInventory(InventoryClickEvent e){

        PlayerStats ps = new PlayerStats();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Vos Statistiques")){
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§4Strength":
                    ps.setStrength(ps.getStrength()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta force !");
                    e.getWhoClicked().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(ps.getStrength() + 1);
                    ps.updateStats((Player) e.getWhoClicked());
                    return;

                case "§4Health":
                    ps.setHealth(ps.getHealth()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta vie !");
                    e.getWhoClicked().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(ps.getHealth() + 1);
                    ps.updateStats((Player) e.getWhoClicked());
                    return;

                case "§4Speed":
                    ps.setSpeed(ps.getSpeed()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta vitesse !");
                    e.getWhoClicked().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(ps.getSpeed() + 1);
                    ps.updateStats((Player) e.getWhoClicked());
                    return;

                case "§4Resistance":
                    ps.setResistance(ps.getResistance()+1);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Tu viens d'augmenter ta resistance !");
                    e.getWhoClicked().getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(ps.getResistance() + 1);
                    ps.updateStats((Player) e.getWhoClicked());
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
            ps.setHealth(cfg.getDouble("stats.health"));
            ps.setSpeed(cfg.getDouble("stats.speed"));
            ps.setResistance(cfg.getDouble("stats.resistance"));
            ps.setStrength(cfg.getDouble("stats.strength"));
        }else{
            ps.setHealth(20.0D);
            ps.setStrength(2.0D);
            ps.setSpeed(0.7D);
            ps.setResistance(0D);

        }

        PlayerUtility.setPlayerStats(e.getPlayer(),ps);

    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){

        PlayerStats ps = new PlayerStats();
        File f = new File(PlayerUtility.getFolderPath(e.getPlayer()) + "/stats.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
        cfg.set("stats.health", ps.getHealth());
        cfg.set("stats.speed", ps.getSpeed());
        cfg.set("stats.resistance", ps.getResistance());
        cfg.set("stats.strength", ps.getStrength());

        try {
            cfg.save(f);
        } catch (IOException exce){
            exce.printStackTrace();
        }

        PlayerUtility.setPlayerStats(e.getPlayer(),null);

    }
}
