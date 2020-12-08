/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.playerdeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kennethan
 */
public class Deck {

    public List<Card> deck;
    private final String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    private final String[] ranks = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

    public Deck() {
        deck = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card> draw(int numOfCards) {
        List<Card> drawnCards = new ArrayList<>();
        while (numOfCards > 0 && deck.size() > 0) {
            drawnCards.add(deck.remove(0));
            numOfCards--;
        }
        return drawnCards;
    }

    public int size() {
        return deck.size();
    }

    public void reset() {
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

}
