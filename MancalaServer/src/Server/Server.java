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
public class Server {

    private static Map<String,Thread> gameSessions = new HashMap<String,Thread>();

    public Server() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            // Ready to create a session for every two players
            while (true) {

                // Connect to player 1
                Player player1 = serverSocket.acceptPlayer();
                player1.setState(new GameState("Player 1", "Player 2"));
                player1.sendState();

                // Connect to player 2
                Player player2 = serverSocket.acceptPlayer();
                player2.setState(new GameState("Player 2", "Player 1"));
                player2.sendState();


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
        Server.gameSessions.remove(sessionId);
    }
}
