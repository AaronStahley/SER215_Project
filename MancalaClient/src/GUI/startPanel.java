package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Client.Client;

// Contains all the content for the start Screen. 

public class startPanel extends JPanel {

    private static final long serialVersionUID = 1L;


    public static JButton startButton;
    public static JLabel startBGLabel;
    public static JButton instructionsButton;
    public static JButton exitButton;

    public startPanel() {

        setLayout(null);


        startButton = new JButton("Start");
        startButton.setOpaque(true);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        add(startButton);

        instructionsButton = new JButton("Instructions");
        instructionsButton.setOpaque(true);
        instructionsButton.setContentAreaFilled(false);
        instructionsButton.setBorderPainted(false);
        add(instructionsButton);


        exitButton = new JButton("Exit");
        exitButton.setOpaque(true);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        startBGLabel = new JLabel();
        add(startBGLabel);


        //This provides the action for the start button.
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Removes the startFrame and replaces it to the Game board.
                Client.frame.getContentPane().removeAll();
                Client.frame.getContentPane().add(Client.gbp);
                Client.frame.revalidate(); // refreshes the JFrame.
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Removes the startFrame and replaces it to the instructionsPanel.
                Client.frame.getContentPane().removeAll();
                Client.frame.getContentPane().add(Client.ip);
                Client.frame.revalidate(); // refreshes the JFrame.
            }
        });

    }
}