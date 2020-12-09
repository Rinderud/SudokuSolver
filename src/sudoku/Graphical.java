package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Graphical {
    private final static int[][] board = new int[][] {
            { 2, 7, 4, 0, 9, 0, 6, 5, 3 },
            { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
            { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
            { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
            { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
            { 1, 0, 0, 4, 5, 6, 7, 8, 9 },
            { 4, 5, 7, 0, 8, 0, 2, 3, 6 },
            { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
            { 0, 0, 5, 3, 6, 2, 9, 7, 4 } };

    private final static int[][] boardSolvable = new int[][] {
            { 1, 0, 0, 2, 0, 0, 0, 0, 0 },
            { 0, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 0, 4, 0, 0, 0, 0 },
            { 0, 0, 4, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 7, 8, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    public Graphical(Sudoku sudoku) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku));
    }

    private void createWindow(Sudoku sudoku) {
        JFrame frame = new JFrame("Solving sodukus since 1999");
        Container container = frame.getContentPane();
        Dimension buttonDimension = new Dimension(450, 30);
        GridLayout gridLayout = new GridLayout(9, 9);
        JPanel segmentPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JTextField[][] textFields = new JTextField[9][9];
        JButton solveButton = new JButton("SOLVE");
        JButton clearButton = new JButton("CLEAR");

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(925, 975));
        container.setPreferredSize(new Dimension(925, 925));
        segmentPanel.setPreferredSize(new Dimension(900, 900));
        solveButton.setPreferredSize(buttonDimension);
        clearButton.setPreferredSize(buttonDimension);
        

        container.setLayout(new BorderLayout());
        segmentPanel.setLayout(gridLayout);

        createTextFields(textFields, segmentPanel);
        updateTextFields(textFields, sudoku.getNumbers());

        solveButton.addActionListener(event -> {
            //if (sudoku.solve()){
                sudoku.solve();
                updateTextFields(textFields, sudoku.getNumbers());
            //}
        });
        clearButton.addActionListener(event -> {
            sudoku.clear();
            updateTextFields(textFields, sudoku.getNumbers());
        });

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(solveButton, BorderLayout.WEST);
        buttonPanel.add(clearButton, BorderLayout.EAST);

        

        container.add(segmentPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);

        
        frame.pack();
        frame.setVisible(true);
    }

    private void createTextFields(JTextField[][] textFields, JPanel segmentPanel) {
        for (int row = 0; row < textFields.length; row++) {
            for (int col = 0; col < textFields[row].length; col++) {
                Dimension preferredSize = new Dimension(75, 75);

                JTextField textField = new JTextField("X");
                textField.setFont(new Font("Serif", Font.BOLD, 50));
                textField.setPreferredSize(preferredSize);
                textField.setHorizontalAlignment(0);
                textField.setBackground(Color.orange);
                if (col == col%3+3 && row != row%3+3){
                    textField.setBackground(Color.white);
                }else if (col != col%3+3 && row == row%3+3){
                    textField.setBackground(Color.white);
                }
                textField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
                textFields[row][col] = textField;
                segmentPanel.add(textField);
            }
        }
    }

    private void updateTextFields(JTextField[][] textFields, int[][] grid) {
        for (int row = 0; row < textFields.length; row++) {
            for (int col = 0; col < textFields[row].length; col++) {
                textFields[row][col].setText(Integer.toString(grid[row][col]));
            }
        }
    }

    public static void main(String[] args) {
        Sudoku solveThis = new Sudoku();
        solveThis.setNumbers(boardSolvable);
        new Graphical(solveThis);
    }
}
