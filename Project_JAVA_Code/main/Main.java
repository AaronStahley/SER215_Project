package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;

import GUI.gameBoardPanel;
//import GUI.menuBar;
//import GUI.startPanel;

public class Main {
	
	public static JFrame frame;
	
	public static void main (String[] args) throws MalformedURLException, IOException{
		
		// ------------------------ GUI STUFF ------------------------------//
	
		// Needed to detect the screen resolution 
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		//startPanel panelStart = new startPanel(); 
		
		// Contains all the JFrame attributes. 
		//menuBar mb = new menuBar();
		gameBoardPanel gbp = new gameBoardPanel(); 
		frame = new JFrame("Mancala"); 
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-------- Adding components to the JFrame ------------//
		
		// Adds the menuBar to the frame
		
		
		
		
		
		/////////------TO DO------//////////////
		
		//frame.getContentPane().add(mb);
		
		/* This needs to be redone using a JMenubar class and 
		 * not my own class. 
		 */
		
		/////////--------------//////////////
		
		
		
		
		//Adds the startPanel to the frame
			//frame.getContentPane().add(panelStart);
	
		//Adds the gameBoardPanel to the frame
		frame.getContentPane().add(gbp);
		
		
		// Sets the panel size to the resolution of the monitor
		frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());
		frame.setResizable(true);
		
		
		// -----------------------------------------------------------------//

		
		
		
		
		
	}

}