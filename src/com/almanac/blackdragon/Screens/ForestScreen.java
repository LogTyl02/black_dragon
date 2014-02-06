package com.almanac.blackdragon.Screens;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class ForestScreen implements Screen {
	private String HUNT	  = "[L]ook for something to hunt";
	private String HEALER = "[H]ealer's Hut";
	private String LEAVE  = "[L]eave";

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("1. " + HUNT, 5, 10, Color.green);
		terminal.write("2. " + HEALER, 5, 11, Color.green);
		terminal.write("3. " + LEAVE, 5, 12, Color.green);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}

}
