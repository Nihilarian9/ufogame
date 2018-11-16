package com.x.ufogame;

import com.x.framework.Screen;
import com.x.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {

	boolean firstTimeCreate = true;

	public static HighScore highscore = new HighScore();

	@Override
	public Screen getInitScreen() {

		if (firstTimeCreate) {
			Assets.load(this);
			firstTimeCreate = false;
		}

		GameScreen.highScore = highscore.readHighScore();

		return new SplashLoadingScreen(this);

	}

	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}


	@Override
	public void onResume() {
		super.onResume();

//		Assets.theme.play();

	}

	@Override
	public void onPause() {
		super.onPause();
//		Assets.theme.pause();

	}
	
	
}