package com.fermata.ui;

import java.awt.Color;

@SuppressWarnings("serial")
public class BlackKey extends PianoKey {

	public BlackKey(int v)
	{
		super(v);
		
		// set pressed state
		down = false;
		
		// set background to white
		updateBackground();
		
		
	}

	@Override
	public void updateBackground() {
		setBackground(isDown() ? Color.RED : Color.BLACK);			
	}
}
