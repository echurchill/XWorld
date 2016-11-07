package me.daddychurchill.XWorld.Worlds.TreesAndSuch;

import me.daddychurchill.XWorld.Generators.CoreGenerator;
import me.daddychurchill.XWorld.Worlds.AbstractWorld;
import me.daddychurchill.XWorld.Worlds.AbstractedWorldFactory;

public class TreesAndSuchFactory extends AbstractedWorldFactory {

	public TreesAndSuchFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getStyle() {
		return "TreesAndSuch";
	}

	@Override
	public AbstractWorld getWorld(CoreGenerator generator) {
		return new TreesAndSuchWorld(generator);
	}

}
