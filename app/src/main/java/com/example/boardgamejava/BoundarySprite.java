package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Size;

abstract public class BoundarySprite extends Sprite {
    protected Size size;

    BoundarySprite(Bitmap image, Point point) {
        super(image, point);
        size = new Size(image.getWidth(), image.getHeight());
    }

    @Override
    public boolean contains(Point point) {
        return Utils.contains(this.point, size, point);
    }
}
