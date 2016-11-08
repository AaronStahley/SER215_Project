package Client;

import Communication.GameEvent;
import Communication.GameState;
import GUI.*;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;

/**
 * Created by mike on 11/8/16.
 */
public class Client implements Runnable {

    public static JFrame frame;
    public static gameBoardPanel gbp;
    public static startPanel panelStart;
    public static menuBar mb;
    public static resolution res;
    public static instructionsPanel ip;
    public static mancalaClient client;
    private ObjectInputStream fromServer;
    private ObjectOutputStream toServer;

    public Client() {
        try {
            // ------------------------ GUI STUFF ------------------------------//

            // Needed to detect the screen resolution sizes the window to your monitor resolution.

            // Contains all the JFrame attributes.
            mb = new menuBar(this);
            panelStart = new startPanel(this);
            gbp = new gameBoardPanel(this);
            ip = new instructionsPanel(this);
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        // -----------------------------------------------------------------//

    }

    public JFrame getFrame() {
        return this.frame;
    }


    public void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("connected");

            this.toServer = new ObjectOutputStream(socket.getOutputStream());
            this.fromServer = new ObjectInputStream(socket.getInputStream());

        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            // listen for server info
            try {
                GameState gameState = (GameState) this.fromServer.readObject();

                if (gameState.isOpponentLeft()) {

                }

                if (gameState.isGameOver()) {

                }
                
                this.updateState(gameState);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private void updateState(GameState gameState) {
    }
}
