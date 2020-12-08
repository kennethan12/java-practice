/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.goblintower;

import java.util.Random;

/**
 *
 * @author kennethan
 */
public class Goblin {

    private int health;
    private int attackPower;
    private int defensePower;

    public Goblin() {
        Random rand = new Random();
        health = rand.nextInt(6) + 5;
        attackPower = rand.nextInt(2) + 2;
        defensePower = rand.nextInt(2) + 1;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        health -= amount;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

}
