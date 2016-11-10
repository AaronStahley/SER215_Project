package GameSession;

import Communication.GameState;
import Server.Controller;

import java.io.EOFException;
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

        System.out.println("-- Starting Game:");

        this.player1.getState().setWaitingForOpponent(false);
        this.player2.getState().setWaitingForOpponent(false);

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

                while (this.player1.isTurn()) {
                    System.out.println(" -- Waiting for player 1 turn");
                    keepGameActive = this.playersTurn(this.player1, this.player2);
                }
                if (!keepGameActive) {
                    continue;
                }

                while (this.player2.isTurn()) {
                    System.out.println(" -- Waiting for player 2 turn");
                    keepGameActive = this.playersTurn(this.player2, this.player1);
                }
                if (!keepGameActive) {
                    continue;
                }

                keepGameActive = (this.player1.isConnected() && this.player2.isConnected());

            } catch (EOFException e) {
                System.out.println("user disconnected!!!!!");

                try {
                    if (this.player1.isConnected()) {
                        this.player1.sendOpponentLeftState();
                    }

                    if (this.player2.isConnected()) {
                        this.player2.sendOpponentLeftState();
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                keepGameActive = false;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getCause());
                e.printStackTrace();
            }
        }

        System.out.println(" -- Game Over, disconnecting!");

        try {
            this.player1.disconnect();
            this.player2.disconnect();
        } catch (IOException e) {
        }

        Controller.clearSession(this.gameId);
    }


    private boolean playersTurn(Player player, Player opponent) throws IOException, ClassNotFoundException {
        if (player.isConnected()) {
            if (opponent.isConnected()) {
                GameState opponentsState = player.waitForMove();

                player.sendState();

                if (opponent.isConnected()) {
                    opponent.setState(opponentsState)
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
