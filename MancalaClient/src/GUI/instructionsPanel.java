package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Client.Client;


public class instructionsPanel extends JPanel {
	
    public ImageIcon instructionsIcon = new ImageIcon(this.getClass().getResource("/resources/directions_Image.png"));

    public static JButton StartButton;

    public static JScrollPane instructionsScrollPane;
    
    public static JLabel instructionsLabel;
    protected Client client;

    public instructionsPanel(Client c) {
        this.client = c;
        setLayout(null);
        
        



        StartButton = new JButton("Start Game");
        instructionsPanel.StartButton.setBounds(335, 520, 100, 25);
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
                client.frame.getContentPane().removeAll();
                client.frame.getContentPane().add(Client.gbp);
                client.frame.revalidate(); // refreshes the JFrame.

            }
        });


    }

}
