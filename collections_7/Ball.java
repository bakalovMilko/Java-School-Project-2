package collections_7;

import java.awt.Color;

public class Ball {
	int x = 0;
	int y = 0; // Current ball position
	int dx = 2; // Increment on ball's x-coordinate
	int dy = 2; // Increment on ball's y-coordinate
	int radius = 5; // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	public static double distance (Ball first, Ball second) {
		int distanceX = first.x - second.x;
		int distanceY = first.y - second.y;
		return Math.sqrt(distanceX*distanceX + distanceY*distanceY);
	}
	public static double distance(Ball first, int x, int y) {
		int distanceX = first.x - x;
		int distanceY = first.y - y;
		return Math.sqrt(distanceX*distanceX + distanceY*distanceY);
	}
}
