import GameSession.Game;
import GameSession.Player;
import Utilites.ServerSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mike on 10/22/16.
 */
public class Server {

    private static List<Thread> gameSessions = new ArrayList<Thread>();

    public static void main(String[] args) {
        new Server();
    }


    public Server() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            // Ready to create a session for every two players
            while (true) {

                // Connect to player 1
                Player player1 = serverSocket.acceptPlayer();

                // Connect to player 2
                Player player2 = serverSocket.acceptPlayer();


                // Create a new thread for this session of two players
                Thread game = new Thread(new Game(player1, player2));

                // Start the new thread
                game.start();
                Server.gameSessions.add(game);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
