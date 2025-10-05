package crossversion.worldeditx;

import org.mineacademy.fo.plugin.SimplePlugin;

import crossversion.worldeditx.util.WorldEditAPIManager;
import lombok.Getter;
@Getter
public class CrossVersion extends SimplePlugin {
    private WorldEditAPIManager worldEditManager;
    
	@Override
	protected void onPluginStart() {
    worldEditManager = new WorldEditAPIManager();
		
	}

}
