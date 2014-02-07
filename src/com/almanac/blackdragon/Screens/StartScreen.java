package com.almanac.blackdragon.Screens;

import java.awt.Color;
import java.awt.event.KeyEvent;
import com.almanac.blackdragon.BlackDragon;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter(" SOMETHING AWESOME ", 3, Color.black, Color.green);
		terminal.writeCenter("By Dogleaf", 5, Color.white);
		
		for (int x = 0; x < BlackDragon.screenWidth; x++) {
			terminal.write((char)178, x, 1, Color.yellow);
		}
		
		for (int x = 0; x < BlackDragon.screenWidth; x++) {
			terminal.write((char)178, x, 7, Color.yellow);
		}
		terminal.writeCenter("1. Play   ", 10, Color.white);
		terminal.writeCenter("2. Options", 11, Color.white);
		terminal.writeCenter("3. About  ", 12, Color.white);
		terminal.writeCenter("4. Quit   ", 13, Color.white);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_1: return new PlayScreen();
		case KeyEvent.VK_2: return new ForestScreen();
		}
		
		return this;
		
	}

}
