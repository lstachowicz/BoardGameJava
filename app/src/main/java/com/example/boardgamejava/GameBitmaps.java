package com.example.boardgamejava;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GameBitmaps {
    public static Context context;

    public static GameBitmaps gameBitmaps;

    public static int bordWidth = 1920;
    public static int boardHeigth = 1080;

    // Original size is 262x381
    // but we will use 10% smaller
    public static int pileWidth = 235;
    public static int pileHeigth = 342;

    public static int pawnWidth = 120;
    public static int pawnHeigth = 120;

    public static int cardWidth = 235;
    public static int cardHeigth = 342;

    public static int cardMenuWidth = 80;
    public static int cardMenuHeigth = 120;

    GameBitmaps(Context context) {
        this.context = context;
        this.gameBitmaps = this;
    }

    public Bitmap getBoard() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.board);
        return Bitmap.createScaledBitmap(bitmap, bordWidth, boardHeigth, false);
    }

    public Bitmap getPile() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.pile);
        return Bitmap.createScaledBitmap(bitmap, pileWidth, pileHeigth, false);
    }

    public Bitmap getGreenPawn() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.green_pawn);
        return Bitmap.createScaledBitmap(bitmap, pawnWidth, pawnHeigth, false);
    }

    public Bitmap getPurplePawn() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.purple_pawn);
        return Bitmap.createScaledBitmap(bitmap, pawnWidth, pawnHeigth, false);
    }

    public Bitmap getCardOne() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
        return Bitmap.createScaledBitmap(bitmap, cardWidth, cardHeigth, false);
    }

    public Bitmap getCardTwo() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card2);
        return Bitmap.createScaledBitmap(bitmap, cardWidth, cardHeigth, false);
    }

    public Bitmap getCardThree() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card3);
        return Bitmap.createScaledBitmap(bitmap, cardWidth, cardHeigth, false);
    }

    public Bitmap getCardFive() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);
        return Bitmap.createScaledBitmap(bitmap, cardWidth, cardHeigth, false);
    }

    public Bitmap getCardZbity() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card_zbity);
        return Bitmap.createScaledBitmap(bitmap, cardWidth, cardHeigth, false);
    }

    public Bitmap getCardMenu() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.card_menu);
        return Bitmap.createScaledBitmap(bitmap, cardMenuWidth, cardMenuHeigth, false);
    }
}
