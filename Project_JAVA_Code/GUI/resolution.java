package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import main.Main;

public class resolution {
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	int width;
	int height; 

	public resolution(){
		
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		
	}
	
	public void getRes0(){
		Main.frame.setSize(1920,1080);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes1(){
		Main.frame.setSize(1768,992);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes2(){
		Main.frame.setSize(1680,1050);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes3(){
		Main.frame.setSize(1600,1024);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes4(){
		Main.frame.setSize(1600,900);
		Main.frame.setLocationRelativeTo(null);
		
		gameBoardPanel.bgLabel.setBounds(0, 0, 1600,900);

		gameBoardPanel.pits[0].setBounds(359, 520, 100, 100);
		gameBoardPanel.pits[1].setBounds(515, 520, 100, 100);
		gameBoardPanel.pits[2].setBounds(671, 520, 100, 100);
		gameBoardPanel.pits[3].setBounds(827, 520, 100, 100);
		gameBoardPanel.pits[4].setBounds(983, 520, 100, 100);
		gameBoardPanel.pits[5].setBounds(1139, 520, 100, 100);
		
		gameBoardPanel.pits[6].setBounds(359, 278, 100, 100);
		gameBoardPanel.pits[7].setBounds(515, 278, 100, 100);
		gameBoardPanel.pits[8].setBounds(671, 278, 100, 100);
		gameBoardPanel.pits[9].setBounds(827, 278, 100, 100);
		gameBoardPanel.pits[10].setBounds(983, 278, 100, 100);
		gameBoardPanel.pits[11].setBounds(1139, 278, 100, 100);
		

	}
	
	public void getRes5(){
		Main.frame.setSize(1366,768);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes6(){
		Main.frame.setSize(1360,768);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes7(){
		Main.frame.setSize(1280,1024);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes8(){
		Main.frame.setSize(1280,960);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes9(){
		Main.frame.setSize(1280,800);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes10(){
		Main.frame.setSize(1280,768);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes11(){
		Main.frame.setSize(1280,720);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes12(){
		Main.frame.setSize(1176,664);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes13(){
		Main.frame.setSize(1152,864);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes14(){
		Main.frame.setSize(1024,768);
		Main.frame.setLocationRelativeTo(null);

	}
	
	public void getRes15(){
		Main.frame.setSize(800,600);
		Main.frame.setLocationRelativeTo(null);

	}
	

	
	
	
}
