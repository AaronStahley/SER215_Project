package Client;

import Communication.GameEvent;
import Communication.GameState;
import GUI.*;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by mike on 11/8/16.
 */
public class Controller implements Runnable {

    private JFrame frame;
    private GameBoardPanel gbp;
    private StartPanel panelStart;
    private MenuBar mb;
    private InstructionsPanel ip;
    private ObjectInputStream fromServer;
    private ObjectOutputStream toServer;
    private EndGamePanel egp;
    private boolean reconnect = false;

    public Controller() {
        try {
            // ------------------------ GUI STUFF ------------------------------//

            this.frame = new JFrame("Mancala");
            this.frame.setLocationRelativeTo(null);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //-------- Adding components to the JFrame ------------//

            // Adds the MenuBar to the frame
            this.frame.setSize(800, 600);
            this.frame.setLocationRelativeTo(null);
            this.frame.setResizable(false);


            // Contains all the JFrame attributes.
            this.mb = new MenuBar(this);
            this.panelStart = new StartPanel(this);
            this.gbp = new GameBoardPanel(this);
            this.ip = new InstructionsPanel(this);
            this.egp = new EndGamePanel(this);

            // ----------------------//

            //Adds the StartPanel to the frame
            this.frame.setJMenuBar(mb.createMenuBar());
            this.frame.getContentPane().add(panelStart);
            this.frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // -----------------------------------------------------------------//
    }

    public JFrame getFrame() {
        return this.frame;
    }


    private void showPanel(JPanel panel) {
        this.getFrame().getContentPane().removeAll();
        this.getFrame().getContentPane().add(panel);
        this.getFrame().revalidate(); // refreshes the JFrame.
        this.getFrame().repaint();
    }

    public void showGameBoard() {
        this.showPanel(this.gbp);
    }

    public void showStartScreen() {
        this.showPanel(this.panelStart);
    }

    public void showInstructionScreen() {
        this.showPanel(this.ip);
    }

    public void showEndScreen() {
        this.showPanel(this.egp);
    }


    public void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 8000);

            this.fromServer = new ObjectInputStream(socket.getInputStream());
            this.toServer = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("connected");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    public void sendToServer(GameEvent event) throws IOException {
        System.out.println(" -- Sending info to server");
        this.toServer.reset();
        this.toServer.writeObject(event);
    }

    public void run() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            // listen for server info
            try {
                System.out.println(" -- Waiting for server to send info");
                GameState gameState = (GameState) this.fromServer.readObject();

                System.out.println(" - New State:");
                System.out.print("  * Your Label: ");
                System.out.println(gameState.getYourLabel());

                System.out.print("  * Your Store: ");
                System.out.println(gameState.getYourStore());

                System.out.print("  * Your Pits: ");
                System.out.println(Arrays.toString(gameState.getYourPits()));

                System.out.print("  * Opponents Label: ");
                System.out.println(gameState.getOpponentsLabel());

                System.out.print("  * Opponents Store: ");
                System.out.println(gameState.getOpponentsStore());

                System.out.print("  * Opponents Pits: ");
                System.out.println(Arrays.toString(gameState.getOpponentsPits()));

                System.out.print("  * Your Turn: ");
                System.out.println(gameState.isYourTurn());

                System.out.print("  * Is Game Over: ");
                System.out.println(gameState.isGameOver());

                System.out.print("  * Opponent Left: ");
                System.out.println(gameState.isOpponentLeft());

                System.out.print("  * You Won: ");
                System.out.println(gameState.isYouWin());

                keepPlaying = this.updateState(gameState);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            this.fromServer.close();
            this.toServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (reconnect) {
            reconnect = false;
            this.playAgain();

        }
    }

    public void playAgain() {
        try {
            this.gbp = new GameBoardPanel(this);
            this.connectToServer();
            this.showGameBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean updateState(GameState gameState) {
        boolean keepPlaying = true;

        if (gameState.isOpponentLeft()) {
            keepPlaying = false;
            reconnect = true;
        }

        if (gameState.isGameOver()) {
            keepPlaying = false;
        }

        this.gbp.updateState(gameState);

        this.frame.repaint();
        return keepPlaying;
    }

}
