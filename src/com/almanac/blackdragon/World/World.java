package com.almanac.blackdragon.World;

public class World {
	public boolean exists;
	private Room[][] rooms;
	
	
	public World(Room[][] rooms) {
		this.rooms = rooms;
		this.exists = true;		// Debugging
	}
	
	public Room[][] getRooms() {
		return rooms;
	}
	
	public void fillRooms() {
		for (int x = 0; x < this.rooms.length; x++) {
			for (int y = 0; y < this.rooms[x].length; y++) {
				this.rooms[x][y] = new Room();
			}
		} 
	}
}
