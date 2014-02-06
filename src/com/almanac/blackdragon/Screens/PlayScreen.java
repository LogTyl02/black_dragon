package com.almanac.blackdragon.Screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.World.Room;
import com.almanac.blackdragon.World.World;
import com.almanac.blackdragon.World.WorldBuilder;

public class PlayScreen implements Screen {

	private World world;
	private List<String> messages;
	private int screenWidth;
	private int screenHeight;
	private Screen subScreen;
	
	private int worldWidth;
	private int worldHeight;
	
	public PlayScreen() {
		screenWidth			=	80;
		screenHeight		=	23;
		messages			=	new ArrayList<String>();
		worldWidth			=	5;
		worldHeight			=	5;
		
		createWorld(worldWidth, worldHeight);
	}
	
	private void createWorld(int worldWidth, int worldHeight) {
		world = new WorldBuilder(worldWidth, worldHeight).build();
		world.fillRooms();
		
		debugPrints();	// Test to make sure all objects are being created
		
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
				
		if (world.exists) {
			terminal.write("You have created a new world.", 2, 2);
		} else {
			terminal.write("No world exists, yet.", 2, 2);
		}
		
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void debugPrints() {
		Room[][] r = world.getRooms();
		System.out.println(r); 		// Does the array of rooms exist?
		
		System.out.println(r[1][2].getX());
	}		
		
}