package com.almanac.blackdragon.Entity;

import java.awt.Color;

public class Item {
	private String name;
	private char glyph;
	private Color color;
	private int weight;
	private int value;
	
	public Item(String name, char glyph, Color color, int weight, int value) {
		this.name = name;
		this.glyph = glyph;
		this.color = color;
		this.weight = weight;
		this.value = value;
	}

}
