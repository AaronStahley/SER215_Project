package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import main.Main;


public class instructionsPanel extends JPanel{
	
	public static JButton StartButton;
	
	public static JScrollPane instructionsScrollPane;

	public instructionsPanel(){
		
		setLayout(null ); 
		
		StartButton = new JButton("Start Game");
		add(StartButton);
	
		instructionsScrollPane = new JScrollPane(resolution.instructionsLabel); 
		instructionsScrollPane.setBounds(0, 0, 795, 520);
		instructionsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		instructionsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		instructionsScrollPane.setMaximumSize(getSize());
		add(instructionsScrollPane);
		
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Main.frame.getContentPane().removeAll();
				Main.frame.getContentPane().add(Main.gbp);
				Main.frame.revalidate(); // refreshes the JFrame. 
		
			}
		});
		

	
	}

}
