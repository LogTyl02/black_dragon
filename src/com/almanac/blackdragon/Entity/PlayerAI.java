package com.almanac.blackdragon.Entity;

public class PlayerAI extends CreatureAI {

	public PlayerAI(Creature creature) {
		super(creature);
		
	}
	
	public void onEnter(int x, int y, Tile tile) {
		if (tile.isWalkable()) {
			creature.x = x;
			creature.y = y;
		} else if (tile.isDiggable()) {
			creature.dig(x, y);
		}
	}
	

}
