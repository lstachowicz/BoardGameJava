package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

// Sprite do not allow draw anything more on object
public abstract class Sprite implements SpriteInterface {
    protected Bitmap image;
    protected Point point;

    public Sprite(Bitmap image, Point point) {
        this.image = image;
        this.point = point;
    }

    @Override
    final public void draw(Canvas canvas) {
        canvas.drawBitmap(image, point.x, point.y, null);
    }
}
