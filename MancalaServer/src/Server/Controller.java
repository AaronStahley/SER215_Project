package Server;

import Communication.GameState;
import GameSession.Game;
import GameSession.Player;
import Utilites.ServerSocket;
import Utilites.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


/**
 * Created by mike on 10/22/16.
 */
public class Controller {

    private static Map<String, Thread> gameSessions = new HashMap<String, Thread>();

    public Controller() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.add(new JLabel("Server"), BorderLayout.NORTH);

        JTextArea ta = new JTextArea();
        TextAreaOutputStream taos = new TextAreaOutputStream(ta, 60);
        PrintStream ps = new PrintStream(taos);
        System.setOut(ps);
        System.setErr(ps);

        frame.add(new JScrollPane(ta));

        frame.pack();
        frame.setVisible(true);

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            // Ready to create a session for every two players
            while (true) {
                System.out.println("Creating new game session:");

                // Connect to player 1
                Player player1 = serverSocket.acceptPlayer();
                player1.setState(new GameState("Player 1", "Player 2"));
                player1.sendState();
                System.out.println(" - Player 1 Connected");

                // Connect to player 2
                Player player2 = serverSocket.acceptPlayer();
                player2.setState(new GameState("Player 2", "Player 1"));
                player2.sendState();
                System.out.println(" - Player 2 Connected");


                if (player1.isConnected() && player2.isConnected()) {
                    System.out.println(" - Creating new game thread");
                    // Create a new thread for this session of two players
                    String sessionId = UUID.randomUUID().toString();
                    Thread game = new Thread(new Game(sessionId, player1, player2));

                    // Start the new thread
                    game.start();
                } else if (!player1.isConnected() && player2.isConnected()) {
                    player2.sendOpponentLeftState();
                } else if (!player2.isConnected() && player1.isConnected()) {
                    player1.sendOpponentLeftState();
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void clearSession(String sessionId) {
        Controller.gameSessions.remove(sessionId);
    }
}
