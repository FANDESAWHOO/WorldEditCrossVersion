package crossversion.worldeditx.util;

import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;
import org.mineacademy.fo.MinecraftVersion;

import crossversion.worldeditx.implementation.NewGeneration;
import crossversion.worldeditx.implementation.OldGeneration;
import crossversion.worldeditx.model.WorldEditAPI;


public class WorldEditAPIManager {
	
    private WorldEditAPI api;
    
	public void init() {
		if(MinecraftVersion.newerThan(MinecraftVersion.V.v1_13)) {
			api = new NewGeneration();
		} else {
			api = new OldGeneration();
		}
	}
	
    public Cuboid getSelection(Player player) {
    	return api.getSelection(player);
    }
	
}
