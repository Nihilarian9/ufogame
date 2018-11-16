package com.x.ufogame;

import android.graphics.Rect;

public class UFO {

    public int posX, posY;

    public UFO(int x, int y) {

        posX = x;
        posY = y;
    }

    private int velX, velY, maxSpeed = 8;
    public int destX, destY;
//    public boolean down = false, up = false, left = false, right = false;
    public boolean ufoMoving = false;
    public boolean cowGot = false, cowInX, isKill = false, gameOver = false;
    public boolean portalReady = false, portalOpen = false, portalThrough = false;
    public static int score = 0;


    public Rect rectWide = new Rect(0, 0, 0, 0);
    public Rect rectTall = new Rect(0, 0, 0, 0);
    private Rect portal = new Rect(0, 0, 0, 0);

    public void update() {

        if (ufoMoving) {
            if (posX + 100 < destX - 8) {
                velX = maxSpeed;
            } else if (posX + 100 > destX + 8) {
                velX = -maxSpeed;
            } else {
                velX = 0;
            }
            if (posY + 30 < destY - 8) {
                velY = maxSpeed;
            } else if (posY + 30 > destY + 8) {
                velY = -maxSpeed;
            } else {
                velY = 0;
            }
        } else {
            velX = 0;
            velY = 0;
        }


        if (cowGot) {
            score++;
            cowGot = false;
        }

        if(portalReady) {
            if(!portalOpen) {
                velX = maxSpeed;
                if (posX > 500) {
                    portalOpen = true;
                }
            } else {
                portal.set(0, 0, 150, 200);
                if (Rect.intersects(rectTall, portal) || Rect.intersects(rectWide, portal)) {
                    portalThrough = true;
                }

            }
        } // end portalReady

        posY += velY;
        posX += velX;

//		BOUNDARIES
        if (posY > 300) {
            velY = 0;
            posY = 300;
        } else if (posY < 0) {
            velY = 0;
            posY = 0;
        }
        if (posX < 50) {
            velX = 0;
            posX = 50;
        } else if (posX > 550) {
            velX = 0;
            posX = 550;
        }
        rectWide.set(posX + 4, posY + 20, posX + 194, posY + 45);
        rectTall.set(posX + 40, posY + 9, posX + 170, posY + 55);

    } // end update

    public void crash() {

        if(posY < 410) {
            velY += 1;
        } else if (posY >= 410) {
            velY = 0;
            gameOver = true;
        }
        posY += velY;
    }

} // end class
