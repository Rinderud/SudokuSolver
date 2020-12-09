package sudoku;

public class Sudoku implements SudokuSolver {

    private int[][] board;
    private int[][] boardCopy; // Om vi behöver ursprungsboard efter att ha ändrat i board.

    public Sudoku(){
        board = new int [9][9];
        boardCopy = new int [9][9];
    }
    public Sudoku(int[][] solveBoard) {
        this.board = solveBoard;
        this.boardCopy = solveBoard; // Om vi behöver ursprungsboard efter att ha ändrat i board.
    }

    /* private boolean solve(int x, int y) {
        if (getNumber(x, y) != 0){           // Om det redan är ifyllt
            if(x == 8){                 // Om det är sista i x-led
                if (y == 8){            // Om det är sista i y-led
                    return true;        // KLAR
                }else{
                    return solve(0, y + 1);    // Forstsätt på nästa rad
                }
            }else{
                return solve(x + 1, y);        // Fortsätt i nästa kolumn
            }
        }

        for (int num = 1; num <= 9; num++){
            if (trySetNumber(x, y, num)){   // Om det går att sätta där
                setNumber(x, y, num);       // Gör det
                if(x == 8){                 // Om det är sista i x-led
                    if (y == 8){            // Om det är sista i y-led
                        return true;        // KLAR
                    }
                    if (solve(0, y + 1)){   // Forstsätt på nästa rad
                        return true;
                    }
                }else{
                    if (solve(x + 1, y)){        // Fortsätt i nästa kolumn
                        return true;
                    }
                }
            }
        }
        return false;
    } */

    private boolean solve(int x, int y) {
		int newX = x;
		int newY;
		if (y != 8) {
			newY = y + 1;

		} else {
			newY = 0;
			newX = x + 1;
		}
		if (x == 9) {
			return true;
		}
		if (boardCopy[x][y] == 0) {
			for (int i = 1; i < 10; i++) {
				if (trySetNumber(x, y, i)) {
					board[x][y] = i;
					if (solve(newX, newY)) {
						return true;
					} else {
						board[x][y] = 0;
					}
				}
			}
			return false;
        } 
		return solve(newX,newY);
	}

    /**
     * 
     * @param row
     * @param number
     * @return if the row contains number
     */
    private boolean rowContains(int row, int number) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param col
     * @param number
     * @return if column contains number
     */
    private boolean colContains(int col, int number) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param row
     * @param col
     * @param number
     * @return if the 3x3 box that row and col is in contains number
     */
    private boolean boxContains(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayBoard()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    @Override
    public void clear() { // Sätter alla rutor till 0
        for ( int i = 0; i < 9; i++) {
            for ( int j = 0; i < 9; i++) {
                board[i][j] = 0; // Hur representeras en tom ruta?
            }
        }

    }

    @Override
    public void setNumber(int row, int col, int number) {
        if (number > 0 && number < 10) {
            board[row][col] = number;
        }
        else return;
    }

    @Override
    public boolean trySetNumber(int row, int col, int number) {
        if ( board[row][col] != 0) {
            return false;
        } 
        else {
            return !(rowContains(row, number) || colContains(col, number) || boxContains(row, col, number));
        }
        
    }

    @Override
    public int getNumber(int row, int col) {
        return board[row][col];
    }

    @Override
    public void removeNumber(int row, int col) {
        board[row][col] = 0; // vilket värde ska en tom ruta ha?
    }

    @Override
    public boolean solve() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(!solve(row, col)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int[][] getNumbers() {
        int[][] tempReturn = new int[9][9];
        for ( int i = 0; i < 9; i++) {
            for ( int j = 0; i < 9; i++) {
                tempReturn[i][j] = board[i][j];
            }
        }
        return tempReturn;
    }

    @Override
    public void setNumbers(int[][] numbers) {
        for ( int i = 0; i < 9; i++) {
            for ( int j = 0; i < 9; i++) {
                board[i][j] = numbers[i][j];
            }
        }
    }
}