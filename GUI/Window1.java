package GUI;

import java.awt.*;

public class Window1 extends Window {
	Button b;

	Window1(Frame frm) {
		super(frm);
		setSize(300, 400);
		setVisible(true);
		setLocation(200, 200);

		Panel panel = new Panel();
		panel.setLocation(200, 250);
		panel.setSize(100, 50);

		panel.setBackground(Color.magenta);
		b = new Button("Click here");
		panel.add(b);
		add(panel);
		panel.setVisible(true);
	}

	public static void main(String... args) {
		Frame frm = new Frame();
		new Window1(frm);
	}
}
