package com.example.boardgamejava;

import android.graphics.Canvas;
import android.graphics.Point;

interface SpriteInterface {
    abstract public void draw(Canvas canvas);
    abstract public void update();
    abstract public boolean contains(Point point);
}