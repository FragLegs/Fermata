package com.fermata.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Staff extends JLayeredPane implements PianoListener {

	public Staff()
	{
		super();
		
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("resources/220px-Grand_staff.svg.png");
		    BufferedImage staffImg = ImageIO.read(input);
		    ImageIcon staffIcon = new ImageIcon(staffImg);
		    JLabel staffLabel = new JLabel(staffIcon);
		    
			// set the size of the staff based on the image
			// maybe make this dynamic later
		    Dimension staffSize = new Dimension(staffImg.getWidth(), staffImg.getHeight());
			setPreferredSize(staffSize);
			staffLabel.setSize(staffSize);
			staffLabel.setLocation(0, 0);
			
			add(staffLabel, 0, 0);
		    
		    
		}
		catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	@Override
	public void PianoKeyDown(int midiValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PianoKeyUp(int midiValue) {
		// TODO Auto-generated method stub
		
	}

}
