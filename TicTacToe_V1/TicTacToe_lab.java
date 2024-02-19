package TicTacToe_V1;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe_lab {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		TTTGame game = new TTTGame();
		int posx;
		int posy;
		do {
			System.out.println("Enter 2 indexes.");
			posx = inp.nextInt();
			posy = inp.nextInt();
		}while(!game.putMark(posx, posy));
		inp.close();
	}
}

class TTTGame {
	//0=empty, 1=X, -1=O
	protected int[][] board;
	protected int curPlayer;
	private final static int[][][] winnerIndices = {
		    {{0,0}, {0,1}, {0,2}},
		    {{1,0}, {1,1}, {1,2}},
		    {{2,0}, {2,1}, {2,2}},
		    {{0,0}, {1,0}, {2,0}},
		    {{0,1}, {1,1}, {2,1}},
		    {{0,2}, {1,2}, {2,2}},
		    {{0,0}, {1,1}, {2,2}},
		    {{0,2}, {1,1}, {2,0}}};
	
	TTTGame(){
		board = new int[3][3];
		curPlayer = 1;
	}
	
	public boolean putMark(int posx, int posy) {
		if(!isEmpty(posx, posy)) {
			throw new IllegalArgumentException("Enter valid input.");
		}
		
		board[posx][posy] = curPlayer;
		
		if(isWinner(curPlayer)) {
			if(curPlayer == 1)
				System.out.println("\nWINNER PLAYER 1!");
			if(curPlayer == -1)
				System.out.println("\nWINNER PLAYER 2!");
			printBoard();
			clearBoard();
			return true;
		}
		
		if(!isAvaiblePositionExist()) {
			System.out.println("\nGAME END! NO WINNER!");
			printBoard();
			clearBoard();
			return true;
		}
		
		printBoard();
		curPlayer = -curPlayer;
		return false;
	}
	
	public boolean isEmpty(int posx, int posy) {
		if(board[posx][posy] == 0)
			return true;
		return false;
	}
	
	public void clearBoard() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public boolean isAvaiblePositionExist() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	public boolean isWinner(int player) {
		int[][] indexP = new int[5][2];
		int countIndex = 0;
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] == player) {
					indexP[countIndex][0] = i;
					indexP[countIndex][1] = j;
					countIndex++;
				}
			}
		}
		for(int i = countIndex; i<indexP.length; i++) {//null atanmadığında [0,0] indexlerin hepsi sayılıp erken win veriyor
			indexP[i] = null;
		}

		int count = 0;
		for(int i = 0; i<winnerIndices.length; i++) {
			for(int j = 0; j<winnerIndices[0].length; j++) {
				for(int k = 0; k<indexP.length; k++) {
					if(Arrays.equals(winnerIndices[i][j], indexP[k])) {
						count++;
					}
				}
			}
			if(count == 3)
				return true;
			else
				count = 0;
		}
		return false;
	}
	
	public void printBoard() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == 0)
					System.out.print(" - ");
				if(board[i][j] == 1)
					System.out.print(" X ");
				if(board[i][j] == -1)
					System.out.print(" O ");
				if(j<2)
					System.out.print("|");
			}
			if(i<2)
				System.out.println("\n- - - - - -");
			else
				System.out.println("\n");
		}
	}
}
