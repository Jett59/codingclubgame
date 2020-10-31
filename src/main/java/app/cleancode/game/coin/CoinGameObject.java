package app.cleancode.game.coin;

import app.cleancode.game.GameObject;
import app.cleancode.sprite.Sprite;
import app.cleancode.sprite.SpriteBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoinGameObject extends GameObject {
	public static double height = 150;
public ObservableList<Sprite> coins;
private final SpriteBuilder spriteBuilder;
public CoinGameObject() {
	spriteBuilder = new SpriteBuilder();
	coins = FXCollections.observableArrayList();
}

public Sprite generateCoin() {
	var coin = spriteBuilder.build("coin", height, false);
	coins.add(coin);
	addNode(coin);
	return coin;
}
	@Override
	public String getName() {
		return "coins";
	}

}
