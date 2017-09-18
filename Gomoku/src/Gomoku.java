import java.util.Stack;

public class Gomoku {
	// instance variables
	private Stack<Move> history;
	private int[][] boardState;
	private int turn;

	// boardState keywords
	public final int EMPTY = 0;
	public final int WHITE = 1;
	public final int BLACK = 2;

//	// turn keywords
//	public final boolean WHITETURN = true;
//	public final boolean BLACKTURN = false;
	
	/**
	 * Constructor
	 */
	public Gomoku() {
		boardState = new int[15][15];
		turn = BLACK;
	}
	
	/**
	 * makes a move on the board.
	 * @param x the x coodinate of the move (0-14)
	 * @param y the y coodinate (0-14)
	 */
	public int makeMove(int x, int y) {
		// place the piece
		if (turn == BLACK) {
			boardState[x][y] = BLACK;
		}
		else {
			boardState[x][y] = WHITE;
		}
		
		history.push(new Move(x,y));
		int whoWon = winCheck(x,y);
		
		// switch turn
		if (turn == BLACK) {
			turn = WHITE;
		}
		else {
			turn = BLACK;
		}
		
		return whoWon;
	}
	/**
	 * 
	 * @param x the x coodinate of the move (0-14)
	 * @param y the y coodinate (0-14)
	 * @return 
	 */
	private int winCheck(int x, int y) {
		int runs;
		int i, j;
		
		// check horizontal wins
		runs = 0;
		i = x-4;
		j = y;
		while (i <= x+4) {
			if ((i<=0) && (i<15)) {
				if (boardState[i][j] == turn) {
					if (++runs == 5) {
						return turn;
					}
				}
				else {
					runs = 0;
				}
			}
			i++;
		}
		
		// check vertical wins
		runs = 0;
		i = x;
		j = y-4;
		while (j <= y+4) {
			if ((j<=0) && (j<15)) {
				if (boardState[i][j] == turn) {
					if (++runs == 5) {
						return turn;
					}
				}
				else {
					runs = 0;
				}
			}
			i++;
		}
		
		// check northwest to southeast diagonal wins
		runs = 0;
		i = x-4;
		j = y-4;
		while (i <= x+4) { // no need to test for j
			if ((i<=0) && (i<15) && (j<=0) && (j<15)) {
				if (boardState[i][j] == turn) {
					if (++runs == 5) {
						return turn;
					}
				}
				else {
					runs = 0;
				}
			}
			i++;
			j++;
		}
		
		// check southwest to northeast diagonal wins
		i = x-4;
		j = y+4;
		while (i <= x+4) { // no need to test for j
			if ((i<=0) && (i<15) && (j<=0) && (j<15)) {
				if (boardState[i][j] == turn) {
					if (++runs == 5) {
						return turn;
					}
				}
				else {
					runs = 0;
				}
			}
			i++;
			j--;
		}
		
		// No win
		return EMPTY;
	}
	
	/**
	 * Undoes a move
	 */
	public void moveBack() {
		if (history.empty()) {
			return;
		}
		Move prev = history.pop();
		boardState[prev.x][prev.y] = EMPTY;
	}
	
	/**
	 * Nested class for Gomoku, used for our history stack.
	 * @author apipes
	 *
	 */
	private class Move {
		public int x;
		public int y;
		
		public Move(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
