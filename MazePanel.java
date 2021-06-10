package mazeSolver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	Maze m;
	boolean isPathVisible = false;
	
	MazePanel(Maze m){
		this.m = m;
		for(int i = 0; i<m.maze.length; i++) {
			for(int j = 0; j< m.maze[i].length; j++) {
				System.out.print(m.maze[i][j]);
			}
			System.out.println();
		}
		this.m.solveMaze();
		for(int i = 0; i<m.maze.length; i++) {
			for(int j = 0; j< m.maze[i].length; j++) {
				System.out.print(m.maze[i][j]);
			}
			System.out.println();
		}
	}
	
	public void findPath() {
		if(m.isSolvable) {
			isPathVisible = true;
		}
	};
	public void cleanPath() {
		isPathVisible = false;
	};
	
	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i< m.maze.length; i++){
			for(int j = 0; j < m.maze[i].length; j++){
				if(m.maze[i][j] == 0) {
					g.setColor(Color.BLACK);
					g.drawLine(10*j, 10*i, 10*j+10, 10*i+10);
					g.drawLine(10*j + 10, 10*i, 10*j, 10*i+10);
				}
				else if(m.maze[i][j] == 2) {
					g.setColor(Color.RED);
					g.fillRect(10*j, 10*i, 10, 10);
				}
				else if(m.maze[i][j] == 1 || m.maze[i][j] == 3) {
					g.setColor(Color.WHITE);
					g.fillRect(10*j, 10*i, 10, 10);
				}
			}
			if(isPathVisible) {
				/*Stack<Position> solution = (Stack<Position>) m.path.clone();
				while(!solution.isEmpty()) {
					g.setColor(Color.GREEN);
					Position currentP = solution.pop();
					g.drawRect(currentP.y*10, currentP.x*10, 10, 10);
				}*/
				for(mazeSolver.Position p : m.path) {
					g.setColor(Color.GREEN);
					g.drawRect(p.x*10, p.y*10, 10, 10);
					//System.out.println(p.x + " " + p.y);
				}
			}
		}

	}
}
