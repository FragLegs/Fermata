package com.fermata.ui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class PianoResizeListener implements ComponentListener
{

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		Piano p = (Piano)e.getComponent();
		
		// get the width of the white keys
		double whiteWidth = (double)p.getWidth() / (double)p.getNumWhite();
		double halfBlackWidth = whiteWidth / 3;
		int whiteHeight = p.getHeight();
		int blackHeight = (int)((double)p.getHeight() / 3) * 2;
		
		double xLoc = 0;
		
		// resize the piano keys
		for (PianoKey k : p.getKeys())
		{
			// white keys
			if (k instanceof WhiteKey)
			{
				k.setBounds((int)xLoc, 0, (int)(xLoc + whiteWidth) - (int)xLoc, whiteHeight);
				xLoc += whiteWidth;
			}
			// black keys
			else
			{
				k.setBounds((int)(xLoc - halfBlackWidth), 0, (int)(2 * halfBlackWidth), blackHeight);
			}					
		}
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
