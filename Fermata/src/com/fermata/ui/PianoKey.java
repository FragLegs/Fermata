package com.fermata.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class PianoKey extends JButton {
	
	// maintain pressed state of key
	protected boolean down;
	public boolean isDown() { return down; }
	
	// the midi value
	private int value;
	public int getValue() { return value; }
	
	public PianoKey(int v)
	{
		value = v;
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				down = true;
				updateBackground();
			}
		});
	}
	
	public abstract void updateBackground();
}

