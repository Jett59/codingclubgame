package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;
import app.cleancode.sound.SoundBuilder;

public class TomatoSpawner extends GameListener {
public TomatoGameObject tomato;
	
	@Override
	public void update() {
		
	}

	@Override
	public void startup() {
		tomato.addNode(tomato.sprite);
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"tomato"
		};
	}

}
