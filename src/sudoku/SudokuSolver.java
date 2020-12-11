package sudoku;

public interface SudokuSolver {
	/** Tömmer hela sudokut */
	void clear(); 

	/**
	 * Sets the digit number in the box row, col.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert
	 * @throws IllegalArgumentException if number not in [1..9] or row or col is outside the allowed range
	 */
	void setNumber(int row, int col, int number);
	
	/** Kollar om siffran number kan sättas i raden row och kolumnen col, 
	 * om det inte går enligt spelreglerna returneras false 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert
	 * @throws IllegalArgumentException if number not in [1..9] or row or col is outside the allowed range
	 */
	boolean trySetNumber(int row, int col, int number);
	
	/** Returnerar siffran på raden row och kolumnen col.
	 * 
	 * @param row    The row
	 * @param col    The column 
	 * @throws IllegalArgumentException if row or col is outside the allowed range 
	 */
	int getNumber(int row, int col);
	
	/** Tar bort siffran på raden row och kolumnen col. 
	 * 
	 * @param row    The row
	 * @param col    The column 
	 * @throws IllegalArgumentException if row or col is outside the allowed range
	 */
	void removeNumber(int row, int col);

	/** Läser sudokut och returnerar true om sudokut går att lösa. */
	boolean solve();
	
	/** Returnerar siffrorna i sudokut. */
	int[][] getNumbers();

	/** Fyller i siffrorna i numbers i sudokut. 
	 * @throws IllegalArgumentException if not all numbers in [0..9]
	 **/
	void setNumbers(int[][] numbers);
}

/* TBD:
 * Numrering av row och col: 0-8 eller 1-9?
 * Tillåtet värde för number 0-9 eller 1-9?
 * Skriva javadoc-kommentarer (Påbörjat, kommentaren till setNumber är nästan klar.)
 * 
 */
