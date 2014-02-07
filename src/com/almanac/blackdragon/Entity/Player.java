package com.almanac.blackdragon.Entity;

import com.almanac.blackdragon.World.World;

public class Player extends Creature {
	
	public Player(World world, String name, char glyph, int level, int currentHealth) {
		super(world, name, glyph, level, currentHealth);
	}

}
