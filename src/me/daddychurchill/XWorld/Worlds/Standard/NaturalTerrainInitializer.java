package me.daddychurchill.XWorld.Worlds.Standard;

import org.bukkit.block.Biome;
import org.bukkit.material.MaterialData;
import me.daddychurchill.XWorld.Blocks.InitializeChunk;
import me.daddychurchill.XWorld.Generators.AbstractInitializer;
import me.daddychurchill.XWorld.Things.RealMaterial;
import me.daddychurchill.XWorld.Worlds.AbstractWorld;
import me.daddychurchill.XWorld.Worlds.Shapes.AbstractedShape;

public class NaturalTerrainInitializer extends AbstractInitializer {

	//protected int specialBlockOdds; // 1/n chance that there is minerals on this level
	//protected int specialsPerLayer; // number of minerals per layer
	//protected int flowerOdds = 6; // 1/n chance that there is a flower on the grass, if there isn't a tree else make some tall grass
	//protected TreeType treeType;
	//protected int treesPerChunk;
	
	protected MaterialData materialStone; // what is the stone made of?
	protected MaterialData materialTopsoil; // what is dirt made of?
	protected MaterialData materialSurface; // what is grass made of?
	protected MaterialData materialLiquidBase; // what is sand made of?
	protected MaterialData materialLiquid; // what is the liquid made of?
	//protected MaterialData materialBlades; // what is a blade of grass made of?
	//protected MaterialData materialFlower; // what is a flower made of?
	
	//protected MaterialData materialMineral; // for later use in the populator
	//protected MaterialData materialFertile;
	//protected int airId; 
	protected AbstractedShape worldShape;
	
	public NaturalTerrainInitializer(AbstractedShape shape) {
		worldShape = shape;
		
		materialStone = RealMaterial.STONE;
		materialTopsoil = RealMaterial.DIRT;
		materialSurface = RealMaterial.GRASS;
		materialLiquidBase = RealMaterial.SAND;
		materialLiquid = RealMaterial.WATER_STATIONARY;
		//materialBlades = RealMaterial.TALL_GRASS;
		//materialFlower = odds.nextBoolean() ? RealMaterial.FLOWER_POPPY : RealMaterial.FLOWER_DANDELION;
		
		//materialMineral = materialBottom;
		//materialFertile = materialTop;
	}

	@Override
	public void renderHere(AbstractWorld world, InitializeChunk chunk) {
		int topsoilThickness = worldShape.getMiddleThickness();
		int seaLevel = worldShape.getSeaLevel();
		
		for (int x = 0; x < 16; x++)
			for (int z = 0; z < 16; z++)
				renderHere(world, chunk, x, world.getSurfaceY(chunk, x, z), z, topsoilThickness, seaLevel);
	}
	
	protected void renderHere(AbstractWorld world, InitializeChunk chunk, int x, int y, int z, int topsoilThickness, int seaLevel) {
		if (y > 0) {
			chunk.setBlock(x, 0, y, RealMaterial.BEDROCK);
			if (topsoilThickness > 0) {
				chunk.setBlocks(x, 1, Math.max(1, y - topsoilThickness), z, materialStone);
				chunk.setBlocks(x, Math.max(1, y - topsoilThickness), y - 1, z, materialTopsoil);
			} else {
				chunk.setBlocks(x, 1, y, z, materialStone);
			}
			
			if (y - 1 < seaLevel) {
				chunk.setBlock(x, y - 1, z, materialLiquidBase);
				chunk.setBlocks(x, y, seaLevel, z, materialLiquid);
			} else if (topsoilThickness > 0)
				chunk.setBlock(x, y - 1, z, materialSurface);
		} else
			chunk.setBiome(x, z, Biome.VOID);
	}

	@Override
	public boolean isHere(AbstractWorld world, InitializeChunk chunk) {
		return true;
	}
}
