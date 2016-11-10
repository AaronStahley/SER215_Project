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
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_13.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_14.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_15.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_16.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_17.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_18.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_19.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_20.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_21.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_22.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_23.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_24.png")),
            new ImageIcon(Pit.class.getResource("/resources/Player_Mancala_Stones_25.png")),

    };
    private JLabel label;
    private JLabel score;
    private JLabel img;
    private Font fontLabel; 

    public Store(String name, int x, int y, boolean leftJustify) {
        super();
        this.setBounds(x, y, 75, 328);
        this.setLayout(null);
        this.setOpaque(false);
        
        this.fontLabel = new Font("Times New Roman", Font.BOLD,16);

        this.label = new JLabel("0");
        this.label.setOpaque(false);
        this.label.setForeground(Color.BLACK);
        this.label.setBackground(null);
        this.label.setFont(fontLabel);
       
        this.score = new JLabel(name);
        this.score.setOpaque(false);
        this.score.setForeground(Color.WHITE);
        this.score.setBackground(null);


        this.img = new JLabel();
        this.img.setOpaque(false);
        this.img.setBackground(null);

        if (leftJustify) {
            this.label.setBounds(5, 20, 75, 32);
            this.img.setBounds(0, 56, 80, 200);
            this.score.setBounds(60, 55, 15, 15);
        } else {
            this.label.setBounds(20, 280, 62, 32);
            this.img.setBounds(0, 56, 80, 200);
            this.score.setBounds(5, 260, 15, 15);
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
            img = stoneImages[24];
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
