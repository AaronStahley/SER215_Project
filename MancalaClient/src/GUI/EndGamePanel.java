package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Client.Controller;
import Communication.GameState;

public class EndGamePanel extends JPanel {

    private Controller controller;
    private ImageIcon background_Icon = new ImageIcon(this.getClass().getResource("/resources/End_Panel_BG.png"));
    private ImageIcon win_Icon = new ImageIcon(this.getClass().getResource("/resources/You_Win.png"));
    private ImageIcon lose_Icon = new ImageIcon(this.getClass().getResource("/resources/You_Lose.png"));
    private ImageIcon tie_Icon = new ImageIcon(this.getClass().getResource("/resources/You_Tied.png"));
    private ImageIcon play_Again_Icon = new ImageIcon(this.getClass().getResource("/resources/Play_Again.png"));
    private ImageIcon play_Again_Hover_Icon = new ImageIcon(this.getClass().getResource("/resources/Play_Again_Hover.png"));
    private ImageIcon exit_Icon = new ImageIcon(this.getClass().getResource("/resources/Final_Exit_Image.png"));
    private ImageIcon exit_Hover_Icon = new ImageIcon(this.getClass().getResource("/resources/Final_Exit_Image_Hover.png"));


	private JLabel backGroundLabel;
    private JLabel winLoseLabel;
    private JButton exitButton; 
    public JButton playAgainButton;
    

    public EndGamePanel(Controller ctr) {
    	this.controller = ctr;
    	setLayout(null); 

        this.winLoseLabel = new JLabel();
        this.winLoseLabel.setBounds(91,32,619,149);
      //  this.winLoseLabel.setIcon(win_Icon);
        this.add(winLoseLabel);

        this.playAgainButton = new JButton();
        this.playAgainButton.setBounds(186,261,428,78);
        this.playAgainButton.setBackground(null);
        this.playAgainButton.setContentAreaFilled(false);
        this.playAgainButton.setBorderPainted(false);
        this.playAgainButton.setOpaque(false);
        this.playAgainButton.setRolloverIcon(play_Again_Hover_Icon);
        this.playAgainButton.setIcon(play_Again_Icon);
        this.add(playAgainButton);
        
        this.exitButton = new JButton();
        this.exitButton.setBounds(308,406,178,82);
        this.exitButton.setBackground(null);
        this.exitButton.setContentAreaFilled(false);
        this.exitButton.setBorderPainted(false);
        this.exitButton.setOpaque(false);
        this.exitButton.setRolloverIcon(exit_Hover_Icon);
        this.exitButton.setIcon(exit_Icon);
        this.add(exitButton); 

        this.backGroundLabel = new JLabel();
        this.backGroundLabel.setBounds(0, 0, 800, 600);
        this.backGroundLabel.setIcon(background_Icon);
        this.add(backGroundLabel);
        
        this.playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.playAgain();
            }
        });

        this.exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
    
}
