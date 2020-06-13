package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.util.Size;

public class BoundaryStaticSprite extends StaticSprite {
    static String TAG = "BoundaryStaticSprite";
    private Size size;

    BoundaryStaticSprite(Bitmap image, Point point) {
        super(image, point);
        size = new Size(image.getWidth(), image.getHeight());
    }

    public boolean contains(Point point) {
        return Utils.contains(this.point, size, point);
    }
}
