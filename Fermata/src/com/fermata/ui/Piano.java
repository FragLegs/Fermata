package com.fermata.ui;

import java.util.HashMap;

import javax.swing.JLayeredPane;

import com.fermata.music.midi.MidiHelpers;

@SuppressWarnings("serial")
public class Piano extends JLayeredPane {
	private HashMap<Integer, PianoKey> keyMap;
	
	public Piano()
	{
		keyMap = new HashMap<Integer, PianoKey>();
		
		for (int i = 21; i <= 108; i++)
		{
			if (MidiHelpers.MidiToPianoKeyType(i) != PianoKeyType.BLACK)
			{
				
			}
		}
		
	}
}