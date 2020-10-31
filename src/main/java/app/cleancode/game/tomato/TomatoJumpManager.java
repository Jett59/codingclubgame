package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;
import app.cleancode.sound.Sound;
import app.cleancode.sound.SoundBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TomatoJumpManager extends GameListener {
	public static double jumpAmount = 25;
public TomatoGameObject tomato;
private SoundBuilder soundBuilder;
private Sound sound;
private boolean jumping = false;

	@Override
	public void update() {
		if(jumping) {
			if(tomato.touchingGround) {
				tomato.yVelocity-=jumpAmount;
				sound.stop();
				sound.play();
			}
		}
	}

	@Override
	public void startup() {
		soundBuilder = new SoundBuilder();
		sound = soundBuilder.build("jump", "mp3");
		tomato.sprite.getScene().addEventHandler(KeyEvent.KEY_PRESSED, evt->{
			if(evt.getCode().equals(KeyCode.SPACE)) {
				jumping = true;
			}
		});
		tomato.sprite.getScene().addEventHandler(KeyEvent.KEY_RELEASED, evt->{
			if(evt.getCode().equals(KeyCode.SPACE)) {
				jumping = false;
			}
		});
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"tomato"
		};
	}

}
