package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

public class Pawn extends BoundarySprite {
    private String TAG = "Pawn";

    Point spawnPoint;
    boolean active;

    Pawn(Bitmap image, Point point) {
        super(image, point);
        spawnPoint = point;
        active = true;
    }

    @Override
    public void update() {
    }

    @Override
    public boolean contains(Point point) {
        if (active && super.contains(point))
        {
            return true;
        }

        return false;
    }

    public void goToSpawn() {
        point = spawnPoint;
    }

    public void moveTo(Point point) {
        this.point = point;
    }

    public void inActive() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public boolean spawnPoint() {
        return spawnPoint.x == point.x && spawnPoint.y == point.y;
    }
}
