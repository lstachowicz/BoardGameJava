package com.example.boardgamejava;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import static com.example.boardgamejava.GameBitmaps.gameBitmaps;

public class Player implements SpriteInterface {
    private  String TAG = "Player";
    List<Card> cards;
    List<Pawn> pawns;
    List<Point> walkable;

    private CardMenu menu;

    private Pawn selectedPawn;
    private Card selectedCard;

    Point spawnPoint;
    Point startPoint;

    Player(Bitmap image) {
        startPoint = new Point(13 * 120, 5 * 120);
        spawnPoint = new Point(13 * 120, 6 * 120);

        menu = new CardMenu(new Point(20, 0));

        cards = new ArrayList<Card>();
        pawns = new ArrayList<Pawn>();
        walkable = new ArrayList<Point>();

        pawns.add(new Pawn(image, spawnPoint));
        pawns.add(new Pawn(image, new Point(spawnPoint.x + 120, spawnPoint.y)));
        pawns.add(new Pawn(image, new Point(spawnPoint.x, spawnPoint.y + 120)));
        pawns.add(new Pawn(image, new Point(spawnPoint.x + 120, spawnPoint.y + 120)));

        walkable.add(new Point(spawnPoint.x + 120, spawnPoint.y - 240));
        walkable.add(new Point(spawnPoint.x + 120, spawnPoint.y - 120));
        startPoint = new Point(spawnPoint.x, spawnPoint.y - 120);
        // 1
        walkable.add(startPoint);

        // 2
        walkable.add(new Point(spawnPoint.x - 120, spawnPoint.y - 120));
        walkable.add(new Point(spawnPoint.x - 120, spawnPoint.y + 0));

        // 12
        walkable.add(new Point(spawnPoint.x - 120, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 240, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 360, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 480, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 600, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 720, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 840, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 960, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 1080, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 1200, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 1320, spawnPoint.y + 120));
        walkable.add(new Point(spawnPoint.x - 1440, spawnPoint.y + 120));

        // 4
        walkable.add(new Point(spawnPoint.x - 1440, spawnPoint.y + 0));
        walkable.add(new Point(spawnPoint.x - 1440, spawnPoint.y - 120));
        walkable.add(new Point(spawnPoint.x - 1440, spawnPoint.y - 240));
        walkable.add(new Point(spawnPoint.x - 1440, spawnPoint.y - 360));

        // 3
        walkable.add(new Point(spawnPoint.x - 1320, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 1200, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 1200, spawnPoint.y - 480));
        walkable.add(new Point(spawnPoint.x - 1200, spawnPoint.y - 600));//

        // 2
        walkable.add(new Point(spawnPoint.x - 1080, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 960, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 840, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 720, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 600, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 480, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 360, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 240, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x - 120, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x, spawnPoint.y - 600));

        //
        walkable.add(new Point(spawnPoint.x + 120, spawnPoint.y - 600));
        walkable.add(new Point(spawnPoint.x + 120, spawnPoint.y - 480));
        walkable.add(new Point(spawnPoint.x + 120, spawnPoint.y - 360));

        //
        walkable.add(new Point(spawnPoint.x, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 120, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 240, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 360, spawnPoint.y - 360));
        walkable.add(new Point(spawnPoint.x - 500, spawnPoint.y - 360));
    }

    @Override
    public void draw(Canvas canvas) {
        for(Pawn pawn : pawns) {
            pawn.draw(canvas);
        }

        menu.draw(canvas);

        if (menu.isOpen()) {
            synchronized (cards) {
                for (Card card : cards) {
                    card.draw(canvas);
                }
            }
        }
    }

