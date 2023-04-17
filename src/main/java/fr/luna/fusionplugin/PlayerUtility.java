package fr.luna.fusionplugin;import org.bukkit.entity.Player;import org.bukkit.inventory.ItemStack;import org.bukkit.Bukkit;import java.util.HashMap;import java.util.Map;import java.util.UUID;public class PlayerUtility {    private static Map<UUID, PlayerStats> playerstats = new HashMap<>();    public static PlayerStats getPlayerStats(Player p){        if(!playerstats.containsKey(p.getUniqueId())){            PlayerStats ps = new PlayerStats();            playerstats.put(p.getUniqueId(),ps);            return ps;        }        return playerstats.get(p.getUniqueId());    }    public static void setPlayerStats(Player p, PlayerStats ps){        if(ps == null) playerstats.remove(p.getUniqueId());        else playerstats.put(p.getUniqueId(),ps);    }    public static String getFolderPath(Player p){        return Bukkit.getPluginManager().getPlugin("FusionPlugin").getDataFolder().getAbsolutePath() + "/players/" + p.getUniqueId();    }}