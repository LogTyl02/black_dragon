package com.almanac.blackdragon.World;

import java.awt.Color;
import java.util.List;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.BatAI;
import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.FungusAI;
import com.almanac.blackdragon.Entity.PlayerAI;

public class CreatureMaker {

	private World world;
	private FieldOfView fov;
	
	public CreatureMaker(World world, FieldOfView fov) {
		this.world = world;
		this.fov = fov;
	}
	
	public Creature newPlayer(List<String> messages) {
		Creature player = new Creature(world, "Player", '@', 1, 10, 5, 1, Color.white);
		world.addAtEmptyLocation(player, 0);
		new PlayerAI(player, messages, fov);
		return player;
	}
	
	public Creature newFungus(int depth) {
		Creature fungus = new Creature(world, "Fungus", 'F', 1, 10, 0, 0, AsciiPanel.brightMagenta);
		world.addAtEmptyLocation(fungus, depth);
		new FungusAI(fungus, this);
		return fungus;
	}
	
	public Creature newBat(int depth) {
		Creature bat = new Creature(world, "Bat", 'B', 2, 15, 3, 1, AsciiPanel.yellow);
		world.addAtEmptyLocation(bat, depth);
		new BatAI(bat);
		return bat;
	}
}
