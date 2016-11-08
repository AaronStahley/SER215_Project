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
    private JMenu displayJM;
    private JMenu resolutionJM;
    private JMenuItem exitJMI;

    private resolution res = new resolution();

    private JMenuItem[] resolutionsJMI = new JMenuItem[16];// creates an array of JMenuItems

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

        // -- Settings menu bar item Attributes --//

        // Creates the Settings button in the menu bar.
        displayJM = new JMenu(" Display ");
        displayJM.setRolloverEnabled(true);
        menuBar.add(displayJM);

        // Resolution Button in the settings menu bar button.
        resolutionJM = new JMenu(" Resolution ");
        resolutionJM.setRolloverEnabled(true);
        displayJM.add(resolutionJM);

        // Creates all the JMenu Items for the resolutions.
        resolutionsJMI[0] = new JMenuItem(" 1920 x 1080 ");
        resolutionsJMI[1] = new JMenuItem(" 1768 x 992 ");
        resolutionsJMI[2] = new JMenuItem(" 1680 x 1050 ");
        resolutionsJMI[3] = new JMenuItem(" 1600 x 1024 ");
        resolutionsJMI[4] = new JMenuItem(" 1600 x 900 ");
        resolutionsJMI[5] = new JMenuItem(" 1366 x 768 ");
        resolutionsJMI[6] = new JMenuItem(" 1360 x 768 ");
        resolutionsJMI[7] = new JMenuItem(" 1280 x 1024 ");
        resolutionsJMI[8] = new JMenuItem(" 1280 x 960 ");
        resolutionsJMI[9] = new JMenuItem(" 1280 x 800 ");
        resolutionsJMI[10] = new JMenuItem(" 1280 x 768 ");
        resolutionsJMI[11] = new JMenuItem(" 1280 x 720 ");
        resolutionsJMI[12] = new JMenuItem(" 1176 x 664 ");
        resolutionsJMI[13] = new JMenuItem(" 1152 x 864 ");
        resolutionsJMI[14] = new JMenuItem(" 1024 x 768 ");
        resolutionsJMI[15] = new JMenuItem(" 800 x 600 ");

        // ------ All action Listeners for resolutionsJMI -------//

        resolutionsJMI[0].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                res.getRes0();
            }
        });
        resolutionsJMI[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes1();
            }
        });
        resolutionsJMI[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes2();
            }
        });
        resolutionsJMI[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes3();
            }
        });
        resolutionsJMI[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes4();
            }
        });
        resolutionsJMI[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes5();
            }
        });
        resolutionsJMI[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes6();
            }
        });
        resolutionsJMI[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes7();
            }
        });
        resolutionsJMI[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes8();
            }
        });
        resolutionsJMI[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes9();
            }
        });
        resolutionsJMI[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes10();
            }
        });
        resolutionsJMI[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes11();
            }
        });
        resolutionsJMI[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes12();
            }
        });
        resolutionsJMI[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes13();
            }
        });
        resolutionsJMI[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes14();
            }
        });
        resolutionsJMI[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.getRes15();
            }
        });

        //----------------------------------------------------------//

        for (int i = 0; i < resolutionsJMI.length; i++) {

            resolutionsJMI[0].setRolloverEnabled(true);
            resolutionJM.add(resolutionsJMI[i]);
        }
        return menuBar;


    }

    // Implements the actionListner for buttons and menu bar items.
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
