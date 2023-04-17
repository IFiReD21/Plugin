package fr.luna.fusionplugin;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StatsManager {

    static double bstrength = 2.0f;
    static double bhealth = 20.0f;
    static double bspeed = 0.7f;
    static double bres = 0.0f;

    static HashMap<UUID, double[]> stats = new HashMap<>();

    static public double[] getStats(UUID uuid){
        double strength = Bukkit.getPlayer(uuid).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
        double health = Bukkit.getPlayer(uuid).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double speed = Bukkit.getPlayer(uuid).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();
        double resistance = Bukkit.getPlayer(uuid).getAttribute(Attribute.GENERIC_ARMOR).getValue();

        double[] stats = {strength,health,speed,resistance};

        return stats;
    }
}
