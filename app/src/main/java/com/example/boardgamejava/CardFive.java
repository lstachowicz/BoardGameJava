package com.example.boardgamejava;

import android.graphics.Point;
import android.graphics.Bitmap;

public class CardFive extends Card {
    CardFive() {
        super(GameBitmaps.gameBitmaps.getCardFive(), new Point(0, 0));
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
    final public int movePoints() { return 5; }
}
