package game.logic;

import javax.swing.*;
import java.awt.*;

class BattlefieldBackground extends JPanel {

    private Image backgroundImage;

    public BattlefieldBackground(String background) {

        if (background.equals("Panel principal")) {
            try {
                backgroundImage = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\" +
                        "stone-battleground-platform-at-night-neon-runes-free-vector.jpg").getImage();
            } catch (Exception e) {
                System.err.println("Imaginea nu a fost găsită: " + e.getMessage());
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

