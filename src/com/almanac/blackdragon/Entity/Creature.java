package com.almanac.blackdragon.Entity;

import java.awt.Color;

import com.almanac.blackdragon.World.World;

public class Creature {
	private World world;
	
	public int x;
	public int y;
	
	private String name;
	private Color color;
	private char glyph;
	private int level;
	private int maximumHealth;
	private int currentHealth;
	
	private Item[] inventory;
	
	public Creature(String name, char glyph, int level, int maximumHealth) {
		this.name  = name;
		this.glyph = glyph;
		this.level = level;
		this.maximumHealth = maximumHealth;
		this.currentHealth = this.maximumHealth;
		inventory = new Item[26];			// 26 is the maximum inventory space for any creature
	}
	
	public String name() {
		return name;
	}
	
	public char glyph() {
		return glyph;
	}
	
	public int level() {
		return level;
	}
	
	public Color color() {
		return color;
	}
	
	public int maximumHealth() {
		return maximumHealth;
	}
	
	public int currentHealth() {
		return currentHealth;
	}
	
	public Item[] inventory() {
		return inventory;
	}

}
