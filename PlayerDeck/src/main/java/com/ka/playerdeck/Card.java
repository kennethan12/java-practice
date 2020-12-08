/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.playerdeck;

/**
 *
 * @author kennethan
 */
public class Card {

    public final String SUIT;
    public final String RANK;

    public Card(String suit, String rank) {
        SUIT = suit;
        RANK = rank;
    }

    @Override
    public String toString() {
        return RANK + " of " + SUIT;
    }

}
