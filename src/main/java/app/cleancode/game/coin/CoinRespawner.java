package app.cleancode.game.coin;

import app.cleancode.game.GameListener;
import app.cleancode.game.tomato.TomatoGameObject;

public class CoinRespawner extends GameListener {
public TomatoGameObject tomato;
public CoinGameObject coins;

	@Override
	public void update() {
		if(tomato.dead) {
			for(var coin : coins.coins) {
				coin.setVisible(true);
			}
		}
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"tomato",
				"coins"
		};
	}

}
