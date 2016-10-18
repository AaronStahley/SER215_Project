package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameBoardPanel extends JPanel{
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
    GridBagConstraints c = new GridBagConstraints();
	
	private ImageIcon bgImage = new ImageIcon(this.getClass().getResource("mancala_GB.jpg"));
	
	private JLabel bgLabel; 
	
	public gameBoardPanel() throws MalformedURLException, IOException{
		
		setLayout(new GridBagLayout());
		 
		Image scaledImage = bgImage.getImage().getScaledInstance(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight(), Image.SCALE_DEFAULT);

		bgImage.setImage(scaledImage);
		c.gridx = 0; 
		c.gridy = 0; 
		bgLabel = new JLabel(bgImage); 
		add(bgLabel,c); 
	
	}

}
