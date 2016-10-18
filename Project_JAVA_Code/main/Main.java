package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;

import GUI.gameBoardPanel;
import GUI.menuBar;
import GUI.startPanel;
//import GUI.menuBar;
//import GUI.startPanel;

public class Main {
	
	public static JFrame frame;
	public static gameBoardPanel gbp;
	public static startPanel panelStart;
	public static menuBar mb; 
	
	public static void main (String[] args) throws MalformedURLException, IOException{
		
		// ------------------------ GUI STUFF ------------------------------//
	
		// Needed to detect the screen resolution sizes the window to your monitor resolution. 
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		// Contains all the JFrame attributes. 
		mb = new menuBar(); 
		panelStart = new startPanel();
		gbp = new gameBoardPanel(); 		
		
		frame = new JFrame("Mancala"); 
		
		frame.pack();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-------- Adding components to the JFrame ------------//
		
		// Adds the menuBar to the frame
		frame.setJMenuBar(mb.createMenuBar());
				
		//Adds the startPanel to the frame
		frame.getContentPane().add(panelStart);		
		
		// Sets the panel size to the resolution of the monitor
		frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());
		frame.setResizable(true);
		
		
		// -----------------------------------------------------------------//

		
		
		
		
		
	}

}