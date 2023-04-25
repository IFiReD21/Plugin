package fr.luna.fusionplugin.Commands;

import fr.luna.fusionplugin.Enum.StatsEnum;
import fr.luna.fusionplugin.Player.PlayerStats;
import fr.luna.fusionplugin.Player.PlayerUtility;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StatsCommand implements CommandExecutor {

    Inventory inv = Bukkit.createInventory(null,27, ChatColor.GOLD + "Vos Statistiques");
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String str, String[] args) {

        Player p = (Player) s;

        setStatsInventory(inv,p);

        return false;
    }

    // TODO : FACTORISER;
    public void setStatsInventory(Inventory inv,Player p){
        ItemStack str = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack hp = new ItemStack(Material.APPLE);
        ItemStack speed = new ItemStack(Material.SUGAR);
        ItemStack res = new ItemStack(Material.SHIELD);

        str.getItemMeta().setDisplayName("Force");
        hp.getItemMeta().setDisplayName("Vie");
        speed.getItemMeta().setDisplayName("Vitesse");
        res.getItemMeta().setDisplayName("Resistance");

        ItemMeta strm = str.getItemMeta();
        ItemMeta hpm = hp.getItemMeta();
        ItemMeta speedm = speed.getItemMeta();
        ItemMeta resm = res.getItemMeta();

        strm.setLore(Collections.singletonList("Level :" + PlayerUtility.getPlayerStats(p).getStrength()));
        hpm.setLore(Collections.singletonList("Level :" + PlayerUtility.getPlayerStats(p).getHealth()));
        speedm.setLore(Collections.singletonList("Level :" + PlayerUtility.getPlayerStats(p).getSpeed()));
        resm.setLore(Collections.singletonList("Level :" + PlayerUtility.getPlayerStats(p).getResistance()));

        str.setItemMeta(strm);
        hp.setItemMeta(hpm);
        speed.setItemMeta(speedm);
        res.setItemMeta(resm);

        List<ItemStack> item = new ArrayList<>();

        item.add(str);
        item.add(hp);
        item.add(speed);
        item.add(res);

        int index = 10;

        for (ItemStack i : item){
            inv.setItem(index,i);
            index = index+2;
        }

        p.openInventory(inv);

    }
}
