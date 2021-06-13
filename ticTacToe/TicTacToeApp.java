package ticTacToe;

import javax.swing.JFrame;

public class TicTacToeApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		frame.add(new MainPanel());
		
		frame.setSize(400, 400);
		frame.setTitle("TestMazeSolver");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
