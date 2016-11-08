package GUI;

import Client.Client;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class menuBar extends JPanel {

    private final Client client;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    static JMenuBar menuBar;

    private JMenu fileJM;
    private JMenuItem exitJMI;

    public menuBar(Client client) {
        this.client = client;
    }

    public JMenuBar createMenuBar() {

        setLayout(new BorderLayout());

        // --------------- Menu Bar Attributes -----------//
        menuBar = new JMenuBar();
        //menuBar.setBounds(0, 0,gd.getDisplayMode().getWidth(), 25);
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
        event e = new event();
        exitJMI.addActionListener(e);

        // ---------------------------------------//

    
		return null;
    

    }

    // Implements the actionListner for buttons and menu bar items.
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
