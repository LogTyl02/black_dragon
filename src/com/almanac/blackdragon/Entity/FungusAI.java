package com.almanac.blackdragon.Entity;

import com.almanac.blackdragon.World.CreatureMaker;

public class FungusAI extends CreatureAI {
	private CreatureMaker maker;
	private int spreadCount;
	
	public FungusAI(Creature creature, CreatureMaker maker) {
		super(creature);
		this.maker = maker;
		
	}
	
	public void onUpdate() {
		if (spreadCount < 5 && Math.random() < 0.001) {
			System.out.println(spreadCount);
			spread();
		}
	}
	
	private void spread() {
		int x = creature.x + (int)(Math.random() * 11) - 5;
		int y = creature.y + (int)(Math.random() * 11) - 5;
		int z = creature.z;
		
		if (!creature.canEnter(x, y, z)) {
			
			System.out.println("Not spreading at " + x + " " + y);
			return;
		}
		
		Creature child = maker.newFungus(z);
		creature.doAction("spreads a little...");
		child.x = x;
		child.y = y;
		spreadCount++;
	}
}
