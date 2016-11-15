package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Client.Controller;

// Contains all the content for the start Screen. 


public class StartPanel extends JPanel {

    private ImageIcon title_Panel_Icon = new ImageIcon(this.getClass().getResource("/Resources/Title_Panel_BG_01.png"));
    private ImageIcon start_Icon = new ImageIcon(this.getClass().getResource("/Resources/Start_Button.png"));
    private ImageIcon exit_Icon = new ImageIcon(this.getClass().getResource("/Resources/Exit_Button.png"));
    private ImageIcon instructions_Icon = new ImageIcon(this.getClass().getResource("/Resources/Instructions_Button.png"));

    private ImageIcon start_Rollover_Icon = new ImageIcon(this.getClass().getResource("/Resources/Start_Rollover_Button.png"));
    private ImageIcon instructions_Rollover_Icon = new ImageIcon(this.getClass().getResource("/Resources/Instructions_Rollover_Button.png"));
    private ImageIcon exit_Rollover_Icon = new ImageIcon(this.getClass().getResource("/Resources/Exit_Rollover_Button.png"));


    private static final long serialVersionUID = 1L;

    public static JButton startButton;
    public static JLabel startBGLabel;
    public static JButton instructionsButton;
    public static JButton exitButton;
    private final Controller controller;

    public StartPanel(Controller c) {
        final StartPanel panel = this;
        this.controller = c;
        this.setLayout(null);

        startButton = new JButton("Start");
        startButton.setOpaque(true);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setBounds(265, 220, 300, 75);
        startButton.setIcon(start_Icon);
        startButton.setRolloverIcon(start_Rollover_Icon);
        add(startButton);

        instructionsButton = new JButton("Instructions");
        instructionsButton.setOpaque(true);
        instructionsButton.setContentAreaFilled(false);
        instructionsButton.setBorderPainted(false);
        instructionsButton.setBounds(170, 320, 500, 75);
        instructionsButton.setIcon(instructions_Icon);
        instructionsButton.setRolloverIcon(instructions_Rollover_Icon);

        add(instructionsButton);


        exitButton = new JButton("Exit");
        exitButton.setOpaque(true);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setBounds(265, 420, 300, 75);
        exitButton.setIcon(exit_Icon);
        exitButton.setRolloverIcon(exit_Rollover_Icon);
        add(exitButton);


        Image title_Panel_Scaled = title_Panel_Icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon title_Panel_Icon = new ImageIcon(title_Panel_Scaled);


        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        startBGLabel = new JLabel();
        startBGLabel.setBounds(0, 0, 800, 600);
        startBGLabel.setIcon(title_Panel_Icon);
        add(startBGLabel);


        //This provides the action for the start button.
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Removes the startFrame and replaces it to the Game board.
                controller.connectToServer();
                controller.showGameBoard();
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Removes the startFrame and replaces it to the InstructionsPanel.
                controller.showInstructionScreen();
            }
        });

    }
}