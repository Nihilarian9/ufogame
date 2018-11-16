package com.x.ufogame;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import com.x.framework.Game;
import com.x.framework.Graphics;
import com.x.framework.Screen;
import com.x.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	public MainMenuScreen(Game game) {
		super(game);
	}
	Paint menuPaint;



	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();

		menuPaint = new Paint();
		menuPaint.setTextSize(30);
		menuPaint.setTextAlign(Paint.Align.CENTER);
		menuPaint.setAntiAlias(true);
		menuPaint.setColor(Color.MAGENTA);

		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

				if (inBounds(event, 35, 315, 280, 450)) {
					game.setScreen(new GameScreen(game));
				}
				if (inBounds(event, 50, 40, 70, 50)) {
					if(GameScreen.isMuted) {
						GameScreen.isMuted = false;
						Assets.theme.play();
					} else {
						GameScreen.isMuted = true;
						Assets.theme.pause();
					}
				}
			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();

		g.drawImage(Assets.menu, 0, 0);
		g.drawImage(Assets.ufo1, 300, 50);
		g.drawString("Highscore", 650, 60, menuPaint);
		g.drawString(String.valueOf(GameScreen.highScore), 650, 90, menuPaint);
		if(GameScreen.isMuted) {
			g.drawImage(Assets.soundoff, 50, 40);
		} else {
			g.drawImage(Assets.soundon, 50, 40);
		}
	}

	@Override
	public void pause() {
		Assets.theme.stop();
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {
        android.os.Process.killProcess(android.os.Process.myPid());

	}
}
