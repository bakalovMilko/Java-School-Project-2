package mazeSolver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel{
	MazePanel mazePanel;
	//Maze currentMaze;
	
	JPanel buttonPanel = new JPanel();
	JButton showPathButton = new JButton("Find Path");
	JButton hidePathButton = new JButton("Clear Path");
	
	JLabel taskLabel = new JLabel("Find the path!");
	
	MainPanel(Maze m){
		mazePanel = new MazePanel(m);
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(showPathButton);
		buttonPanel.add(hidePathButton);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.add(header);
		this.add(taskLabel);
		this.add(mazePanel);
		this.add(buttonPanel);
		
		showPathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mazePanel.findPath();
				if(mazePanel.m.isSolvable)
					taskLabel.setText("Path found!");
				else
					taskLabel.setText("Path not found!");
				repaint();
			}
			
		});
		hidePathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taskLabel.setText("Find the path!");
				mazePanel.cleanPath();
				repaint();
			}
			
		});
	}

}
