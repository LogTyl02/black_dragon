package com.almanac.blackdragon.Entity;

import java.awt.Color;

public class Item {
	private String name;
	private char glyph;
	private Color color;

	public Item(String name, char glyph, Color color) {
		this.name = name;
		this.glyph = glyph;
		this.color = color;

	}
	
	public String name() {
		return name;
	}
	
	public char glyph() {
		return glyph;
	}
	
	public Color color() {
		return color;
	}

}
