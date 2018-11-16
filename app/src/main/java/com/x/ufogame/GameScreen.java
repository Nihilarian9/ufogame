package com.x.ufogame;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.x.framework.Game;
import com.x.framework.Graphics;
import com.x.framework.Image;
import com.x.framework.Input.TouchEvent;
import com.x.framework.Screen;


/*
* TODO:
* AESTHETIC IMPROVEMENTS:
* cow animations?
*
*/


public class GameScreen extends Screen {
	enum GameState {
		Ready, Running, Paused, GameOver, GameWin;
	}

	GameState state = GameState.Ready;

	public static boolean isMuted = false;

	// Variable Setup

	private static UFO ufo;
	private static Cow cow1, cow2;
	private static Jet jet1, jet2;

	private Image ufoImage, cowImage, cowImage2, jetImage1, jetImage2, portal;

	private Image background, outro1, ufo1, ufo2, ufo3, ufocrash1, ufocrash2, ufocrash3, ufocrashed, beam;
	private Image cowLeft, cowRight, cowexplode1, cowexplode2, cowexplode3;
	private Image jetLeft1, jetLeft2, jetLeft3, jetRight1, jetRight2, jetRight3,
			jetcrashingleft1, jetcrashingleft2, jetcrashingleft3, jetcrashingleft4,
			jetcrashingright1, jetcrashingright2, jetcrashingright3, jetcrashingright4,
			jetcrashedright1, jetcrashedright2, jetcrashedleft1, jetcrashedleft2;
	private Image portal1, portal2, portal3, portal4, portal5, portal6, portal7;

	private Animation ufoAnim, ufoCrashAnim, jetLeftAnim, jetRightAnim, cowExplodeAnim, jetCrashingLeftAnim,
			jetCrashingRightAnim, jetCrashedLeftAnim, jetCrashedRightAnim, portalAnim;

	public static int highScore;
	private boolean newHighScore;

	Paint paint, paint2;

