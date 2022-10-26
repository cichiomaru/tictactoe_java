import java.util.Scanner;

public class TicTacToe1401079875 {
	private Scanner scanner = new Scanner(System.in);
	
	private int playerTurn = 1;	
	private int winner = 0;	
	private int[][] board = new int[3][3];
	
	public TicTacToe1401079875() {
		do {
			PrintBoard();
			GetInput();
			ValidateBoard();
		} while (winner == 0);
	}
	
	private void ValidateBoard() {
		// horizontal 
		for (int y=0; y<3; y++) {
			if (board[y][0] == board[y][1] && board[y][0] == board[y][2]) {
				if (board[y][0]==0) {
					continue;
				} else {
					ShowWinner(board[y][0]);
					return;
				}
			}
		}
		// vertical
		for (int x=0; x<3; x++) {
			if (board[0][x] == board[1][x] && board[0][x] == board[2][x]) {
				if (board[0][x]==0) {
					continue;
				} else {
					ShowWinner(board[0][x]);
					return;
				}
			}
		}
		// diagonal
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			if (board[0][0] == 0) {
				ShowWinner(board[0][0]);
				return;				
			}
		} 
		if (board[0][2]==board[1][1] && board[0][2]==board[2][0]) {
			if (board[0][0] == 0) {
				ShowWinner(board[0][2]);
				return;
			}
		}
	}

	private void ShowWinner(int i) {
		System.out.printf("Player %d's WIN!\n", i);
		winner = i;
	}

	private void GetInput() {
		int x = -1;
		int y = -1;
		
		do {
			System.out.printf("Player %d's turn\n", playerTurn);
			System.out.print("Input x coordinate: ");
			x = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Input y coordinate: ");
			y = scanner.nextInt();
			scanner.nextLine();
		} while (x<0 || x>2 || y<0 || y>2 || board[y][x]!=0);
		
		board[y][x] = playerTurn;
		playerTurn = playerTurn == 1 ? 2 : 1;
	}

	private void PrintBoard() {
		// TODO Auto-generated method stub
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				if (board[y][x] == 1) {
					System.out.print("O");
				}
				else if (board[y][x] == 2) {
					System.out.print("X");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToe1401079875();
	}

}
