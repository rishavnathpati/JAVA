package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserInfoForm extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel genderLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JLabel interestsLabel;
    private JCheckBox sportsCheckBox;
    private JCheckBox moviesCheckBox;
    private JCheckBox musicCheckBox;
    private JButton submitButton;

    public UserInfoForm() {
        super("User Information Form");
        setLayout(new FlowLayout());

        // Create name input field
        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField(20);
        add(nameField);

        // Create gender input field
        genderLabel = new JLabel("Gender:");
        add(genderLabel);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);

        // Create interests input field
        interestsLabel = new JLabel("Interests:");
        add(interestsLabel);
        sportsCheckBox = new JCheckBox("Sports");
        moviesCheckBox = new JCheckBox("Movies");
        musicCheckBox = new JCheckBox("Music");
        JPanel interestsPanel = new JPanel();
        interestsPanel.add(sportsCheckBox);
        interestsPanel.add(moviesCheckBox);
        interestsPanel.add(musicCheckBox);
        add(interestsPanel);

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get user information
        String name = nameField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        String interests = "";
        if (sportsCheckBox.isSelected()) {
            interests += "Sports, ";
        }
        if (moviesCheckBox.isSelected()) {
            interests += "Movies, ";
        }
        if (musicCheckBox.isSelected()) {
            interests += "Music, ";
        }
        interests = interests.isEmpty() ? "None" : interests.substring(0, interests.length() - 2);

        // Write user information to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("user_info.txt", true))) {
            writer.printf("Name: %s\n", name);
            writer.printf("Gender: %s\n", gender);
            writer.printf("Interests: %s\n", interests);
            writer.println();
            writer.flush();
            JOptionPane.showMessageDialog(this, "User information saved successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save user information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new UserInfoForm();
    }
}
