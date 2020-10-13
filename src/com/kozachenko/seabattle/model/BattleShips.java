package com.kozachenko.seabattle.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleShips {
    private final int CELL_SIZE;
    private ArrayList<BattleShip> battleShips = new ArrayList<>();
    private final int[] PATTERN = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    private Random random;
    private boolean hide;

    public BattleShips(int fieldSize, int cellSize, boolean hide) {
        this.CELL_SIZE =  cellSize;
        random = new Random();
        for (int i = 0; i < PATTERN.length; i++){
            BattleShip battleShip;
            do {
                int x = random.nextInt(fieldSize);
                int y = random.nextInt(fieldSize);
                int position = random.nextInt(2);
                battleShip = new BattleShip(x, y, PATTERN[i], position);
            } while (battleShip.isOutOfField(0, fieldSize-1) || isOverlayOrTouch(battleShip));
            battleShips.add(battleShip);
        }

        this.hide = hide;
    }

    public boolean isOverlayOrTouch(BattleShip ctrlShip) {
        for (BattleShip battleShip : battleShips){
            if (battleShip.isOverlayOrTouch(ctrlShip)){
                return true;
            }
        }
        return false;
    }

    public boolean checkHit(int x, int y){
        for (BattleShip battleShip : battleShips){
            if (battleShip.checkHit(x,y)){
                return true;
            }
        }
        return false;
    }

    public boolean checkSurvivors(){
        for (BattleShip battleShip : battleShips){
            if (battleShip.isAlive()){
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics g){
        for (BattleShip battleShip : battleShips){
            battleShip.paint(g, CELL_SIZE, hide);
        }
    }

}
