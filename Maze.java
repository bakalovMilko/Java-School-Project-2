package mazeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Maze {
	public int[][] maze;
	public Stack<Position> path = new Stack<Position>();
	public Position start;
	boolean isSolvable = false;

	public Maze(String filePath) throws FileNotFoundException {

		Scanner in = new Scanner(new File(filePath));
		int rows = Integer.parseInt(in.nextLine());
		this.maze = new int[rows][];

		for (int i = 0; i < rows; i++) {
			String line = in.nextLine();
			String[] numbers = line.split(", ");
			this.maze[i] = new int[numbers.length];
			for (int j = 0; j < numbers.length; j++) {
				this.maze[i][j] = Integer.parseInt(numbers[j]);
			}
		}

		this.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
	}
	
	public void solveMaze() {
		path.push(start);

		while (true) {
			int y = path.peek().y;
			int x = path.peek().x;

			if(maze[y][x]!=0)
				maze[y][x] = 3; // marking the positions I have already been on with zero, so we avoid going in
								// circles

			// down
			if (isValid(y + 1, x)) {
				if (maze[y + 1][x] == 2) {
					//System.out.println("Moved down");
					isSolvable = true;
					break;
				} else if (maze[y + 1][x] == 1) {
					System.out.println("Moved down");
					path.push(new Position(y + 1, x));
					continue;
				}
			}

			// left
			if (isValid(y, x - 1)) {
				if (maze[y][x - 1] == 2) {
					//System.out.println("Moved left");
					isSolvable =  true;
					break;
				} else if (maze[y][x - 1] == 1) {
					//System.out.println("Moved left");
					path.push(new Position(y, x - 1));
					continue;
				}
			}

			// up
			if (isValid(y - 1, x)) {
				if (maze[y - 1][x] == 2) {
					//System.out.println("Moved up");
					isSolvable = true;
					break;
				} else if (maze[y - 1][x] == 1) {
					System.out.println("Moved up");
					path.push(new Position(y - 1, x));
					continue;
				}
			}

			// right
			if (isValid(y, x + 1)) {
				if (maze[y][x + 1] == 2) {
					//System.out.println("Moved right");
					isSolvable = true;
					break;
				} else if (maze[y][x + 1] == 1) {
					//System.out.println("Moved right");
					path.push(new Position(y, x + 1));
					continue;
				}
			}

			path.pop(); // going back in case we have reached a dead end
			//System.out.println("Moved back");
			if (path.size() <= 0) { // nowhere new to go
				isSolvable = false;
				break;
			}
		}
	}

	public boolean isValid(int y, int x) {
		if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
			return false;
		}
		return true;
	}

}
