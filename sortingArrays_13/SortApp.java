package sortingArrays_13;

import javax.swing.JFrame;

public class SortApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(new SortControll());
		frame.setTitle("Sorty");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
