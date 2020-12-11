package sudoku;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class sudokuTest {
    private int[][] cantSolve;
    private int[][] canSolve;
    private int[][] zeros;
    private Sudoku sudokuCantSolve;
    private Sudoku sudokuCanSolve;
    private Sudoku emptySudoku;

    @Before
    public void setUp() throws Exception {
        cantSolve = new int[][] { { 2, 7, 4, 0, 9, 0, 6, 5, 3 }, { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
                { 0, 4, 0, 6, 1, 8, 3, 9, 7 }, { 7, 6, 1, 0, 4, 0, 5, 2, 8 }, { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
                { 1, 0, 0, 4, 5, 6, 7, 8, 9 }, { 4, 5, 7, 0, 8, 0, 2, 3, 6 }, { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
                { 0, 0, 5, 3, 6, 2, 9, 7, 4 } };
        canSolve = new int[][] { { 0, 0, 0, 2, 6, 0, 7, 0, 1 }, { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
                { 1, 9, 0, 0, 0, 4, 5, 0, 0 }, { 8, 2, 0, 1, 0, 0, 0, 4, 0 }, { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
                { 0, 5, 0, 0, 0, 3, 0, 2, 8 }, { 0, 0, 9, 3, 0, 0, 0, 7, 4 }, { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
                { 7, 0, 3, 0, 1, 8, 0, 0, 0 } };
        zeros = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        sudokuCantSolve = new Sudoku(cantSolve);
        sudokuCanSolve = new Sudoku(canSolve);
        emptySudoku = new Sudoku();
    }

    @After
    public void tearDown() throws Exception {
        sudokuCantSolve = null;
        sudokuCanSolve = null;
        emptySudoku = null;
    }

    @Test
    public void testImpSudoku() { // Tests impossible sudoku
        assertFalse(sudokuCantSolve.solve());
    }

    @Test
    public void testSudoku() {
        assertArrayEquals(emptySudoku.getNumbers(), zeros);
        assertArrayEquals(sudokuCanSolve.getNumbers(), canSolve);
    }

    @Test
    public void testSolve() {
        assertTrue(sudokuCanSolve.solve());
    }

    @Test
    public void testClear() {
        sudokuCanSolve.clear();
        int[][] emptyBoard = new int[9][9];
        for (int row = 0; row < emptyBoard.length; row++) {
            for (int col = 0; col < emptyBoard[row].length; col++) {
                emptyBoard[row][col] = 0;
            }
        }
        assertArrayEquals(emptyBoard, sudokuCanSolve.getNumbers());
    }

    @Test
    public void testSetNumber() {
        for (int row = 0; row < canSolve.length; row++) {
            for (int col = 0; col < canSolve[row].length; col++) {
                for (int i = 1; i <= 9; i++) {
                    sudokuCanSolve.setNumber(row, col, i);
                    assertEquals(i, sudokuCanSolve.getNumber(row, col));
                }
            }
        }
        emptySudoku.setNumber(4, 2, 42);
        assertFalse(emptySudoku.getNumber(4, 2) == 42);
        ;
    }

    @Test
    public void testTrySetNumber() {
        assertFalse(emptySudoku.trySetNumber(4, 2, 42));
        sudokuCanSolve.setNumber(4, 2, 1);
        assertFalse(sudokuCanSolve.trySetNumber(4, 2, 1));
        assertTrue(emptySudoku.trySetNumber(6, 5, 3));
    }

    @Test
    public void testGetNumber() {
        for (int row = 0; row < canSolve.length; row++) {
            for (int col = 0; col < canSolve[row].length; col++) {
                for (int i = 1; i <= 9; i++) {
                    sudokuCanSolve.setNumber(row, col, i);
                    assertEquals(i, sudokuCanSolve.getNumber(row, col));
                }
            }
        }
        assertEquals(0, emptySudoku.getNumber(4, 2));
    }

    @Test
    public void testRemoveNumber() {
        for (int row = 0; row < canSolve.length; row++) {
            for (int col = 0; col < canSolve[row].length; col++) {
                sudokuCanSolve.removeNumber(row, col);
                assertEquals(0, sudokuCanSolve.getNumber(row, col));
            }
        }
    }

    @Test
    public void testGetNumbers() {
        assertArrayEquals(canSolve, sudokuCanSolve.getNumbers());
    }

    @Test
    public void testSetNumbers() {
        emptySudoku.setNumbers(canSolve);
        assertArrayEquals(canSolve, emptySudoku.getNumbers());
    }

}
