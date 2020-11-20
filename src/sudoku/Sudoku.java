package sudoku;

public class Sudoku implements SudokuSolver {

    private int[][] board = new int [9][9];
    private int[][] boardCopy = new int [9][9]; // Om vi behöver ursprungsboard efter att ha ändrat i board.

    public Sudoku(int[][] solveBoard) {
        this.board = solveBoard;
        this.boardCopy = solveBoard; // Om vi behöver ursprungsboard efter att ha ändrat i board.
    }

    private boolean solve(int x, int y) {

    }

    private boolean checkRules(int val, int x, int y, boolean begin) {
        // rad
        for (int i = 0; i < 9; i++) {
            if ( y != i && board[x][i] == val) {
                return false;
            }
        }
        // col
        for (int i = 0; i < 9; i++) {
            if ( x != i && board[i][y] == val) {
                return false;
            }
        }

        // Lägg till check för 3x3.

        return true;
    }

    @Override
    public void clear() {
        for ( int i = 0; i < 9; i++) {
            for ( int j = 0; i < 9; i++) {
                board[i][j] = 0;
            }
        }

    }

    @Override
    public void setNumber(int row, int col, int number) {
        if (number > 0 && number < 10) {
            board[row][col] = number;
        }
        else return; // fundera på detta
    }

    @Override
    public boolean trySetNumber(int row, int col, int number) {
        
        return false;
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
        // TODO Auto-generated method stub
        return false;
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
    
}