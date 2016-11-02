package GameSession;

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
    }

    public GameState waitForMove() throws IOException, ClassNotFoundException {
        GameEvent playerAction = (GameEvent) this.inputStream.readObject();

        // Todo: need to read input and process it and then update the this.state bulk of the code should go here for processing a move

//        playerAction.buttonPressed;
//
//        this.state.getYourPits()


        GameState opponentsState = this.state.generateOpponentsState();

        // Todo: check to see if the game is over and update both state objects


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
