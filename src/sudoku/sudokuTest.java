package sudoku;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class sudokuTest {

    private int[][] board1;
    private int[][] board2;
    private Sudoku sudoko1;
    private Sudoku sudoko2;


    @Before
    public void setUp() throws Exception {
        board1 = new int[9][9];
        board2 = new int[9][9];
        sudoko1 = new Sudoku(board1);
        sudoko2 = new Sudoku(board2);   
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void testImpSudoku(){
        board1 = new int[][] { { 2, 7, 4, 0, 9, 0, 6, 5, 3 },
                                { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
                                { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
                                { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
                                { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
                                { 1, 0, 0, 4, 5, 6, 7, 8, 9 },
								{ 4, 5, 7, 0, 8, 0, 2, 3, 6 },
								{ 6, 8, 9, 2, 3, 7, 0, 4, 0 },
								{ 0, 0, 5, 3, 6, 2, 9, 7, 4 }
								};
    }
    
    @Test
    public void testSudoku(){
        fail("Not yet implemented");
    }

    @Test
    public void testSolve(){
        fail("Not yet implemented");
    }

    @Test
    public void testCheckRules(){
        fail("Not yet implemented");
    }

    @Test
    public void testClear(){
        fail("Not yet implemented");
    }

    @Test
    public void testSetNumber(){
        fail("Not yet implemented");
    }

    @Test
    public void testTrySetNumber(){
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumber(){
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveNumber(){
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumbers(){
        fail("Not yet implemented");
    }

    @Test
    public void testSetNumbers(){
        fail("Not yet implemented");
    }

}
