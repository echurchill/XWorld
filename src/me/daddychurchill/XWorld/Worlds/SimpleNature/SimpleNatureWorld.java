package me.daddychurchill.XWorld.Worlds.SimpleNature;

import me.daddychurchill.XWorld.Generators.CoreGenerator;
import me.daddychurchill.XWorld.Worlds.ShapedWorld;
import me.daddychurchill.XWorld.Worlds.Shapes.NaturalGroundShape;
import me.daddychurchill.XWorld.Worlds.Standard.GrassPopulator;
import me.daddychurchill.XWorld.Worlds.Standard.NaturalTerrainInitializer;
import me.daddychurchill.XWorld.Worlds.Standard.SingleTreePopulator;

public class SimpleNatureWorld extends ShapedWorld {
	
	public SimpleNatureWorld(CoreGenerator generator) {
		super(generator, new NaturalGroundShape(generator));
		
		initializers.add(new NaturalTerrainInitializer(getWorldShape()));
		
		populators.add(new SingleTreePopulator());
		populators.add(new GrassPopulator());
	}
}