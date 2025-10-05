package crossversion.worldeditx.implementation;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

import crossversion.worldeditx.model.WorldEditAPI;

public class OldGeneration implements WorldEditAPI {
    private final WorldEditPlugin plugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
    @Override
    public Cuboid getSelection(Player player) {
        return fromSelectionToCuboid(plugin.getSelection(player));
    }

    public Cuboid fromSelectionToCuboid(Selection selection) {
    	Cuboid cuboid = new Cuboid(selection.getMinimumPoint(), selection.getMaximumPoint());
    	return cuboid;
    }
}