	public GameScreen(Game game) {
		super(game);

		// Initialize game objects here

		ufo = new UFO(300, 0);
		cow1 = new Cow(-200, 3);
		cow2 = new Cow(1000, 4);
		jet1 = new Jet(1300, 1);
		jet2 = new Jet(-500, 170);

		background = Assets.background;
		outro1 = Assets.outro1;

		ufo1 = Assets.ufo1;
		ufo2 = Assets.ufo2;
		ufo3 = Assets.ufo3;
		ufocrash1 = Assets.ufocrash1;
		ufocrash2 = Assets.ufocrash2;
		ufocrash3 = Assets.ufocrash3;
		ufocrashed = Assets.ufocrashed;
		beam = Assets.beam;

		portal1 = Assets.portal1;
		portal2 = Assets.portal2;
		portal3 = Assets.portal3;
		portal4 = Assets.portal4;
		portal5 = Assets.portal5;
		portal6 = Assets.portal6;
		portal7 = Assets.portal7;

		cowLeft = Assets.cowLeft;
		cowRight = Assets.cowRight;
		cowexplode1 = Assets.cowexplode1;
		cowexplode2 = Assets.cowexplode2;
		cowexplode3 = Assets.cowexplode3;

		jetLeft1 = Assets.jetLeft1;
		jetLeft2 = Assets.jetLeft2;
		jetLeft3 = Assets.jetLeft3;
		jetRight1 = Assets.jetRight1;
		jetRight2 = Assets.jetRight2;
		jetRight3 = Assets.jetRight3;

		jetcrashingleft1 = Assets.jetcrashingleft1;
		jetcrashingleft2 = Assets.jetcrashingleft2;
		jetcrashingleft3 = Assets.jetcrashingleft3;
		jetcrashingleft4 = Assets.jetcrashingleft4;
		jetcrashingright1 = Assets.jetcrashingright1;
		jetcrashingright2 = Assets.jetcrashingright2;
		jetcrashingright3 = Assets.jetcrashingright3;
		jetcrashingright4 = Assets.jetcrashingright4;

		jetcrashedleft1 = Assets.jetcrashedleft1;
		jetcrashedleft2 = Assets.jetcrashedleft2;
		jetcrashedright1 = Assets.jetcrashedright1;
		jetcrashedright2 = Assets.jetcrashedright2;

//		HERE COME THE ANIMATIONS MUTHA FUCKA

		ufoAnim = new Animation();
		ufoAnim.addFrame(ufo1, 50);
		ufoAnim.addFrame(ufo2, 50);
		ufoAnim.addFrame(ufo3, 50);

		portalAnim = new Animation();
		portalAnim.addFrame(portal1, 50);
		portalAnim.addFrame(portal2, 50);
		portalAnim.addFrame(portal3, 50);
		portalAnim.addFrame(portal4, 50);
		portalAnim.addFrame(portal5, 50);
		portalAnim.addFrame(portal6, 50);
		portalAnim.addFrame(portal7, 50);

		ufoCrashAnim = new Animation();
		ufoCrashAnim.addFrame(ufocrash1, 50);
		ufoCrashAnim.addFrame(ufocrash2, 50);
		ufoCrashAnim.addFrame(ufocrash3, 50);
		ufoCrashAnim.addFrame(ufocrash1, 50);

		cowExplodeAnim = new Animation();
		cowExplodeAnim.addFrame(cowexplode1, 100);
		cowExplodeAnim.addFrame(cowexplode2, 100);
		cowExplodeAnim.addFrame(cowexplode3, 100);

		jetLeftAnim = new Animation();
		jetLeftAnim.addFrame(jetLeft1, 100);
		jetLeftAnim.addFrame(jetLeft2, 100);
		jetLeftAnim.addFrame(jetLeft3, 100);

		jetRightAnim = new Animation();
		jetRightAnim.addFrame(jetRight1, 100);
		jetRightAnim.addFrame(jetRight2, 100);
		jetRightAnim.addFrame(jetRight3, 100);

		jetCrashingLeftAnim = new Animation();
		jetCrashingLeftAnim.addFrame(jetcrashingleft1, 100);
		jetCrashingLeftAnim.addFrame(jetcrashingleft2, 100);
		jetCrashingLeftAnim.addFrame(jetcrashingleft3, 100);
		jetCrashingLeftAnim.addFrame(jetcrashingleft4, 100);

		jetCrashingRightAnim = new Animation();
		jetCrashingRightAnim.addFrame(jetcrashingright1, 100);
		jetCrashingRightAnim.addFrame(jetcrashingright2, 100);
		jetCrashingRightAnim.addFrame(jetcrashingright3, 100);
		jetCrashingRightAnim.addFrame(jetcrashingright4, 100);

		jetCrashedLeftAnim = new Animation();
		jetCrashedLeftAnim.addFrame(jetcrashedleft1, 100);
		jetCrashedLeftAnim.addFrame(jetcrashedleft2, 100);

		jetCrashedRightAnim = new Animation();
		jetCrashedRightAnim.addFrame(jetcrashedright1, 100);
		jetCrashedRightAnim.addFrame(jetcrashedright2, 100);

//		rainAnim = new Animation();
//		rainAnim.addFrame(Assets.rain1, 100);
//		rainAnim.addFrame(Assets.rain2, 100);


		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);

		paint2 = new Paint();
		paint2.setTextSize(50);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.RED);

		ufoImage = ufo1;
		cowImage = cowRight;
		cowImage2 = cowRight;
		jetImage1 = jetcrashedleft1;
		jetImage2 = jetcrashedright2;
		portal = portal1;

	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		// GameState update methods

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
		if (state == GameState.GameWin)
			updateGameWin(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {


		// When the user touches the screen, the game begins.

		if (touchEvents.size() > 0) {
			if(!isMuted) {
				Assets.theme.stop();
			}

			state = GameState.Running;
			ufo.score = 0;
			newHighScore = false;
		}

	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

		// This is identical to the update() method from our Unit 2/3 game.


		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				ufo.destX = event.x;
				ufo.destY = event.y;
				ufo.ufoMoving = true;

			}

			if (event.type == TouchEvent.TOUCH_DRAGGED) {
				ufo.destX = event.x;
				ufo.destY = event.y;
				ufo.ufoMoving = true;
			}

			if (event.type == TouchEvent.TOUCH_UP) {
				ufo.ufoMoving = false;
			}

		}

//			COW IMAGE HANDLES
		if(cow1.explode){
			cowImage = cowExplodeAnim.getImage();

		} else {
			if(cow1.left) {
				cowImage = cowLeft;
			} else if(cow1.right) {
				cowImage = cowRight;
			}
		}
		if(cow2.explode){
			cowImage2 = cowExplodeAnim.getImage();

		} else {
			if(cow2.left) {
				cowImage2 = cowLeft;
			} else if(cow2.right) {
				cowImage2 = cowRight;
			}
		}

