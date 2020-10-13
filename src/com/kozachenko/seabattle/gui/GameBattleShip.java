package com.kozachenko.seabattle.gui;

import com.kozachenko.seabattle.model.BattleShips;
import com.kozachenko.seabattle.model.Shot;
import com.kozachenko.seabattle.model.Shots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameBattleShip extends JFrame {

    final String TITLE_OF_PROGRAM = "LemonSchool Sea Battle";
    final int FIELD_SIZE = 10;
    final int AI_PANEL_SIZE = 400;
    final int AI_CELL_SIZE = AI_PANEL_SIZE / FIELD_SIZE;
    final int HUMAN_PANEL_SIZE = AI_PANEL_SIZE/2;
    final int HUMAN_CELL_SIZE = HUMAN_PANEL_SIZE / FIELD_SIZE;
    final String BTN_INIT = "Start new Battle";
    final String BTN_EXIT = "Exit";
    final String YOU_WON = "Flawless victory!";
    final String AI_WON = "You Loser!";
    final int MOUSE_BUTTON_LEFT = 1; // for mouse listener
    final int MOUSE_BUTTON_RIGHT = 3;

    JTextArea board; // for logging
    Canvas leftPanel, humanPanel; // for game fields
    BattleShips aiShips, humanShips; // set of human's and AI ships
    Shots humanShots, aiShots; // set of shots from human and AI
    Random random;
    boolean gameOver;

    public GameBattleShip() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initShipsAndShots();
        initLeftPanel();
        initHumanPanel();

        JButton initButton = new JButton(BTN_INIT); // init button
        initButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                init();
                leftPanel.repaint();
                humanPanel.repaint();
            }
        });
        JButton exitButton = new JButton(BTN_EXIT); // exit game button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        board = new JTextArea(); // scoreboard
        board.setEditable(false);
        JScrollPane scroll = new JScrollPane(board); // scroll for board

        JPanel buttonPanel = new JPanel(); // panel for button
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.add(initButton);
        buttonPanel.add(exitButton);

        JPanel rightPanel = new JPanel();         // panel for human ships,
        rightPanel.setLayout(new BorderLayout()); //  scoreboard and buttons

        rightPanel.add(humanPanel, BorderLayout.NORTH);
        rightPanel.add(scroll, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(leftPanel);
        add(rightPanel);
        pack();
        setLocationRelativeTo(null); // to the center
        setVisible(true);
        init();
    }

    private void initHumanPanel() {
        humanPanel = new Canvas(FIELD_SIZE, AI_CELL_SIZE, humanShots, aiShots, humanShips, aiShips); // panel for human ships
        humanPanel.setPreferredSize(new Dimension(HUMAN_PANEL_SIZE, HUMAN_PANEL_SIZE));
        humanPanel.setBackground(Color.white);
        humanPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    private void initLeftPanel() {
        leftPanel = new Canvas(FIELD_SIZE, AI_CELL_SIZE, humanShots, aiShots, humanShips, aiShips); // panel for AI ships
        leftPanel.setPreferredSize(new Dimension(AI_PANEL_SIZE, AI_PANEL_SIZE));
        leftPanel.setBackground(Color.white);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        leftPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int x = e.getX()/AI_CELL_SIZE; // coordinates transformation
                int y = e.getY()/AI_CELL_SIZE;
                if (e.getButton() == MOUSE_BUTTON_LEFT && !gameOver) // left mouse
                    if (!humanShots.hitSamePlace(x, y)) {
                        humanShots.add(x, y, true);
                        if (aiShips.checkHit(x, y)) { // human hit the target
                            if (!aiShips.checkSurvivors()) {
                                board.append("\n" + YOU_WON);
                                gameOver = true;
                            }
                        } else shootsAI(); // human missed - AI will shoot
                        leftPanel.repaint();
                        humanPanel.repaint();
                        board.setCaretPosition(board.getText().length());
                    }
                if (e.getButton() == MOUSE_BUTTON_RIGHT) { // right mouse
                    Shot label = humanShots.getLabel(x, y);
                    if (label != null)
                        humanShots.removeLabel(label);
                    else
                        humanShots.add(x, y, false);
                    leftPanel.repaint();
                }
            }
        });
    }

    void init() { // init all game object
        board.setText(BTN_INIT);
        gameOver = false;
        random = new Random();
    }

    private void initShipsAndShots() {
        aiShips = new BattleShips(FIELD_SIZE, AI_CELL_SIZE, true);
        humanShips = new BattleShips(FIELD_SIZE, HUMAN_CELL_SIZE, false);
        aiShots = new Shots(HUMAN_CELL_SIZE);
        humanShots = new Shots(AI_CELL_SIZE);
    }

    void shootsAI() { // AI shoots randomly
        int x, y;
        do {
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (aiShots.hitSamePlace(x, y));
        aiShots.add(x, y, true);
        if (!humanShips.checkHit(x, y)) { // AI missed
            board.append(
                    "\n" + (x + 1) + ":" + (y + 1) + " AI missed.");
            return;
        } else { // AI hit the target - AI can shoot again
            board.append(
                    "\n" + (x + 1) + ":" + (y + 1) + " AI hit the target.");
            board.setCaretPosition(board.getText().length());
            if (!humanShips.checkSurvivors()) {
                board.append("\n" + AI_WON);
                gameOver = true;
            } else
                shootsAI();
        }
    }
}
