package game.logic;

import game.Background;
import game.Monstru;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Batalie {
    protected Monstru dragon1;
    protected Monstru dragon2;
    protected Random random;
    int actiune = 0;

    public Batalie(Monstru dragon1, Monstru dragon2){
        this.dragon1 = dragon1;
        this.dragon2 = dragon2;
        this.random = new Random();

    }
    public void incepeBatalia() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel battlefield = new Background("Battlefield");
        battlefield.setVisible(true);
        battlefield.setSize(800, 400);
        frame.add(battlefield);
        frame.setVisible(true);

        while (dragon1.getCantitateViata() > 0 && dragon2.getCantitateViata() > 0) {

            if (actiune % 2 == 0) {
                Atac atac = alegereAtac(dragon1.getNume());
                dragon2.scadeViata(atac.executaAtac());
                JOptionPane.showMessageDialog(null, dragon1.getNume() + " atacă " +
                        dragon2.getNume() + " cu " + atac.executaAtac() + " puncte de daune!");
            } else {
                Atac atac = alegereAtac(dragon2.getNume());
                dragon1.scadeViata(atac.executaAtac());
                JOptionPane.showMessageDialog(null, dragon2.getNume() + " atacă " +
                        dragon1.getNume() + " cu " + atac.executaAtac() + " puncte de daune!");
            }
            actiune++;
            verificaCastigator();
        }
    }
    protected abstract Atac alegereAtac(String numeDragon);

    protected void verificaCastigator() {
        if (dragon1.getCantitateViata() <= 0) {
            JOptionPane.showMessageDialog(null, dragon2.getNume() + " a câștigat bătălia!");
        } else if (dragon2.getCantitateViata() <= 0) {
            JOptionPane.showMessageDialog(null, dragon1.getNume() + " a câștigat bătălia!");
        }
    }
}


