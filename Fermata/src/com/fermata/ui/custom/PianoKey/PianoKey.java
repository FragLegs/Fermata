package com.fermata.ui.custom.PianoKey;

import javax.swing.*;

@SuppressWarnings("serial")
public class PianoKey extends JComponent {
	
	/*
	 * The UI class ID string.
	 */
	private static final String uiClassID = "PianoKeyUI";

	/**
	 * Sets the new UI delegate.
	 * 
	 * @param ui
	 *            New UI delegate.
	 */
	public void setUI(PianoKeyUI ui) {
		super.setUI(ui);
	}

	/**
	 * Resets the UI property to a value from the current look and feel.
	 * 
	 * @see JComponent#updateUI
	 */
	public void updateUI() {
		if (UIManager.get(getUIClassID()) != null) {
			setUI((PianoKeyUI) UIManager.getUI(this));
		} else {
			setUI(new BasicPianoKeyUI());
		}
	}

	/**
	 * Returns the UI object which implements the L&F for this component.
	 * 
	 * @return UI object which implements the L&F for this component.
	 * @see #setUI
	 */
	public PianoKeyUI getUI() {
		return (PianoKeyUI) ui;
	}

	/**
	 * Returns the name of the UI class that implements the L&F for this
	 * component.
	 * 
	 * @return The name of the UI class that implements the L&F for this
	 *         component.
	 * @see JComponent#getUIClassID
	 * @see UIDefaults#getUI
	 */
	public String getUIClassID() {
		return uiClassID;
	}

	protected PianoKeyModel model;
	
	public PianoKeyModel getModel()
	{
		return this.model;
	}
	
	public int getMidiValue()
	{
		return this.model.getMidiValue();
	}
	
	public boolean isDown()
	{
		return this.model.getDown();
	}
	
	public void clicked()
	{
		this.model.setDown(!this.model.getDown());
	}
}