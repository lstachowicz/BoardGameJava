package com.example.boardgamejava;

import android.graphics.Point;

public class CardOne extends Card {
    CardOne() {
        super(GameBitmaps.gameBitmaps.getCardOne(), new Point(0, 0));
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
        return 1;
    }
}
