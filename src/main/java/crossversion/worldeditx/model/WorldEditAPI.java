package crossversion.worldeditx.model;

import org.bukkit.entity.Player;
import org.hcgames.hcfactions.util.cuboid.Cuboid;

public interface WorldEditAPI {
	
	Cuboid getSelection(Player player);

}
