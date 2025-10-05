package crossversion.worldeditx.implementation;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionOwner;

import crossversion.worldeditx.model.WorldEditAPI;

public class NewGeneration implements WorldEditAPI {

	@Override
	public Cuboid getSelection(Player player) {
		Cuboid region = null;
		LocalSession session = WorldEdit.getInstance().getSessionManager().get((SessionOwner) player);
		Region selection;
		try {
			selection = session.getSelection();
			region = new Cuboid(fromVectorToLocation(player, selection.getMinimumPoint()),fromVectorToLocation(player,selection.getMaximumPoint())); // CROSSVERSION 1.13+
		} catch (IncompleteRegionException e) {
			e.printStackTrace();
		}
		return region;
	}
	
	public Location fromVectorToLocation(Player player, BlockVector3 block) {
		Location location = new Location(player.getWorld(), block.getBlockX(), block.getBlockY(), block.getBlockZ());
		return location;
	}
}
