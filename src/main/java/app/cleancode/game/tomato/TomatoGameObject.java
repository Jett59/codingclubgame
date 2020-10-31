package app.cleancode.game.tomato;

import app.cleancode.game.GameObject;
import app.cleancode.sprite.Sprite;
import app.cleancode.sprite.SpriteBuilder;

public class TomatoGameObject extends GameObject {
	public static double TOMATO_HEIGHT = 256;
	public static double TERMINAL_VELOCITY = Double.MAX_VALUE;
public Sprite sprite;
public double yVelocity = 0d;
public double xVelocity = 0;
public boolean touchingGround = false;
private SpriteBuilder spriteBuilder;
public TomatoGameObject(SpriteBuilder spriteBuilder) {
	this.spriteBuilder = spriteBuilder;
	sprite = spriteBuilder.build("tomato", TOMATO_HEIGHT, false);
	System.out.printf("%.1fx%.1f\n", sprite.getSpriteBoundsInLocal().getWidth(), sprite.getSpriteBoundsInLocal().getHeight());
}
public TomatoGameObject() {
	this(new SpriteBuilder());
}
	@Override
	public String getName() {
		return "tomato";
	}

}
