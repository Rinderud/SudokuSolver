package sudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Graphical {

    public Graphical(int bigness) {
        SwingUtilities.invokeLater(() -> createWindow(bigness));
    }

    private void createWindow(int n) {
        JFrame frame = new JFrame("Solving sodukus since 1999");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container windowPane = frame.getContentPane();
        windowPane.setLayout(new GridLayout(n, n));

        JPanel[] panelMatrix = new JPanel[n * n];

        int[][] board = new int[][] {
            { 2, 7, 4, 0, 9, 0, 6, 5, 3 },
            { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
            { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
            { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
            { 9, 3, 8, 7, 2, 5, 0, 6, 3 },
            { 1, 0, 0, 4, 5, 6, 7, 8, 9 },
            { 4, 5, 7, 0, 8, 0, 2, 3, 6 },
            { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
            { 0, 0, 5, 3, 6, 2, 9, 7, 4 } };


/**
 * Loopen behöver göras om:
 * Den ska loopa logiskt, dvs. som man loopar igenom en 2d matris.
 * Den grafiska delen behöver då skrivas om,
 * samma delar men kanske i en annan loop och sparas annorlunda.
 */


        for (int i = 0; i < panelMatrix.length; i++) {
            panelMatrix[i] = new JPanel();
            panelMatrix[i].setLayout(new GridLayout(n, n));
            for (int j = 0; j < n * n; j++) {
                JLabel label = new JLabel("  " + board[x][y] + "  "); // Tillfällig lösning till hur brädan skrivs ut
                label.setFont(new Font("Serif", Font.PLAIN, 100)); // Sätter storleken på texten till 100, så man enkelt
                                                                   // ser.
                panelMatrix[i].add(label);
            }
            if (i % 2 == 1) {
                panelMatrix[i].setBackground(new Color(150, 150, 150)); // Färgar hälften av 3x3 rutorna, så det blir
                                                                        // tydligare
            }

            windowPane.add(panelMatrix[i]);
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Graphical(3);
    }
}
