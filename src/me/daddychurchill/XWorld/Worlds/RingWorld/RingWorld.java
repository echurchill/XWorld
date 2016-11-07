package me.daddychurchill.XWorld.Worlds.RingWorld;

import me.daddychurchill.XWorld.Generators.CoreGenerator;
import me.daddychurchill.XWorld.Worlds.ShapedWorld;
import me.daddychurchill.XWorld.Worlds.Standard.GrassPopulator;
import me.daddychurchill.XWorld.Worlds.Standard.NaturalTerrainInitializer;
import me.daddychurchill.XWorld.Worlds.Standard.SingleTreePopulator;

public class RingWorld extends ShapedWorld {

	public RingWorld(CoreGenerator generator) {
		super(generator, new RingWorldShape(generator, 400, 192));
		
		initializers.add(new NaturalTerrainInitializer(getWorldShape()));
		
		populators.add(new SingleTreePopulator());
		populators.add(new GrassPopulator());
	}
}