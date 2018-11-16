package com.x.ufogame;

import android.graphics.Rect;

public class Cow {


    public boolean left = false, right = true, beamMeUp = false, explode = false;
    public boolean mooSound = false;
    private UFO ufo = GameScreen.getUfo();
    private int ground = 390;
    private int speedX;
    public Rect r = new Rect(0, 0, 0, 0);

    private int origX;


    public Cow(int x, int sX) {
        origX = x;
        speedX = sX;

    }
    public int posX = origX, posY = ground;

    private int velX = 4;
    private int velY;


    public void update() {

        r.set(posX, posY + 5, posX + 115, posY + 55);

        if(posX < -200) {
            velX = speedX;
            right = true;
            left = false;
            posX = -200;
        } else if(posX > 1000) {
            velX = -speedX;
            left = true;
            right = false;
            posX = 1000;
        }
        if(posX + 50 > ufo.posX && posX + 50 < ufo.posX + 200) {
            ufo.cowInX = true;
        } else {
            ufo.cowInX = false;
        }

        if (explode) {
            ufo.score += 5;
            posX = origX;
            posY = ground;
            beamMeUp = false;
            explode = false;

        } else {
            if(ufo.cowInX && posY > ufo.posY) {
                velY = -10;
                beamMeUp = true;
                if(posY == ground) {
                    mooSound = true;
                } else {
                    mooSound = false;
                }
            } else if(ufo.cowInX && Rect.intersects(r, ufo.rectTall)) {
                ufo.cowGot = true;
                posX = origX;
                posY = ground;
                beamMeUp = false;
            } else if (posY < ground){
                beamMeUp = false;
                velY += 1;
            } else {
                beamMeUp = false;
                velY = 0;
                posY = ground;
            }
        }

        posY += velY;

        posX += velX;



    }

}
