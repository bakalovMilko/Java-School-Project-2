package mazeSolver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel{
	MazePanel mazePanel;
	//Maze currentMaze;
	JTextField header = new JTextField("");
	
	JPanel buttonPanel = new JPanel();
	JButton showPathButton = new JButton("Find Path");
	JButton hidePathButton = new JButton("Clear Path");
	
	MainPanel(Maze m){
		mazePanel = new MazePanel(m);
		header.setEditable(false);
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(showPathButton);
		buttonPanel.add(hidePathButton);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.add(header);
		this.add(buttonPanel);
		this.add(mazePanel);
		
		showPathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mazePanel.findPath();
				repaint();
			}
			
		});
		hidePathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				header.setText("find the path!");
				mazePanel.cleanPath();
				repaint();
			}
			
		});
	}

}
