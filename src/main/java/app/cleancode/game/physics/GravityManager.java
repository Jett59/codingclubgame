package app.cleancode.game.physics;

import app.cleancode.game.GameListener;
import app.cleancode.game.tomato.TomatoGameObject;

public class GravityManager extends GameListener {
public TomatoGameObject tomato;

@Override
public void update() {
	tomato.yVelocity+=1.2;
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
