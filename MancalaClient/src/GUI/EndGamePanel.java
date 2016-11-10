package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Client.Controller;

public class EndGamePanel extends JPanel {

	private JLabel backGroundLabel;
    private JLabel winLabel;
    private JLabel loseLabel;

    public static JButton playAgainButton;

    public EndGamePanel(Controller controller) {

        winLabel = new JLabel();
        add(winLabel);

        loseLabel = new JLabel();
        add(loseLabel);

        playAgainButton = new JButton();
        add(playAgainButton);

        backGroundLabel = new JLabel();
        add(backGroundLabel);

    }

}
