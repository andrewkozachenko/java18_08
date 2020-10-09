package com.kozachenko.seabattle.model;

public class BattleShip {
    private int hitPoint;

    public BattleShip(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void getInfo(){

    }

    public boolean isAlive(){
        if (hitPoint > 0){
            return true;
        }
        return false;
    }
}
