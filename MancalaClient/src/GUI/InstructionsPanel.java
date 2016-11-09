package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Client.Controller;


public class InstructionsPanel extends JPanel {
	
    public ImageIcon instructionsIcon = new ImageIcon(this.getClass().getResource("/resources/directions_Image.png"));

    public static JButton StartButton;

    public static JScrollPane instructionsScrollPane;
    
    public static JLabel instructionsLabel;
    protected Controller controller;

    public InstructionsPanel(Controller c) {
        this.controller = c;
        setLayout(null);
        
        



        StartButton = new JButton("Start Game");
        InstructionsPanel.StartButton.setBounds(335, 520, 100, 25);
        add(StartButton);

        instructionsScrollPane = new JScrollPane(instructionsLabel = new JLabel());
        instructionsScrollPane.setBounds(0, 0, 795, 520);
        instructionsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        instructionsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        instructionsScrollPane.setMaximumSize(getSize());
        add(instructionsScrollPane);
        
        instructionsLabel.setIcon(instructionsIcon);

        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getFrame().getContentPane().removeAll();
                controller.getFrame().getContentPane().add(controller.getGbp());
                controller.getFrame().revalidate(); // refreshes the JFrame.

            }
        });


    }

}
