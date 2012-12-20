package com.fermata.ui.custom.PianoKey;

import javax.swing.event.ChangeListener;

public interface PianoKeyModel {
	
	public int getMidiValue();
	public PianoKeyType getType();
	
	public boolean getDown();
	public void setDown(boolean b);
		
	/**
	 * Adds a ChangeListener to the model's listener list.
	 * 
	 * @param x
	 *            the ChangeListener to add
	 * @see #removeChangeListener
	 */
	void addChangeListener(ChangeListener x);

	/**
	 * Removes a ChangeListener from the model's listener list.
	 * 
	 * @param x
	 *            the ChangeListener to remove
	 * @see #addChangeListener
	 */
	void removeChangeListener(ChangeListener x);
}