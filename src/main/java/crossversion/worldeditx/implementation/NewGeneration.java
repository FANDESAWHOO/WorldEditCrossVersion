package crossversion.worldeditx.implementation;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;

import crossversion.worldeditx.model.WorldEditAPI;

public class NewGeneration implements WorldEditAPI {

    @Override
    public Cuboid getSelection(Player player) {
        try {
            // Cargar la clase WorldEdit
            Class<?> weClass = Class.forName("com.sk89q.worldedit.WorldEdit");
            Object worldEdit = weClass.getMethod("getInstance").invoke(null);

            // SessionManager
            Object sessionManager = weClass.getMethod("getSessionManager").invoke(worldEdit);

            // get(Player) → LocalSession
            Method getSession = sessionManager.getClass().getMethod("get", Class.forName("com.sk89q.worldedit.session.SessionOwner"));
            Object localSession = getSession.invoke(sessionManager, player);

            if (localSession == null) return null;

            // LocalSession#getSelection() → Region
            Method getSelection = localSession.getClass().getMethod("getSelection");
            Object region = getSelection.invoke(localSession);

            if (region == null) return null;

            // Region#getMinimumPoint() y getMaximumPoint() → BlockVector3
            Method getMin = region.getClass().getMethod("getMinimumPoint");
            Method getMax = region.getClass().getMethod("getMaximumPoint");

            Object minVec = getMin.invoke(region);
            Object maxVec = getMax.invoke(region);

            // BlockVector3#getBlockX/Y/Z
            Class<?> vecClass = Class.forName("com.sk89q.worldedit.math.BlockVector3");
            Method getX = vecClass.getMethod("getBlockX");
            Method getY = vecClass.getMethod("getBlockY");
            Method getZ = vecClass.getMethod("getBlockZ");

            Location min = new Location(player.getWorld(),
                    (int) getX.invoke(minVec),
                    (int) getY.invoke(minVec),
                    (int) getZ.invoke(minVec));

            Location max = new Location(player.getWorld(),
                    (int) getX.invoke(maxVec),
                    (int) getY.invoke(maxVec),
                    (int) getZ.invoke(maxVec));

            return new Cuboid(min, max);

        } catch (Throwable t) {
            Bukkit.getLogger().warning("[WorldEditX] Error usando NewGeneration: " + t.getMessage());
            return null;
        }
    }
}
