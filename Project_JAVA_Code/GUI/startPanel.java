package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

// Contains all the content for the start Screen. 

public class startPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	public static JButton startButton;
	public static JLabel startBGLabel; 
	public static JButton InstructionsButton; 
	public static JButton exitButton; 
		
	public startPanel(){
				
		setLayout(null); 
		

		startButton = new JButton("Start"); 
		startButton.setOpaque(true);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		add(startButton);
		
		InstructionsButton = new JButton("Instructions");
		InstructionsButton.setOpaque(true);
		InstructionsButton.setContentAreaFilled(false);
		InstructionsButton.setBorderPainted(false);
		add(InstructionsButton);
		
		exitButton = new JButton("Exit");
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
		  }
		});
	
		
		startBGLabel = new JLabel();
		add(startBGLabel);
		

		

		
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