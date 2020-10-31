package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TomatoMovementControler extends GameListener {
	public static double speed = 1;
public TomatoGameObject tomato;
private Direction direction;
private boolean reversing = false;

	@Override
	public void update() {
		if(direction != null) {
			switch (direction) {
			case LEFT: {
				if(reversing) {
					tomato.xVelocity+=speed;
					if(tomato.xVelocity >= 0) {
						reversing = false;
						direction = null;
					}
				}else {
					if((TomatoGameObject.TERMINAL_VELOCITY*-1)+speed < tomato.xVelocity) {
				tomato.xVelocity-=speed;
					}
				}
				break;
			}
			case RIGHT: {
				if(reversing) {
					tomato.xVelocity-=speed;
					if(tomato.xVelocity <= 0) {
						reversing = false;
						direction = null;
					}
				}else {
					if(TomatoGameObject.TERMINAL_VELOCITY-speed > tomato.xVelocity) {
				tomato.xVelocity+=speed;
					}else {
						System.out.println("terminal velocity reached!");
					}
					System.out.println("velocity: "+tomato.xVelocity);
				}
				break;
			}
			default: break;
			}
		}
	}

	@Override
	public void startup() {
		tomato.sprite.getScene().addEventHandler(KeyEvent.KEY_PRESSED, evt->{
			Direction direction = Direction.ofKeyCode(evt.getCode());
			if(direction != null) {
				this.direction = direction;
			}
		});
		tomato.sprite.getScene().addEventHandler(KeyEvent.KEY_RELEASED, evt->{
			if(direction != null) {
				if(Direction.ofKeyCode(evt.getCode()).equals(direction)) {
					reversing = true;
				}
			}
		});
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"tomato"
		};
	}
private static enum Direction{
	LEFT(KeyCode.LEFT, KeyCode.A),
	RIGHT(KeyCode.RIGHT, KeyCode.D);
private final KeyCode primary;
private final KeyCode secondary;
private Direction(KeyCode primary, KeyCode secondary) {
	this.primary = primary;
	this.secondary = secondary;
}
public static Direction ofKeyCode(KeyCode code) {
	for(Direction direction : Direction.values()) {
		if(direction.secondary.equals(code) || direction.primary.equals(code)) {
			return direction;
		}
	}
	return null;
}
}
}
