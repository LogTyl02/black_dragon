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
	
	private CreatureAI AI;
	private int attackPower;
	private int defenseValue;
	
	private Item[] inventory;
	
	/*
	 * 	Constructor
	 */
	
	public Creature(World world, String name, char glyph, int level, int maximumHealth) {
		this.world = world;
		this.name  = name;
		this.glyph = glyph;
		this.level = level;
		this.maximumHealth = maximumHealth;
		this.currentHealth = this.maximumHealth;
		
		inventory = new Item[26];			// 26 is the maximum inventory space for any creature
	}
	
	
	/*
	 * 	Methods
	 */
	
	public void attack(Creature target) {
		int damageAmount = Math.max(0, attackPower() - target.defenseValue());
		
		damageAmount = (int)(Math.random() * damageAmount) + 1;
		
		target.modifyHealth(-damageAmount);
	}
	
	
	public void modifyHealth(int damageAmount) {
		currentHealth += damageAmount;
		
		if (currentHealth < 1) {
			// Die
		}
	}
	
	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}
	
	public void moveBy(int mx, int my) {
		Tile tile = world.tile(x + mx, y + my);
		AI.onEnter(x + mx, y + my, tile);
	}
	
	
	
	/*
	 * 	Getters
	 */
	
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
	
	public int attackPower() {
		return attackPower;
	}
	
	public int defenseValue() {
		return defenseValue;
	}
	
	public Item[] inventory() {
		return inventory;
	}
	
	/*
	 * 	Setter Injection
	 */
	
	public void setCreatureAI(CreatureAI AI) {
		this.AI = AI;
	}

}
