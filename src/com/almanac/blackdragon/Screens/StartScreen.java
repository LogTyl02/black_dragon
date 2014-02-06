package com.almanac.blackdragon.Screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("Welcome, traveler", 2, 2);
		terminal.writeCenter(" -- Press [Enter] to Start -- ", 22);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}

}
