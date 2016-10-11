package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

import GUI.menuBar;
import GUI.startPanel;

public class Main {
	
	public static JFrame frame;
	
	public static void main (String[] args){
		
		// ------------------------ GUI STUFF ------------------------------//
	
		// Needed to detect the screen resolution 
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		startPanel panelStart = new startPanel(); 
		
		// Contains all the JFrame attributes. 
		menuBar mb = new menuBar(); 
		frame = new JFrame("Game"); 
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-------- Adding components to the JFrame ------------//
		
		//Adds the panel to the frame
		frame.getContentPane().add(panelStart);
		// Adds the menuBar to the frame
		frame.getContentPane().add(mb);
		
		// Sets the panel size to the resolution of the monitor
		frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());
		frame.setResizable(false);
		
		// -----------------------------------------------------------------//

		
		
		
		
		
	}

}