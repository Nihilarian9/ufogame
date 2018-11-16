package com.x.ufogame;

import com.x.framework.Image;
import com.x.framework.Music;
import com.x.framework.Sound;

public class Assets {

	public static Image menu, background, splash, outro1, soundon, soundoff;
	public static Image ufo1, ufo2, ufo3, ufocrash1, ufocrash2, ufocrash3, ufocrashed, beam;
	public static Image cowLeft, cowRight, cowexplode1, cowexplode2, cowexplode3;
	public static Image jetLeft1, jetLeft2, jetLeft3, jetRight1, jetRight2, jetRight3,
	jetcrashingleft1, jetcrashingleft2, jetcrashingleft3, jetcrashingleft4,
	jetcrashingright1, jetcrashingright2, jetcrashingright3, jetcrashingright4,
	jetcrashedright1, jetcrashedright2, jetcrashedleft1, jetcrashedleft2;
	public static Image portal1, portal2, portal3, portal4, portal5, portal6, portal7;

	public static Sound cowget, jetcrashsound, moosound;
	public static Music theme;

	public static void load(SampleGame sampleGame) {

		theme = sampleGame.getAudio().createMusic("piano2.ogg");
		theme.setLooping(true);
		theme.setVolume(0.30f);
		theme.play();

	}

	
}
