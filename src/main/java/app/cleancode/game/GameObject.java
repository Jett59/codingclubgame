package app.cleancode.game;

import java.util.function.Consumer;

import javafx.scene.Node;

public abstract class GameObject {
public Consumer<Node> addNode;
public void addNode(Node node) {
	addNode.accept(node);
}
public abstract String getName();
}
