package mazeSolver;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class MazeSolverApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		Maze m = new Maze("C:/Users/User/Documents/workspace 2/Module 2/src/mazes.txt");
		
		frame.add(new MainPanel(m));
		
		frame.setSize(400, 400);
		frame.setTitle("TestMazeSolver");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
