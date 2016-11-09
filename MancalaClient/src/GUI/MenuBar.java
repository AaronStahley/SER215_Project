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

    static JMenuBar menuBar;

    private JMenu fileJM;
    private JMenuItem exitJMI;

    public MenuBar(Controller controller) {
        this.controller = controller;
//        this.setLayout(null);
    }

    public JMenuBar createMenuBar() {

        setLayout(new BorderLayout());

        // --------------- Menu Bar Attributes -----------//
        menuBar = new JMenuBar();
        //MenuBar.setBounds(0, 0,gd.getDisplayMode().getWidth(), 25);
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
