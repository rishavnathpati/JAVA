package GUI;

// JTextFields and JPasswordFields.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldFrame extends JFrame {
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JPasswordField passwordField;

	public TextFieldFrame() {
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());

		// construct text field with 10 columns

		textField1 = new JTextField(10);
		add(textField1);

		// construct text field with default text

		textField2 = new JTextField("Enter text here");
		add(textField2);

		// construct text field with default text and 21 columns

		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setEditable(false); // disable editing
		add(textField3);

		// construct password field with default text

		passwordField = new JPasswordField("Hidden text");
		add(passwordField); // add passwordField to JFrame

		// register event handlers

		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 100);
		setLocation(100, 100);
		setVisible(true);
	}

	// private inner class for event handling

	private class TextFieldHandler implements ActionListener {

		// process text field events

		public void actionPerformed(ActionEvent event) {
			String string = "";

			// user pressed Enter in JTextField textField1

			if (event.getSource() == textField1)
				string = String.format("textField1: %s", event.getActionCommand());

			// user pressed Enter in JTextField textField2

			else if (event.getSource() == textField2)
				string = String.format("textField2: %s", event.getActionCommand());

			// user pressed Enter in JTextField textField3

			else if (event.getSource() == textField3)
				string = String.format("textField3: %s", event.getActionCommand());

			// user pressed Enter in JTextField passwordField

			else if (event.getSource() == passwordField)
				string = String.format("passwordField: %s", event.getActionCommand());

			// display JTextField content

			JOptionPane.showMessageDialog(null, string);
		}

	} // end private inner class TextFieldHandler

	public static void main(String[] args) {
		new TextFieldFrame();

	}

} // end class TextFieldFrame
