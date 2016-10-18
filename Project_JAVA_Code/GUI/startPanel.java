package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main;

// Contains all the content for the start Screen. 

public class startPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton startButton;
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	
	
	public startPanel(){
				
		setLayout(null); 
		
		startButton = new JButton("Start"); 
		startButton.setBounds(700, 50, 100, 50);
		add(startButton);
		
		//This provides the action for the start button. 
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
			// Removes the startFrame and replaces it to the Game board. 
			Main.frame.getContentPane().removeAll();
			Main.frame.getContentPane().add(Main.gbp);
			Main.frame.revalidate(); // refreshes the JFrame. 
		  }
		});
		
	}	
}