package app.cleancode.game.floor;

import app.cleancode.game.GameListener;

public class FloorCreator extends GameListener {
public FloorGameObject floor;

	@Override
	public void update() {
		
	}

	@Override
	public void startup() {
		floor.addNode(floor.floor);
		System.out.println("floor created!");
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"floor"
		};
	}

}
