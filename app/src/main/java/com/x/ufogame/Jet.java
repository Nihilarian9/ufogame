package com.x.ufogame;

import android.graphics.Rect;
import android.util.Log;

public class Jet {



    public boolean left = false, right = false, crashing = false, crashed = false;
    public boolean crashsound = false;
    private int maxAltitude = 0, minAltitude = 255, ground = 400, gravity = 1;
    private int respawnCount;

    private UFO ufo = GameScreen.getUfo();
    private Cow cow1 = GameScreen.getCow1();
    private Cow cow2 = GameScreen.getCow2();
    private int origX, origY;
    public int posX, posY;
    private int gravInc;
    public int speedX = 5;
    private int scoreCount = 1;


    public Rect rectBody = new Rect(0, 0, 0, 0);
    public Rect rectWing = new Rect(0, 0, 0, 0);
    public Rect rectTail = new Rect(0, 0, 0, 0);

    public Jet(int x, int y) {

        posX = x;
        posY = y;
        origX = x;
        origY = y;

    }


    private int velY, velX;

    public void update() {

        if (ufo.score / 50 > scoreCount) {
            scoreCount++;
            speedX++;
        }

        if(posX < -400) {
            velX = speedX;
            right = true;
            left = false;
            posX = -400;
            if(posY < minAltitude) {
                posY += 85;
            } else {
                posY = maxAltitude;
            }
        } else if (posX > 1200) {
            velX = -speedX;
            left = true;
            right = false;
            posX = 1200;
            if(posY < minAltitude) {
                posY += 85;
            } else {
                posY = maxAltitude;
            }
        }

        // more precise collision rectangles

        if (left) {
            rectBody.set(posX + 2, posY + 30, posX + 192, posY + 52);
            rectTail.set(posX + 110, posY + 8, posX + 160, posY + 38);
            rectWing.set(posX + 50, posY + 40, posX + 148, posY + 78);

        } else if (right) {
            rectBody.set(posX + 5, posY + 30, posX + 195, posY + 52);
            rectTail.set(posX + 40, posY + 8, posX + 88, posY + 38);
            rectWing.set(posX + 50, posY + 40, posX + 148, posY + 75);

        }

        if (crashed) {
            respawnCount--;
            crashsound = false;
            if (respawnCount < 0) {
                posX = origX;
                posY = origY;
                crashed = false;

            }
        } else if (!crashing && !crashed) {
            collisionCheck();

        } else if (crashing && !crashed) {
            gravInc++;
            if (gravInc > 5) {
                velY += gravity;
                gravInc = 0;
            }

            posY += velY;
            if(posY > ground) {
                crashing = false;
                crashed = true;
                crashsound = true;
                velY = 0;
                respawnCount = 50;
            }
        }

        if (!crashed) {
            posX += velX;
        }
    }


    public void collisionCheck() {
        if(Rect.intersects(ufo.rectWide, rectBody) || Rect.intersects(ufo.rectWide, rectWing) || Rect.intersects(ufo.rectWide, rectTail)) {
            ufo.isKill = true;
            crashing = true;
            speedX++;

        } else if (Rect.intersects(ufo.rectTall, rectBody) || Rect.intersects(ufo.rectTall, rectWing) || Rect.intersects(ufo.rectTall, rectTail)) {
            ufo.isKill = true;
            crashing = true;
            speedX++;

        } else if (Rect.intersects(cow1.r, rectBody) || Rect.intersects(cow1.r, rectWing) || Rect.intersects(cow1.r, rectTail)) {
            cow1.explode = true;
            crashing = true;
            speedX++;

        } else if (Rect.intersects(cow2.r, rectBody) || Rect.intersects(cow2.r, rectWing) || Rect.intersects(cow2.r, rectTail)) {
            cow2.explode = true;
            crashing = true;
            speedX++;

        }
    }
}
