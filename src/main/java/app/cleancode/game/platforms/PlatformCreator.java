package app.cleancode.game.platforms;

import app.cleancode.game.GameListener;
import javafx.scene.shape.Rectangle;

public class PlatformCreator extends GameListener {
	public static int MAX_CONCURRENT_PLATFORM_GENERATIONS = 5;
	public static int platformSpacing = 250;
	public static double platformWidth = 50;
	public static double platformHeight = 50;
	public static double platformY = 512;
public PlatformsGameObject platforms;
private int createdPlatforms = 0;

	@Override
	public void update() {
		for(int i = 0; i < MAX_CONCURRENT_PLATFORM_GENERATIONS; i++) {
		double x = createdPlatforms*(platformWidth+platformSpacing);
		Rectangle platform = new Rectangle(x, platformY, platformWidth, platformHeight);
		platforms.addNode(platform);
		platforms.platforms.add(platform);
		createdPlatforms++;
		}
	}

	@Override
	public void startup() {
		double x = createdPlatforms*(platformWidth+platformSpacing);
		Rectangle platform = new Rectangle(x, platformY, platformWidth, platformHeight);
		platforms.addNode(platform);
		platforms.platforms.add(platform);
		createdPlatforms++;
	}

	@Override
	public String[] getGameObjects() {
		return new String[] {
				"platforms"
		};
	}

}
