package com.almanac.blackdragon.Screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class VillageScreen implements Screen {
	
	private String BLACKSMITH = "(B)lacksmith";
	private String HEALER = "(H)ealer";
	private String ITEM = "(I)tem Shop";
	
	private String VILLAGEDESC = "A cozy little village.";

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("   Village   ", 5, AsciiPanel.black, AsciiPanel.white);
		terminal.writeCenter(VILLAGEDESC, 7, AsciiPanel.brightGreen);
		
		terminal.write("-------------", 3, 7, AsciiPanel.brightGreen);
		terminal.write(BLACKSMITH, 3, 8, AsciiPanel.brightGreen);
		terminal.write(HEALER, 3, 9, AsciiPanel.brightGreen);
		terminal.write(ITEM, 3, 10, AsciiPanel.brightGreen);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}

}