//			JET IMAGE HANDLES
		if(jet1.left){
			if(jet1.crashing) {
				jetImage1 = jetCrashingLeftAnim.getImage();
			} else if (jet1.crashed) {
				jetImage1 = jetCrashedLeftAnim.getImage();
				playJetCrash(jet1);
			} else {
				jetImage1 = jetLeftAnim.getImage();
			}
		} else if(jet1.right) {
			if(jet1.crashing) {
				jetImage1 = jetCrashingRightAnim.getImage();
			} else if (jet1.crashed) {
				jetImage1 = jetCrashedRightAnim.getImage();
				playJetCrash(jet1);
			} else {
				jetImage1 = jetRightAnim.getImage();
			}
		}

		if(jet2.left){
			if(jet2.crashing) {
				jetImage2 = jetCrashingLeftAnim.getImage();
			} else if (jet2.crashed) {
				jetImage2 = jetCrashedLeftAnim.getImage();
				playJetCrash(jet2);
			} else {
				jetImage2 = jetLeftAnim.getImage();
			}
		} else if(jet2.right) {
			if(jet2.crashing) {
				jetImage2 = jetCrashingRightAnim.getImage();
			} else if (jet2.crashed) {
				jetImage2 = jetCrashedRightAnim.getImage();
				playJetCrash(jet2);
			} else {
				jetImage2 = jetRightAnim.getImage();
			}
		}

