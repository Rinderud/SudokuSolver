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

    private boolean solve(int x, int y) {
        if(getNumber(x, y) != 0){           // Om det redan är ifyllt
            if(x == 8){                 // Om det är sista i x-led
                if (y == 8){            // Om det är sista i y-led
                    return true;        // KLAR
                }else{
                    solve(0, y + 1);    // Forstsätt på nästa rad
                }
            }else{
                solve(x + 1, y);        // Fortsätt i nästa kolumn
            }
        }
        for (int num = 1; num <= 9; num++){
            if (trySetNumber(x, y, num)){   // Om det går att sätta där
                setNumber(x, y, num);       // Gör det
                if(x == 8){                 // Om det är sista i x-led
                    if (y == 8){            // Om det är sista i y-led
                        return true;        // KLAR
                    }
                    solve(0, y + 1);        // Forstsätt på nästa rad
                }else{
                    solve(x + 1, y);        // Fortsätt i nästa kolumn
                }
            }
        }
        return false;
    }

    /** Returns true if no rule has been broken, else false */
    private boolean checkRules(int x, int y, int val) {
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
        int row = x-x%3;
        int col = y-y%3;
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; i++) {
                if (board[i][j] == val) {
                    return false;
                }
            
            }
            
        }

        return true;
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
        else return; // fundera på detta
    }

    @Override
    public boolean trySetNumber(int row, int col, int number) {
        if (checkRules(row,col,number)) {
            return true;
        }
        else return false;
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
        return solve(0, 0);
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