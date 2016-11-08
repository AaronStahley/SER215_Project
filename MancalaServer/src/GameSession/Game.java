package GameSession;

import Communication.GameState;
import Server.Server;

import java.io.IOException;


/**
 * Created by mike on 10/22/16.
 */
public class Game implements Runnable {
    private final String gameId;
    private Player player1;
    private Player player2;

    public Game(String gameId, Player player1, Player player2) {
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        boolean keepGameActive = true;

        this.player1.setState(new GameState("Player 1", "Player 2"));
        this.player2.setState(new GameState("Player 2", "Player 1"));

        // Start Game
        try {
            this.player1.setTurn(true);
            this.player1.sendState();
            this.player2.sendState();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (keepGameActive) {
            try {

                while(this.player1.isTurn()){
                    keepGameActive = this.playersTurn(this.player1, this.player2);
                }
                if (!keepGameActive) {
                    continue;
                }

                while(this.player2.isTurn()) {
                    keepGameActive = this.playersTurn(this.player2, this.player1);
                }
                if (!keepGameActive) {
                    continue;
                }

                keepGameActive = (this.player1.isConnected() && this.player2.isConnected());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        try {
            this.player1.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.player2.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Server.clearSession(this.gameId);
    }


    private boolean playersTurn(Player player, Player opponent) throws IOException, ClassNotFoundException {
        if (player.isConnected()) {
            if (opponent.isConnected()) {
                GameState opponentsState = player.waitForMove();

                player.setTurn(false).sendState();

                if (opponent.isConnected()) {
                    opponent.setState(opponentsState)
                            .setTurn(true)
                            .sendState();
                }
            } else {
                player.sendOpponentLeftState();
                return false;
            }
        }
        return true;
    }
}
