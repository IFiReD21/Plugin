package fr.luna.fusionplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class AdGiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String str, String[] args) {

        Player p = (Player) s;
        ArrayList<ItemStack> items = FusionPlugin.items;

        System.out.println(args[0]);

        int id = Integer.parseInt(args[0].toString());

        p.getInventory().addItem(items.get(id));
        return false;
    }
}
