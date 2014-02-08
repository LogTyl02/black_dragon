package com.almanac.blackdragon.World;

import java.awt.Color;
import java.util.List;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.FungusAI;
import com.almanac.blackdragon.Entity.PlayerAI;

public class CreatureMaker {

	private World world;
	
	public CreatureMaker(World world) {
		this.world = world;
	}
	
	public Creature newPlayer(List<String> messages) {
		Creature player = new Creature(world, "Player", '@', 1, 100, 12, 5, Color.white);
		world.addAtEmptyLocation(player, 0);
		new PlayerAI(player, messages);
		return player;
	}
	
	public Creature newFungus(int depth) {
		Creature fungus = new Creature(world, "Fungus", 'F', 1, 10, 0, 0, AsciiPanel.brightMagenta);
		world.addAtEmptyLocation(fungus, depth);
		new FungusAI(fungus, this);
		return fungus;
	}
}
