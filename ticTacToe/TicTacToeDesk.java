package ticTacToe;

public class TicTacToeDesk {
	int winner = 2;
	public int currentPlayer = (int)Math.random()*2;
	int [][] desk = new int[3][3];
	// 0 - 0
	// 1 - x
	// 2 - empty
	TicTacToeDesk() {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				desk[i][j] = 2;
			}
		}
	}
	public boolean isTheMoveMade(int x, int y, int player) {
		if(desk[x][y] == 2) {
			desk[x][y] = player;
			return true;
		}
		else 
			return false;
	}
	public void whoWon() {
		boolean didOWin = true;
		boolean didXWin = true;
		
		// rows
		for(int i = 0; i<3; i++) {
			didOWin = true;
			didXWin = true;
			for(int j = 0; j<3; j++) {
				if(desk[i][j] != 0)
					didOWin = false;
				if(desk[i][j] != 1)
					didXWin = false;
			}
			if(didOWin)
				winner =  0;
			if(didXWin)
				winner =  1;
		}
		// columns
		for(int i = 0; i<3; i++) {
			didOWin = true;
			didXWin = true;
			for(int j = 0; j<3; j++) {
				if(desk[j][i] != 0)
					didOWin = false;
				if(desk[j][i] != 1)
					didXWin = false;
			}
			if(didOWin)
				winner =  0;
			if(didXWin)
				winner = 1;
		}
		// first main diagonal
		didOWin = true;
		didXWin = true;
		for(int i = 0; i<3; i++) {
			if(desk[i][i] != 0)
				didOWin = false;
			if(desk[i][i] != 1)
				didXWin = false;
		}
		if(didOWin)
			winner = 0;
		if(didXWin)
			winner = 1;
		//second main diagonal
		didOWin = true;
		didXWin = true;
		for(int i = 0; i<3; i++) {
			if(desk[i][i] != 0)
				didOWin = false;
			if(desk[i][i] != 1)
				didXWin = false;
		}
		if(didOWin)
			winner = 0;
		if(didXWin)
			winner = 1;
	}
}
