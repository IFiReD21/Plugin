package fr.luna.fusionplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String str, String[] args) {

        Player p = (Player) s;

        createStatsInv(p);

        return false;
    }

    public void createStatsInv(Player p){

        Inventory inv = Bukkit.createInventory(p,27, ChatColor.GOLD + "Vos Statistiques");
        int index = 10;

        for(StatsEnum en : StatsEnum.values()){
            ItemStack is = new ItemStack(en.getMat());
            ItemMeta im = is.getItemMeta();

            im.setDisplayName(en.getName());
            im.setLore(Collections.singletonList(en.getLore()));

            is.setItemMeta(im);
            inv.setItem(index,is);
            index = index+2;
        }

        p.openInventory(inv);
    }
}
