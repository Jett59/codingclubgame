package app.cleancode.game.camera;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.game.GameListener;
import app.cleancode.game.tomato.TomatoGameObject;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;

public class CameraMovementManager extends GameListener {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
public TomatoGameObject tomato;
private Camera camera;

	@Override
	public void update() {
		camera.setTranslateX(tomato.sprite.getTranslateX()-screenSize.width/2d);
	}

	@Override
	public void startup() {
		camera = new PerspectiveCamera();
		tomato.sprite
		.getScene()
		.setCamera(camera);
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"tomato"
		};
	}

}
