package sudoku;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class sudokuTest {
    private int[][] cantSolve;
    private int[][] canSolve;
    private Sudoku sudokuCantSolve;
    private Sudoku sudokuCanSolve;
    private Sudoku emptySudoku;

    @Before
    public void setUp() throws Exception {
        cantSolve = new int[][] {
                { 2, 7, 4, 0, 9, 0, 6, 5, 3 },
                { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
                { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
                { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
                { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
                { 1, 0, 0, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 7, 0, 8, 0, 2, 3, 6 },
                { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
                { 0, 0, 5, 3, 6, 2, 9, 7, 4 } };
        canSolve = new int[][] {
                { 2, 7, 4, 0, 9, 0, 6, 5, 0 },
                { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
                { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
                { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
                { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
                { 1, 0, 0, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 7, 0, 8, 0, 2, 3, 6 },
                { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
                { 0, 0, 5, 3, 6, 2, 9, 7, 4 } };
        sudokuCantSolve = new Sudoku(cantSolve);
        sudokuCanSolve = new Sudoku(canSolve);
        emptySudoku = new Sudoku();
    }

    @After
    public void tearDown() throws Exception {
        cantSolve = null;
        canSolve = null;
        sudokuCantSolve = null;
        sudokuCanSolve = null;
        emptySudoku = null;
    }

    @Test
    public void testImpSudoku() { // Tests impossible sudoku
        fail("Not yet implemented");
    }

    @Test
    public void testSudoku() {
        fail("Not yet implemented");
    }

    @Test
    public void testSolve() {
        fail("Not yet implemented");
    }

    @Test
    public void testClear() {
        sudokuCanSolve.clear();
        int[][] emptyBoard = new int[9][9];
        for (int i = 0; i < emptyBoard.length; i++) {
            for (int j = 0; j < emptyBoard.length; j++) {
                emptyBoard[i][j] = 0;
            }
        }
        assertArrayEquals(emptyBoard, sudokuCanSolve.getNumbers());
    }

    @Test
    public void testSetNumber() {
        fail("Not yet implemented");
    }

    @Test
    public void testTrySetNumber() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumber() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNumber() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumbers() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetNumbers() {
        emptySudoku.setNumbers(canSolve);
        assertArrayEquals(canSolve, emptySudoku.getNumbers());
    }

}
