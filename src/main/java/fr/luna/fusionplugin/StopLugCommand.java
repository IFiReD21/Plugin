package fr.luna.fusionplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class StopLugCommand implements CommandExecutor {

    Plugin pl = Bukkit.getPluginManager().getPlugin("FusionPlugin");
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String str, String[] args) {
        getServer().getPluginManager().disablePlugin(pl);

        s.sendMessage("Le plugin viens d'être désactivé");
        return false;
    }
}
