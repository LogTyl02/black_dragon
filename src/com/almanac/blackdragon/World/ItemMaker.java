package com.almanac.blackdragon.World;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.Item;

/*
 * 	I MAKE ITEMS FOR YOU TO ADVENTURE WITH!
 */

public class ItemMaker {
	
	private World world;

	public ItemMaker(World world) {
		this.world = world;
	}
	
	public Item newRock(int depth) {
		Item rock = new Item("Rock", '*', AsciiPanel.yellow);
		world.addAtEmptyLocation(rock, depth);
		return rock;
	}
	
}
