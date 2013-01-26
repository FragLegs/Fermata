package com.fermata.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class PianoKey extends JButton {
	
	// maintain pressed state of key
	protected boolean down;
	public boolean isDown() { return down; }
	
	// the midi value
	private int value;
	public int getValue() { return value; }
	
	// the note name
	private String name;
	public String getName() { return name; }
	
	// the octave
	private int octave;
	public int getOctave() { return octave; }
	
	public PianoKey(int v)
	{
		value = v;
		name = KeyNames[v % 12];
		octave = (v / 12) - 1;
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pushKey();
			}
		});
	}
	
	public void pushKey()
	{
		down = !down;
		updateBackground();
	}
	
	public abstract void updateBackground();
	
	// create a piano key from a numeric value
	public static PianoKey CreateKey(int v)
	{
		switch (v % 12)
		{
		case 1:
		case 3:
		case 6:
		case 8:
		case 10:
			return new BlackKey(v);
		default:
			return new WhiteKey(v);
		}
	}

	public static String[] KeyNames = { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B" }; 
}

