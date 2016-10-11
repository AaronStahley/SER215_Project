package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JPanel;

// Contains all the content for the start Screen. 

public class startPanel extends JPanel {

	private static final long serialVersionUID = 1L;


	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

	
	public startPanel(){
				
		setLayout(null); 
		
		
		
	}
	


}