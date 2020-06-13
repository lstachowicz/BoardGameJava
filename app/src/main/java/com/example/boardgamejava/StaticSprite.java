package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;

// Sprite do not allow draw anything more on object
// Static sprint do not allow to update object onece it is created.
public class StaticSprite extends Sprite {
    public StaticSprite(Bitmap image, Point point) {
        super(image, point);
    }

    @Override
    final public void update() {
        throw new RuntimeException("Static sprint should not be updated!");
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }
}
