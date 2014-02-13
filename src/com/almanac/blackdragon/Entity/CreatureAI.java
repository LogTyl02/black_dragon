package com.almanac.blackdragon.Entity;

import com.almanac.blackdragon.World.Line;
import com.almanac.blackdragon.World.Point;

public class CreatureAI {

	protected Creature creature;
	
	public CreatureAI(Creature creature) {
		this.creature = creature;
		this.creature.setCreatureAI(this);
	}
	
	public void onEnter(int x, int y, int z, Tile tile) {
		
	}
	
	public void onUpdate() {
		
	}
	
	public void onNotify(String message){
        
    }
	
	public boolean canSee(int wx, int wy, int wz) {
		// Creatures can't see thru z levels
		if (creature.z != wz) {
			return false;
		}
		
		if ((creature.x-wx)*(creature.x-wx) + (creature.y-wy)*(creature.y-wy) > creature.visionRadius()*creature.visionRadius())
            return false;
		
		
		// Cast rays from a creature to a world position
		for (Point p : new Line(creature.x, creature.y, wx, wy)){
            if (creature.tile(p.x, p.y, wz).isWalkable() || p.x == wx && p.y == wy)
                continue;
         
            return false;
        }
				
		return true;
	}
	
}
