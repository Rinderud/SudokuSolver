package sudoku_ht20;

public interface SudokuSolver {
	/** TÃ¶mmer hela sudokut */
	void clear(); 

	/**
	 * Sets the digit number in the box row, col.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert
	 * @throws IllegalArgumentException if the digit is outside the allowed range
	 */
	void setNumber(int row, int col, int number);
	
	/** Kollar om siffran number kan sÃ¤ttas i raden row och kolumnen col, 
	 * om det inte gÃ¥r enligt spelreglerna returneras false 
	 * @throws IllegalArgumentException if the digit is outside the allowed range
	 */
	boolean trySetNumber(int row, int col, int number);
	
	/** Returnerar siffran pÃ¥ raden row och kolumnen col. 
	 * @throws IllegalArgumentException if the digit is outside the allowed range 
	 */
	int getNumber(int row, int col);
	
	/** Tar bort siffran pÃ¥ raden row och kolumnen col. 
	 * @throws IllegalArgumentException if the digit is outside the allowed range
	 */
	int removeNumber(int row, int col);

	/** LÃ¶ser sudokut och returnerar true om sudokut gÃ¥r att lÃ¶sa. */
	boolean solve();
	
	/** Returnerar siffrorna i sudokut. */
	int[][] getNumbers();
}

/* TBD:
 * Numrering av row och col: 0-8 eller 1-9?
 * TillÃ¥tet vÃ¤rde fÃ¶r number 0-9 eller 1-9?
 * Skriva javadoc-kommentarer (PÃ¥bÃ¶rjat, kommentaren till setNumber Ã¤r nÃ¤stan klar.)
 * 
 */
