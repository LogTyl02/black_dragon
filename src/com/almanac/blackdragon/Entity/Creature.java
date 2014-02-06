package com.almanac.blackdragon.Entity;

public class Creature {
	private int level;
	private int maximumHealth;
	private int currentHealth;
	
	private Item[] inventory;
	
	public Creature() {
		inventory = new Item[26];	// 26 is the maximum inventory space for any creature
	}

}
