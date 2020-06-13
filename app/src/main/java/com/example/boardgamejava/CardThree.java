package com.example.boardgamejava;

import android.graphics.Point;

public class CardThree extends Card {
    CardThree() {
        super(GameBitmaps.gameBitmaps.getCardThree(), new Point(0, 0));
    }

    @Override
    final public boolean isMovable()
    {
        return true;
    }

    @Override
    final public boolean isEnterCard()
    {
        return false;
    }

    @Override
    final public boolean isDeathCard()
    {
        return false;
    }

    @Override
    public int movePoints() {
        return -3;
    }
}
