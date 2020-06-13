package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile extends BoundarySprite {
    static String TAG = "Pile";

    static Pile pile;

    List<Card> cardsInPile;
    List<Card> cardsInHands;
    List<Card> cardsReturned;

    Pile(Bitmap image, Point point) {
        super(image, point);

        pile = this;

        cardsInPile = new ArrayList<Card>();
        cardsInHands = new ArrayList<Card>();
        cardsReturned = new ArrayList<Card>();

        for (int i = 0; i < 2; ++i){
            cardsInPile.add(new CardOne());
        }
        for (int i = 0; i < 2; ++i){
            cardsInPile.add(new CardTwo());
        }
        for (int i = 0; i < 3; ++i){
            cardsInPile.add(new CardThree());
        }
        for (int i = 0; i < 6; ++i){
            cardsInPile.add(new CardFive());
        }
        for (int i = 0; i < 3; ++i){
            cardsInPile.add(new CardZbity());
        }

        Collections.shuffle(cardsInPile);
    }

    @Override
    public boolean contains(Point point) {
        if (super.contains(point)) {
            return true;
        }

        return false;
    }

    public Card getCard() {
        // If empty ask again later
        if (cardsInPile.isEmpty()) {
            return null;
        }

        Card card = cardsInPile.remove(0);
        cardsInHands.add(card);
        return card;
    }

    public void returnCard(Card card) {
        cardsInHands.remove(card);
        cardsReturned.add(card);
    }

    @Override
    public void update() {
        if (cardsInPile.isEmpty()) {
            cardsInPile.addAll(cardsReturned);
            cardsReturned.clear();

            SecureRandom secureRandom;
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            }
            catch (NoSuchAlgorithmException e) {
                secureRandom = new SecureRandom();
            }
            secureRandom.nextBytes(new byte[20]); // force SecureRandom to seed itself
            Collections.shuffle(cardsInPile, secureRandom);
        }
    }
}
