package sudoku;

/**
 * @author Jacob Rinderud & Linus Carlsson
 */
public class Sudoku implements SudokuSolver {

    private int[][] board;
    private int[][] boardCopy; // Om vi behöver ursprungsboard efter att ha ändrat i board.

    public Sudoku() {
        board = new int[9][9];
        boardCopy = new int[9][9];
    }

    public Sudoku(int[][] solveBoard) {
        this.board = solveBoard;
        this.boardCopy = solveBoard; // Om vi behöver ursprungsboard efter att ha ändrat i board.
    }

    /**
     * Tries to fill the empty square with a legal number
     * 
     * @param row   The row to start at
     * @param col   The column to start at
     * @return false if the empty square cannot be filled with a legal number
     */
    private boolean solve(int row, int col) {
        int newX = row;
        int newY;
        if (col != 8) {
            newY = col + 1;
        } else {
            newY = 0;
            newX = row + 1;
        }
        if (row == 9) {
            return true;
        }
        if (boardCopy[row][col] == 0) {
            for (int number = 1; number < 10; number++) {
                if (trySetNumber(row, col, number)) {
                    board[row][col] = number;
                    if (solve(newX, newY)) {
                        return true;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
            return false;
        }
        return solve(newX, newY);
    }

    /**
     * Checks if the row contains the number
     * 
     * @param row   The row
     * @param number    The number
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
     * Checks if the column contains the number
     * 
     * @param col   The column
     * @param number    The number
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
     * Checks if the 3x3 box that the row and column is within contains the number
     * 
     * @param row   The row
     * @param col   The column
     * @param number    The number
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

    /**
     * Checks if the starting numbers are legal according to the Sudoku rules
     * 
     * @return true if the board is legal, false if the board is illegal.
     */
    private boolean legalBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int number = board[row][col];
                if (number != 0) {
                    board[row][col] = 0;
                    if (!trySetNumber(row, col, number)) {
                        board[row][col] = number;
                        return false;
                    } else {
                        board[row][col] = number;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Displays the board in the terminal
     */
    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** Tömmer hela sudokut */
    @Override
    public void clear() { // Sätter alla rutor till 0
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = 0;
                boardCopy[row][col] = 0; // Hur representeras en tom ruta?
            }
        }

    }

    /**
	 * Sets the digit number in the box row, col.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert
	 * @throws IllegalArgumentException if number not in [1..9] or row or col is
	 *                                  outside the allowed range
	 */
    @Override
    public void setNumber(int row, int col, int number) {
        if (row < 0 || row > 8 || col < 0 || col > 8 || number < 0 || number > 9) {
            throw new IllegalArgumentException();
        }
        if (number > 0 && number < 10) {
            board[row][col] = number;
            boardCopy[row][col] = number;
        } else
            return;
    }

    /**
	 * Kollar om siffran number kan sättas i raden row och kolumnen col, om det inte
	 * går enligt spelreglerna returneras false
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert
	 * @return true if it, according to the rules of Sudoku, is possible to put
	 *         number at row, col, else false
	 * @throws IllegalArgumentException if number not in [1..9] or row or col is
	 *                                  outside the allowed range
	 */
    @Override
    public boolean trySetNumber(int row, int col, int number) {
        if (row < 0 || row > 8 || col < 0 || col > 8 || number < 0 || number > 9) {
            throw new IllegalArgumentException();
        }
        if (board[row][col] != 0) {
            return false;
        } else {
            return !(rowContains(row, number) || colContains(col, number) || boxContains(row, col, number));
        }

    }

    /**
	 * Returnerar siffran på raden row och kolumnen col.
	 * 
	 * @param row The row
	 * @param col The column
	 * @return int of box with row row and col col
	 * @throws IllegalArgumentException if row or col is outside the allowed range
	 */
    @Override
    public int getNumber(int row, int col) {
        if (row < 0 || row > 8 || col < 0 || col > 8) {
            throw new IllegalArgumentException();
        }
        return board[row][col];
    }

    /**
	 * Tar bort siffran på raden row och kolumnen col.
	 * 
	 * @param row The row
	 * @param col The column
	 * @throws IllegalArgumentException if row or col is outside the allowed range
	 */
    @Override
    public void removeNumber(int row, int col) {
        if (row < 0 || row > 8 || col < 0 || col > 8) {
            throw new IllegalArgumentException();
        }
        board[row][col] = 0;
        boardCopy[row][col] = 0; // vilket värde ska en tom ruta ha?
    }

	/**
	 * Läser sudokut och returnerar true om sudokut går att lösa.
	 * 
	 * @return true if solvable, else false
	 */
    @Override
    public boolean solve() {
        if (legalBoard()) {
            if (solve(0, 0)) {
                return true;
            }
            return false;
        } else {
            return false;
        }

    }

    /**
	 * Returnerar siffrorna i sudokut.
	 * 
	 * @return int array representing the Sudoku board
	 */
    @Override
    public int[][] getNumbers() {
        int[][] tempReturn = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                tempReturn[row][col] = board[row][col];
            }
        }
        return tempReturn;
    }

    /**
	 * Fyller i siffrorna i numbers i sudokut.
	 * 
	 * @param numbers board
	 * @throws IllegalArgumentException if not all numbers in [0..9]
	 **/
    @Override
    public void setNumbers(int[][] numbers) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (numbers[row][col] < 0 || numbers[row][col] > 9) {
                    throw new IllegalArgumentException();
                }
                board[row][col] = numbers[row][col];
                boardCopy[row][col] = numbers[row][col];
            }
        }
    }
}