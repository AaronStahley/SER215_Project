package GUI.Models;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mike on 11/8/16.
 */
public class Store extends JPanel {

    private static ImageIcon[] stoneImages = {
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_01.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_02.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_03.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_04.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_05.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_06.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_07.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_08.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_09.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_10.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_11.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_12.png")),
    };
    private JLabel label;
    private JLabel score;
    private JLabel img;

    public Store(String name, int x, int y, boolean leftJustify) {
        super();
        this.setBounds(x, y, 62, 328);
        this.setLayout(null);
        this.setOpaque(false);

        this.label = new JLabel("0");
        this.label.setOpaque(false);
        this.label.setForeground(Color.WHITE);
        this.label.setBackground(null);

        this.score = new JLabel(name);
        this.score.setOpaque(false);
        this.score.setForeground(Color.WHITE);
        this.score.setBackground(null);


        this.img = new JLabel();
        this.img.setOpaque(false);
        this.img.setBackground(null);

        if (leftJustify) {
            this.label.setBounds(0, 0, 62, 32);
            this.img.setBounds(0, 56, 48, 217);
            this.score.setBounds(47, 38, 15, 15);
        } else {
            this.label.setBounds(0, 296, 62, 32);
            this.img.setBounds(14, 56, 48, 217);
            this.score.setBounds(0, 277, 15, 15);
        }

        this.update(0, name);

        this.add(this.label);
        this.add(this.img);
        this.add(this.score);
    }

    public void update(int score, String name) {
        this.label.setText(name);
        this.score.setText(score + "");
        ImageIcon img;

        if (score > stoneImages.length) {
            img = stoneImages[11];
        } else if (score == 0) {
            img = null;
        } else {
            img = stoneImages[score - 1];
        }

        if (img == null) {
            this.img.setVisible(false);
        } else {
            this.img.setIcon(img);
            this.img.setVisible(true);
        }
    }
}
