package com.almanac.blackdragon.World;

import java.awt.Color;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.FungusAI;
import com.almanac.blackdragon.Entity.PlayerAI;

public class CreatureMaker {

	private World world;
	
	public CreatureMaker(World world) {
		this.world = world;
	}
	
	public Creature newPlayer() {
		Creature player = new Creature(world, "Player", '@', 1, 10, Color.white);
		world.addAtEmptyLocation(player);
		new PlayerAI(player);
		return player;
	}
	
	public Creature newFungus() {
		Creature fungus = new Creature(world, "Fungus", 'F', 1, 5, AsciiPanel.magenta);
		world.addAtEmptyLocation(fungus);
		new FungusAI(fungus, this);
		return fungus;
	}
}
