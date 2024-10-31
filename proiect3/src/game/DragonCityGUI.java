package game;

import game.logic.Atac;
import game.logic.Batalie;
import game.logic.BatalieDragoni;
import game.staff.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

// salut Sebi
public class DragonCityGUI implements  ActionListener{

        private static JPanel panel;
        private static JFrame frame;
        private static JLabel utilizator;
        private static JLabel parola;
        private static JTextField intUtil;
        private static JPasswordField intPass;
        private static JButton login;
        private static JLabel titlu;
        private static JPanel panelLogin;
        public static Angajat angajat;
        private JButton ListAngajati;
        private DefaultListModel<String> Lista;
        private static JList <String> listaAng;
        StocHrana stocHrana;
        private static JPanel panelButon;
        private static JButton adaugaAngajat;
        private ArrayList<String> listaGlobalaAngajati = new ArrayList<>(Arrays.asList(
                "George - Patron",
                "Marian - Contabil",
                "Mihai - Manager",
                "Ionel - Ingrijitor"
        ));
        private ArrayList<Produs> listaProduse = new ArrayList<>();

        public DragonCityGUI() {

            initalizareUI();
        }

        public void initalizareUI() {

            panel = new Background("Panel principal");

            frame = new JFrame();

            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(panel);
            panel.setLayout(null);

            panelLogin = new JPanel();
            panelLogin.setBounds(100, 200, 400, 200);
            panelLogin.setLayout(null);
            panelLogin.setOpaque(false);
            panel.add(panelLogin);

            titlu = new JLabel("Dragon City");
            titlu.setFont(new Font("Georgia", Font.BOLD, 25));
            titlu.setBounds(220, 180, 500, 30);
            panel.add(titlu);


            utilizator = new JLabel("Utilizator");
            utilizator.setFont(new Font("Arial", Font.BOLD, 15));
            utilizator.setBounds(90, 30, 100, 25);
            panelLogin.add(utilizator);

            parola = new JLabel("Parola");
            parola.setFont(new Font("Arial", Font.BOLD, 15));
            parola.setBounds(90, 80, 100, 25);
            panelLogin.add(parola);

            intUtil = new JTextField();
            intUtil.setBounds(200, 30, 100, 25);
            panelLogin.add(intUtil);

            intPass = new JPasswordField();
            intPass.setBounds(200, 80, 100, 25);
            panelLogin.add(intPass);

            login = new JButton("Login");
            login.setBounds(90, 120, 200, 50);
            panelLogin.add(login);
            login.addActionListener(this);

            frame.setVisible(true);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String util = intUtil.getText();
            String pass = intPass.getText();

            if (util.equalsIgnoreCase("Ingrijitor") && pass.equals("ingrijitor123")) {
                panelLogin.setVisible(false);
                angajat = new Ingrijitor("Ionel", "ingrijitor");
                titlu.setText("Bun venit, " + angajat.getNume() + "!");
                titlu.setBounds(170, 200, 500, 25);
                TimerHide();
            }

            if (util.equalsIgnoreCase("Manager") && pass.equals("manager123")) {
                panelLogin.setVisible(false);
                angajat = new Manager("Marian", "Manager");
                titlu.setBounds(170, 200, 500, 25);
                titlu.setText("Bun venit, " + angajat.getNume() + "!");
                TimerHide();
            } else {
                JLabel eroare = new JLabel("Datele de logare sunt gresite");
                eroare.setBounds(70, 170, 250, 30);
                eroare.setFont(new Font("Arial", Font.BOLD, 15));
                eroare.setForeground(Color.RED);
                panelLogin.add(eroare);
                panelLogin.revalidate();
                panelLogin.repaint();

            }
        }

