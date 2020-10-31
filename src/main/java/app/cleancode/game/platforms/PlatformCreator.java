package app.cleancode.game.platforms;

import java.util.Random;

import app.cleancode.game.GameListener;
import javafx.scene.shape.Rectangle;

public class PlatformCreator extends GameListener {
	public static int MAX_CONCURRENT_PLATFORM_GENERATIONS = 5;
	public static int platformSpacing = 750;
	public static int numberOfPlatforms = 100;
	public static double platformWidth = 500;
	public static double platformHeight = 12;
	public static double platformY = 512;
	public static double platformYVariation = 50;
public PlatformsGameObject platforms;
private int createdPlatforms = 0;
private Random rand = new Random();

	@Override
	public void update() {
		for(int i = 0; i < MAX_CONCURRENT_PLATFORM_GENERATIONS; i++) {
			if(createdPlatforms <= numberOfPlatforms) {
		double x = createdPlatforms*(platformWidth+platformSpacing);
		double y = rand.nextDouble()*(2*platformY)+1;
		Rectangle platform = new Rectangle(x, y, platformWidth, platformHeight);
		platforms.addNode(platform);
		platforms.platforms.add(platform);
		createdPlatforms++;
			}else {
				break;
			}
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
