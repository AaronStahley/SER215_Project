package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class instructionsPanel extends JPanel{
	
	public static JButton exitButton;
	
	public static JScrollPane instructionsScrollPane;


	public instructionsPanel(){
		
		setLayout(null); 
		
		exitButton = new JButton();
		add(exitButton);
		
		// NOT WORKING PROPERLY YET
		instructionsScrollPane = new JScrollPane(resolution.instructionsLabel); 
		instructionsPanel.instructionsScrollPane.setBounds(0, 0, 795, 550);
		add(instructionsScrollPane);


	
	}

}
