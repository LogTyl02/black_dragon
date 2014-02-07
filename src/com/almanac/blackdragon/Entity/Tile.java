package com.almanac.blackdragon.Entity;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {	
	GRASS((char)250, AsciiPanel.brightGreen),
	DIRT((char)250, AsciiPanel.yellow),
	WALL((char)177, AsciiPanel.brightYellow),
	WATER('~', AsciiPanel.brightBlue),
	VOID(('x'), AsciiPanel.brightBlack);
	
	private char glyph;
	private Color color;
	
	public char glyph() {
		return glyph;
	}
	
	public Color color() {
		return color;
	}
	
	Tile(char glyph, Color color) {
		this.glyph = glyph;
		this.color = color;
	}
	

}
