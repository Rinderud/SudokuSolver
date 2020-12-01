package sudoku;

import java.awt.*;

import javax.swing.*;

public class Graphical {

    public Graphical(int bigness) {
        SwingUtilities.invokeLater(() -> createWindow(bigness));
    }

    private void createWindow(int n) {
        JFrame frame = new JFrame("Solving sodukus since 1999");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container windowPane = frame.getContentPane();
        windowPane.setLayout(new GridLayout(n, n));

        JPanel[] panelMatrix = new JPanel[n*n];

        for (int i = 0; i < panelMatrix.length; i++){
            panelMatrix[i] = new JPanel();
            panelMatrix[i].setLayout(new GridLayout(n, n));
            for(int j = 0; j < n*n; j++){
                JLabel label = new JLabel(" " + i + ":" + j + " ");
                label.setFont(new Font("Serif", Font.PLAIN, 64));
                panelMatrix[i].add(label);
            }
            panelMatrix[i].setBackground(new Color(i*5, i*5, i*5));
            windowPane.add(panelMatrix[i]);
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Graphical(3);
    }
}
