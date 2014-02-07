package com.almanac.blackdragon.World;

import java.awt.Color;

import com.almanac.blackdragon.Entity.Tile;

public class World {
	private Tile[][] tiles;
	private int width;
	private int height;
	
	/*
	 * 	Constructor
	 */
	
	public World(Tile[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
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
