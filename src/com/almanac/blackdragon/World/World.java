package com.almanac.blackdragon.World;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.Entity.Tile;

public class World {
	private Tile[][] tiles;
	private List<Creature> creatures;
	private int width;
	private int height;
	
	/*
	 * 	Constructor
	 */
	
	public World(Tile[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		
		this.creatures = new ArrayList<Creature>();
	}
	
	/*
	 * 	Methods
	 */
	
	public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.VOID;
        else
            return tiles[x][y];
    }
	
	public void dig(int x, int y) {
		if (tile(x, y).isDiggable()) {
			tiles[x][y] = Tile.GRASS;	
		}
	}
	
	public Creature creature(int x, int y){
		for (Creature c : creatures){
			if (c.x == x && c.y == y)
				return c;
		}
		return null;
	}
	
	public void addAtEmptyLocation(Creature creature) {
		int x;
		int y;
		
		
		// Pick random spots until you find a walkable one
		do {
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
		}
		while (!tile(x, y).isWalkable() || creature(x, y) != null);	// Make sure no other creature is there
		
		// Put the creature there
		creature.x = x;
		creature.y = y;
		
		// Add the creature to the master list
		creatures.add(creature);
	}
	
	public void remove(Creature target) {
		creatures.remove(target);
	}
	
	public void update() {
		
		List<Creature> toUpdate = new ArrayList<Creature>(creatures);
		for (Creature creature : toUpdate) {
			
			creature.update();
		}
	}
	
	/*
	 * 	Getters
	 */
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	public char glyph(int x, int y){
        return tile(x, y).glyph();
    }
	
	public Color color(int x, int y) {
        return tile(x, y).color();
    }
	
}
