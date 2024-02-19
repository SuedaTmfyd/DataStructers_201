package TicTacToe_V1;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) throws Exception {
		TTT g = new TTT();
		g.Game();
	}
}

class TTT{
	public void Game() throws Exception {
		int player = 1; //p1 = 1, p2 = -1, space = 0
		int[][] board = new int[3][3];
		boolean pause = false;
		pause = End(board);
		Scanner inp = new Scanner(System.in);
	
		while(!pause){
			System.out.println("Enter 2 indexes to put mark:"); //putMark(posx,posy)
			int row = inp.nextInt();
			int column = inp.nextInt();
		
			if(board[row][column] != 0 || row>2 || column>2) { //isEmpty(posx,posy)
				throw new IllegalArgumentException("Can't put mark there!");
			}
		
			board[row][column] = player;
			Print(board);
			pause = End(board);
			player = -player;
		}
		
		if(isFull(board)) {
			System.out.println("Draw!");
			return;
		}
		if(player == -1)
			System.out.println("Winner is player 2!");
		else
			System.out.println("Winner is player 1!");
	
	    inp.close();
	}
	
	public boolean isFull(int[][] board) {
		int count = 0;
		for(int i = 0; i < board.length;i++) {
			for(int j = 0; j<board.length; j++) {
				if(board[i][j] != 0)
					count++;
			}
		}
		if(count == 9)
			return true;
		return false;
	}
	
	public boolean End(int[][] board) {
		if((board[0][0] + board[0][1] + board[0][2] == 3) || (board[0][0] + board[0][1] + board[0][2] == -3) ||
				(board[1][0] + board[1][1] + board[1][2] == 3) || (board[1][0] + board[1][1] + board[1][2] == -3) ||
				(board[2][0] + board[2][1] + board[2][2] == 3) || (board[2][0] + board[2][1] + board[2][2] == -3) ||
				(board[0][0] + board[1][0] + board[2][0] == 3) || (board[0][0] + board[1][0] + board[2][0] == -3) ||
				(board[0][1] + board[1][1] + board[2][1] == 3) || (board[0][1] + board[1][1] + board[2][1] == -3) ||
				(board[0][2] + board[1][2] + board[2][2] == 3) || (board[0][2] + board[1][2] + board[2][2] == -3) ||
				(board[0][0] + board[1][1] + board[2][2] == 3) || (board[0][0] + board[1][1] + board[2][2] == -3) ||
				(board[0][2] + board[1][1] + board[2][0] == 3) || (board[0][2] + board[1][1] + board[2][0] == -3))
				{
			return true;
		}
		
		if(isFull(board)) {
			return true;
		}
	
		return false;
	}
	
	public void Print(int[][] board){
		System.out.print("-------------" + "\n");
		for(int i = 0; i<board.length; i++) {
			System.out.print("| ");
			for(int j = 0; j<board.length; j++) {
				if(board[i][j] == 1)
					System.out.print("X" + " | ");
				else if(board[i][j] == -1)
					System.out.print("O" + " | ");
				else
					System.out.print(" " + " | ");
			}
			System.out.print("\n" + "-------------" + "\n");
		}
	}
}
