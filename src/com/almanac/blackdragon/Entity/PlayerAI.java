package com.almanac.blackdragon.Entity;

import java.util.List;

import com.almanac.blackdragon.World.FieldOfView;

public class PlayerAI extends CreatureAI {
	
	private FieldOfView fov;
	
	private List<String> messages;

	public PlayerAI(Creature creature, List<String> messages, FieldOfView fov) {
		super(creature);
		this.messages = messages;
		this.fov = fov;
	}
	
	public void onNotify(String message){
        messages.add(message);
    }
	
	public boolean canSee(int wx, int wy, int wz) {
		return fov.isVisible(wx, wy, wz);
	}
	
	public void onEnter(int x, int y, int z, Tile tile) {
		if (tile.isWalkable()) {
			creature.x = x;
			creature.y = y;
			creature.z = z;
		} else {
			creature.doAction("bump into a wall");
		}
	}
	

}
