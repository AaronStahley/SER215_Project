package Communication;

import java.io.Serializable;

/**
 * Created by mike on 10/22/16.
 */
public class GameState implements Serializable {
    private String yourLabel = "You";
    private String opponentsLabel = "Opponent";
    private int yourStore = 0;
    private int[] yourPits = {4, 4, 4, 4, 4, 4};
    private int opponentsStore = 0;
    private int[] opponentsPits = {4, 4, 4, 4, 4, 4};
    private boolean youWin = false;
    private boolean yourTurn = false;
    private boolean gameOver = false;
    private boolean opponentLeft = false;

    public GameState(String yourLabel, String opponentsLabel) {
        this.yourLabel = yourLabel;
        this.opponentsLabel = opponentsLabel;
    }

    public GameState(int yourStore, int[] yourPits, int opponentsStore, int[] opponentsPits) {
        this.yourStore = yourStore;
        this.yourPits = yourPits;
        this.opponentsStore = opponentsStore;
        this.opponentsPits = opponentsPits;
    }

    public GameState setOpponentLeft(boolean opponentLeft) {
        this.opponentLeft = opponentLeft;
        return this;
    }

    public GameState setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        return this;
    }

    public GameState setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
        return this;
    }

    public void setYourStore(int yourStore) {
        this.yourStore = yourStore;
    }

    public void setYourPits(int[] yourPits) {
        this.yourPits = yourPits;
    }

    public void setOpponentsPits(int[] opponentsPits) {
        this.opponentsPits = opponentsPits;
    }

    public void setOpponentsStore(int opponentsStore) {
        this.opponentsStore = opponentsStore;
    }

    public String getYourLabel() {
        return this.yourLabel;
    }

    public String getOpponentsLabel() {
        return this.opponentsLabel;
    }

    public int getYourStore() {
        return yourStore;
    }

    public int[] getYourPits() {
        return yourPits;
    }

    public int getOpponentsStore() {
        return opponentsStore;
    }

    public int[] getOpponentsPits() {
        return opponentsPits;
    }

    public boolean isYouWin() {
        return youWin;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isOpponentLeft() {
        return opponentLeft;
    }


    public GameState generateOpponentsState() {
        return new GameState(this.opponentsStore, this.opponentsPits, this.yourStore, this.yourPits);
    }

}
