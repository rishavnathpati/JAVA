package GUI;


import javax.swing.*;

public class SFrameExample{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button1 = new JButton("Press");
        frame.getContentPane().add(button1); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
    
}