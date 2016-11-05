package GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Main;

public class resolution {
	
	private ImageIcon game_Board_Icon = new ImageIcon(this.getClass().getResource("mancala_GB_01.png"));
	
	private ImageIcon player_01_turn = new ImageIcon(this.getClass().getResource("Player_01_Turn.png"));
//	private ImageIcon player_02_turn = new ImageIcon(this.getClass().getResource("Player_02_Turn.png"));

	
	private ImageIcon stones_04_Image = new ImageIcon(this.getClass().getResource("Mancala_Stones_04.png"));
	
	private ImageIcon title_Panel_Icon = new ImageIcon(this.getClass().getResource("Title_Panel_BG_01.png"));
	private ImageIcon start_Icon = new ImageIcon(this.getClass().getResource("Start_Button.png"));
	private ImageIcon exit_Icon = new ImageIcon(this.getClass().getResource("Exit_Button.png"));
	private ImageIcon instructions_Icon = new ImageIcon(this.getClass().getResource("Instructions_Button.png"));
	
	private ImageIcon start_Rollover_Icon = new ImageIcon(this.getClass().getResource("Start_Rollover_Button.png"));
	private ImageIcon instructions_Rollover_Icon = new ImageIcon(this.getClass().getResource("Instructions_Rollover_Button.png"));
	private ImageIcon exit_Rollover_Icon = new ImageIcon(this.getClass().getResource("Exit_Rollover_Button.png"));
	
	public ImageIcon instructionsIcon = new ImageIcon(this.getClass().getResource("directions_Image.png"));
	
	public static JLabel instructionsLabel;


	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	int width;
	int height; 

