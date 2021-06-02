package mazeSolver;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MazeGraphics extends JPanel{
	public Maze m;
	
	MazeGraphics(Maze inputMaze){
		m = inputMaze;
		
	};
	public void repaint(Graphics g){
		for(int j = 0; j< m.maze.length; j++){
			for(int i = 0; i < m.maze[j].length; i++){
				if(m.maze[i][j] == 1){
					g.fillRect(10*i, 10*j, 10, 10);
				}else 
			}
		}
	}
}
