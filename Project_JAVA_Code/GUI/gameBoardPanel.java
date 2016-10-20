package GUI;

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
	
	public static JButton[] pits = new JButton[12]; 
		
	public gameBoardPanel() throws MalformedURLException, IOException{
		
		setLayout(null);
				
		pits[0] = new JButton();
		pits[1] = new JButton(); 
		pits[2] = new JButton(); 
		pits[3] = new JButton(); 
		pits[4] = new JButton(); 
		pits[5] = new JButton(); 
		pits[6] = new JButton(); 
		pits[7] = new JButton(); 
		pits[8] = new JButton(); 
		pits[9] = new JButton(); 
		pits[10] = new JButton(); 
		pits[11] = new JButton(); 
		
		for(int i = 0; i < pits.length; i++){
		pits[i].setOpaque(true);
		pits[i].setContentAreaFilled(false);
		pits[i].setBorderPainted(false);
		}
				
		for(int i = 0; i < pits.length; i++){
			
			add(pits[i]);
		}
	
		bgLabel = new JLabel(); 
		add(bgLabel); 
		
	
	}

	

}