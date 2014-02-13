package com.almanac.blackdragon.Entity;

public class BatAI extends CreatureAI {

	public BatAI(Creature creature) {
		super(creature);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate() {
		wander();
		wander();
	}
}
