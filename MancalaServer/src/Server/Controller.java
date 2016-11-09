package Server;

import Communication.GameState;
import GameSession.Game;
import GameSession.Player;
import Utilites.ServerSocket;

import java.io.IOException;
import java.util.*;


/**
 * Created by mike on 10/22/16.
 */
public class Controller {

    private static Map<String,Thread> gameSessions = new HashMap<String,Thread>();

    public Controller() {
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


                System.out.println(" - Creating new game thread");
                // Create a new thread for this session of two players
                String sessionId = UUID.randomUUID().toString();
                Thread game = new Thread(new Game(sessionId, player1, player2));

                // Start the new thread
                game.start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void clearSession(String sessionId){
        Controller.gameSessions.remove(sessionId);
    }
}
