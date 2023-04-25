package fr.luna.fusionplugin.Enum;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public enum ItemEnum {

    MERCURY(ChatColor.RED + "[ S ]", Material.NETHERITE_SWORD, ChatColor.DARK_BLUE + "Mercury"),
    SATURN(ChatColor.BLUE + "[ A ]", Material.DIAMOND_SWORD,ChatColor.YELLOW + "Saturn"),
    MERCURITE(ChatColor.BLUE + "[ A ]", Material.NETHERITE_INGOT,ChatColor.YELLOW + "Mercurite"),
    SATURNITE(ChatColor.GREEN + "[ B ]", Material.DIAMOND,ChatColor.GREEN + "Saturnite");


    private String rank;
    private Material mat;
    private String name;


    ItemEnum(String rank, Material mat,String name) {
        this.rank = rank;
        this.name = name;
        this.mat = mat;
    }

    public String getRank(){
        return rank;
    }

    public String getName(){
        return name;
    }
    public Material getMat(){
        return mat;
    }
}
