/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.playerdeck;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kennethan
 */
public class App {

    Deck deck = new Deck();
    Scanner sc = new Scanner(System.in);

    public void run() {
        do {
            deck.reset();
            deck.shuffle();
            System.out.println(deck.size());
            System.out.println("Deck shuffled!");

            while (deck.size() > 0) {
                System.out.println("How many do you want to draw? ");
                int numOfCards = sc.nextInt();
                List<Card> cards = deck.draw(numOfCards);

                cards.forEach(card -> {
                    System.out.println(card);
                });
            }
        } while (playAgain());
        System.out.println("Thanks for playing!");
    }

    public boolean playAgain() {
        System.out.println("Would you like to play again? (y/n)");
        String response = sc.next();
        return response.equals("y");
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
