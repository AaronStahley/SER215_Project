package GUI;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameBoardPanel extends JPanel{
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	

	public static JLabel bgLabel; 
	
	public static JButton[] pitButton = new JButton[6]; 
	public static JLabel[] pitLabel = new JLabel[6]; 
	
	public static JLabel[] pitNumberLabel = new JLabel[12];
	
	public static JLabel mancalaLeft;
	public static JLabel mancalaRight;
	
	public static JLabel playerTurn; 
	
		
	public gameBoardPanel() throws MalformedURLException, IOException{
		
		setLayout(null);
		
		playerTurn = new JLabel("Player Turn"); 

		add(playerTurn); 
		
		mancalaLeft = new JLabel();
		add(mancalaLeft);
		
		mancalaRight = new JLabel(); 
		add(mancalaRight); 
		
		pitButton[0] = new JButton();
		pitButton[1] = new JButton(); 
		pitButton[2] = new JButton(); 
		pitButton[3] = new JButton(); 
		pitButton[4] = new JButton(); 
		pitButton[5] = new JButton(); 
		
		pitLabel[0] = new JLabel();
		pitLabel[1] = new JLabel();
		pitLabel[2] = new JLabel();
		pitLabel[3] = new JLabel();
		pitLabel[4] = new JLabel();
		pitLabel[5] = new JLabel();
		
		pitNumberLabel[0] = new JLabel("4");
		pitNumberLabel[1] = new JLabel("4");
		pitNumberLabel[2] = new JLabel("4");
		pitNumberLabel[3] = new JLabel("4");
		pitNumberLabel[4] = new JLabel("4");
		pitNumberLabel[5] = new JLabel("4");
		pitNumberLabel[6] = new JLabel("4");
		pitNumberLabel[7] = new JLabel("4");
		pitNumberLabel[8] = new JLabel("4");
		pitNumberLabel[9] = new JLabel("4");
		pitNumberLabel[10] = new JLabel("4");
		pitNumberLabel[11] = new JLabel("4");
		
		for(int i = 0; i < pitButton.length; i++){
		pitButton[i].setOpaque(true);
		pitButton[i].setContentAreaFilled(false);
		pitButton[i].setBorderPainted(false);
		}
		
		for(int i = 0; i < pitNumberLabel.length; i++){
			pitNumberLabel[i].setForeground(Color.WHITE);
		}
			
		
		for(int i = 0; i < pitNumberLabel.length; i++){
			
			add(pitNumberLabel[i]);
		}
			
		for(int i = 0; i < pitButton.length; i++){
			
			add(pitButton[i]);
		}
		for(int i = 0; i < pitLabel.length; i++){
			add(pitLabel[i]);
		}

		
	
		bgLabel = new JLabel(); 
		add(bgLabel); 
		
	
	}

	

}