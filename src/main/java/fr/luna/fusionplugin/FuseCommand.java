package fr.luna.fusionplugin;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FuseCommand implements CommandExecutor {

    ArrayList<ItemStack> items = FusionPlugin.items;
    HashMap<ItemStack[],ItemStack> crafts = FusionPlugin.crafts;

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String str, String[] args) {
        Player p = (Player) s;
        ItemStack firstHand = p.getInventory().getItemInMainHand();
        ItemStack secondHand = p.getInventory().getItemInOffHand();
        ItemStack[] comb = {firstHand,secondHand};
        ItemStack[] comb2 = {secondHand,firstHand};

        if(firstHand.getType() != Material.AIR && secondHand.getType() != Material.AIR) {
            for (Map.Entry<ItemStack[], ItemStack> set : crafts.entrySet()) {
                if (Arrays.equals(set.getKey(), comb) || Arrays.equals(set.getKey(), comb2)) {
                    firstHand.setAmount(0);
                    secondHand.setAmount(0);
                    p.getInventory().addItem(set.getValue());
                    p.spawnParticle(Particle.FIREWORKS_SPARK,p.getLocation(),50);
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 4.5f,1.0f);
                    p.sendMessage(ChatColor.GOLD + "You successfully created : " + set.getValue().getItemMeta().getDisplayName() + " !");
                    break;
                } else {
                    p.sendMessage(ChatColor.RED +"These materials can't be fused !");
                    return false;
                }
            }
        } else {
            p.sendMessage("Please hold the materials in your two hands");
            return false;
        }
        return false;
    }
}