	public resolution(){
		
		
		instructionsLabel = new JLabel();
		instructionsLabel.setIcon(instructionsIcon);
		
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
			

		// Scales the title image to 1600/900
		Image title_Panel_Scaled = title_Panel_Icon.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
		ImageIcon title_Panel_Icon = new ImageIcon(title_Panel_Scaled);
	
		startPanel.startBGLabel.setBounds(0, 0, 1600, 900);
		startPanel.startBGLabel.setIcon(title_Panel_Icon);
		
		Image game_Board_Panel_Scaled = game_Board_Icon.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
		ImageIcon game_Board_Icon = new ImageIcon(game_Board_Panel_Scaled);
	
		gameBoardPanel.bgLabel.setBounds(0, 0, 1600, 900);
		gameBoardPanel.bgLabel.setIcon(game_Board_Icon);
	
		
		startPanel.startButton.setBounds(650, 350, 300, 75);
		startPanel.startButton.setIcon(start_Icon);
		startPanel.startButton.setRolloverIcon(start_Rollover_Icon);
		
		startPanel.instructionsButton.setBounds(550,450,500,75);
		startPanel.instructionsButton.setIcon(instructions_Icon);
		startPanel.instructionsButton.setRolloverIcon(instructions_Rollover_Icon);

		
		startPanel.exitButton.setBounds(650,550,300,75);
		startPanel.exitButton.setIcon(exit_Icon);
		startPanel.exitButton.setRolloverIcon(exit_Rollover_Icon);


		for(int i = 0; i < gameBoardPanel.pitButton.length; i++){
			gameBoardPanel.pitButton[i].setIcon(stones_04_Image);
		}
		
		for(int i = 0; i < gameBoardPanel.pitLabel.length; i++){
			gameBoardPanel.pitLabel[i].setIcon(stones_04_Image);
		}
		
		gameBoardPanel.pitButton[0].setBounds(359, 520, 100, 100);
		gameBoardPanel.pitButton[1].setBounds(515, 520, 100, 100);
		gameBoardPanel.pitButton[2].setBounds(671, 520, 100, 100);
		gameBoardPanel.pitButton[3].setBounds(827, 520, 100, 100);
		gameBoardPanel.pitButton[4].setBounds(983, 520, 100, 100);
		gameBoardPanel.pitButton[5].setBounds(1139, 520, 100, 100);
		
		gameBoardPanel.pitLabel[0].setBounds(359, 278, 100, 100);
		gameBoardPanel.pitLabel[1].setBounds(515, 278, 100, 100);
		gameBoardPanel.pitLabel[2].setBounds(671, 278, 100, 100);
		gameBoardPanel.pitLabel[3].setBounds(827, 278, 100, 100);
		gameBoardPanel.pitLabel[4].setBounds(983, 278, 100, 100);
		gameBoardPanel.pitLabel[5].setBounds(1139, 278, 100, 100);
		

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
		
		//This is all the stuff for the title_Panel
		
		// Scales the title image to 800/600
		Image title_Panel_Scaled = title_Panel_Icon.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
		ImageIcon title_Panel_Icon = new ImageIcon(title_Panel_Scaled);
	
		startPanel.startBGLabel.setBounds(0, 0, 1024, 768);
		startPanel.startBGLabel.setIcon(title_Panel_Icon);
	
		
		startPanel.startButton.setBounds(375, 280, 300, 75);
		startPanel.startButton.setIcon(start_Icon);
		startPanel.startButton.setRolloverIcon(start_Rollover_Icon);
		
		startPanel.instructionsButton.setBounds(275,380,500,75);
		startPanel.instructionsButton.setIcon(instructions_Icon);
		startPanel.instructionsButton.setRolloverIcon(instructions_Rollover_Icon);

		
		startPanel.exitButton.setBounds(375,480,300,75);
		startPanel.exitButton.setIcon(exit_Icon);
		startPanel.exitButton.setRolloverIcon(exit_Rollover_Icon);

		//---------------------------------------------------------------//
		
		
		// This is all the stuff for the game_Board_Panel 
		Image game_Board_Panel_Scaled = game_Board_Icon.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
		ImageIcon new_game_Board_Icon = new ImageIcon(game_Board_Panel_Scaled);
	
		gameBoardPanel.bgLabel.setBounds(0, 0, 1024, 768);
		gameBoardPanel.bgLabel.setIcon(new_game_Board_Icon);
		
		Image stones_04_Scaled = stones_04_Image.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon stones_04_Icon = new ImageIcon(stones_04_Scaled);
		
		for(int i = 0; i < gameBoardPanel.pitButton.length; i++){
			gameBoardPanel.pitButton[i].setIcon(stones_04_Icon);
		}
		
		for(int i = 0; i < gameBoardPanel.pitLabel.length; i++){
			gameBoardPanel.pitLabel[i].setIcon(stones_04_Icon);
		}
		
		gameBoardPanel.pitButton[0].setBounds(226, 453, 70, 70);
		gameBoardPanel.pitButton[1].setBounds(326, 453, 70, 70);
		gameBoardPanel.pitButton[2].setBounds(426, 453, 70, 70);
		gameBoardPanel.pitButton[3].setBounds(526, 453, 70, 70);
		gameBoardPanel.pitButton[4].setBounds(626, 453, 70, 70);
		gameBoardPanel.pitButton[5].setBounds(726, 453, 70, 70);
		
		gameBoardPanel.pitLabel[0].setBounds(226, 243, 70, 70);
		gameBoardPanel.pitLabel[1].setBounds(326, 243, 70, 70);
		gameBoardPanel.pitLabel[2].setBounds(426, 243, 70, 70);
		gameBoardPanel.pitLabel[3].setBounds(526, 243, 70, 70);
		gameBoardPanel.pitLabel[4].setBounds(626, 243, 70, 70);
		gameBoardPanel.pitLabel[5].setBounds(726, 243, 70, 70);
		
		//--------------------------------------------------------//

	}
	
