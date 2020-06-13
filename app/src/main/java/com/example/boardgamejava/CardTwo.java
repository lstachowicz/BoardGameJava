package com.example.boardgamejava;

import android.graphics.Point;

public class CardTwo extends Card {
    CardTwo() {
        super(GameBitmaps.gameBitmaps.getCardTwo(), new Point(0, 0));
    }

    @Override
    final public boolean isMovable()
    {
        return true;
    }

    @Override
    final public boolean isEnterCard()
    {
        return true;
    }

    @Override
    final public boolean isDeathCard()
    {
        return false;
    }

    @Override
    public int movePoints() {
        return 2;
    }
}
