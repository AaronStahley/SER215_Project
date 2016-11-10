package GUI;

import Client.Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBar extends JPanel {

    private final Controller controller;

    private JMenuBar menuBar;

    private JMenu fileJM;
    private JMenuItem exitJMI;

    public MenuBar(Controller controller) {
        this.controller = controller;
        this.setLayout(null);
    }

    public JMenuBar createMenuBar() {

        setLayout(null);

        // --------------- Menu Bar Attributes -----------//
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 800, 25);
        menuBar.setVisible(true);
        add(menuBar);


        // -----File menu bar item Attributes ----//

        // Creates the File button in the menu bar
        fileJM = new JMenu(" File ");
        fileJM.setRolloverEnabled(true);
        menuBar.add(fileJM);

        // Exit button in the file menu bar button.
        exitJMI = new JMenuItem(" Exit ");
        fileJM.add(exitJMI);
        exitJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ---------------------------------------//
        return null;
    }

}
