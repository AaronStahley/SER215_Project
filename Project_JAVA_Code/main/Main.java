package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import GUI.startPanel;

public class Main {
	
	public static void main (String[] args){
		
		// ------------------------ GUI STUFF ------------------------------//
	
		// Needed to detect the screen resolution 
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		startPanel panelStart = new startPanel(); 
		
		// Contains all the JFrame attributes. 
		
		JFrame frame = new JFrame("Game"); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panelStart);
		
		// Sets the panel size to the resolution of the monitor
		frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());
		frame.setResizable(false);
		
		// -----------------------------------------------------------------//

		
		
		
		
		
	}

}
