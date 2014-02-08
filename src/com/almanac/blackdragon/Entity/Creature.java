package com.almanac.blackdragon.Entity;

import java.awt.Color;

import com.almanac.blackdragon.World.World;

public class Creature {
	private World world;
	
	public int x;
	public int y;
	public int z;
	
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
	
	public Creature(World world, String name, char glyph, int level, int maximumHealth, int attack, int defense, Color color) {
		this.world = world;
		this.name  = name;
		this.glyph = glyph;
		this.level = level;
		this.maximumHealth = maximumHealth;
		this.currentHealth = this.maximumHealth;
		this.attackPower = attack;
		this.defenseValue = defense;
		this.color = color;
		
		inventory = new Item[26];			// 26 is the maximum inventory space for any creature
	}
	
	
	/*
	 * 	Methods
	 */
	
	public void attack(Creature target) {
		int damageAmount = Math.max(0, attackPower() - target.defenseValue());
		
		damageAmount = (int)(Math.random() * damageAmount) + 1;
		
		target.modifyHealth(-damageAmount);
		
		
		doAction("attack the '%s' for %d damage", target.name, damageAmount);
		//notify("You attack the '%s' for %d damage.", target.name, damageAmount);
		//target.notify("The '%s' attacks you for %d damage.", name, damageAmount);
	}
	
	public void notify(String message, Object ... params) {
		AI.onNotify(String.format(message, params));
	}
	
	
	public void modifyHealth(int damageAmount) {
		currentHealth += damageAmount;
		
		if (currentHealth < 1) {
			doAction("kill the %s!", name);
			world.remove(this);
		}
	}
	
	public void dig(int wx, int wy, int wz) {
		notify("You succeed in cutting away some rock");
		world.dig(wx, wy, wz);
	}
	
	public void moveBy(int mx, int my, int mz){
        Tile tile = world.tile(x+mx, y+my, z+mz);
     
        if (mz == -1){
            if (tile == Tile.STAIRS_DOWN) {
                doAction("walk up the stairs to level %d", z+mz+1);
            } else {
                doAction("try to go up but are stopped by the cave ceiling");
                return;
            }
        } else if (mz == 1){
            if (tile == Tile.STAIRS_UP) {
                doAction("walk down the stairs to level %d", z+mz+1);
            } else {
                doAction("try to go down but are stopped by the cave floor");
                return;
            }
        }
     
        Creature other = world.creature(x+mx, y+my, z+mz);
     
        if (other == null)
            AI.onEnter(x+mx, y+my, z+mz, tile);
        else
            attack(other);
    }
	
	public void update() {
		AI.onUpdate();
	}
	
	public boolean canEnter(int wx, int wy, int wz) {
		return world.tile(wx, wy, wz).isWalkable() && world.creature(wx, wy, wz) == null;
	}
	
	public void doAction(String message, Object ... params) {
		int r = 9;
		for (int ox = -r; ox < r+1; ox++){
			for (int oy = -r; oy < r+1; oy++){
				if (ox*ox + oy*oy > r*r)
					continue;
				
				Creature other = world.creature(x+ox, y+oy, z);
				
				if (other == null)
					continue;
				
				if (other == this)
					other.notify("You " + message + ".", params);
				else
					other.notify(String.format("The '%s' %s.", glyph, makeSecondPerson(message)), params);
			}
		}
	}
	
	private String makeSecondPerson(String text){
	    String[] words = text.split(" ");
	    words[0] = words[0] + "s";
	     
	    StringBuilder builder = new StringBuilder();
	    for (String word : words){
	        builder.append(" ");
	        builder.append(word);
	    }
	     
	    return builder.toString().trim();
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
