package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class instructionsPanel extends JPanel{
	
	public static JButton exitButton;
	public static JScrollPane instructionsScrollPane;
	
	private ImageIcon instructionsIcon = new ImageIcon(this.getClass().getResource("directions_Image.png"));


	public instructionsPanel(){
		
		setLayout(null); 
		
		exitButton = new JButton();
		add(exitButton);
		
		// NOT WORKING PROPERLY YET
		instructionsScrollPane = new JScrollPane(new JLabel(instructionsIcon)); 
		instructionsScrollPane.setBounds(0, 0, 795, 550);
		add(instructionsScrollPane); 

	
	}

}