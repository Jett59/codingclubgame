package app.cleancode.game.physics;

import app.cleancode.game.GameListener;
import app.cleancode.game.tomato.TomatoGameObject;

public class AirResistanceManager extends GameListener {
public TomatoGameObject tomato;
	
	@Override
	public void update() {
		tomato.yVelocity -= tomato.yVelocity/tomato.TERMINAL_VELOCITY;
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
