package me.daddychurchill.XWorld.Populators;
import me.daddychurchill.XWorld.Blocks.AbstractedChunk;
import me.daddychurchill.XWorld.Blocks.FinalizeChunk;
import me.daddychurchill.XWorld.Generators.AbstractedPopulator;
import me.daddychurchill.XWorld.Generators.CoreGenerator;
import me.daddychurchill.XWorld.Support.Odds;
import me.daddychurchill.XWorld.Things.RealMaterial;

public class BushPopulator extends AbstractedPopulator {

	public BushPopulator(CoreGenerator generator) {
		super(generator);
	}

	@Override
	public void renderHere(FinalizeChunk chunk) {
		int y1 = chunk.getGenerator().getConfig().getStreetLevel();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				if (chunk.getOdds().rollDiceFor(0) && chunk.isEmpty(x, y1, z))
					chunk.setBlock(x, y1, z, RealMaterial.TALL_GRASS);
			}
		}
	}

	@Override
	public boolean isHere(AbstractedChunk chunk) {
		return chunk.getOdds().playOdds(Odds.oddsEnormouslyLikely);
	}

}