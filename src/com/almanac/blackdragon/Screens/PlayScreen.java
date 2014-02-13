package com.almanac.blackdragon.Screens;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.World.CreatureMaker;
import com.almanac.blackdragon.World.FieldOfView;
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
	private int worldDepth;
	
	private int centerX;
	private int centerY;
	
	private Creature player;
	
	private FieldOfView fov;
	
	public PlayScreen() {
		screenWidth			=	100;	// Change these to add black space to the side or bottom
		screenHeight		=	26;
		messages			=	new ArrayList<String>();
		worldWidth			=	100;
		worldHeight			=	50;
		worldDepth			=	5;
		
		createWorld(worldWidth, worldHeight, worldDepth);
		fov = new FieldOfView(world);
		CreatureMaker creatureMaker = new CreatureMaker(world, fov);
		
		
		// Populate the world with baddies
		createCreatures(creatureMaker);
		
	}
	
	private void createWorld(int worldWidth, int worldHeight, int worldDepth) {
        world = new WorldBuilder(worldWidth, worldHeight, worldDepth).makeCaves().build();
    }

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
        int top = getScrollY();
    
        displayTiles(terminal, left, top);
        
        String name  = "Dogleaf";
        String title = " the Slow";
        String stats = String.format("%3d/%3d HP", player.currentHealth(), player.maximumHealth());
        terminal.write(name + title, 1, 27);
        terminal.write(stats, 1, 28);
        
        displayMessages(terminal, messages);
        
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyChar()){
        case '<': player.moveBy( 0, 0, -1); break;
        case '>': player.moveBy( 0, 0, 1); break;
        }
		
		switch (key.getKeyCode()){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_NUMPAD4: player.moveBy(-1, 0, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_NUMPAD6: player.moveBy( 1, 0, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_NUMPAD8: player.moveBy( 0,-1, 0); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_NUMPAD2: player.moveBy( 0, 1, 0); break;
		case KeyEvent.VK_NUMPAD7: player.moveBy(-1,-1, 0); break;
		case KeyEvent.VK_NUMPAD9: player.moveBy( 1,-1, 0); break;
		case KeyEvent.VK_NUMPAD1: player.moveBy(-1, 1, 0); break;
		case KeyEvent.VK_NUMPAD3: player.moveBy( 1, 1, 0); break;
		}
		
		world.update();
		if (player.currentHealth() <= 0) {
			return new LoseScreen();
		}
		
		return this;
	}
	
	public int getScrollX() {
	    return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
	}
	
	public int getScrollY() {
	    return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
	}
	
	private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
    }
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
	    fov.update(player.x, player.y, player.z, player.visionRadius());
	     
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;
	 
	            if (player.canSee(wx, wy, player.z))
	                terminal.write(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
	            else
	                terminal.write(fov.tile(wx, wy, player.z).glyph(), x, y, Color.darkGray);
	        }
	    }
	}
	
	private void displayMessages(AsciiPanel terminal, List<String> messages) {
	    int top = screenHeight - messages.size();
	    for (int i = 0; i < messages.size(); i++){
	        terminal.writeCenter(messages.get(i), top + 1);
	    }
	    messages.clear();
	}
	
	private void createCreatures(CreatureMaker creatureMaker) {
		player = creatureMaker.newPlayer(messages);
		
		for (int z = 0; z < world.depth(); z++) {
			for (int i = 0; i < 8; i++) {
				creatureMaker.newFungus(z);
			}
		}
		
		for (int z = 0; z < world.depth(); z++) {
			for (int i = 0; i < 20; i++) {
				creatureMaker.newBat(z);
			}
		}
	}
		
}
