package com.almanac.blackdragon.Screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Entity.Creature;
import com.almanac.blackdragon.World.CreatureMaker;
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
	
	private int centerX;
	private int centerY;
	
	private Creature player;
	private String NAME = "Dogleaf";
	private String TITLE = "the Explorer";
	private String LOCATION = " SPOOKY FOREST ";
	
	public PlayScreen() {
		screenWidth			=	100;
		screenHeight		=	30;
		messages			=	new ArrayList<String>();
		worldWidth			=	200;
		worldHeight			=	100;
		
		createWorld(worldWidth, worldHeight);
		CreatureMaker creatureMaker = new CreatureMaker(world);
		
		// Populate the world with baddies
		createCreatures(creatureMaker);
		
	}
	
	private void createWorld(int worldWidth, int worldHeight) {
        world = new WorldBuilder(worldWidth, worldHeight).makeCaves().build();
    }

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
        int top = getScrollY();
    
        displayTiles(terminal, left, top);
        
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_NUMPAD4: player.moveBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_NUMPAD6: player.moveBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_NUMPAD8: player.moveBy( 0,-1); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_NUMPAD2: player.moveBy( 0, 1); break;
		case KeyEvent.VK_NUMPAD7: player.moveBy(-1,-1); break;
		case KeyEvent.VK_NUMPAD9: player.moveBy( 1,-1); break;
		case KeyEvent.VK_NUMPAD1: player.moveBy(-1, 1); break;
		case KeyEvent.VK_NUMPAD3: player.moveBy( 1, 1); break;
		}
		
		world.update();
		
		return this;
	}
	
	private void debugPrints() {
		
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
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;
	            
	            Creature creature = world.creature(wx, wy);
	            
	            if (creature != null) {
	            	terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
	            } else
	 
	            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
	        }
	    }
	}
	
	private void createCreatures(CreatureMaker creatureMaker) {
		player = creatureMaker.newPlayer();
		
		for (int i = 0; i < 8; i++) {
			System.out.println("Spawning a Fungus!");
			creatureMaker.newFungus();
		}
	}
		
}
