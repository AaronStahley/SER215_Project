package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

// Contains all the content for the start Screen. 

public class startPanel extends JPanel {

	private static final long serialVersionUID = 1L;


	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

	
	static JMenuBar menuBar;
	
	private JMenu file; 
	private JMenu settings; 
	private JMenu resolution;
	private JMenuItem exit; 
	
	
	public startPanel(){
		
		setLayout(null); 
		
		// --------------- Menu Bar Attributes -----------//
		menuBar = new JMenuBar(); 
		menuBar.setBounds(0, 0,gd.getDisplayMode().getWidth(), 25);
		menuBar.setVisible(true);
		add(menuBar);
		
		
		// -----File menu bar item Attributes ----//
		
		// Creates the File button in the menu bar
		file = new JMenu(" File ");
		file.setRolloverEnabled(true);
		menuBar.add(file);
		
		// Exit button in the file menu bar button. 
		exit = new JMenuItem(" Exit ");
		file.add(exit);
		event e = new event();
		exit.addActionListener(e);
		
		// ---------------------------------------//
		
		// -- Settings menu bar item Attributes --//
		
		// Creates the Settings button in the menu bar.
		settings = new JMenu(" Settings ");
		settings.setRolloverEnabled(true);
		menuBar.add(settings);
		
		// Resolution Button in the settings menu bar button. 
		resolution = new JMenu(" Resolution ");
		resolution.setRolloverEnabled(true);
		settings.add(resolution); 
		
		
		
		// ---------------------------------------//
		
	}
	
	// Implements the actionListner for buttons and menu bar items. 
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}


}
