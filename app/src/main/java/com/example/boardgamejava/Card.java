package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;

abstract public class Card extends BoundaryStaticSprite {
    Card(Bitmap image, Point point) {
        super(image, point);
    }

    public void setPosition(Point point) {
        this.point = point;
    }

    // Card actions
    abstract public boolean isMovable();
    abstract public boolean isEnterCard();
    abstract public boolean isDeathCard();

    public int movePoints() {
        if (!isMovable()) {
            throw new RuntimeException("Card is not movable");
        }
        return 0;
    }
}
