package GUI;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameBoardPanel extends JPanel {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private ImageIcon game_Board_Icon = new ImageIcon(this.getClass().getResource("/resources/mancala_GB_01.png"));


    public static JLabel bgLabel;

    public static JButton[] pitButton = new JButton[6];
    public static JLabel[] pitLabel = new JLabel[6];

    public static JLabel[] pitNumberLabel = new JLabel[12];

    public static JLabel mancalaLeftCountLabel;
    public static JLabel mancalaRightCountLabel;

    public static JLabel mancalaLeft;
    public static JLabel mancalaRight;

    public static JLabel playerTurn;

    
    private ImageIcon player_01_turn = new ImageIcon(this.getClass().getResource("/resources/Player_01_Turn.png"));
    private ImageIcon player_02_turn = new ImageIcon(this.getClass().getResource("/resources/Player_02_Turn.png"));
    
    
    private ImageIcon stones_04_Image = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_04.png"));

    public ImageIcon mancala_Stones_Icon_01 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_01.png"));
    public ImageIcon mancala_Stones_Icon_02 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_02.png"));
    public ImageIcon mancala_Stones_Icon_03 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_03.png"));
    public ImageIcon mancala_Stones_Icon_04 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_04.png"));
    public ImageIcon mancala_Stones_Icon_05 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_05.png"));
    public ImageIcon mancala_Stones_Icon_06 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_06.png"));
    public ImageIcon mancala_Stones_Icon_07 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_07.png"));
    public ImageIcon mancala_Stones_Icon_08 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_08.png"));
    public ImageIcon mancala_Stones_Icon_09 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_09.png"));
    public ImageIcon mancala_Stones_Icon_10 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_10.png"));
    public ImageIcon mancala_Stones_Icon_11 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_11.png"));
    public ImageIcon mancala_Stones_Icon_12 = new ImageIcon(this.getClass().getResource("/resources/Player_Mancala_Stones_12.png"));

    public ImageIcon pit_Stones_Icon_01 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_01.png"));
    public ImageIcon pit_Stones_Icon_02 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_02.png"));
    public ImageIcon pit_Stones_Icon_03 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_03.png"));
    public ImageIcon pit_Stones_Icon_04 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_04.png"));
    public ImageIcon pit_Stones_Icon_05 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_05.png"));
    public ImageIcon pit_Stones_Icon_06 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_06.png"));
    public ImageIcon pit_Stones_Icon_07 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_07.png"));
    public ImageIcon pit_Stones_Icon_08 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_08.png"));
    public ImageIcon pit_Stones_Icon_09 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_09.png"));
    public ImageIcon pit_Stones_Icon_10 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_10.png"));
    public ImageIcon pit_Stones_Icon_11 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_11.png"));
    public ImageIcon pit_Stones_Icon_12 = new ImageIcon(this.getClass().getResource("/resources/Mancala_Stones_12.png"));


    public gameBoardPanel() throws MalformedURLException, IOException {

        setLayout(null);
        
        Image game_Board_Panel_Scaled = game_Board_Icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon new_game_Board_Icon = new ImageIcon(game_Board_Panel_Scaled);
        
       
        Image stones_04_Scaled = stones_04_Image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon stones_04_Icon = new ImageIcon(stones_04_Scaled);
        

        playerTurn = new JLabel("Player Turn");

        add(playerTurn);

        mancalaLeft = new JLabel();
        add(mancalaLeft);

        mancalaRight = new JLabel();
        add(mancalaRight);

        mancalaLeftCountLabel = new JLabel("0");
        mancalaLeftCountLabel.setForeground(Color.WHITE);
        add(mancalaLeftCountLabel);

        mancalaRightCountLabel = new JLabel("0");
        mancalaRightCountLabel.setForeground(Color.WHITE);
        add(mancalaRightCountLabel);

        pitButton[0] = new JButton();
        pitButton[1] = new JButton();
        pitButton[2] = new JButton();
        pitButton[3] = new JButton();
        pitButton[4] = new JButton();
        pitButton[5] = new JButton();

        pitLabel[0] = new JLabel();
        pitLabel[1] = new JLabel();
        pitLabel[2] = new JLabel();
        pitLabel[3] = new JLabel();
        pitLabel[4] = new JLabel();
        pitLabel[5] = new JLabel();

        pitNumberLabel[0] = new JLabel("4");
        pitNumberLabel[1] = new JLabel("4");
        pitNumberLabel[2] = new JLabel("4");
        pitNumberLabel[3] = new JLabel("4");
        pitNumberLabel[4] = new JLabel("4");
        pitNumberLabel[5] = new JLabel("4");
        pitNumberLabel[6] = new JLabel("4");
        pitNumberLabel[7] = new JLabel("4");
        pitNumberLabel[8] = new JLabel("4");
        pitNumberLabel[9] = new JLabel("4");
        pitNumberLabel[10] = new JLabel("4");
        pitNumberLabel[11] = new JLabel("4");

        for (int i = 0; i < pitButton.length; i++) {
            pitButton[i].setOpaque(true);
            pitButton[i].setContentAreaFilled(false);
            pitButton[i].setBorderPainted(false);
        }

        for (int i = 0; i < pitNumberLabel.length; i++) {
            pitNumberLabel[i].setForeground(Color.WHITE);
        }


        for (int i = 0; i < pitNumberLabel.length; i++) {

            add(pitNumberLabel[i]);
        }

        for (int i = 0; i < pitButton.length; i++) {

            add(pitButton[i]);
        }
        for (int i = 0; i < pitLabel.length; i++) {
            add(pitLabel[i]);
        }


        bgLabel = new JLabel();
        add(bgLabel);
        
        
        gameBoardPanel.playerTurn.setBounds(150, 30, 500, 75);
        gameBoardPanel.playerTurn.setIcon(player_01_turn);

        gameBoardPanel.mancalaLeft.setBounds(112, 200, 50, 200);
        gameBoardPanel.mancalaRight.setBounds(640, 200, 50, 200);

        gameBoardPanel.mancalaLeftCountLabel.setBounds(158, 175, 15, 15);

        gameBoardPanel.mancalaRightCountLabel.setBounds(632, 410, 15, 15);

        for (int i = 0; i < gameBoardPanel.pitButton.length; i++) {
           pitButton[i].setIcon(stones_04_Icon);
        }

        for (int i = 0; i < gameBoardPanel.pitLabel.length; i++) {
          pitLabel[i].setIcon(stones_04_Icon);
        }
        
        gameBoardPanel.bgLabel.setBounds(0, 0, 800, 600);
        gameBoardPanel.bgLabel.setIcon(new_game_Board_Icon);


        pitButton[0].setBounds(179, 355, 50, 50);
        pitButton[1].setBounds(257, 355, 50, 50);
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


    }
    


}