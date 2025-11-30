package prac15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButtonListener implements ActionListener {
    private final JTextField display;
    private Double pendingValue = null;
    private String pendingOperator = null;
    private Boolean waitingForNewNumber = true;

    public CalculatorButtonListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            handleDigit(command);
            return;
        }

        if (".".equals(command)) {
            handleDot();
            return;
        }

        if ("C".equals(command)) {
            clearAll();
            return;
        }

        if ("←".equals(command)) {
            backspace();
            return;
        }

        if (isOperator(command)) {
            handleOperator(command);
            return;
        }

        if ("=".equals(command)) {
            handleEquals();
        }
    }

    private void handleDigit(String d) {
        if (waitingForNewNumber) {
            display.setText(d);
            waitingForNewNumber = false;
        } else {
            display.setText(display.getText() + d);
        }
    }

    private void handleDot() {
        if (waitingForNewNumber) {
            display.setText("0.");
            waitingForNewNumber = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void clearAll() {
        display.setText("");
        pendingValue = null;
        pendingOperator = null;
        waitingForNewNumber = true;
    }

    private void backspace() {
        if (waitingForNewNumber) return;
        String txt = display.getText();
        if (txt == null || txt.length() == 0) {
            waitingForNewNumber = true;
            return;
        }
        txt = txt.substring(0, txt.length() - 1);
        display.setText(txt);
        if (txt.isEmpty()) waitingForNewNumber = true;
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    private void handleOperator(String op) {
        if (pendingOperator != null && !waitingForNewNumber) {
            try {
                double right = parseDisplayAsDouble();
                pendingValue = apply(pendingValue, right, pendingOperator);
                display.setText(formatNumber(pendingValue));
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                clearAll();
                return;
            } catch (NumberFormatException ignored) {
                pendingValue = apply(pendingValue, 0.0, pendingOperator);
                display.setText(formatNumber(pendingValue));
            }
            waitingForNewNumber = true;
            pendingOperator = op;
            return;
        }

        if (pendingOperator != null && waitingForNewNumber) {
            pendingOperator = op;
            return;
        }

        try {
            double current = parseDisplayAsDouble();
            pendingValue = current;
        } catch (NumberFormatException ex) {
            pendingValue = 0.0;
        }
        pendingOperator = op;
        waitingForNewNumber = true;
    }

    private void handleEquals() {
        if (pendingOperator == null) {
            return;
        }
        try {
            double right = parseDisplayAsDouble();
            pendingValue = apply(pendingValue, right, pendingOperator);
            display.setText(formatNumber(pendingValue));
            // После = очищаем оператор — результат остаётся в pendingValue
            pendingOperator = null;
            waitingForNewNumber = true;
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            clearAll();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Неверный ввод числа", "Ошибка", JOptionPane.ERROR_MESSAGE);
            clearAll();
        }
    }

    private double parseDisplayAsDouble() {
        String txt = display.getText();
        if (txt == null || txt.trim().isEmpty()) return 0.0;
        return Double.parseDouble(txt.trim());
    }

    private double apply(Double left, double right, String op) {
        double a = (left == null) ? 0.0 : left;
        return switch (op) {
            case "+" -> a + right;
            case "-" -> a - right;
            case "*" -> a * right;
            case "/" -> {
                if (right == 0.0) throw new ArithmeticException("Ошибка: деление на ноль!");
                yield a / right;
            }
            default -> right;
        };
    }

    private String formatNumber(double v) {
        if (v == Math.rint(v)) {
            long lv = (long) v;
            return Long.toString(lv);
        } else {
            return Double.toString(v);
        }
    }
}