package game;

import javax.swing.*;
import java.awt.*;

class HabitatBackground extends JButton {
    private Image imagineFundal;

    public HabitatBackground(String text, ImageIcon iconita, String caleImagineFundal) {
        super(text);
        setIcon(iconita); // Setează imaginea principală a butonului
        this.imagineFundal = new ImageIcon(caleImagineFundal).getImage();
        setContentAreaFilled(false); // Ascunde background-ul standard
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Desenează imaginea de fundal
        g.drawImage(imagineFundal, 0, 0, getWidth(), getHeight(), this);

        // Desenează iconița și textul
        super.paintComponent(g);
    }
}

