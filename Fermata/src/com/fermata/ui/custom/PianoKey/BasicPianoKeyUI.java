package com.fermata.ui.custom.PianoKey;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;

public class BasicPianoKeyUI extends PianoKeyUI {
	
	// The associated PianoKey
	PianoKey pianoKey;
	
	// Listeners
	protected MouseListener mouseListener;
	protected ChangeListener pianoKeyChangeListener;
	
	public static ComponentUI createUI(JComponent c) {
		return new BasicPianoKeyUI();
	}
	
	public void installUI(JComponent c) {
		this.pianoKey = (PianoKey) c;
		installDefaults();
		installComponents();
		installListeners();
	}
	
	public void uninstallUI(JComponent c) {
		c.setLayout(null);
		uninstallListeners();
		uninstallComponents();
		uninstallDefaults();

		this.pianoKey = null;
	}

	public void installDefaults() {	}
	
	public void installComponents() { }
	
	public void installListeners() {
		// mouse listener
		this.mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pianoKey.clicked();
			}
		};
		this.pianoKey.addMouseListener(this.mouseListener);

		// state change listener
		this.pianoKeyChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				pianoKey.repaint();
			}
		};
		this.pianoKey.getModel().addChangeListener(
				this.pianoKeyChangeListener);
	}
	
	public void uninstallDefaults() { }

	public void uninstallComponents() { }
	
	public void uninstallListeners() {
		this.pianoKey.removeMouseListener(this.mouseListener);
		this.mouseListener = null;

		this.pianoKey.getModel().removeChangeListener(
				this.pianoKeyChangeListener);
		this.pianoKeyChangeListener = null;
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		this.paintPianoKey(g);
	}

	protected void paintPianoKey(Graphics g) {
		Rectangle sliderBounds = sliderRendererPane.getBounds();
		this.sliderRendererPane.paintComponent(g, this.slider,
				this.flexiSlider, sliderBounds.x, sliderBounds.y,
				sliderBounds.width, sliderBounds.height, true);
	}
}
