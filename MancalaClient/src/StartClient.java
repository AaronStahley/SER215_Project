import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;

import Client.mancalaClient;
import GUI.*;
//import GUI.menuBar;
//import GUI.startPanel;

public class StartClient {

    public static JFrame frame;
    public static gameBoardPanel gbp;
    public static startPanel panelStart;
    public static menuBar mb;
    public static resolution res;
    public static instructionsPanel ip;
    public static mancalaClient client;

    public static void main(String[] args) throws MalformedURLException, IOException {

        // ------------------------ GUI STUFF ------------------------------//

        // Needed to detect the screen resolution sizes the window to your monitor resolution.

        // Contains all the JFrame attributes.
        mb = new menuBar();
        panelStart = new startPanel();
        gbp = new gameBoardPanel();
        ip = new instructionsPanel();


        // Client stuff
        client = new mancalaClient();
        client.isStandAlone = true;

        if (args.length == 1) {
            client.host = args[0];
        }

        client.init();
        // ----------------------//


        res = new resolution();


        frame = new JFrame("Mancala");

        frame.setLocationRelativeTo(null);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-------- Adding components to the JFrame ------------//

        // Adds the menuBar to the frame
        frame.setJMenuBar(mb.createMenuBar());

        //Adds the startPanel to the frame
        frame.getContentPane().add(panelStart);

        // Sets the panel size to the resolution of the monitor
        //frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());


        frame.setVisible(true);
        res.getRes15();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        // -----------------------------------------------------------------//


    }

}