package GameSession;

import Communication.GameState;

import java.io.IOException;


/**
 * Created by mike on 10/22/16.
 */
public class Game implements Runnable {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setOpponent(this.player2);
        this.player2.setOpponent(this.player1);
    }

    public void run() {

        this.player1.setState(new GameState());
        this.player2.setState(new GameState());

        // Start Game
        try {
            this.player1.sendState();
            this.player2.sendState();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                this.player1.waitForMove();
                this.player1.sendState();
                this.player2.sendState();

                this.player2.waitForMove();
                this.player1.sendState();
                this.player2.sendState();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
