package game.ui;

import game.entities.Monster;
import game.logic.GameWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class DungeonCrawlerGUI extends JFrame {
    private GameWorld gameWorld;
    private JTextArea gameLog;
    private JButton startBattleButton, actionButton, statusButton, exitButton;
    private JLabel playerStatus, monsterStatus;
    private Monster currentMonster;
    private int battlesCount = 0;
    private boolean gameOver = false;

    private Random rand = new Random();

    public DungeonCrawlerGUI() {
        setTitle("Dungeon Crawler");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameLog);
        add(scrollPane, BorderLayout.CENTER);

        playerStatus = new JLabel("Player Status");
        monsterStatus = new JLabel("Monster Status");

        JPanel statusPanel = new JPanel(new GridLayout(1, 2));
        statusPanel.add(playerStatus);
        statusPanel.add(monsterStatus);
        add(statusPanel, BorderLayout.NORTH);

        startBattleButton = new JButton("Start Batalie");
        actionButton = new JButton("Alege Actiune");
        statusButton = new JButton("Verifica Status");
        exitButton = new JButton("Iesire");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startBattleButton);
        buttonPanel.add(actionButton);
        buttonPanel.add(statusButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        initGame();

        startBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAdventure();
            }
        });

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAction();
            }
        });

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.append("Player status: " + gameWorld.getPlayer().getHealth() + " HP\n");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void initGame() {
        String playerName = JOptionPane.showInputDialog("Introduceti numele personajului dvs.:");
        gameWorld = new GameWorld(playerName);
        gameLog.append("Bine ai venit la Dungeon Crawler!\n");
    }

    private void startAdventure() {
        if (gameOver) {
            gameLog.append("Jocul s-a terminat. Restartati aplicatia pentru a incepe din nou.\n");
            return;
        }

        if (battlesCount == 4) {
            gameLog.append("Felicitari! Ai invins toate bataliile!\n");
            return;
        }

        if (currentMonster == null || !currentMonster.isAlive()) {
            List<Monster> monsters = gameWorld.getMonsters();
            if (battlesCount < 3) {
                currentMonster = monsters.get(rand.nextInt(3));
            } else {
                currentMonster = monsters.get(3); // Boss
            }

            gameLog.append("\nUn " + currentMonster.getName() + " iti apare in cale!\n");
            updateStatusLabels();
        } else {
            gameLog.append("\nEsti deja in lupta cu " + currentMonster.getName() + "!\n");
        }
    }

    private void chooseAction() {
        if (gameOver || currentMonster == null || !currentMonster.isAlive()) {
            gameLog.append("Nu poti alege o actiune acum!\n");
            return;
        }

        String[] options = {
                "Atac Normal (10 daune)",
                "Atac Puternic (15 daune, 65% sansa)",
                "Explozie de Foc (25 daune, 50% sansa)"
        };

        int action = JOptionPane.showOptionDialog(null,
                "Alege actiunea ta:",
                "Alege Actiune",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        int damage = 0;

        switch (action) {
            case 0:
                damage = 10;
                gameLog.append("Ai atacat normal pentru " + damage + " daune!\n");
                break;
            case 1:
                if (rand.nextDouble() <= 0.65) {
                    damage = 15;
                    gameLog.append("Ai atacat puternic pentru " + damage + " daune!\n");
                } else {
                    gameLog.append("Atacul puternic a ratat!\n");
                }
                break;
            case 2:
                if (rand.nextDouble() <= 0.5) {
                    damage = 25;
                    gameLog.append("Explozie de Foc reusita! Ai provocat " + damage + " daune!\n");
                } else {
                    gameLog.append("Explozie de Foc a ratat!\n");
                }
                break;
            default:
                gameLog.append("Actiune invalida. Incearca din nou.\n");
                return;
        }

        if (currentMonster.isAlive()) {
            currentMonster.takeDamage(damage);
            gameLog.append(currentMonster.getName() + " are acum " + currentMonster.getHealth() + " HP.\n");
        }

        if (!currentMonster.isAlive()) {
            gameLog.append("Ai invins " + currentMonster.getName() + "!\n");
            battlesCount++;
            currentMonster = null;
            if (battlesCount == 4) {
                gameLog.append("Felicitari! Ai castigat jocul!\n");
                gameOver = true;
            }
            return;
        }

        fight();
        updateStatusLabels();
    }

    private void fight() {
        if (currentMonster != null && currentMonster.isAlive()) {
            int monsterDamage = currentMonster.attack();
            gameLog.append(currentMonster.getName() + " te-a atacat pentru " + monsterDamage + " daune!\n");
            gameWorld.getPlayer().takeDamage(monsterDamage);

            if (!gameWorld.getPlayer().isAlive()) {
                gameLog.append("Ai fost invins! Jocul s-a terminat.\n");
                gameOver = true;
            }
        }
    }

    private void updateStatusLabels() {
        playerStatus.setText("Player: " + gameWorld.getPlayer().getHealth() + " HP");
        if (currentMonster != null) {
            monsterStatus.setText(currentMonster.getName() + ": " + currentMonster.getHealth() + " HP");
        } else {
            monsterStatus.setText("Niciun inamic curent.");
        }
    }
}
