package com.example.boardgamejava;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "GameView";

    private GameBitmaps gameBitmaps;

    private MainThread thread;

    private ArrayList<Sprite> staticSprites;

    private double widthScalar;
    private double heightScalar;

    private int windowWidth;
    private int windowHeight;

    // Important game object
    private Player player;
    private Pile pile;

    public GameView(Context context, int windowWidth, int windowHeight) {
        super(context);

        staticSprites = new ArrayList<>();
        gameBitmaps = new GameBitmaps(context);

        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    public void StartGame() {
        player = new Player(gameBitmaps.getPurplePawn());
    }

    @Override
    public void surfaceChanged(SurfaceHolder surface, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder surface) {
        staticSprites.add(new StaticSprite(gameBitmaps.getBoard(), new Point(0, 0)));
        pile = new Pile(gameBitmaps.getPile(), new Point(1190, 490));
        staticSprites.add(pile);

        thread.setRunning(true);
        thread.start();

        StartGame();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surface) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            retry = false;
        }
    }

    public void update() {
        player.update();
        pile.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            for (Sprite sprint : staticSprites) {
                sprint.draw(canvas);
            }

            player.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Point point = new Point((int)event.getX(), (int)event.getY());
        if (player.contains(point)
            || pile.contains(point)
        )
        {
            return true;
        }

        return super.onTouchEvent(event);
    }
}
