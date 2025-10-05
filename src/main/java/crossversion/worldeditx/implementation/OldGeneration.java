package crossversion.worldeditx.implementation;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;

import crossversion.worldeditx.model.WorldEditAPI;

public class OldGeneration implements WorldEditAPI {

    @Override
    public Cuboid getSelection(Player player) {
        return fromSelectionToCuboid(player);
    }

    public Cuboid fromSelectionToCuboid(Player player) {
        try {
 
            Class<?> weClass = Class.forName("com.sk89q.worldedit.bukkit.WorldEditPlugin");
            Object we = Bukkit.getPluginManager().getPlugin("WorldEdit");

            if (!weClass.isInstance(we)) {
                return null; 
            }

            Method getSelection = weClass.getMethod("getSelection", Player.class);
            Object selection = getSelection.invoke(we, player);

            if (selection == null) {
                return null; 
            }
            
            Method getMin = selection.getClass().getMethod("getMinimumPoint");
            Method getMax = selection.getClass().getMethod("getMaximumPoint");

            Location min = (Location) getMin.invoke(selection);
            Location max = (Location) getMax.invoke(selection);

            return new Cuboid(min, max);

        } catch (Throwable ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
