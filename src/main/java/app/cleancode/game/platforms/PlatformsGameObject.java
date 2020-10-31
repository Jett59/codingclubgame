package app.cleancode.game.platforms;

import app.cleancode.game.GameObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;

public class PlatformsGameObject extends GameObject {
public ObservableList<Rectangle> platforms;

public PlatformsGameObject() {
	platforms = FXCollections.observableArrayList();
}
	@Override
	public String getName() {
		return "platforms";
	}
}
