package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class endGamePanel extends JPanel {

    public static JLabel backGroundLabel;
    public static JLabel winLabel;
    public static JLabel loseLabel;

    public static JButton playAgainButton;

    public endGamePanel() {

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
