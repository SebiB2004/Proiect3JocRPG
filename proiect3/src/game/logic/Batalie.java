package game.logic;

import game.Monstru;

import javax.swing.*;
import java.awt.*;

public abstract class Batalie {
    protected Monstru dragon1;
    protected Monstru dragon2;
    protected ImageIcon img1;
    protected ImageIcon img2;
    private JPanel healthBar1;
    private JPanel healthBar2;
    int actiune = 0;
    JLabel viata1;
    JLabel viata2;

    public Batalie(Monstru dragon1, Monstru dragon2){
        this.dragon1 = dragon1;
        this.dragon2 = dragon2;


    }
    public void incepeBatalia() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel battlefield = new Background("Battlefield");
        battlefield.setVisible(true);
        battlefield.setLayout(null);
        battlefield.setSize(600, 600);

        healthBar1 = new JPanel();
        healthBar1.setBounds(420,310,300,30);
        healthBar1.setBackground(Color.green);
        healthBar1.setVisible(true);
        battlefield.add(healthBar1);

        healthBar2 = new JPanel();
        healthBar2.setBounds(70, 310, 300, 30);
        healthBar2.setBackground(Color.green);
        healthBar2.setVisible(true);
        battlefield.add(healthBar2);

        if(dragon1.getNume() == "Gica"){
            img1 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\MarbleDragonStore (1).png");
            JLabel imagine1 = new JLabel(img1);
            imagine1.setBounds(140, 10, 280, 280);
            imagine1.setVisible(true);
            battlefield.add(imagine1);
            viata1 = new JLabel();
            viata1.setText("HP-ul lui Gica este " + String.valueOf(dragon1.getCantitateViata()));
            viata1.setFont(new Font("Arial", Font.BOLD, 25 ));
            viata1.setBounds(70, 150, 280, 280);
            viata1.setForeground(Color.WHITE);
            battlefield.add(viata1);
        }

        if(dragon2.getNume() == "Ionel"){
            img2 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\180px-lightningdragonstore.png");
            JLabel imagine2 = new JLabel(img2);
            imagine2.setBounds(370, 40, 280, 280);
            imagine2.setVisible(true);
            battlefield.add(imagine2);
            viata2 = new JLabel();
            viata2.setText("HP-ul lui Ionel este " + String.valueOf(dragon1.getCantitateViata()));
            viata2.setFont(new Font("Arial", Font.BOLD, 25 ));
            viata2.setBounds(420, 150, 280, 280);
            viata2.setForeground(Color.WHITE);
            battlefield.add(viata2);
        }
        frame.add(battlefield);
        frame.setVisible(true);

        while (dragon1.getCantitateViata() > 0 && dragon2.getCantitateViata() > 0) {

            if (actiune % 2 == 0) {
                Atac atac = alegereAtac(dragon1.getNume());
                dragon2.scadeViata(atac.executaAtac());
                JOptionPane.showMessageDialog(null, dragon1.getNume() + " atacă " +
                        dragon2.getNume() + " cu " + atac.executaAtac() + " puncte de daune!");
                viata2.setText("Viata lui Ionel este " + String.valueOf(dragon2.getCantitateViata()));

                int latimeNoua = (dragon2.getCantitateViata() * 300) / 150;
                healthBar1.setBounds(420,310, latimeNoua, 30);
                battlefield.revalidate();
                battlefield.repaint();
            } else {
                Atac atac = alegereAtac(dragon2.getNume());
                dragon1.scadeViata(atac.executaAtac());
                JOptionPane.showMessageDialog(null, dragon2.getNume() + " atacă " +
                        dragon1.getNume() + " cu " + atac.executaAtac() + " puncte de daune!");
                viata1.setText("HP-ul lui Gica este " + String.valueOf(dragon1.getCantitateViata()));

                int latimeNoua = (dragon1.getCantitateViata() * 300) / 100;
                healthBar2.setBounds(70, 310, latimeNoua, 30);
            }
            actiune++;
            verificaCastigator();
        }

    }
    protected abstract Atac alegereAtac(String numeDragon);

    protected void verificaCastigator() {
        if (dragon1.getCantitateViata() <= 0) {
            viata1.setText("MORT!");
            JOptionPane.showMessageDialog(null, dragon2.getNume() + " a câștigat bătălia!");
        } else if (dragon2.getCantitateViata() <= 0) {
            viata2.setText("MORT!");
            JOptionPane.showMessageDialog(null, dragon1.getNume() + " a câștigat bătălia!");


        }
    }



}


