package JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField addressField;
    private JButton submitButton;
    private JButton fetchButton;
    private JTextArea displayArea;
    private Connection conn;

    public UserForm() {
        super("User Details");

        // Create input fields for user details
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);

        // Create submit button and add listener
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Create fetch button and add listener
        fetchButton = new JButton("Fetch");
        fetchButton.addActionListener(this);

        // Add components to frame
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(fetchButton);
        add(buttonPanel, BorderLayout.CENTER);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // Connect to MySQL database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Insert user details into database
            String name = nameField.getText();
            String email = emailField.getText();
            String address = addressField.getText();

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_details (name, email, address) VALUES (?, ?, ?)")) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, address);
                int result = stmt.executeUpdate();
                displayArea.setText(result > 0 ? "User details inserted successfully" : "Failed to insert user details");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == fetchButton) {
            // Retrieve user details from database and display in text area
            StringBuilder sb = new StringBuilder();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM user_details")) {
                while (rs.next()) {
                    sb.append("Name: ");
                    sb.append(rs.getString("name"));
                    sb.append(", Email: ");
                    sb.append(rs.getString("email"));
                    sb.append(", Address: ");
                    sb.append(rs.getString("address"));
                    sb.append("\n");
                }
                displayArea.setText(sb.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UserForm().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Connection conn = ((UserForm)e.getSource()).conn;
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}