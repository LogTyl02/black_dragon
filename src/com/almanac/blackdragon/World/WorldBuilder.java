package com.almanac.blackdragon.World;

public class WorldBuilder {
	private Room[][] roomSet;
	private int worldWidth;
	private int worldHeight;
	private World newWorld;
	
	public WorldBuilder(int worldWidth, int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
	}
	
	public World build() {
		Room[][] worldRooms = populateWorld(this.worldWidth, this.worldHeight);
		newWorld = new World(worldRooms);
		return newWorld;
	}
	
	public Room[][] populateWorld(int width, int height) {
		roomSet = new Room[width][height];
		return roomSet;
	}
	
}
