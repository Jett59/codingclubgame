package app.cleancode.game.coin;

import app.cleancode.game.GameObject;
import app.cleancode.sound.Sound;
import app.cleancode.sound.SoundBuilder;
import app.cleancode.sprite.Sprite;
import app.cleancode.sprite.SpriteBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoinGameObject extends GameObject {
	public static double height = 150;
public ObservableList<Sprite> coins;
public Sound sound;
private final SpriteBuilder spriteBuilder;
private final SoundBuilder soundBuilder;
public CoinGameObject() {
	spriteBuilder = new SpriteBuilder();
	soundBuilder = new SoundBuilder();
	coins = FXCollections.observableArrayList();
	sound = soundBuilder.build("coin", "wav");
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
