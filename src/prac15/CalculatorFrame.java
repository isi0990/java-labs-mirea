package prac15;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    JTextField display;
    JPanel buttonPanel;

    public CalculatorFrame() {

        super("Calculator");

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(0, 70));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 6, 6));

        String[] buttons = {
                "C", "←", "/", "*",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "0", ".", "", ""
        };

        CalculatorButtonListener listener = new CalculatorButtonListener(display);

        for (String label : buttons) {
            JButton b = new JButton(label);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            if (label.isEmpty()) {
                JButton empty = new JButton();
                empty.setEnabled(false);
                buttonPanel.add(empty);
            } else {
                b.addActionListener(listener);
                buttonPanel.add(b);
            }
        }

        setLayout(new BorderLayout(8, 8));
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setSize(360, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
