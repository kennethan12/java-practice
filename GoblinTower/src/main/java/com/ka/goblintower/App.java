/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.goblintower;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kennethan
 */
public class App {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Hero hero;

    public void run() {
        do {
            int steps = 0;
            int level = 1;
            boolean isDead = false;
            hero = new Hero();

            while (!isDead) {
                steps++;

                System.out.println("Health: " + hero.getHealth());
                System.out.println("Level: " + level);

                int next = rand.nextInt(2);
                switch (next) {
                    case 0:
                        System.out.println("Safe step.");
                        break;
                    case 1:
                        boolean beatGoblin = fightGoblin();
                        if (!beatGoblin) {
                            isDead = true;
                            System.out.println("You got killed!");
                        } else {
                            System.out.println("You beat the goblin!");
                        }
                        break;
                }

                if (!isDead) {
                    if (steps % 10 == 0) {
                        level++;
                        buyPotions();
                    }
                    drinkPotions();
                }

                System.out.println("Press enter for next step.");
                sc.nextLine();
            }

            System.out.println("You traveled " + steps + " steps.");
            System.out.println("You got up to level " + level + ".");
        } while (playAgain());

        System.out.println("Good bye!");
    }

    private boolean fightGoblin() {
        System.out.println("A goblin wants to fight you!");

        Goblin goblin = new Goblin();

        while (hero.getHealth() > 0 && goblin.getHealth() > 0) {
            System.out.println("Goblin's health: " + goblin.getHealth());
            hero.reduceHealth(goblin.getAttackPower());
            goblin.reduceHealth(hero.getAttackPower());
        }

        return hero.getHealth() > 0;
    }

    private void buyPotions() {
        System.out.println("Would you like to buy some potions? (y/n)");
        String response = sc.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You have " + hero.numOfPotions() + " potions.");
            System.out.println("You have " + hero.getGold() + " gold.");
            System.out.println("How many potions would you like to buy? ");
            int numOfPotions = sc.nextInt();

            while (numOfPotions > 0 && hero.getGold() > 3) {
                hero.addPotion();
                numOfPotions--;
                hero.reduceGold(4);
            }

            System.out.println("You now have " + hero.numOfPotions() + " potions.");
            System.out.println("You have " + hero.getGold() + " gold left.");
        }
    }

    private void drinkPotions() {
        System.out.println("Would you like to drink some potions? (y/n)");
        String response = sc.nextLine();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("You have " + hero.numOfPotions() + " potions.");
            System.out.println("How many potions would you like to drink?");
            int numOfPotions = sc.nextInt();

            while (numOfPotions < 0 && hero.numOfPotions() < 0 && hero.getHealth() < hero.getMaxHealth()) {
                hero.usePotion();
            }
        }
    }

    private boolean playAgain() {
        System.out.println("Would you like to play again? (y/n)");
        String response = sc.nextLine();
        return response.equalsIgnoreCase("y");
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
