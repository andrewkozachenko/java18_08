package com.kozachenko.seabattle.gui;

import com.kozachenko.seabattle.model.BattleShips;
import com.kozachenko.seabattle.model.Shots;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private Shots humanShots;
    private Shots aiShots;
    private BattleShips humanShips;
    private BattleShips aiShips;

    public Canvas(int FIELD_SIZE, int CELL_SIZE, Shots humanShots, Shots aiShots, BattleShips humanShips, BattleShips aiShips) {
        this.FIELD_SIZE = FIELD_SIZE;
        this.CELL_SIZE = CELL_SIZE;
        this.humanShots = humanShots;
        this.aiShots = aiShots;
        this.humanShips = humanShips;
        this.aiShips = aiShips;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int cellSize = (int) getSize().getWidth()/FIELD_SIZE;
        g.setColor(Color.blue);
        /**
         * начало отрисовки сетки
         */
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i*cellSize, FIELD_SIZE*cellSize, i*cellSize);
            g.drawLine(i*cellSize, 0, i*cellSize, FIELD_SIZE*cellSize);
        }
        /**
         * конец отрисовки сетки
         */

        if (cellSize == CELL_SIZE) {
            humanShots.paint(g);
            aiShips.paint(g);
        } else {
            aiShots.paint(g);
            humanShips.paint(g);
        }
    }
}
