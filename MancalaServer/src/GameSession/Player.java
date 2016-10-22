package GameSession;

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
    private Player opponent;

    public Player() {
        // Create data input and output streams
    }

    public void waitForMove() throws IOException, ClassNotFoundException {
        this.inputStream.readObject();

        //Todo: need to read input and process it

//        this.setState(new GameState());
//        this.opponent.setState(new GameState());
    }

    public void createStreams() throws IOException {
        this.outputStream = new ObjectOutputStream(this.getOutputStream());
        this.inputStream = new ObjectInputStream(this.getInputStream());
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void sendState() throws IOException {
        this.outputStream.writeObject(this.state);
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
}
