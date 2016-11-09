package GUI;

import Client.Controller;
import Communication.GameState;
import GUI.Models.Pit;
import GUI.Models.Store;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private final Controller controller;
    private final Store yourStore;
    private final Store opponentsStore;

    private ImageIcon game_Board_Icon = new ImageIcon(this.getClass().getResource("/resources/mancala_GB_01.png"));

    private Pit[] pits = new Pit[12];
    public JLabel bgLabel;
    public JLabel yourTurn;


    private ImageIcon yourTurnIcon = new ImageIcon(this.getClass().getResource("/resources/Player_01_Turn.png"));


    public GameBoardPanel(Controller controller) throws MalformedURLException, IOException {
        this.controller = controller;
        this.setLayout(null);

        Image game_Board_Panel_Scaled = game_Board_Icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon new_game_Board_Icon = new ImageIcon(game_Board_Panel_Scaled);


        this.yourTurn = new JLabel("Player Turn");
        this.yourTurn.setIcon(yourTurnIcon);
        this.add(yourTurn);


        this.pits[0] = new Pit(178, 314, false, controller, 0);
        this.pits[1] = new Pit(255, 314, false, controller, 1);
        this.pits[2] = new Pit(333, 314, false, controller, 2);
        this.pits[3] = new Pit(411, 314, false, controller, 3);
        this.pits[4] = new Pit(489, 314, false, controller, 4);
        this.pits[5] = new Pit(568, 314, false, controller, 5);

        this.pits[6] = new Pit(568, 174, true, controller);
        this.pits[7] = new Pit(489, 174, true, controller);
        this.pits[8] = new Pit(411, 174, true, controller);
        this.pits[9] = new Pit(333, 174, true, controller);
        this.pits[10] = new Pit(255, 174, true, controller);
        this.pits[11] = new Pit(178, 174, true, controller);

        for (Pit pit : this.pits) {
            this.add(pit);
        }

        this.opponentsStore = new Store("Him", 109, 135, true);
        this.yourStore = new Store("You", 632, 135, false);

        this.add(this.opponentsStore);
        this.add(this.yourStore);



        this.bgLabel = new JLabel();
        this.bgLabel.setBounds(0, 0, 800, 600);
        this.bgLabel.setIcon(new_game_Board_Icon);
        this.add(bgLabel);

    }


    public void updateState(GameState gameState) {

        int[] yourPits = gameState.getYourPits();
        int[] opponentsPits = gameState.getOpponentsPits();

        for (int i = 0; i < yourPits.length; i++) {
            this.pits[i].update(yourPits[i]);

            if (!gameState.isYourTurn()) {
                this.pits[i].disableButton();
            } else {
                this.pits[i].enableButton();
            }
        }

        for (int i = 0; i < opponentsPits.length; i++) {
            this.pits[i + 6].update(opponentsPits[i]);
        }

        this.yourStore.update(gameState.getYourStore(), gameState.getYourLabel());
        this.opponentsStore.update(gameState.getOpponentsStore(), gameState.getOpponentsLabel());
    }
}