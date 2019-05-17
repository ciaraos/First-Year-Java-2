
/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment: I used public static void
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment:yes, I used two loops
   2. printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:I used public static void
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment: yes, it looks like a board and prints out the array
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: I used public static boolean and return if it is true or false
Did I check if a specified location was BLANK?
Mark out of 5:5
Comment:yes, I used an if statement
   4. makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:I used public static void
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:5
Comment:yes I used an if statement  in the makeMove function
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:I used public static boolean 
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment:yes, i checked for blank characters
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5:5
Comment:     I used public static char
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:15
Comment:I believe I have done this
   7.main
Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:yes, I used constants and used the clearBoard function
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments:yes, I used a while loop for this
Did I call all of the methods above?
Mark out of 5:5
Comments:yes, I call each method
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments:I believe I have done this
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments:yes, I used an if statement for this
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:3
Comments:yes, I used if statements for this
   8. Overall
Is my code indented correctly?
Mark out of 3:3
Comments:I indented where necessary
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:I believe they make sense and are easy to follow
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:I believe they do
      Total Mark out of 100 (Add all the previous marks):100    */

import java.util.InputMismatchException;
import java.util.Scanner;

public class NoughtsAndCrosses {
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;

	public static void clearBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				board[row][column] = ' ';
			}
		}
	}

	public static void printBoard(char[][] board) {
		System.out.println("      0" + "       1" + "       2");
		System.out.println("          |" + "       |");
		System.out.println("0     " + board[0][0] + "   |   " + board[0][1] + "   |   " + board[0][2]);
		System.out.println("   	  |" + "       |");
		System.out.println("   -----------------------");
		System.out.println("          |" + "       |");
		System.out.println("1     " + board[1][0] + "   |   " + board[1][1] + "   |   " + board[1][2]);
		System.out.println("	  |" + "       |");
		System.out.println("   -----------------------");
		System.out.println("          |" + "       |");
		System.out.println("2     " + board[2][0] + "   |   " + board[2][1] + "   |   " + board[2][2]);
		System.out.println("	  |" + "       |");
	}

	public static boolean canMakeMove(char[][] board, int rowEntered, int columnEntered) {
		boolean canMakeMove = true;
		if ((rowEntered < 3) && (rowEntered > 0) && (columnEntered < 3) && (columnEntered > 0)
				&& (board[rowEntered][columnEntered] == ' ')) {
			canMakeMove = true;
		} else {
			System.out.println("Sorry, this space is invalid, choose different coordinates ");
			canMakeMove = false;
		}
		return canMakeMove;
	}

	public static void makeMove(char[][] board, char currentPlayerPiece, int rowEntered, int columnEntered, int count) {
		if (count % 2 == 0) {
			currentPlayerPiece = 'O';
		} else if (count % 2 == 1) {
			currentPlayerPiece = 'X';
		}
		board[rowEntered][columnEntered] = currentPlayerPiece;
	}

	public static boolean isBoardFull(char[][] board) {
		boolean isFull = true;
		int index = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if (board[x][y] != ' ') {
					index++;
				}
			}
		}
		if (index == 9) {
			isFull = true;
		} else {
			isFull = false;
		}
		return isFull;
	}

	public static char winner(char[][] board) {
		char win = ' ';
		// check rows
		for (int rowEntered = 0; rowEntered < board.length; rowEntered++) {
			if ((board[rowEntered][0] == board[rowEntered][1]) && (board[rowEntered][1] == board[rowEntered][2])) {
				if (board[rowEntered][0] != ' ') {
					win = board[rowEntered][0];
				}
			}
		}
		// check columns
		for (int columnEntered = 0; columnEntered < board.length; columnEntered++) {
			if ((board[0][columnEntered] == board[1][columnEntered])
					&& (board[1][columnEntered] == board[2][columnEntered])) {
				if (board[0][columnEntered] != ' ') {
					win = board[0][columnEntered];
				}
			}
		}
		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])
				|| (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
			if (board[1][1] != ' ') {
				win = board[1][1];
			}
		}
		return win;
	}

	public static void main(String[] args) {
		char[][] board = new char[ROWS][COLUMNS];
		clearBoard(board);
		printBoard(board);
		char currentPlayerPiece = ' ';
		int count = 1;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Player 1 is X's and player 2 is O's");
		boolean finished = isBoardFull(board);
		try {
			while (!finished) {
				System.out.println("Choose the row to place an your piece ");
				int rowEntered = inputScanner.nextInt();
				System.out.println("Choose the column to place your piece ");
				int columnEntered = inputScanner.nextInt();
				if (canMakeMove(board, rowEntered, columnEntered) == true) {
					makeMove(board, currentPlayerPiece, rowEntered, columnEntered, count);
					count++;
				}
				printBoard(board);
				finished = isBoardFull(board);
				char winner = winner(board);
				if (winner(board) != ' ') {
					System.out.print("Congratulations, " + winner + " won!");
					inputScanner.close();
					finished = true;
				}
				if (finished && winner == ' ') {
					System.out.print("DRAW");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please choose a row or column between 0 and 2, the space must be empty");
		} catch (InputMismatchException e) {
			System.out.println("Please enter a positve number e.g. 1");
		}
	}
}