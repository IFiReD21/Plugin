package fr.luna.fusionplugin;

import org.bukkit.Material;

public enum StatsEnum {

    STRENGTH("§4Strength",Material.DIAMOND_SWORD,"Level : " + " 0"),
    HEALTH("§4Health",Material.GOLDEN_APPLE,"Level : " + " 0"),
    SPEED("§4Speed",Material.SUGAR,"Level : " + " 0"),
    RESISTANCE("§4Resistance",Material.SHIELD,"Level : " + " 0");


    private final String name;
    private final Material mat;
    private final String lore;

    StatsEnum(String name, Material mat, String lore) {

        this.name = name;
        this.mat = mat;
        this.lore = lore;
    }

    public String getName(){ return name; }
    public Material getMat(){ return mat; }
    public String getLore(){ return lore; }

}
