package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;

public class TomatoMovementManager extends GameListener {
public TomatoGameObject tomato;

	@Override
	public void update() {
		tomato.sprite.setTranslateY(tomato.sprite.getTranslateY()+tomato.yVelocity);
		tomato.sprite.setTranslateX(tomato.sprite.getTranslateX()+tomato.xVelocity);
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
