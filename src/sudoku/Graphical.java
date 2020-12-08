package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

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

    public Graphical(Sudoku sudoku, int bigness) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku, bigness));
    }

    private void createWindow(Sudoku sudoku, int n) {
        JFrame frame = new JFrame("Solving sodukus since 1999");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container windowPane = frame.getContentPane();
        windowPane.setLayout(new BorderLayout());

        JPanel segmentPanel = new JPanel();
        segmentPanel.setLayout(new GridLayout(n, n));
        JPanel[] panelMatrix = new JPanel[n * n];

        for (int i = 0; i < panelMatrix.length; i++) {
            panelMatrix[i] = new JPanel();
            panelMatrix[i].setLayout(new GridLayout(n, n));
        }

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                JTextField textField = new JTextField(""+sudoku.getNumber(x, y));
                textField.setFont(new Font("Serif", Font.BOLD, 50)); // Större text
                textField.setHorizontalAlignment(0);
                if (conversion(x, y) % 2 == 0) {
                    textField.setBackground(new Color(254, 127, 73));
                }
                panelMatrix[conversion(x, y)].add(textField);
            }
        }

        for (int i = 0; i < panelMatrix.length; i++) {
            segmentPanel.add(panelMatrix[i]);
        }

        JButton solveButton = new JButton("SOLVE");
        JButton clearButton = new JButton("CLEAR");

        Dimension buttonDimension = new Dimension(441, 30);
        solveButton.setPreferredSize(buttonDimension);
        clearButton.setPreferredSize(buttonDimension);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(solveButton, BorderLayout.WEST);
        buttonPanel.add(clearButton, BorderLayout.EAST);


        windowPane.add(segmentPanel);
        windowPane.add(buttonPanel, BorderLayout.SOUTH);

        frame.setPreferredSize(new Dimension(900, 900));
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 
     * @param x
     * @param y
     * @return The index of the pane that number should be in
     */
    private int conversion(int x, int y) {
        if (x < 3 && 0 <= x) {
            if (y < 3 && 0 <= y) {
                return 0;
            } else if (y < 6 && 3 <= y) {
                return 1;
            } else {
                return 2;
            }
        } else if (x < 6 && 3 <= x) {
            if (y < 3 && 0 <= y) {
                return 3;
            } else if (y < 6 && 3 <= y) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (y < 3 && 0 <= y) {
                return 6;
            } else if (y < 6 && 3 <= 6) {
                return 7;
            } else {
                return 8;
            }
        }

    }

    public static void main(String[] args) {
        Sudoku solveThis = new Sudoku();
        solveThis.solve();
        new Graphical(solveThis, 3);
    }
}
