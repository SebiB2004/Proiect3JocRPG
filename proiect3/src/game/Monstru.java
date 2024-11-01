package game;

import game.bazaDeDate.StocHrana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monstru extends StocHrana {
    private String nume;
    private int cantitateViata;
    private int putereAtac;
    static JButton Ionel;
    static JButton Gica;
    static JButton Mihai;
    static JButton Vasile;
    JButton vacaJPG;
    Object[] options = {"Hraneste dragonul", "Vezi info despre dragon"};
    private static JFrame info;

    public Monstru(String nume, int cantitateViata, int putereAtac){
        this.nume = nume;
        this.cantitateViata  = cantitateViata;
        this.putereAtac = putereAtac;
    }

    public Monstru() {

        ImageIcon dragon1 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\DesertIslandStore.png");
        Ionel = new JButton(dragon1);
        Ionel.setBounds(170, 40, 280, 280);
        Ionel.setContentAreaFilled(false);
        Ionel.setOpaque(false);
        Ionel.setBorderPainted(false);
        Ionel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int actiune = JOptionPane.showOptionDialog(null, "Ce actiune doresti sa aplici?", "Alege o optiune", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(actiune == 0){
                    Hraneste();

                } else if(actiune == 1){
                    getInfo("<html> <br> <br>" +
                            "  Nume: Ionel <br>" +
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


        ImageIcon dragon2 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\Image0.png");
        Gica = new JButton(dragon2);
        Gica.setVisible(true);
        Gica.setBounds(170, 280, 270, 290);
        Gica.setContentAreaFilled(false);
        Gica.setOpaque(false);
        Gica.setBorderPainted(false);

        Gica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int actiune = JOptionPane.showOptionDialog(null, "Ce actiune doresti sa aplici?", "Alege o optiune", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(actiune == 0){
                    Hraneste();
                } else if(actiune == 1){
                    getInfo("<html> <br> <br>" +
                            "Nume: Gică <br>" +
                            "<br> <br>" +
                            "* Tip: Dragon alb mitic <br>" +
                            "<br> <br>" +
                            "* Înălțime: Aproximativ 12 metri în poziție ridicată <br>" +
                            "<br> <br>" +
                            "* Lungime: 25 de metri de la bot la vârful cozii <br>" +
                            "<br> <br>" +
                            "* Aripi: Armură aurie, cu membrane translucide ce strălucesc în lumina soarelui, având o anvergură de 35 de metri <br>" +
                            "<br> <br>" +
                            "* Solzi: Scânteietori, de un alb pur cu reflexii aurii, care strălucesc în lumina <br>" +
                            "<br> <br>" +
                            "* Ochii: De un albastru profund, strălucind ca două safire <br>" +
                            "<br> <br>" +
                            "* Puterile: <br>" +
                            "<br> <br>" +
                            "* Capabil să invoce zăpezi și furtuni de gheață <br>" +
                            "<br> <br>" +
                            "* Respiră un foc alb, capabil să înghețe și să topească în același timp <br>" +
                            "<br> <br>" +
                            "* Abilitatea de a se camufla în zăpadă și ceață <br>" +
                            "<br> <br>" +
                            "* Personalitate: <br>" +
                            "<br> <br>" +
                            "* Înțelept și calm, cu un simț al dreptății <br>" +
                            "<br> <br>" +
                            "* Protector al teritoriului său, dar cu o natură prietenoasă față de cei care îi respectă <br>" +
                            "<br> <br>" +
                            "* Loial și generos cu cei care demonstrează curaj <br>" +
                            "<br> <br>" +
                            "* Habitat preferat: Vârfurile munților acoperiți de zăpadă, unde poate observa regatul său <br>" +
                            "<br> <br>" +
                            "</html>");
                }
            }
        });

        ImageIcon dragon3 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\Lava_Island_Super.png");
        Mihai = new JButton(dragon3);
        Mihai.setBounds(250, 20, 280, 280);
        Mihai.setContentAreaFilled(false);
        Mihai.setOpaque(false);
        Mihai.setBorderPainted(false);
        Mihai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int actiune = JOptionPane.showOptionDialog(null, "Ce actiune doresti sa aplici?", "Alege o optiune", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(actiune == 0){
                    Hraneste();

                } else if(actiune == 1){
                    getInfo("<html> <br> <br>" +
                            "  Nume: Mihai <br>" +
                            "<br> <br>" +
                            "*  Tip: Dragon Wrestler<br>" +
                            "<br> <br>" +
                            "*  Înălțime: Aproximativ 12 metri în poziție ridicată<br>" +
                            "<br> <br>" +
                            "*  Lungime: 25 de metri de la bot la vârful cozii<br>" +
                            "<br> <br>" +
                            " Aripi: Membrane robuste, de un verde închis, cu o anvergură de 35 de metri<br>" +
                            "<br> <br>" +
                            " Solzi: Groși și duri, de un gri metalic, capabili să reziste la impacturi puternice<br>" +
                            "<br> <br>" +
                            " Ochii: De un portocaliu aprins, strălucind cu o intensitate feroce<br>" +
                            "<br> <br>" +
                            "* Puterile:<br>" +
                            "<br> <br>" +
                            " Forță fizică impresionantă, capabil să ridice inamici de dimensiuni mari<br>" +
                            "<br> <br>" +
                            " Tehnici avansate de luptă, folosind aripile și coada pentru manevre devastatoare<br>" +
                            "<br> <br>" +
                            " Abilitatea de a provoca tremururi în sol prin salturi puternice, destabilizând adversarii<br>" +
                            "<br> <br>" +
                            "*  Personalitate:<br>" +
                            "<br> <br>" +
                            " Îndrăzneț și competitiv, mereu în căutarea unui nou rival de înfruntat<br>" +
                            "<br> <br>" +
                            " Un protector al celor slabi, luptând cu dârzenie pentru cei neputincioși<br>" +
                            "<br> <br>" +
                            " Loial față de prietenii săi și temut de inamicii săi, fiind un adversar de temut<br>" +
                            "<br> <br>" +
                            "*  Habitat preferat: Arenele de luptă naturale, cum ar fi peșterile adânci sau stâncile abrupte<br>" +
                            "<br> <br></html>"
                    );
                }
            }
        });

        ImageIcon dragon4 = new ImageIcon("C:\\Users\\dariu\\OneDrive\\Desktop\\Proiect3JocRPG\\proiect3\\imagini\\Image0png.png");
        Vasile = new JButton(dragon4);
        Vasile.setBounds(50, 280, 270, 320);
        Vasile.setContentAreaFilled(false);
        Vasile.setOpaque(false);
        Vasile.setBorderPainted(false);
        Vasile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int actiune = JOptionPane.showOptionDialog(null, "Ce actiune doresti sa aplici?", "Alege o optiune", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(actiune == 0){
                    Hraneste();

                } else if(actiune == 1){
                    getInfo("<html> <br> <br>" +
                            "  Nume: Vasile <br>" +
                            "<br> <br>" +
                            "*  Tip: Dragon al Electricității<br>" +
                            "<br> <br>" +
                            "*  Înălțime: Aproximativ 10 metri în poziție ridicată<br>" +
                            "<br> <br>" +
                            "*  Lungime: 20 de metri de la bot la vârful cozii<br>" +
                            "<br> <br>" +
                            " Aripi: Membrane translucide, de un albastru electric strălucitor, cu o anvergură de 30 de metri<br>" +
                            "<br> <br>" +
                            " Solzi: Reflectorizanți, cu nuanțe de galben și alb, ce imită fulgerele<br>" +
                            "<br> <br>" +
                            " Ochii: De un violet intens, scânteind cu energie electrică<br>" +
                            "<br> <br>" +
                            "* Puterile:<br>" +
                            "<br> <br>" +
                            " Control total asupra electricității, capabil să genereze fulgere devastatoare<br>" +
                            "<br> <br>" +
                            " Capacitatea de a se mișca cu viteză incredibilă, lăsând o urmă de energie electrizantă în urma sa<br>" +
                            "<br> <br>" +
                            " Abilitatea de a crea câmpuri electrice pentru a-și proteja teritoriul<br>" +
                            "<br> <br>" +
                            "*  Personalitate:<br>" +
                            "<br> <br>" +
                            " Agil și jucăuș, dar și imprevizibil, atrăgând atenția cu acțiuni surprinzătoare<br>" +
                            "<br> <br>" +
                            " Curajos și protector, luptând cu dârzenie împotriva celor care amenință natura<br>" +
                            "<br> <br>" +
                            " Loial față de prietenii săi, dar temut de inamicii săi, pe care îi lovește cu forța electricității<br>" +
                            "<br> <br>" +
                            "*  Habitat preferat: Vârfurile munților în timpul furtunilor electrice, unde poate controla cerul<br>" +
                            "<br> <br></html>"

                    );
                }
            }
        });

    }

    public static JButton getIonel(){
        return Ionel;
    }
    public static JButton getGica(){
        return Gica;
    }

    public static JButton getMihai(){
        return Mihai;
    }

    public static JButton getVasile(){
        return Vasile;
    }

    public String getNume(){
        return this.nume;
    }

    public int getCantitateViata(){
        return this.cantitateViata;
    }

    public int getPutereAtac(){
        return this.putereAtac;
    }

    public void scadeViata(int daune){
        this.cantitateViata -= daune;
    }



    private void Hraneste() {
        String produs = JOptionPane.showInputDialog(null, "Cu ce produs doresti sa hranesti dragonul?", "Intrebare", JOptionPane.QUESTION_MESSAGE);

        if(produs != null && !produs.isEmpty()){
        String cantitateStr = JOptionPane.showInputDialog(null, "Ce cantitate doresti sa oferi dragonului?", "Intrebare", JOptionPane.QUESTION_MESSAGE);

        try {
            int cantitate = Integer.parseInt(cantitateStr);
            if (cantitate > 0) {
                if (scadeCantitate(produs, cantitate)) {
                    JOptionPane.showMessageDialog(null, "Ai hranit cu succes dragonul!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Introduceti o cantitate valida!");
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Cantitatea introdusa nu este valida!");
        }
        } else {
            JOptionPane.showMessageDialog(null, "Produsul nu a fost introdus!");
        }
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

