package me.daddychurchill.MyWorld.Worlds;

import me.daddychurchill.MyWorld.CoreGenerator;
import me.daddychurchill.MyWorld.Initializers.FlatTerrainInitializer;
import me.daddychurchill.MyWorld.Populators.SingleTreePopulator;

public class TreesOnlyWorld extends AbstractedWorld {

	public TreesOnlyWorld() {
		super();
	}

	@Override
	public void initializeGenerator(CoreGenerator generator) {

		generator.addInitializer(new FlatTerrainInitializer());
		
		generator.addPopulator(new SingleTreePopulator());
	}

}