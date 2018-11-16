package com.x.ufogame;

import android.provider.ContactsContract;

import com.x.framework.Game;
import com.x.framework.Graphics;
import com.x.framework.Graphics.ImageFormat;
import com.x.framework.Screen;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("intro1.png", ImageFormat.RGB565);
		Assets.background = g.newImage("background.png", ImageFormat.RGB565);
		Assets.outro1 = g.newImage("outro1.png", ImageFormat.RGB565);
		Assets.soundoff = g.newImage("soundoff.png", ImageFormat.RGB565);
		Assets.soundon = g.newImage("soundon.png", ImageFormat.RGB565);

		Assets.ufo1 = g.newImage("ufo1.png", ImageFormat.ARGB4444);
		Assets.ufo2 = g.newImage("ufo2.png", ImageFormat.ARGB4444);
		Assets.ufo3 = g.newImage("ufo3.png", ImageFormat.ARGB4444);
		Assets.ufocrash1 = g.newImage("ufocrash1.png", ImageFormat.ARGB4444);
		Assets.ufocrash2 = g.newImage("ufocrash2.png", ImageFormat.ARGB4444);
		Assets.ufocrash3 = g.newImage("ufocrash3.png", ImageFormat.ARGB4444);
		Assets.ufocrashed = g.newImage("ufocrashed.png", ImageFormat.ARGB4444);
		Assets.beam = g.newImage("beam.png", ImageFormat.ARGB4444);

		Assets.portal1 = g.newImage("portal1.png", ImageFormat.ARGB4444);
		Assets.portal2 = g.newImage("portal2.png", ImageFormat.ARGB4444);
		Assets.portal3 = g.newImage("portal3.png", ImageFormat.ARGB4444);
		Assets.portal4 = g.newImage("portal4.png", ImageFormat.ARGB4444);
		Assets.portal5 = g.newImage("portal5.png", ImageFormat.ARGB4444);
		Assets.portal6 = g.newImage("portal6.png", ImageFormat.ARGB4444);
		Assets.portal7 = g.newImage("portal7.png", ImageFormat.ARGB4444);

		Assets.cowLeft = g.newImage("cowLeft.png", ImageFormat.ARGB4444);
		Assets.cowRight = g.newImage("cowRight.png", ImageFormat.ARGB4444);
		Assets.cowexplode1 = g.newImage("cowexplode1.png", ImageFormat.ARGB4444);
		Assets.cowexplode2 = g.newImage("cowexplode2.png", ImageFormat.ARGB4444);
		Assets.cowexplode3 = g.newImage("cowexplode3.png", ImageFormat.ARGB4444);

		Assets.jetLeft1 = g.newImage("jetLeft1.png", ImageFormat.ARGB4444);
		Assets.jetLeft2 = g.newImage("jetLeft2.png", ImageFormat.ARGB4444);
		Assets.jetLeft3 = g.newImage("jetLeft3.png", ImageFormat.ARGB4444);
		Assets.jetRight1 = g.newImage("jetRight1.png", ImageFormat.ARGB4444);
		Assets.jetRight2 = g.newImage("jetRight2.png", ImageFormat.ARGB4444);
		Assets.jetRight3 = g.newImage("jetRight3.png", ImageFormat.ARGB4444);

		Assets.jetcrashingleft1 = g.newImage("jetcrashingleft1.png", ImageFormat.ARGB4444);
		Assets.jetcrashingleft2 = g.newImage("jetcrashingleft2.png", ImageFormat.ARGB4444);
		Assets.jetcrashingleft3 = g.newImage("jetcrashingleft3.png", ImageFormat.ARGB4444);
		Assets.jetcrashingleft4 = g.newImage("jetcrashingleft4.png", ImageFormat.ARGB4444);
		Assets.jetcrashingright1 = g.newImage("jetcrashingright1.png", ImageFormat.ARGB4444);
		Assets.jetcrashingright2 = g.newImage("jetcrashingright2.png", ImageFormat.ARGB4444);
		Assets.jetcrashingright3 = g.newImage("jetcrashingright3.png", ImageFormat.ARGB4444);
		Assets.jetcrashingright4 = g.newImage("jetcrashingright4.png", ImageFormat.ARGB4444);

		Assets.jetcrashedleft1 = g.newImage("jetcrashedleft1.png", ImageFormat.ARGB4444);
		Assets.jetcrashedleft2 = g.newImage("jetcrashedleft2.png", ImageFormat.ARGB4444);
		Assets.jetcrashedright1 = g.newImage("jetcrashedright1.png", ImageFormat.ARGB4444);
		Assets.jetcrashedright2 = g.newImage("jetcrashedright2.png", ImageFormat.ARGB4444);


		Assets.cowget = game.getAudio().createSound("cowget.wav");
		Assets.jetcrashsound = game.getAudio().createSound("explode.wav");
		Assets.moosound = game.getAudio().createSound("moo.wav");

		
		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}