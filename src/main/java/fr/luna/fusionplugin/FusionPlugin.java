package fr.luna.fusionplugin;

import fr.luna.fusionplugin.Commands.*;
import fr.luna.fusionplugin.Enum.CraftEnum;
import fr.luna.fusionplugin.Enum.ItemEnum;
import fr.luna.fusionplugin.Listeners.EventListenerClass;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public final class FusionPlugin extends JavaPlugin implements Listener {

    public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    public static HashMap<ItemStack[], ItemStack> crafts = new HashMap<>();
    static HashMap<UUID, double[]> stats = new HashMap<>();

    @Override
    public void onEnable() {
        System.out.println("Plugin OK");
        itemsInitiate();
        craftInit();
        getCommand("fuse").setExecutor(new FuseCommand());
        getCommand("admingive").setExecutor(new AdGiveCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("stoplug").setExecutor(new StopLugCommand());
        getCommand("testcommand").setExecutor(new TestCommand());

        getServer().getPluginManager().registerEvents(new EventListenerClass(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void itemsInitiate(){
        for(ItemEnum i : ItemEnum.values()){
            ItemStack is = new ItemStack(i.getMat());
            ItemMeta im = is.getItemMeta();
            im.setDisplayName(i.getName());
            im.setLore(Arrays.asList(i.getRank()));


            is.setItemMeta(im);

            items.add(is);
            System.out.println(i.getName() + " as been initiated");
        }
    }

    public void craftInit(){
        for(CraftEnum c : CraftEnum.values()){
            crafts.put(c.getMatList(),c.getResult());
        }
    }
}
