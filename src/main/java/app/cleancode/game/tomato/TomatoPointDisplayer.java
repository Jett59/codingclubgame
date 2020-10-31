package app.cleancode.game.tomato;

import app.cleancode.game.GameListener;
import javafx.scene.text.Text;

public class TomatoPointDisplayer extends GameListener {
private Text pointText;
public TomatoGameObject tomato;
@Override
public void update() {
	pointText.setTranslateX(tomato.sprite.getTranslateX());
	pointText.setText(String.format("%d points!", tomato.score));
}
@Override
public void startup() {
	pointText = new Text("Loading!");
	pointText.setTranslateY(150);
	tomato.addNode(pointText);
	pointText.getStyleClass().add("pointText");
}
@Override
public String[] getGameObjects() {
	return new String[] {
			"tomato"
	};
}
}
