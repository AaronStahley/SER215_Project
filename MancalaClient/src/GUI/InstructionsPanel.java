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
	
    private ImageIcon instructionsIcon = new ImageIcon(this.getClass().getResource("/resources/directions_Image.png"));

    private JButton StartButton;

    private JScrollPane instructionsScrollPane;
    
    private JLabel instructionsLabel;
    protected Controller controller;

    public InstructionsPanel(Controller c) {
        this.controller = c;
        setLayout(null);
        
        StartButton = new JButton("Start Game");
        StartButton.setBounds(335, 542, 100, 25);
        add(StartButton);

        instructionsScrollPane = new JScrollPane(instructionsLabel = new JLabel(instructionsIcon));
        instructionsScrollPane.setBounds(0, 0, 795, 540);
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
