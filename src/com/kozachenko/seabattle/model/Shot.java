package com.kozachenko.seabattle.model;

import java.awt.*;

public class Shot {
    private int x, y;
    private boolean shot;

    public Shot(int x, int y, boolean shot) {
        this.x = x;
        this.y = y;
        this.shot = shot;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isShot() {
        return shot;
    }

    public void paint(Graphics g, int cellSize){
        g.setColor(Color.gray);
        if(isShot()){
            g.fillRect(x*cellSize + cellSize/2-3, y*cellSize+cellSize/2-3, 8,8);
        } else {
            g.drawRect(x*cellSize + cellSize/2-3, y*cellSize+cellSize/2-3, 8,8);
        }
    }
}
