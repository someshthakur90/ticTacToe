import java.util.Scanner;
public class ticTacToe {

	char p1 = 'x', p2 = 'o';
	static char[][] board;
	
	public ticTacToe() {
		board = new char[3][3];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = '_';
			}
		}

	}
	private static void printBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}
	private static boolean gameOver() {
		if(gameWon() == 'x' || gameWon() == 'o')	return true;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '_')	return false;
			}
		}
		return true;
	}
	private static char gameWon() {
		if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))	return board[0][0];
	        if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))	return board[0][2]; 	
		for(int i = 0; i < board.length; i++) {
			if((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]))
			       return board[i][0];
		}
		for(int i = 0; i < board[0].length; i++) {
			if((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
				return board[0][i];
		}

		return '-';
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char p1 = 'x';
		new ticTacToe();
		while(!gameOver()) {
			printBoard();
			int x = sc.nextInt(), y = sc.nextInt();
			if(x > 2) x = 2;
			else if(x < 0) x = 0;
			if(y > 2) y = 2;
			else if(y < 0) y = 0;
			if(board[x][y] == '_') {

				board[x][y] = p1;
				if(p1 == 'x') p1 = 'o';
				else p1 = 'x';
			}
			else System.out.println("Try again");
			if(gameWon() == 'x' || gameWon() == 'o') {
				p1 = gameWon();
				break;
			}
		}
		if(gameWon() == '-') System.out.println("Game over "+" Draw");
		else System.out.println("Game Over "+"Player "+p1+" won the game");
		printBoard();
	}
}




