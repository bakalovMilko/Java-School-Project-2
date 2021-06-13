package ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel{
	public JButton restartButton = new JButton("Restart");
	public TicTacToePanel tPanel = new TicTacToePanel();
	public JLabel header= new JLabel(((tPanel.d.currentPlayer==0)? "O":"X") + " has to play");
	public JPanel otherComponents = new JPanel();
	
	MainPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		otherComponents.setLayout(new BoxLayout(otherComponents, BoxLayout.X_AXIS));;
		otherComponents.add(header);
		otherComponents.add(restartButton);
		
		this.add(tPanel);
		this.add(otherComponents);
		
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tPanel.restart();
			}
		});
		
		tPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tPanel.d.winner ==2 ) {
					int x = e.getX();
					int y = e.getY();
					if(tPanel.d.isTheMoveMade( 3*y/getHeight(), 3*x/getWidth(), tPanel.d.currentPlayer)) {
						tPanel.d.currentPlayer = (tPanel.d.currentPlayer+1) % 2;
						header.setText(((tPanel.d.currentPlayer==0)? "O":"X") + " has to play");
						tPanel.d.whoWon();
						if(tPanel.d.winner != 2)
							header.setText(((tPanel.d.winner==0)? "O":"X") + " won!");
					}
				}
				
			}	
				
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
}
