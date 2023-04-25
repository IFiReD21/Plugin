package fr.luna.fusionplugin.Enum;

import com.sun.tools.javac.jvm.Items;
import fr.luna.fusionplugin.FusionPlugin;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;



public enum CraftEnum {

    // ALL THE CRAFTING RECIPES ARE HERE :
    // ID LIST :
    // 0 MERCURY
    // 1 SATURN
    // 2 MERCURITE
    // 3 SATURNITE

    MERCURY(FusionPlugin.items.get(1),FusionPlugin.items.get(2),FusionPlugin.items.get(0)),
    SATURN(FusionPlugin.items.get(3),new ItemStack(Material.DIAMOND_SWORD),FusionPlugin.items.get(1));


    private final ItemStack fmat;
    private final ItemStack smat;
    private final ItemStack result;

    CraftEnum(ItemStack fmat, ItemStack smat, ItemStack result) {
        this.fmat = fmat;
        this.smat = smat;
        this.result = result;

    }

    public ItemStack getFmat() { return fmat; }
    public ItemStack getSmat() { return smat; }
    public ItemStack getResult() { return result; }

    public ItemStack[] getMatList() {

        return new ItemStack[]{fmat,smat};
    }
}
