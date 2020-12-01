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

        for (int i = 0; i < panelMatrix.length; i++) {
            panelMatrix[i] = new JPanel();
            panelMatrix[i].setLayout(new GridLayout(n, n));
            for (int j = 0; j < n * n; j++) {
                JLabel label = new JLabel(" " + i + ":" + j + " ");
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
