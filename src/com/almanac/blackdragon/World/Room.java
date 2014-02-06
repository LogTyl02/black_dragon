package com.almanac.blackdragon.World;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.Item;

public class Room {
	private int x;
	private int y;
	
	private Item[] items;
	private Creature[] creatures;
	
	public Room() {
		this.x = 5;
		this.y = 5;
	}
	
	public int getX() {
		return x;
	}
	
	

}
