package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private JTextField textField;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals, buttonClear;

    private double num1, num2, result;
    private char operator;

    public CalculatorGUI() {
        super("Calculator");

        // Initialize componentsq
        textField = new JTextField(20);
        textField.setEditable(false);
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonEquals = new JButton("=");
        buttonClear = new JButton("C");

        // Add action listeners to buttons
        button0.addActionListener(new NumberButtonListener());
        button1.addActionListener(new NumberButtonListener());
        button2.addActionListener(new NumberButtonListener());
        button3.addActionListener(new NumberButtonListener());
        button4.addActionListener(new NumberButtonListener());
        button5.addActionListener(new NumberButtonListener());
        button6.addActionListener(new NumberButtonListener());
        button7.addActionListener(new NumberButtonListener());
        button8.addActionListener(new NumberButtonListener());
        button9.addActionListener(new NumberButtonListener());
        buttonPlus.addActionListener(new OperatorButtonListener());
        buttonMinus.addActionListener(new OperatorButtonListener());
        buttonMultiply.addActionListener(new OperatorButtonListener());
        buttonDivide.addActionListener(new OperatorButtonListener());
        buttonEquals.addActionListener(new EqualsButtonListener());
        buttonClear.addActionListener(new ClearButtonListener());

        // Create grid of buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(buttonClear);
        buttonPanel.add(button0);
        buttonPanel.add(buttonEquals);
        buttonPanel.add(buttonDivide);

        // Add components to frame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(textField, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        // setSize(300, 300);
        setVisible(true);
    }

    // Listener for number buttons
    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String number = event.getActionCommand();
            textField.setText(textField.getText() + number);
        }
    }

    // Listener for operator buttons
    private class OperatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            num1 = Double.parseDouble(textField.getText());
            operator = event.getActionCommand().charAt(0);
            textField.setText("");
        }
    }

    // Listener for equals button
    private class EqualsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
        }
    }

    // Listener for clear button
    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textField.setText("");
        }
    }

    // Main method to start program
    public static void main(String[] args) {
        new CalculatorGUI();
    }
}