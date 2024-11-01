package game.logic;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Image backgroundImage;

    public Background(String background) {

        if (background.equals("Panel principal")) {
            try {
                backgroundImage = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\1e79a561645499.5aa5558789b4d.jpg").getImage();
            } catch (Exception e) {
                System.err.println("Imaginea nu a fost găsită: " + e.getMessage());
            }
        } else if(background.equals("Battlefield")){
            try {
                backgroundImage = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\" +
                        "gaming-vector-background-landscape-video-game-fantasy-wallpaper-mountain-posters-controller_597121-629.jpg").getImage();
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

