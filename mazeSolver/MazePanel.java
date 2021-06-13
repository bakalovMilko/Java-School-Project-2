package mazeSolver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	public Maze m;
	public boolean isPathVisible = false;
	public static int margin = 3;
	
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
		super.paintComponent(g);
		int width = (this.getWidth()-margin) / m.maze[0].length - margin;
		int height = (this.getHeight()-margin) / m.maze.length - margin;
		for(int i = 0; i< m.maze.length; i++){
			for(int j = 0; j < m.maze[i].length; j++){
				if(m.maze[i][j] == 0) {
					g.setColor(Color.BLACK);
					g.drawLine(margin + (width+margin)*j, margin + (height+margin)*i, margin + (width+margin)*j + width, margin + (height+margin)*i + height);
					g.drawLine(margin + (width+margin)*j + width, margin + (height+margin)*i, margin + (width+margin)*j, margin +  (height+margin)*i + height);
				}
				else if(m.maze[i][j] == 2) {
					g.setColor(Color.RED);
					g.fillRect(margin + (width+margin)*j, margin + (height+margin)*i, width, height);
				}
				else if(m.maze[i][j] == 1 || m.maze[i][j] == 3) {
					g.setColor(Color.WHITE);
					g.fillRect(margin + (width+margin)*j, margin + (height+margin)*i, width, height);
				}
				if(m.start.x == j && m.start.y == i) {
					g.setColor(Color.GREEN);
					g.drawRect(margin + (width+margin)*j, margin + (height+margin)*i, width, height);
				}
			}
			if(isPathVisible) {
				for(mazeSolver.Position p : m.path) {
					g.setColor(Color.GREEN);
					g.fillRect(margin + p.x*(width+margin),margin + p.y*(height+margin), width, height);
				}
			}
		}

	}
}
