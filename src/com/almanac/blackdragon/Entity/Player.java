package com.almanac.blackdragon.Entity;

import java.awt.Color;

import com.almanac.blackdragon.World.World;

public class Player extends Creature {
	
	public Player(World world, String name, char glyph, int level, int currentHealth, Color color) {
		super(world, name, glyph, level, currentHealth, color);
	}

}
