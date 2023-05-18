package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserDataGUI extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;
    private JButton displayButton;

    public UserDataGUI() {
        super("User Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text area for user input
        textArea = new JTextArea();

        // Create save button and add listener
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);

        // Create load button and add listener
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);

        // Create display button and add listener
        displayButton = new JButton("Display");
        displayButton.addActionListener(this);

        // Add components to frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(displayButton);
        add(textArea, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            try (PrintWriter writer = new PrintWriter("userdata.txt")) {
                writer.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == loadButton) {
            try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = reader.readLine();
                }
                textArea.setText(sb.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == displayButton) {
            try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = reader.readLine();
                }
                JOptionPane.showMessageDialog(this, sb.toString(), "User Data", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserDataGUI();
            }
        });
    }
}