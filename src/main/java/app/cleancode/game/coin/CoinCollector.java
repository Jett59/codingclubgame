package app.cleancode.game.coin;

import app.cleancode.game.GameListener;
import app.cleancode.game.tomato.TomatoGameObject;

public class CoinCollector extends GameListener {
public CoinGameObject coins;
public TomatoGameObject tomato;

	@Override
	public void update() {
		for(var coin : coins.coins) {
			if(coin.isVisible()) {
				if(coin.checkCollision(tomato.sprite.getSpriteBoundsInParent())) {
					tomato.score++;
					coin.setVisible(false);
					coins.sound.stop();
					coins.sound.play();
				}
			}
		}
	}

	@Override
	public void startup() {
		
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"coins",
				"tomato"
		};
	}

}
