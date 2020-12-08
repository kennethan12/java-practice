/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.goblintower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kennethan
 */
public class Hero {
    
    private int health;
    private int maxHealth;
    private int attackPower;
    private int defensePower;
    private int gold;
    private List<Integer> potions;
    
    public Hero() {
        Random rand = new Random();
        maxHealth = rand.nextInt(10) + 20;
        health = maxHealth;
        attackPower = rand.nextInt(3) + 1;
        defensePower = rand.nextInt(5) + 1;
        gold = 0;
        potions = new ArrayList<>();
        
        potions.add(1);
        potions.add(1);
    }
    
    public int getHealth() {
        return health;
    }
    
    public void addHealth(int amount) {
        while (amount > 0 && health < maxHealth) {
            health++;
        }
    }
    
    public void reduceHealth(int amount) {
        health -= amount;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getAttackPower() {
        return attackPower;
    }
    
    public int getDefensePower() {
        return defensePower;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void addGold(int amount) {
        gold += amount;
    }
    
    public void reduceGold(int amount) {
        gold -= amount;
    }
    
    public void addPotion() {
        if (potions.size() < 5) {
            potions.add(1);
        }
    }
    
    public int usePotion() {
        if (!potions.isEmpty()) {
            potions.remove(0);
            addHealth(2);
        }
        return potions.size();
    }
    
    public int numOfPotions() {
        return potions.size();
    }
    
}
