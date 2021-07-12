package com.pyramid;

import java.util.Random;

public class Goblins implements Players {
    private int health;
    private String name;
    private final String symbol = "\uD83D\uDC7A";
    Random random = new Random();

    public Goblins(String name) {
        this.health = random.nextInt(100)+1;
        this.name = name;
    }

    public boolean isAlive() {
        if (this.health > 0)
            return true;
        else
            return false;
    }

    @Override
    public void attack(Players players) {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damage){
        this.health = this.health - damage;
    }



    @Override
    public String toString() {
        return " "+symbol+ " ";
    }
}
