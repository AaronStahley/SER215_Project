import Communication.GameEvent;
import Communication.GameState;

import java.io.*;
import java.net.Socket;

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

        // Todo: process the input and then update the this.state. The bulk of the code should go here for processing a move
//done by Payal(nov 10th and nov 11th 2016)
        int pressed = playerAction.buttonPressed;
        int stonesInPit = this.states[pressed];
        this.state[pressed] = 0;

        //make a temp board in a single array to make iteration easier
        int[] tempBoard = new int[14]
        //copy first six pits
        for (int i=0; i<6; i++) {
            tempBoard[i] = this.state.yourPits[i];
        }
        //copy our store
        tempBoard[6] = this.state.yourStore;
        //copy enemy pits
        for (int i=0; i<6; i++) {
            tempBoard[i+6] = this.state.opponentsPits[i];
        }
        // copy enemy store
        tempBoard[14] = this.state.opponentsStore;

        //change the board

        //get start and end positions
        int end = pressed+stoneInPit;
        int start = pressed+1;


        while (end>13) {
            for (int i=start; i<=13; i++) {
                tempBoard[i]++;
            }
            end-=13;
            start=0;
        }
        for (int i=start; i<=end; i++) {
            tempBoard[i]++;
        }

        //put temp board back into this.state
        for (int i=0; i<14; i++) {
            if (i<6) {
                this.state.yourPits[i] = tempBoard[i];
            }
            else if (i==6) {
                this.state.yourStore = temBoard[i];
            }
            else if (i<13) {
                this.state.opponentsPits[i] = temBoard[i];
            }
            else {
                this.state.opponentsStore = tempBoard[i];
            }
        }

        GameState opponentsState = this.state.generateOpponentsState();

        // Todo: check to see if the game is over and update both state objects
        boolean endOfGame = true;

        for (i=0; i<6; i++) {
            endOfGame &= !(boolean)this.state.yourPits[i];
            endOfGame &= !(boolean)this.state.opponentsPits[i];
        }
        if (endOfGame) {
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
        this.outputStream.writeObject(this.state);
        return this;
    }

    public Player sendOpponentLeftState() throws IOException {
        this.setGameOver(true)
                .setOpponentLeft(true)
                .sendState();
        return this;
    }

    public Player setTurn(boolean turn) {
        this.getState().setYourTurn(turn);
        return this;
    }

    public Player setOpponentLeft(boolean opponentLeft) {
        this.getState().setOpponentLeft(opponentLeft);
        return this;
    }

    public Player setGameOver(boolean gameOver) {
        this.getState().setGameOver(gameOver);
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
}
