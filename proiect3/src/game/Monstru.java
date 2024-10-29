package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monstru extends StocHrana{

    static JButton dragonJPG;
    JButton calJPG;
    JButton vacaJPG;
    Object[] options = {"Hraneste dragonul", "Vezi info despre dragon"};
    private static JFrame info;

    public Monstru() {


        ImageIcon dragon = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\180px-lightningdragonstore.png");
        dragonJPG = new JButton(dragon);
        dragonJPG.setBounds(285, 70, 230, 230);
        dragonJPG.setContentAreaFilled(false);
        dragonJPG.setOpaque(false);
        dragonJPG.setBorderPainted(false);
        dragonJPG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int actiune = JOptionPane.showOptionDialog(null, "Ce actiune doresti sa aplici?", "Alege o optiune", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(actiune == 0){

                String produs = JOptionPane.showInputDialog(null, "Cu ce produs doresti sa hranesti dragonul?", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                String cantitate = JOptionPane.showInputDialog(null, "Ce cantitate doresti sa oferi dragonului?", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                if(scadeCantitate(produs, Integer.parseInt(cantitate))) {
                    scadeCantitate(produs, Integer.parseInt(cantitate));

                }} else if(actiune == 1){
                    getInfo("<html> <br> <br>" +
                            "  Nume: Fulgerul Cerurilor<br>" +
                            "<br> <br>" +
                            "*  Tip: Dragon al furtunilor<br>" +
                            "<br> <br>" +
                            "*  Înălțime: Aproximativ 15 metri în poziție ridicată<br>" +
                            "<br> <br>" +
                            "*  Lungime: 30 de metri de la bot la vârful cozii<br>" +
                            "<br> <br>" +
                            " Aripi: Membrane argintii, strălucitoare, cu o anvergură de 40 de metri<br>" +
                            "<br> <br>" +
                            " Solzi: Scânteietori, de un albastru electric, cu reflexii metalice<br>" +
                            "<br> <br>" +
                            " Ochii: De un galben intens, strălucind ca două fulgere<br>" +
                            "<br> <br>" +
                            "* Puterile:<br>" +
                            "<br> <br>" +
                            " Control asupra furtunilor și al trăsnetelor<br>" +
                            "<br> <br>" +
                            " Respiră un foc albastru ce îngheață și incendiază simultan<br>" +
                            "<br> <br>" +
                            " Capacitate de a crea ceață densă pentru a se ascunde de inamici<br>" +
                            "<br> <br>" +
                            "*  Personalitate:<br>" +
                            "<br> <br>" +
                            " Inteligent și strategic, cu o înclinație spre curaj și protejarea teritoriului<br>" +
                            "<br> <br>" +
                            " Neînfricat în fața primejdiilor, dar precaut cu necunoscuții<br>" +
                            "<br> <br>" +
                            " Foarte loial față de cei ce dovedesc respect și curaj<br>" +
                            "<br> <br>" +
                            "*  Habitat preferat: Vârfuri de munte acoperite de furtuni, unde poate supraveghea pământurile din jur" +
                            "<br> <br></html>");
                }
            }
        });

        ImageIcon cal = new ImageIcon("/home/sebi_programatorul/Desktop/Proiect2/Proiect2/638607217752048766.png");
        calJPG = new JButton(cal);
        calJPG.setBounds(285, 300, 230, 230);
        calJPG.setContentAreaFilled(false);
        calJPG.setOpaque(false);
        calJPG.setBorderPainted(false);

        ImageIcon vaca = new ImageIcon("/home/sebi_programatorul/Desktop/Proiect2/Proiect2/637577398224101135.png");
        vacaJPG = new JButton(vaca);
        vacaJPG.setBounds(285, 500, 230, 230);
        vacaJPG.setContentAreaFilled(false);
        vacaJPG.setOpaque(false);
        vacaJPG.setBorderPainted(false);
    }

    public static JButton getPorc(){
        return dragonJPG;
    }
    public JButton getCalJPG(){
        return this.calJPG;
    }
    public JButton getVacaJPG(){
        return this.vacaJPG;
    }

    private static JFrame getInfo(String infoText){
        info = new JFrame();
        info.setSize(600, 600);
        info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        info.setBackground(Color.BLUE);
        JLabel text = new JLabel(infoText);
        text.setBounds(100, 100, 200, 200);
        text.setFont(new Font("Georgia", Font.BOLD, 15));
        info.add(text);
        info.setVisible(true);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        info.add(scrollPane);

        return info;

    }
}

