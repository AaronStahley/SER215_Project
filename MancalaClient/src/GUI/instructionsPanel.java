package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Client.Client;


public class instructionsPanel extends JPanel {

    public static JButton StartButton;

    public static JScrollPane instructionsScrollPane;
    protected Client client;

    public instructionsPanel(Client c) {
        this.client = c;
        setLayout(null);

        StartButton = new JButton("Start Game");
        add(StartButton);

        instructionsScrollPane = new JScrollPane(resolution.instructionsLabel);
        instructionsScrollPane.setBounds(0, 0, 795, 520);
        instructionsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        instructionsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        instructionsScrollPane.setMaximumSize(getSize());
        add(instructionsScrollPane);

        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.frame.getContentPane().removeAll();
                client.frame.getContentPane().add(Client.gbp);
                client.frame.revalidate(); // refreshes the JFrame.

            }
        });


    }

}
