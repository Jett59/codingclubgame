package app.cleancode.game.coin;

import app.cleancode.game.GameListener;
import app.cleancode.game.platforms.PlatformsGameObject;

public class CoinSpawner extends GameListener {
	public static double heightAbovePlatform = 250;
public CoinGameObject coins;
public PlatformsGameObject platforms;
private int nextPlatformNumber = 1;

	@Override
	public void update() {
		if(platforms.platforms.size() > nextPlatformNumber) {
			var nextPlatform = platforms.platforms.get(nextPlatformNumber);
			double centreX = nextPlatform.getBoundsInParent().getCenterX();
			var coin = coins.generateCoin();
			double coinX = centreX-(coin.getSpriteBoundsInLocal().getWidth()/2d);
			double coinY = nextPlatform.getY()-heightAbovePlatform;
			coin.setTranslateX(coinX);
			coin.setTranslateY(coinY);
			nextPlatformNumber++;
		}
	}

	@Override
	public void startup() {
		
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"coins",
				"platforms"
		};
	}

}
