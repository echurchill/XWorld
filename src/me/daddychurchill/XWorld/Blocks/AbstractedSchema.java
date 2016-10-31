package me.daddychurchill.XWorld.Blocks;

import org.bukkit.block.Biome;

import me.daddychurchill.XWorld.Generators.CoreGenerator;
import me.daddychurchill.XWorld.Support.Odds;

public abstract class AbstractedSchema extends AbstractedBlocks {
	
	private Odds odds;
	
	public AbstractedSchema(CoreGenerator generator) {
		super(generator);
		
		odds = new Odds();
	}
	
	@Override
	public Odds getOdds() {
		return odds;
	}
	
	@Override
	public Biome getBiome(int x, int z) {
		assert(false);
		return null;
	}
	
	@Override
	public void setBiome(int x, int z, Biome biome) {
		assert(false);
	}

	@Override
	public void setBiome(Biome biome) {
		assert(false);
	}
	
}
