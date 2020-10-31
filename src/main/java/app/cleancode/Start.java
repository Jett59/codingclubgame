package app.cleancode;

import app.cleancode.game.GameListener;
import app.cleancode.game.GameLoop;
import app.cleancode.game.GameObject;
import app.cleancode.game.camera.CameraMovementManager;
import app.cleancode.game.coin.CoinCollector;
import app.cleancode.game.coin.CoinGameObject;
import app.cleancode.game.coin.CoinSpawner;
import app.cleancode.game.floor.FloorCreator;
import app.cleancode.game.floor.FloorGameObject;
import app.cleancode.game.physics.AirResistanceManager;
import app.cleancode.game.physics.GravityManager;
import app.cleancode.game.platforms.PlatformCreator;
import app.cleancode.game.platforms.PlatformsGameObject;
import app.cleancode.game.tomato.TomatoGameObject;
import app.cleancode.game.tomato.TomatoJumpManager;
import app.cleancode.game.tomato.TomatoKiller;
import app.cleancode.game.tomato.TomatoLander;
import app.cleancode.game.tomato.TomatoMovementControler;
import app.cleancode.game.tomato.TomatoMovementManager;
import app.cleancode.game.tomato.TomatoPointDisplayer;
import app.cleancode.game.tomato.TomatoSpawner;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Start extends Application {
	private static GameListener[] gameListeners = new GameListener[] {
			new TomatoSpawner(),
			new TomatoJumpManager(),
			new TomatoMovementManager(),
			new TomatoLander(),
			new TomatoMovementControler(),
			new TomatoKiller(),
			new TomatoPointDisplayer(),
			new FloorCreator(),
			new PlatformCreator(),
			new CoinSpawner(),
			new CoinCollector(),
			new GravityManager(),
			new CameraMovementManager()
	};
	private static GameObject[] gameObjects = new GameObject[] {
			new TomatoGameObject(),
			new FloorGameObject(),
			new PlatformsGameObject(),
			new CoinGameObject()
	};
public static void main(String[] args) {
	launch(args);
}
private Pane nodes = new Pane();
 private Pane gamePane = new Pane();
@Override
public void start(Stage primaryStage) throws Exception {
	Scene scene = new Scene(gamePane);
	scene.getStylesheets().add("/app/cleancode/app.css");
	nodes.getChildren().add(new Text("Loading"));
	primaryStage.setTitle("Game");
	primaryStage.setFullScreen(true);
	primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	primaryStage.setScene(new Scene(nodes));
	primaryStage.show();
	for(GameListener listener : gameListeners) {
		for(String gameObjectName : listener.getGameObjects()) {
			for(GameObject gameObject : gameObjects) {
				gameObject.addNode = this::addNode;
				if(gameObject.getName().equalsIgnoreCase(gameObjectName)) {
					try {
						var gameObjectField = listener.getClass().getDeclaredField(gameObjectName);
						gameObjectField.set(listener, gameObject);
						break;
					}catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		listener.startup();
	}
	scene.setFill(Color.BLUE);
	primaryStage.setScene(scene);
	primaryStage.setFullScreen(true);
	GameLoop loop = new GameLoop(this::tick);
	loop.start();
}
public void tick() {
	for(GameListener gameListener : gameListeners) {
		gameListener.update();
	}
}
public void addNode(Node node) {
	gamePane.getChildren().add(node);
}
}
