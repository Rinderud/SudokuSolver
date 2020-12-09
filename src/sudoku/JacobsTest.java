package sudoku;

public class JacobsTest implements SudokuSolver {
    private int[][] grid;

    @Override
    public void clear() {
        grid = new int[9][9];
    }

    @Override
    public int getNumber(int row, int col) {
        return grid[row][col];
    }

    @Override
    public int[][] getNumbers() {
        return grid;
    }

    @Override
    public void removeNumber(int row, int col) {
        grid[row][col] = 0;
    }

    @Override
    public void setNumber(int row, int col, int number) {
        grid[row][col] = number;

    }

    @Override
    public void setNumbers(int[][] numbers) {
        grid = numbers;
    }

    @Override
    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int number = 0; number <= 9; number++) {
                        if (trySetNumber(row, col, number)){
                            grid[row][col] = number;
                            if (solve()) {
                                return true;
                            }else{
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean trySetNumber(int row, int col, int number) {
        return !(rowContains(row, number) || colContains(col, number) || boxContains(row, col, number));
    }

    /**
     * 
     * @param row
     * @param number
     * @return if the row contains number
     */
    private boolean rowContains(int row, int number) {
        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == number) {
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
            if (grid[row][col] == number) {
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
                if (grid[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public JacobsTest(int[][] grid) {
        this.grid = grid;
    }

    public JacobsTest() {
        this.grid = new int[9][9];
    }

}
