package com.almanac.blackdragon.Entity;

import java.util.List;

public class PlayerAI extends CreatureAI {
	
	private List<String> messages;

	public PlayerAI(Creature creature, List<String> messages) {
		super(creature);
		this.messages = messages;
		
	}
	
	public void onNotify(String message){
        messages.add(message);
    }
	
	public void onEnter(int x, int y, int z, Tile tile) {
		if (tile.isWalkable()) {
			creature.x = x;
			creature.y = y;
			creature.z = z;
		} else if (tile.isDiggable()) {
			creature.dig(x, y, z);
		}
	}
	

}
