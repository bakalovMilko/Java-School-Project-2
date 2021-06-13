package ticTacToe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TicTacToePanel extends JPanel{
	TicTacToeDesk d = new TicTacToeDesk();
	public static int margin = 3;
	
	public void restart() {
		d = new TicTacToeDesk();
		repaint();
	}
	public boolean isTheMoveMade(int x, int y, int player) {
		boolean isMoveValid = d.isTheMoveMade(x, y, player);
		repaint();
		return isMoveValid;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.repaint();
		int width = this.getWidth() / 3;
		int height = this.getHeight() / 3;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				g.setColor(Color.WHITE);
				g.fillRect(margin + j*width, margin + i*height, width-margin, height-margin);
			}
		}
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				if(d.desk[i][j] == 0) {
					g.setColor(Color.GREEN);
					g.drawOval(margin + j*width, margin + i*height, width-margin, height-margin);
				}
				else if(d.desk[i][j] == 1) {
					g.setColor(Color.RED);
					g.drawLine(margin + j*width, margin + i*height, margin + (j+1) * width - margin, margin + (i+1) * height - margin);
					g.drawLine(margin + j*width, margin + (i+1) * height - margin,  margin + (j+1) * width - margin, margin + i*height);
				}
			}
		}
	}
}
