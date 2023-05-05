package GUI;

import javax.swing.*;

public class SFrameExample extends JFrame {
    SFrameExample() {
        super("Hello Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        JButton button1 = new JButton("Press");
        button1.setSize(10, 10);
        button1.addActionListener(e -> {
            System.out.println("Hello World");
        });

        getContentPane().add(button1); // Adds Button to content pane of frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new SFrameExample();
    }
}