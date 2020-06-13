package com.example.boardgamejava;

import android.graphics.Point;
import android.util.Size;

final public class Utils {
    static boolean contains(Point rectangle_point, Size rectangle_size, Point point) {
        return (rectangle_point.x <= point.x && rectangle_point.x + rectangle_size.getWidth() > point.x
                && rectangle_point.y <= point.y && rectangle_point.y + rectangle_size.getHeight() > point.y);
    }

}
