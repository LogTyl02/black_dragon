package com.almanac.blackdragon.World;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.PlayerAI;

public class CreatureMaker {

	private World world;
	
	public CreatureMaker(World world) {
		this.world = world;
	}
	
	public Creature newPlayer() {
		Creature player = new Creature(world, "Player", '@', 1, 10);
		world.addAtEmptyLocation(player);
		new PlayerAI(player);
		return player;
	}
}
