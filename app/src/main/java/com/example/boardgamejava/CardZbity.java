package com.example.boardgamejava;

import android.graphics.Point;

public class CardZbity extends Card {
    CardZbity() {
        super(GameBitmaps.gameBitmaps.getCardZbity(), new Point(0, 0));
    }

    @Override
    final public boolean isMovable()
        {
            return false;
        }

    @Override
    final public boolean isEnterCard()
        {
            return false;
        }

    @Override
    final public boolean isDeathCard()
        {
            return true;
        }

    @Override
    public int movePoints() {
            return 0;
        }
}