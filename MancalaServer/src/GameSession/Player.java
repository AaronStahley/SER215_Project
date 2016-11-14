package GameSession;

import Communication.GameEvent;
import Communication.GameState;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by mike on 10/22/16.
 */
public class Player extends Socket {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private GameState state;


    public Player() {
        // Create data input and output streams
    }

    public GameState waitForMove() throws IOException, ClassNotFoundException {
        GameEvent playerAction = (GameEvent) this.inputStream.readObject();

        System.out.println(" - New Event:");
        System.out.print("  * Button Clicked: ");
        System.out.println(playerAction.buttonPressed);


        // need to read input and process it and then update the this.state

        int yourStore = this.state.getYourStore();
        int opponentsStore = this.state.getOpponentsStore();
        int[] yourPits = this.state.getYourPits();
        int[] opponentsPits = this.state.getOpponentsPits();
        int stonesToDistribute = yourPits[playerAction.buttonPressed];
        boolean goAgain = false;
        boolean gameOver = false;

        yourPits[playerAction.buttonPressed] = 0;

        int startingPitIndex = playerAction.buttonPressed + 1;
        while (stonesToDistribute > 0) {
            for (int i = startingPitIndex; i < yourPits.length && stonesToDistribute > 0; i++) {
                yourPits[i]++;
                stonesToDistribute--;

                // check if we need to steal the opponents stones
                if (stonesToDistribute == 0 && yourPits[i] == 1) {
                    int pitToSteal = Math.abs((i % 10) - 5);
                    yourStore += opponentsPits[pitToSteal];
                    opponentsPits[pitToSteal] = 0;
                }
            }
            startingPitIndex = 0;

            // give single stone to your store, go again if that was the last stone
            if (stonesToDistribute > 0) {
                yourStore++;
                stonesToDistribute--;

                if (stonesToDistribute == 0) {
                    goAgain = true;
                }
            }

            // distribute stones to opponents pits
            for (int i = 0; i < opponentsPits.length && stonesToDistribute > 0; i++) {
                opponentsPits[i]++;
                stonesToDistribute--;
            }
        }


        // check to see if the game is over and update both state objects

        int yourPitsSum = 0;
        for (int pitCount : yourPits) {
            yourPitsSum += pitCount;
        }

        if (yourPitsSum == 0) {
            // game over
            gameOver = true;
            for (int i = 0; i < opponentsPits.length; i++) {
                opponentsStore += opponentsPits[i];
                opponentsPits[i] = 0;
            }
        }


        this.state.setYourStore(yourStore);
        this.state.setYourPits(yourPits);
        this.state.setOpponentsPits(opponentsPits);
        this.state.setOpponentsStore(opponentsStore);


        GameState opponentsState = this.state.generateOpponentsState();

        if (!goAgain) {
            this.state.setYourTurn(false);
            opponentsState.setYourTurn(true);
        }

        if (gameOver) {
            if (this.state.getYourStore() > this.state.getOpponentsStore()) {
                this.state.setYouWin(true);
            } else if (this.state.getYourStore() < this.state.getOpponentsStore()) {
                opponentsState.setYouWin(true);
            } else {
                this.state.setIsTie(true);
                opponentsState.setIsTie(true);
            }

            this.state.setGameOver();
            opponentsState.setGameOver();
        }

        return opponentsState;
    }

    public void createStreams() throws IOException {
        this.outputStream = new ObjectOutputStream(this.getOutputStream());
        this.inputStream = new ObjectInputStream(this.getInputStream());
    }

    public Player setState(GameState state) {
        this.state = state;
        return this;
    }

    public Player sendState() throws IOException {
        this.outputStream.reset();
        this.outputStream.writeObject(this.state);
        return this;
    }

    public Player sendOpponentLeftState() throws IOException {
        this.getState().setGameOver().setOpponentLeft(true);
        this.sendState();
        return this;
    }

    public Player setTurn(boolean turn) {
        this.getState().setYourTurn(turn);
        return this;
    }

    public GameState getState() {
        return state;
    }

    public void disconnect() throws IOException {
        if (this.isConnected()) {
            this.shutdownInput();
            this.shutdownOutput();
            this.close();
        }
    }

    public boolean isTurn() {
        return this.state.isYourTurn();
    }
}
