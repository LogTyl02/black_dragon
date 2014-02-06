package com.almanac.blackdragon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;

import com.almanac.blackdragon.Screens.Screen;
import com.almanac.blackdragon.Screens.StartScreen;


public class BlackDragon extends JFrame implements KeyListener {
	
	/**
	 * 		Unique serialization UID
	 */
	
	private static final long serialVersionUID = 3528113194671989458L;
	
	private AsciiPanel terminal;
	private Screen screen;

	public BlackDragon() {
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}
	
	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}
	
	

	public static void main(String[] args) {
		
		BlackDragon game = new BlackDragon();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);

	}



	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