	public void getRes15(){
		Main.frame.setSize(800,600);
		Main.frame.setLocationRelativeTo(null);

		
		//This is all the stuff for the title_Panel
		
		// Scales the title image to 800/600
		Image title_Panel_Scaled = title_Panel_Icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon title_Panel_Icon = new ImageIcon(title_Panel_Scaled);
	
		startPanel.startBGLabel.setBounds(0, 0, 800, 600);
		startPanel.startBGLabel.setIcon(title_Panel_Icon);
	
		
		startPanel.startButton.setBounds(265, 220, 300, 75);
		startPanel.startButton.setIcon(start_Icon);
		startPanel.startButton.setRolloverIcon(start_Rollover_Icon);
		
		startPanel.instructionsButton.setBounds(170,320,500,75);
		startPanel.instructionsButton.setIcon(instructions_Icon);
		startPanel.instructionsButton.setRolloverIcon(instructions_Rollover_Icon);

		
		startPanel.exitButton.setBounds(265,420,300,75);
		startPanel.exitButton.setIcon(exit_Icon);
		startPanel.exitButton.setRolloverIcon(exit_Rollover_Icon);

		//---------------------------------------------------------------//
		
		
		// This is all the stuff for the game_Board_Panel 
		Image game_Board_Panel_Scaled = game_Board_Icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon new_game_Board_Icon = new ImageIcon(game_Board_Panel_Scaled);
	
		gameBoardPanel.bgLabel.setBounds(0, 0, 800, 600);
		gameBoardPanel.bgLabel.setIcon(new_game_Board_Icon);
		
		Image stones_04_Scaled = stones_04_Image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon stones_04_Icon = new ImageIcon(stones_04_Scaled);
		
		
		gameBoardPanel.playerTurn.setBounds(150, 30, 500, 75);
		gameBoardPanel.playerTurn.setIcon(player_01_turn);		
		
		gameBoardPanel.mancalaLeft.setBounds(112, 200, 50, 200);
		gameBoardPanel.mancalaRight.setBounds(640, 200, 50, 200);

		
		for(int i = 0; i < gameBoardPanel.pitButton.length; i++){
			gameBoardPanel.pitButton[i].setIcon(stones_04_Icon);
		}
		
		for(int i = 0; i < gameBoardPanel.pitLabel.length; i++){
			gameBoardPanel.pitLabel[i].setIcon(stones_04_Icon);
		}
		
		gameBoardPanel.pitButton[0].setBounds(179, 355, 50, 50);
		gameBoardPanel.pitButton[1].setBounds(257, 355, 50, 50);
		gameBoardPanel.pitButton[2].setBounds(335, 355, 50, 50);
		gameBoardPanel.pitButton[3].setBounds(413, 355, 50, 50);
		gameBoardPanel.pitButton[4].setBounds(491, 355, 50, 50);
		gameBoardPanel.pitButton[5].setBounds(569, 355, 50, 50);
		
		gameBoardPanel.pitLabel[0].setBounds(179, 192, 50, 50);
		gameBoardPanel.pitLabel[1].setBounds(257, 192, 50, 50);
		gameBoardPanel.pitLabel[2].setBounds(335, 192, 50, 50);
		gameBoardPanel.pitLabel[3].setBounds(413, 192, 50, 50);
		gameBoardPanel.pitLabel[4].setBounds(491, 192, 50, 50);
		gameBoardPanel.pitLabel[5].setBounds(569, 192, 50, 50);
		
		gameBoardPanel.pitNumberLabel[0].setBounds(200, 320, 15, 15); 
		gameBoardPanel.pitNumberLabel[1].setBounds(275, 320, 10, 10); 
		gameBoardPanel.pitNumberLabel[2].setBounds(355, 320, 10, 10); 
		gameBoardPanel.pitNumberLabel[3].setBounds(435, 320, 10, 10); 
		gameBoardPanel.pitNumberLabel[4].setBounds(515, 320, 10, 10); 
		gameBoardPanel.pitNumberLabel[5].setBounds(590, 320, 10, 10); 
		gameBoardPanel.pitNumberLabel[6].setBounds(200, 270, 10, 10); 
		gameBoardPanel.pitNumberLabel[7].setBounds(275, 270, 10, 10); 
		gameBoardPanel.pitNumberLabel[8].setBounds(355, 270, 10, 10); 
		gameBoardPanel.pitNumberLabel[9].setBounds(435, 270, 10, 10); 
		gameBoardPanel.pitNumberLabel[10].setBounds(515, 270, 10, 10); 
		gameBoardPanel.pitNumberLabel[11].setBounds(590, 270, 10, 10); 

		//--------------------------------------------------------//
		
		//-------------------Instructions Panel ------------------// 
		
		
		
		instructionsPanel.StartButton.setBounds(335,520,100,25);
		
		
		
		//--------------------------------------------------------//

	
					
	
	}
	
	
	
	
	
	
}
