package com.kozachenko.seabattle.model;

import com.kozachenko.seabattle.gui.Cell;

import java.awt.*;
import java.util.ArrayList;

public class BattleShip {
    private int hitPoint;
    private ArrayList<Cell> cells = new ArrayList<>();

    public BattleShip(int x, int y, int length, int position) {
        for (int i = 0; i < length; i++) {
            int xCell = x + i * ((position == 1) ? 0 : 1);
            int yCell = y + i * ((position == 1) ? 1 : 0);
            cells.add(new Cell(xCell, yCell));
        }
    }

    /**
     * проверяем выходит ли корабль за границы поля
     */
    public boolean isOutOfField(int bottom, int top) {
        for (Cell cell : cells) {
            if (cell.getX() < bottom || cell.getX() > top ||
                    cell.getY() < bottom || cell.getY() > top) {
                return true;
            }
        }
        return false;
    }

    /**
     * проверяем произошло ли наложение одного корабля на другой
     * или произошло соприкосновение
     */
    public boolean isOverlayOrTouch(BattleShip ctrlShip) {
        for (Cell cell : cells) {
            if (ctrlShip.isOverlayOrTouchCell(cell)) {
                return true;
            }
        }
        return false;
    }

    /**
     * проверяем наложение или соприкосновение через ячейки
     */
    private boolean isOverlayOrTouchCell(Cell ctrlCell) {
        for (Cell cell : cells) {
            for (int dx = -1; dx < 2; dx++) {
                for (int dy = -1; dy < 2; dy++) {
                    if (ctrlCell.getX() == cell.getX() + dx &&
                            ctrlCell.getY() == cell.getY() + dy)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean checkHit(int x, int y) {
        for (Cell cell : cells) {
            if (cell.checkHit(x, y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        for (Cell cell : cells) {
            if (cell.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics g, int cellSize, boolean hide) {
        for (Cell cell : cells){
            cell.paint(g, cellSize, hide);
        }
    }
}
