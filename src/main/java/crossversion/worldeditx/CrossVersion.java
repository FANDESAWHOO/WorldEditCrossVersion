package crossversion.worldeditx;

import org.mineacademy.fo.plugin.SimplePlugin;

import crossversion.worldeditx.util.WorldEditAPIManager;
import lombok.Getter;

public class CrossVersion extends SimplePlugin {
	@Getter  public WorldEditAPIManager worldEditManager;
    
	@Override
	protected void onPluginStart() {
    worldEditManager = new WorldEditAPIManager();
    worldEditManager.init();
		
	}
	
	public static CrossVersion getInstance() {
		return (CrossVersion) SimplePlugin.getInstance();
	}

}
