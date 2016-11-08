package Client;

import java.io.IOException.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class mancalaClient extends Socket
        implements Runnable {

    public static int PLAYER1 = 1;
    public static int PLAYER2 = 1;
    public static int PLAYER1_WON = 1;
    public static int PLAYER2_WON = 2;

    private int pileSelected;

    private DataInputStream fromServer;
    private DataOutputStream toServer;

    private boolean keepPlaying = true;

    private boolean waiting = true;

    public boolean isStandAlone = false;

    public String host = "localhost";

    public void init() {

        connectToServer();

    }

    private void connectToServer() {
        try {
            Socket socket = new Socket(host, 8000);
            System.out.println("connected");

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            int player = fromServer.readInt();

            if (player == PLAYER1) {
                //	jlblTitle.setText("Player 1");
                //	jlblStatus.setText("Waiting for player 2 to join");

                fromServer.readInt();

                //	jlblStatus.setText("Player 2 has joined, I go first");

                myTurn = true;
            } else if (player == PLAYER2) {
                //	jlblTitle.setText("Player 2");
                //		jlblStatus.setText("Waiting for player 1 to move");
            }

            while (keepPlaying) {
                if (player == PLAYER1) {
                    waitForPlayerAction();
                    sendMove();
                    receiveInfoFromServer();
                } else if (player == PLAYER2) {
                    receiveInfoFromServer();
                    waitForPlayerAction();
                    sendMove();
                }
            }
        } catch (Exception ex) {

        }
    }

    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }

        waiting = true;
    }

    private void sendMove() throws IOException {
        toServer.writeInt(pileSelected);
    }

    private void receiveInfoFromServer() throws IOException {
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            keepPlaying = false;
            //	jlblStatus.setText("Player 1 Won!");
            receiveMove();
        } else if (status == PLAYER2_WON) {
            keepPlaying = false;
            //	jlblStatus.setText("Player 2 Won!");
            receiveMove();
        }
    }

    private void receiveMove() throws IOException {
        int pileSelected = fromServer.readInt();
    }

    public class Pile extends JPanel {
        private int pile;

        public Pile(int pileNum) {
            pileSelected = pileNum;
            //	addMouseListener(new ClickListener());
        }

        public int getPile() {
            return pileSelected;
        }

        public void setPile(int pileNum) {
            this.pile = pileSelected;
        }

        private class ClickListener extends MouseAdapter {
            public void mouseClicked(MouseEvent e) {
                setPile(pileSelected);
                myTurn = false;
                //	jlblStatus.setText("Waiting for the other player to move");
                waiting = false;
            }
        }
    }

}