        public void TimerHide() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    titlu.setText("");
                    SecondPanel();
                }
            });
            timer.setRepeats(false);
            timer.start();

        }

        public void SecondPanel() {

            titlu.setBounds(10, 10, 500, 25);
            titlu.setText("Functie: " + intUtil.getText());
            panel.revalidate();
            panel.repaint();
            panelButon = new JPanel();

            panelButon.setLayout(new BoxLayout(panelButon, BoxLayout.Y_AXIS));
            panelButon.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelButon.add(Box.createVerticalGlue());
            panelButon.setBackground(Color.darkGray);

            ListAngajati = new JButton("Lista angajatilor");
            JButton buttonBack = back();
            panel.add(buttonBack);
            buttonBack.setVisible(false);

            ListAngajati.setAlignmentX(Component.CENTER_ALIGNMENT);
            ListAngajati.setForeground(Color.BLACK);
            ListAngajati.setBackground(Color.ORANGE);
            ListAngajati.setOpaque(true);
            ListAngajati.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(ListAngajati);



            ListAngajati.addActionListener(new ActionListener() {
                private int numarAngajati = 4;
                private int inaltimeCelula = 30;
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(Lista == null) {
                        Lista = new DefaultListModel<>();
                        listaAng = new JList<>(Lista);
                        listaAng.setVisibleRowCount(listaGlobalaAngajati.size());
                        listaAng.setFixedCellHeight(inaltimeCelula);
                        panel.add(listaAng);
                    }

                    Lista.clear();

                    for(String angajat : listaGlobalaAngajati){
                        Lista.addElement(angajat);
                    }


                    if(angajat.getAutoritate().equalsIgnoreCase("medium") || angajat.getAutoritate().equalsIgnoreCase("High")) {
                        if (adaugaAngajat == null) {
                            adaugaAngajat = new JButton("Adauga un angajat nou");
                            adaugaAngajat.setBounds(290, 170, 200, 50);
                            adaugaAngajat.setBackground(Color.ORANGE);
                            listaAng.setBounds(80, 150, 200, 120);
                            panel.add(adaugaAngajat);

                            adaugaAngajat.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String raspuns = JOptionPane.showInputDialog(null, "Scrie numele si functia noului angajat", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                                    {
                                        listaGlobalaAngajati.add(raspuns);
                                        Lista.addElement(raspuns);
                                        listaAng.setVisibleRowCount(listaGlobalaAngajati.size());
                                        listaAng.setBounds(80, 150, 200, listaGlobalaAngajati.size() * inaltimeCelula);
                                    }
                                }
                            });
                        }
                    }
                    else {

                        listaAng.setBounds(135, 150, 200, 120);
                    }

                    JButton buttonBack = back();
                    buttonBack.setVisible(true);
                    panel.add(buttonBack);
                    buttonBack.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panelButon.setVisible(true);
                            adaugaAngajat.setVisible(false);
                            listaAng.setVisible(false);
                            buttonBack.setVisible(false);
                            panel.revalidate();
                            panel.repaint();
                        }
                    });

                    adaugaAngajat.setVisible(true);
                    buttonBack.setVisible(true);
                    panelButon.setVisible(false);
                    listaAng.setVisible(true);
                    panel.add(listaAng);
                    panel.revalidate();
                    panel.repaint();
                }
            });

            JButton Stoc = new JButton("Stoc Hrana");
            Stoc.setAlignmentX(Component.CENTER_ALIGNMENT);
            Stoc.setForeground(Color.BLACK);
            Stoc.setBackground(Color.ORANGE);
            Stoc.setContentAreaFilled(true);
            Stoc.setOpaque(true);
            Stoc.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            Stoc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.revalidate();
                    panel.repaint();
                    panelButon.setVisible(false);

                    if(stocHrana == null) {
                        stocHrana = new StocHrana();
                        for (Produs produs : listaProduse) {
                            stocHrana.adaugaProdus(produs);
                        }
                    }
                    if (panel.isAncestorOf(stocHrana.getTabelStoc())) {
                        panel.revalidate();
                        panel.repaint();
                        return;
                    }

                    panel.add(stocHrana.getTabelStoc());
                    panel.revalidate();
                    panel.repaint();


                    JButton adaugaStoc = new JButton("Adauga un nou produs");
                    adaugaStoc.setBounds(200, 390, 200, 50);
                    panel.add(adaugaStoc);
                    JButton buttonBack = back();
                    buttonBack.setVisible(true);
                    panel.add(buttonBack);

                    adaugaStoc.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String denumire = JOptionPane.showInputDialog(null, "Ce produs doresti sa adaugi?", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                            String cantitate = JOptionPane.showInputDialog(null, "Introdu cantitatea:", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                            String pret = JOptionPane.showInputDialog(null, "Introdu pretul:", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                            if (verificareString(cantitate) && verificareString(pret)) {
                                Produs produs = new Produs(denumire, Integer.parseInt(cantitate), Integer.parseInt(pret));
                                listaProduse.add(produs);
                                stocHrana.adaugaProdus(produs);

                                panel.revalidate();
                                panel.repaint();
                            } else {
                                JOptionPane.showMessageDialog(null, "Imi pare rau, formatul cantitatii sau al pretului nu este corect");
                            }
                        }
                    });
                    buttonBack.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(stocHrana.getTabelStoc());
                            buttonBack.setVisible(false);
                            adaugaStoc.setVisible(false);
                            panelButon.setVisible(true);
                            panel.repaint();
                            panel.revalidate();
                        }
                    });
                }
            });
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Stoc);

            JButton Grajduri = new JButton("Grajduri");
            Monstru monstru = new Monstru();

            Grajduri.setAlignmentX(Component.CENTER_ALIGNMENT);
            Grajduri.setForeground(Color.BLACK);
            Grajduri.setBackground(Color.ORANGE);
            Grajduri.setOpaque(true);
            Grajduri.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            Grajduri.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelButon.setVisible(false);
                    panel.add(Monstru.getIonel());
                    panel.add(Monstru.getGica());
                    frame.setSize(600, 600);


                    JButton buttonBack = back();
                    panel.add(buttonBack);
                    buttonBack.setVisible(true);
                    buttonBack.setBounds(150, 30, 150, 100);
                    buttonBack.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panelButon.setVisible(true);
                            buttonBack.setVisible(false);
                            panel.remove(Monstru.getIonel());
                            panel.remove(Monstru.getGica());
                            frame.setSize(600, 600);
                        }
                    });

                }
            });


            panelButon.setBounds(150, 150, 300, 300);
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Grajduri);

            JButton butonBatalie = new JButton("Intra intr-o noua batalie!");
            butonBatalie.setAlignmentX(Component.CENTER_ALIGNMENT);
            butonBatalie.setForeground(Color.BLACK);
            butonBatalie.setBackground(Color.ORANGE);
            butonBatalie.setOpaque(true);
            butonBatalie.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            butonBatalie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Monstru Ionel = new Monstru("Ionel", 100, 10);
                    Monstru Gica = new Monstru("Gica", 100, 10);
                    BatalieDragoni batalie = new BatalieDragoni(Ionel, Gica);
                    batalie.incepeBatalia();

                }
            });

            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(butonBatalie);

            butonBatalie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelButon.setVisible(false);
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                }
            });

            JButton Parteneri = new JButton("Parteneri");
            Parteneri.setAlignmentX(Component.CENTER_ALIGNMENT);
            Parteneri.setForeground(Color.BLACK);
            Parteneri.setOpaque(true);
            Parteneri.setBackground(Color.ORANGE);
            Parteneri.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Parteneri);

            panelButon.add(Box.createVerticalGlue());
            panelButon.setOpaque(false);
            panelButon.setBounds(175, 175, 250, 250);
            panel.add(panelButon);
            panel.revalidate();
            panel.repaint();


        }

        public static boolean verificareString(String str){
            try {
                Integer.parseInt(str);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }

        public static JButton back(){
            JButton backButton = new JButton("BACK");
            backButton.setBounds(220, 50, 150, 100);
            backButton.setFont(new Font("Arial", Font.BOLD, 20));
            backButton.setContentAreaFilled(false);
            backButton.setOpaque(false);
            backButton.setBorderPainted(false);
            return backButton;
        }


    }






