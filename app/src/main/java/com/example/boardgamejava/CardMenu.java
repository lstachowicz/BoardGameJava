package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.Calendar;
import java.util.Date;

public class CardMenu extends BoundaryStaticSprite {
    private boolean isMenuOpen;
    Long tsLong;

    CardMenu(Point point) {
        super(GameBitmaps.gameBitmaps.getCardMenu(), point);

        tsLong = 0L;

        isMenuOpen = false;
    }

    @Override
    public boolean contains(Point point) {
        Long tsLong = System.currentTimeMillis()/1000;

        if (super.contains(point)) {
            if (tsLong < this.tsLong + 2) {
                return true;
            }

            this.tsLong = tsLong;
            isMenuOpen = !isMenuOpen;
            return true;
        }

        return false;
    }

    public boolean isOpen() {
        return isMenuOpen;
    }

    public void close() {
        isMenuOpen = false;
        tsLong = 0L;
    }
}
