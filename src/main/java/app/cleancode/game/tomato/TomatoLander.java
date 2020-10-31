package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;
import app.cleancode.game.floor.FloorGameObject;
import app.cleancode.game.platforms.PlatformsGameObject;
import javafx.scene.shape.Rectangle;

public class TomatoLander extends GameListener {
public FloorGameObject floor;
public TomatoGameObject tomato;
public PlatformsGameObject platforms;

	@Override
	public void update() {
		tomato.touchingGround = false;
		for(var platform : platforms.platforms) {
			checkCollision(platform);
		}
		checkCollision(floor.floor);
		}

private void checkCollision(Rectangle otherRectangle) {
	if(tomato.sprite.checkCollision(otherRectangle.getBoundsInParent())) {
		var bounds = tomato.sprite.getSpriteBoundsInLocal();
		var newY = (otherRectangle.getY()-(bounds.getMinY()+bounds.getHeight()))+1;
		tomato.sprite.setTranslateY(newY);
		tomato.touchingGround = true;
		tomato.yVelocity = tomato.yVelocity*-0.75;
	}
}

	@Override
	public void startup() {
		
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"floor",
				"tomato",
				"platforms"
		};
	}

}
