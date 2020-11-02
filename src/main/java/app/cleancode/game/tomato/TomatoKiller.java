package app.cleancode.game.tomato;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.game.GameListener;

public class TomatoKiller extends GameListener {
public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
public TomatoGameObject tomato;

@Override
public void update() {
	if(tomato.dead) {
		tomato.sprite.setTranslateY(0);
		tomato.sprite.setTranslateX(0);
		tomato.xVelocity = 0;
		tomato.yVelocity = 0;
		tomato.score = 0;
		tomato.dead = false;
	}
	if(tomato.sprite.getTranslateY()> screenSize.height*1.5d) {
		tomato.dead = true;
	}
}

@Override
public void startup() {
	
}

@Override
public String[] getGameObjects() {
	return new String[] {
			"tomato"
	};
}
}
