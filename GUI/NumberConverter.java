package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberConverter extends JFrame {
    private JTextField decimalField, hexField, binaryField;

    public NumberConverter() {
        super("Number Converter");

        JLabel decimalLabel = new JLabel("DECIMAL");
        decimalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel hexLabel = new JLabel("HEX");
        hexLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel binaryLabel = new JLabel("BINARY");
        binaryLabel.setHorizontalAlignment(SwingConstants.CENTER);

        decimalField = new JTextField(10);
        decimalField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimalValue = Integer.parseInt(decimalField.getText());
                    String hexValue = Integer.toHexString(decimalValue).toUpperCase();
                    String binaryValue = Integer.toBinaryString(decimalValue);
                    hexField.setText(hexValue);
                    binaryField.setText(binaryValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(NumberConverter.this, "Invalid decimal value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        hexField = new JTextField(10);
        hexField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimalValue = Integer.parseInt(hexField.getText(), 16);
                    String binaryValue = Integer.toBinaryString(decimalValue);
                    decimalField.setText(Integer.toString(decimalValue));
                    binaryField.setText(binaryValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(NumberConverter.this, "Invalid hex value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        binaryField = new JTextField(10);
        binaryField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimalValue = Integer.parseInt(binaryField.getText(), 2);
                    String hexValue = Integer.toHexString(decimalValue).toUpperCase();
                    decimalField.setText(Integer.toString(decimalValue));
                    hexField.setText(hexValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(NumberConverter.this, "Invalid binary value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 2, 5, 5));
        contentPane.add(decimalLabel);
        contentPane.add(decimalField);
        contentPane.add(hexLabel);
        contentPane.add(hexField);
        contentPane.add(binaryLabel);
        contentPane.add(binaryField);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberConverter();
            }
        });
    }
}
