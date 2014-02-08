package com.almanac.blackdragon.Entity;

import com.almanac.blackdragon.World.CreatureMaker;

public class FungusAI extends CreatureAI {
	private CreatureMaker maker;
	private int spreadCount;
	
	public FungusAI(Creature creature, CreatureMaker maker) {
		super(creature);
		this.maker = maker;
		this.spreadCount = 0;
		
	}
	
	public void onUpdate() {
		if (spreadCount < 5 && Math.random() < 0.01) {
			System.out.println(spreadCount);
			spread();
		}
	}
	
	private void spread() {
		int x = creature.x + (int)(Math.random() * 11) - 5;
		int y = creature.y + (int)(Math.random() * 11) - 5;
		
		if (!creature.canEnter(x, y)) {
			System.out.println("Not spreading at " + x + " " + y);
			return;
		}
		
		Creature child = maker.newFungus();
		System.out.println("Spreading!");
		child.x = x;
		child.y = y;
		this.spreadCount = this.spreadCount += 1;
	}
}
