package GUI;

import java.awt.*;
import java.awt.event.*;
//Scrollbar demo

public class ScrollBarDemo extends Frame implements AdjustmentListener, MouseMotionListener {
	Scrollbar hsbar, vsbar;
	String msg = "";

	ScrollBarDemo(String title) {
		super(title);
		setBackground(Color.white);
		setForeground(Color.blue);
		setSize(800, 500);
		setLocation(100, 100);
		setFont(new Font("Times Roman", Font.ITALIC, 20));
		setVisible(true);

		hsbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 300);
		vsbar = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 300);

		add(hsbar, BorderLayout.SOUTH);
		add(vsbar, BorderLayout.EAST);

		hsbar.addAdjustmentListener(this);
		vsbar.addAdjustmentListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		}
		);

		// pack();
	}

	public void adjustmentValueChanged(AdjustmentEvent ae) {
		repaint();
	}

	public static void main(String[] args) {
		new ScrollBarDemo("Scrollbars demo");
	}

	public void mouseDragged(MouseEvent me) {
		int x = me.getX();
		int y = me.getY();
		vsbar.setValue(y);
		hsbar.setValue(x);
		repaint();
	}

	public void mouseMoved(MouseEvent me) {
	}

	public void paint(Graphics g) {
		msg = "Vertical: " + vsbar.getValue();
		msg += ", Horizontal: " + hsbar.getValue();
		g.drawString(msg, 6, 160);
		g.drawString("*", hsbar.getValue(), vsbar.getValue());
	}

}
