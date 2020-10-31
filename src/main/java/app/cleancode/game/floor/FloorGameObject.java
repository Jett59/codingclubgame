package app.cleancode.game.floor;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.game.GameObject;
import javafx.scene.shape.Rectangle;

public class FloorGameObject extends GameObject {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public Rectangle floor;
public FloorGameObject() {
	floor = new Rectangle(0, 1024, screenSize.width, screenSize.height-1024);
	floor.setVisible(true);
	floor.getStyleClass().add("floor");
}
@Override
public String getName() {
	return "floor";
}
}