//			UFO IMAGE HANDLES
		if (ufo.isKill && ufo.score > 50) { //TODO change win score threshold here.

			state = GameState.GameWin;
			ufo.portalReady = true;

		}else if (ufo.isKill && !ufo.gameOver) {
			ufoImage = ufoCrashAnim.getImage();
			ufo.crash();

		} else if (ufo.gameOver) {
			ufoImage = ufocrashed;
			state = GameState.GameOver;
		} else {
			ufoImage = ufoAnim.getImage();

			if(cow1.mooSound || cow2.mooSound) {
				playMoo();
			}
			if(ufo.cowGot) {
				playCow();
			}
			ufo.update();
		}

		cow1.update();
		cow2.update();
		jet1.update();
		jet2.update();

		animate();

	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		// TODO highscore stuff

		if (ufo.score > highScore) {
			highScore = ufo.score;
			SampleGame.highscore.writeHighScore(highScore);
			newHighScore = true;
		}
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));

					if(!isMuted) {
						Assets.theme.play();
					}
					return;
				}
			}
		}
	}

	private void updateGameWin(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				ufo.destX = event.x;
				ufo.destY = event.y;
				ufo.ufoMoving = true;
			}

			if (event.type == TouchEvent.TOUCH_DRAGGED) {
				ufo.destX = event.x;
				ufo.destY = event.y;
				ufo.ufoMoving = true;
			}

			if (event.type == TouchEvent.TOUCH_UP) {
				ufo.ufoMoving = false;

			}

		}
		if (ufo.portalThrough) {

			state = GameState.GameOver;
		}
		ufoImage = ufoAnim.getImage();
		portal = portalAnim.getImage();
		ufo.update();
		animate();
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		// First draw the game elements.

		g.drawImage(background, 0, 0);

		if (state == GameState.GameWin) {
			jet1.posX = 2000;
			jet2.posX = 2000;
			cow1.posX = 2000;
			cow2.posX = 2000;

		} else {

			g.drawImage(jetImage1, jet1.posX, jet1.posY);
			g.drawImage(jetImage2, jet2.posX, jet2.posY);
			g.drawImage(cowImage, cow1.posX, cow1.posY);
			g.drawImage(cowImage2, cow2.posX, cow2.posY);

		}
		if(cow1.beamMeUp || cow2.beamMeUp) {
			g.drawImage(beam, ufo.posX - 75, ufo.posY);
		}

		g.drawImage(ufoImage, ufo.posX, ufo.posY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();
		if (state == GameState.GameWin)
			drawGameWinUI();

	}

	public void animate() {
		ufoAnim.update(10);
		ufoCrashAnim.update(10);
		cowExplodeAnim.update(10);
		jetLeftAnim.update(10);
		jetRightAnim.update(10);
		jetCrashingLeftAnim.update(10);
		jetCrashingRightAnim.update(10);
		jetCrashedLeftAnim.update(10);
		jetCrashedRightAnim.update(10);
		portalAnim.update(10);

	}

	private void nullify() {

		// Set all variables to null. You will be recreating them in the
		// constructor.
		paint = null;
		paint2 = null;

		ufo = null;
		cow1 = null;
		cow2 = null;
		jet1 = null;
		jet2 = null;

		ufoImage = null;
		jetImage1 = null;
		jetImage2 = null;
		cowImage = null;
		cowImage2 = null;

		portal = null;
		portal1 = null;
		portal2 = null;
		portal3 = null;
		portal4 = null;
		portal5 = null;
		portal6 = null;
		portal7 = null;

		background = null;
		outro1 = null;
		ufo1 = null;
		ufo2 = null;
		ufo3 = null;
		ufocrash1 = null;
		ufocrash2 = null;
		ufocrash3 = null;
		ufocrashed = null;

		cowLeft = null;
		cowRight = null;
		cowexplode1 = null;
		cowexplode2 = null;
		cowexplode3 = null;

		jetLeft1 = null;
		jetLeft2 = null;
		jetLeft3 = null;
		jetRight1 = null;
		jetRight2 = null;
		jetRight3 = null;

		jetcrashingleft1 = null;
		jetcrashingleft2 = null;
		jetcrashingleft3 = null;
		jetcrashingleft4 = null;
		jetcrashingright1 = null;
		jetcrashingright2 = null;
		jetcrashingright3 = null;
		jetcrashingright4 = null;

		jetcrashedleft1 = null;
		jetcrashedleft2 = null;
		jetcrashedright1 = null;
		jetcrashedright2 = null;

		ufoAnim = null;
		ufoCrashAnim = null;
		cowExplodeAnim = null;
		jetLeftAnim = null;
		jetRightAnim = null;
		jetCrashingLeftAnim = null;
		jetCrashingRightAnim = null;
		jetCrashedLeftAnim = null;
		jetCrashedRightAnim = null;
		portalAnim = null;
//		rainAnim = null;

		// Call garbage collector to clean up memory.
		System.gc();

	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("COLLECT THE MOOMOOS", 400, 240, paint);

	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();
	}

	private void drawPausedUI() { //TODO suss out pause menu
		Graphics g = game.getGraphics();
		// Darken the entire screen so you can display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 360, paint2);

	}

	private void drawGameOverUI() {
		/// game over to draw differently depending on whether it was gamewin or game lose;
		if(ufo.portalThrough) {
			Graphics g = game.getGraphics();
			g.drawRect(0, 0, 801, 481, Color.BLACK);
			g.drawImage(outro1, 0, 0);
			g.drawString("You look upon your beautiful homeworld", 400, 370, paint);
			g.drawString("and vow never to leave it again.", 400, 400, paint);

			if(newHighScore) {
				g.drawString("NEW HIGH SCORE", 400, 50, paint2);
				g.drawString(String.valueOf(highScore), 400, 100, paint2);
			} else {
				g.drawString("Score", 400, 100, paint);
				g.drawString(String.valueOf(ufo.score), 400, 130, paint);
			}

			g.drawImage(ufoImage, ufo.posX - 50, ufo.posY);

		} else {
			Graphics g = game.getGraphics();
			g.drawRect(0, 0, 801, 481, Color.BLACK);
			g.drawString("You didn't make it home.", 400, 330, paint);
			g.drawString("It's off to AREA 51 for you.", 400, 360, paint);

			if(newHighScore) {
				g.drawString("NEW HIGH SCORE", 400, 50, paint2);
				g.drawString(String.valueOf(highScore), 400, 100, paint2);
			} else {
				g.drawString("Score", 400, 100, paint);
				g.drawString(String.valueOf(ufo.score), 400, 130, paint);
			}
			g.drawImage(ufoImage, ufo.posX, ufo.posY);
		}

	}

	private void drawGameWinUI() {
		Graphics g = game.getGraphics();
		g.drawImage(background, 0, 0);
		g.drawImage(ufoImage, ufo.posX, ufo.posY);
		g.drawImage(portal, 0, 0);

		g.drawString("The warp field has opened", 400, 330, paint);
		g.drawString("fly through to return home", 400, 360, paint);

	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;

	}

	@Override
	public void resume() {
		if (state == GameState.Paused)
			state = GameState.Running;
	}


	@Override
	public void dispose() {

	}

	public static void playCow() {
		if(!isMuted) {
			Assets.cowget.play(0.25f);
		}
	}

	public static void playMoo() {
		if(!isMuted) {
			Assets.moosound.play(0.05f);
		}
	}

	public static void playJetCrash(Jet jet) {
		if (!isMuted) {
			if (jet.crashsound) {
				Assets.jetcrashsound.play(0.30f);
			}
		}
	}

	@Override
	public void backButton() {
		pause();
	}

	private void goToMenu() {

		game.setScreen(new MainMenuScreen(game));

	}

	public static Cow getCow1() {

		return cow1;
	}

	public static Cow getCow2() {

		return cow2;
	}

	public static UFO getUfo() {

		return ufo;
	}

}