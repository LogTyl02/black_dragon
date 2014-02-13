package com.almanac.blackdragon.Screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("YOU ARE DEAD", 13, AsciiPanel.brightRed);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}

}
