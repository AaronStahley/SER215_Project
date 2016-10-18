package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameBoardPanel extends JPanel{
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	private ImageIcon bgImage = new ImageIcon(this.getClass().getResource("mancala_GB.jpg"));
	
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
			
			add(pits[i]);
		}
		 
		Image scaledImage = getBgImage().getImage().getScaledInstance(1600,900, Image.SCALE_DEFAULT);
		
		getBgImage().setImage(scaledImage);
		bgLabel = new JLabel(getBgImage()); 
		add(bgLabel); 
		
	
	}

	public ImageIcon getBgImage() {
		return bgImage;
	}

	public void setBgImage(ImageIcon bgImage) {
		this.bgImage = bgImage;
	}

}