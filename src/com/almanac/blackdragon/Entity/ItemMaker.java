package com.almanac.blackdragon.Entity;

import com.almanac.blackdragon.World.World;

import java.awt.Color;

/*
 * 	I MAKE ITEMS FOR YOU TO ADVENTURE WITH!
 */

public class ItemMaker {
	
	private World world;

	public ItemMaker(World world) {
		this.world = world;
	}
	
	public Item newPotion() {
		Item potion = new Item("Potion", '!', Color.cyan, 2, 5);
		return potion;
	}
	
}