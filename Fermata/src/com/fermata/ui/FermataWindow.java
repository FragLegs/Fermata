package com.fermata.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class FermataWindow extends JFrame {
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
    		if (e.getID() == KeyEvent.KEY_PRESSED) {
    			piano.PianoKeyDown(e.getKeyCode());
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            	piano.PianoKeyUp(e.getKeyCode());
            }
            return false;
        }
    }

	private JPanel contentPane; // commnt
	private Piano piano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FermataWindow frame = new FermataWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FermataWindow() throws IOException {
		setMinimumSize(new Dimension(900, 500));
		setTitle("Fermata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// add the menu bar
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		// File menu
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		// File->Exit option
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		// Help menu
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		// Help->About option
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Created by Matt Panning and Shayne Miel, 2012", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		
		// everything else
		JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new GridBagLayout());
		contentPane.add(windowPanel, BorderLayout.CENTER);
		
		// Build the panel where we will be displaying the staff
		JPanel staffPanel = new JPanel();
		staffPanel.setBackground(Color.WHITE);
		GridBagConstraints staffConstraints = new GridBagConstraints();
		staffConstraints.fill = GridBagConstraints.BOTH;
		staffConstraints.gridx = 0;
		staffConstraints.gridy = 0;
		staffConstraints.weightx = 1.0;
		staffConstraints.weighty = 0.66;
		windowPanel.add(staffPanel, staffConstraints);
		
		// load the staff image
		// TODO: refactor into a component
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("resources/220px-Grand_staff.svg.png");
		    Image staffImg = ImageIO.read(input);
			staffPanel.setLayout(new BorderLayout(0, 0));
			JLabel staffLabel = new JLabel( new ImageIcon( staffImg ) );
			staffPanel.add(staffLabel, BorderLayout.CENTER);
		}
		catch (IOException e) { throw e; } // just throw for now because this would be a code error, not a user error
		
/*		// Build the panel where we will be displaying the keyboard
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		keyboardPanel.setBackground(SystemColor.control);
		contentPane.add(keyboardPanel, BorderLayout.SOUTH);
		
		// load the keyboard image
		// TODO: refactor into a component
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("resources/keyboard4.png");
		    Image keyboardImg = ImageIO.read(input);
			keyboardPanel.setLayout(new BorderLayout(0, 0));
			JLabel keyboardLabel = new JLabel( new ImageIcon( keyboardImg ) );
			keyboardPanel.add(keyboardLabel, BorderLayout.CENTER);
		}
		catch (IOException e) { throw e; } // just throw for now because this would be a code error, not a user error
*/		
		piano = new Piano();
		piano.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		piano.setBackground(Color.PINK);//SystemColor.control);
		GridBagConstraints pianoConstraints = new GridBagConstraints();
		pianoConstraints.fill = GridBagConstraints.BOTH;
		pianoConstraints.gridx = 0;
		pianoConstraints.gridy = 1;
		pianoConstraints.weightx = 1.0;
		pianoConstraints.weighty = 0.34;
		windowPanel.add(piano, pianoConstraints);
		
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
	}

}
