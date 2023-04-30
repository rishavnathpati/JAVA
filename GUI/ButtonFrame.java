package GUI;

// Command buttons and action events.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
    private final JButton plainJButton;
    private final JButton fancyJButton;

    public ButtonFrame() {
        super("Testing Buttons");
        setLayout(new FlowLayout());

        plainJButton = new JButton("Plain Button"); // button with text

        add(plainJButton); // add plainJButton to JFrame

        Icon icon1 = new ImageIcon(("restart.gif"));
        Icon icon2 = new ImageIcon(("icon8.gif"));

        fancyJButton = new JButton("Fancy Button", icon1); // set image
        fancyJButton.setRolloverIcon(icon2); // set rollover image
        add(fancyJButton); // add fancyJButton to JFrame

        // create new ButtonHandler for button event handling

        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocation(200, 100);
        setVisible(true);

    }

    // inner class for button event handling

    private class ButtonHandler implements ActionListener {
        // handle button event

        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
                    "You pressed: %s", event.getActionCommand()));
        }
    }

    public static void main(String[] args) {
        new ButtonFrame();
    }
} // end class ButtonFrame