    @Override
    public void update() {
        synchronized (cards) {
            if (cards.size() < 5) {
                Card card = Pile.pile.getCard();
                if (card != null) {
                    cards.add(card);
                }
            }
        }

        if (menu.isOpen()) {
            int x = 120;
            synchronized (cards) {
                for (Card card : cards) {
                    card.setPosition(new Point(x, 200));
                    x += GameBitmaps.cardWidth + 5;
                }
            }
        }

        if (selectedCard != null && selectedPawn != null) {
            if ((selectedCard.isEnterCard() && selectedPawn.spawnPoint())
                    || (selectedCard.isDeathCard() && selectedPawn.spawnPoint())) {
                selectedPawn.moveTo(startPoint);
                Log.v(TAG, "Moving pawn to start point");
                clearAction();
                return;
            }
        }

        if (selectedCard != null && selectedPawn != null) {
            if (selectedCard.isMovable() && pawns.contains(selectedPawn) && !selectedPawn.spawnPoint()) {
                int pointIndex = -1;
                for (Point point : walkable) {
                    if (selectedPawn.contains(point)) {
                        pointIndex = walkable.indexOf(point);
                        break;
                    }
                }

                if (pointIndex != -1) {
                    if (pointIndex + selectedCard.movePoints() < 0) {
                        Log.v(TAG, "Moving pawn by " + selectedCard.movePoints());
                        int movePoints = selectedCard.movePoints() + pointIndex;
                        pointIndex = walkable.size() - 7 - movePoints;
                        selectedPawn.moveTo(walkable.get(pointIndex));
                        clearAction();
                        return;

                    } else if (pointIndex + selectedCard.movePoints() < walkable.size()) {
                        Log.v(TAG, "Moving pawn by " + selectedCard.movePoints());

                        if (pointIndex + selectedCard.movePoints() == 0) {
                            selectedPawn.moveTo(walkable.get(walkable.size() - 6));
                        } else {
                            selectedPawn.moveTo(walkable.get(pointIndex + selectedCard.movePoints()));
                        }

                        if (selectedPawn.contains(walkable.get(walkable.size()-1))) {
                            selectedPawn.inActive();
                        }

                        clearAction();
                        return;
                    }
                }
            }
        }

        if (selectedCard != null) {
            boolean found = false;
            synchronized (cards) {
                int on_resp = 0;
                for (Pawn pawn : pawns) {
                    if (pawn.spawnPoint()) {
                        on_resp++;
                        for (Card card : cards) {
                            if (card.isEnterCard() || card.isDeathCard()) {
                                return;
                            }
                        }
                    }
                }

                int active = 0;
                for (Pawn pawn : pawns) {
                    if (pawn.isActive()) {
                        ++active;
                    }
                }

                if (active == on_resp) {
                    clearAction();
                    return;
                }

                int death_card = 0;
                if (!found) {
                    for (Card card : cards) {
                        if (card.isDeathCard()) {
                            ++death_card;
                        }
                    }

                    if (death_card == 5) {
                        clearAction();
                        return;
                    }
                }

//                if (selectedCard != null) {
//                    for (Card card : cards) {
//                        for (Pawn pawn : pawns) {
//                            if (pawn.isActive() && card.isMovable()) {
//                                for (Point walk : walkable) {
//                                    if (pawn.contains(walk) && walkable.indexOf(walk) + card.movePoints() >= walkable.size()) {
//                                        found = true;
//                                        break;
//                                    }
//                                }
//                            }
//
//                            if (found) {
//                                break;
//                            }
//                        }
//
//                        if (found) {
//                            break;
//                        }
//                    }
//
//                    if (!found) {
//                        clearAction();
//                    }
//                }
            }
        }
    }

    private void clearAction() {
        Card card = selectedCard;
        selectedPawn = null;
        selectedCard = null;

        Pile.pile.returnCard(card);
        cards.remove(card);

        Log.v(TAG, "Deleting card");
    }

    @Override
    public boolean contains(Point point) {
        if (menu.contains(point)) {
            return true;
        }

        if (menu.isOpen()) {
            synchronized (cards) {
                selectedCard = null;
                for (Card card : cards) {
                    if (card.contains(point)) {
                        selectedCard = card;
                        menu.close();
                        return true;
                    }
                }
            }
        }

        for (Pawn pawn : pawns) {
            if (pawn.contains(point) && pawn.isActive()) {
                selectedPawn = pawn;
                return true;
            }
        }

        if (menu.isOpen()) {
            menu.close();
        }

        return false;
    }
}
