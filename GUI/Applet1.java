package GUI;

//<applet code = Applet1 width = 600 height = 400 > </applet>

import java.applet.*;
import java.awt.*;

public class Applet1 extends Applet {
	String msg = "";
	Button b1, b2, b3;

	public void init() {
		setBackground(Color.red);
		setForeground(Color.cyan);
		setFont(new Font("Arial", Font.ITALIC, 24));
		System.out.println("Inside init method ");
		msg += "Inside init method";
		// create components
		b1 = new Button("Click here");
		b2 = new Button("Click there");
		b3 = new Button("Click there too");

		add(b1);
		add(b2);
		add(b3);

	}

	public void start() {
		System.out.println("Inside start method");
		msg += "Inside start method ";
	}

	public void stop() {
		System.out.println("Inside stop method");
		msg += "Inside stop method ";

	}

	public void destroy() {
		System.out.println("Inside destroy method");
		msg += "Inside destroy method ";

	}

	public void paint(Graphics g) {
		// g.drawString("Inside paint method", 100, 100);
		msg += "Inside paint method ";
		g.drawString(msg, 100, 100);
		g.drawLine(100, 500, 400, 100);
		g.drawRect(300, 300, 70, 50);
		g.fillRect(300, 300, 70, 50);

		g.drawRoundRect(300, 300, 100, 50, 20, 10);

	}

}