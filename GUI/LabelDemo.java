package GUI;

import java.awt.*;
import java.awt.event.*;

public class LabelDemo extends Frame implements ActionListener, ItemListener {
	Label label1, label2;
	Button b1, b2;
	Choice choice, choice1;
	List list1, list2;
	Checkbox cb1, cb2;
	TextField tf1;
	Checkbox rb1, rb2, rb3;
	Scrollbar hsbar, vsbar;
	String msg = "";
	String[] items = { "" };
	MenuBar mbar;
	Menu file, view, submenu;

	LabelDemo(String title) {
		super(title);
		setBackground(Color.white);
		setForeground(Color.blue);
		setSize(400, 400);
		setLocation(100, 100);
		setLayout(new FlowLayout());
		setFont(new Font("Times Roman",
				Font.PLAIN, 20));
		setVisible(true);

		label1 = new Label("First Label");
		label2 = new Label("2nd Label");
		label1.setSize(30, 10);
		add(label1);
		add(label2);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		b1 = new Button("Click b1");
		b2 = new Button("Click b2");

		add(b1);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		choice = new Choice();
		choice.add("Windows");
		choice.add("Linux");
		choice.add("Tizen");

		add(choice);

		choice1 = new Choice();

		choice1.add("Firefox");
		choice1.add("Chrome");
		choice1.add("Edge");

		add(choice1);

		choice.addItemListener(this);
		choice1.addItemListener(this);

		list1 = new List(3, true);

		list1.add("C");
		list1.add("C++");
		list1.add("Java");
		list1.add("Python");

		add(list1);

		list1.addActionListener(this);

		cb1 = new Checkbox("Bold");
		cb2 = new Checkbox("Italic");

		add(cb1);
		add(cb2);

		cb1.addItemListener(this);
		cb2.addItemListener(this);

		tf1 = new TextField(30);

		add(tf1);

		// creating radio buttons
		CheckboxGroup cbg = new CheckboxGroup();

		rb1 = new Checkbox("Arial", true, cbg);
		rb2 = new Checkbox("Sans serif", false, cbg);
		rb3 = new Checkbox("Lucida bright", false, cbg);

		add(rb1);
		add(rb2);
		add(rb3);

		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);

		file = new Menu("File");
		file.add(new MenuItem("Save"));
		file.add(new MenuItem("Open"));
		file.add(new MenuItem("Save as..."));
		file.add(new MenuItem("New"));

		view = new Menu("View");
		view.add(new CheckboxMenuItem("Status bar"));

		submenu = new Menu("Submenu");
		submenu.add(new MenuItem("pdf file"));
		submenu.add(new MenuItem("doc file"));

		file.add(submenu);

		mbar = new MenuBar();
		mbar.add(file);
		mbar.add(view);

		setMenuBar(mbar);
		pack();

	}

	public static void main(String[] args) {
		new LabelDemo("Label Demo");
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			label1.setText("You clicked b1");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			label1.setText("First Label");
		} else if (ae.getSource() == b2) {
			label2.setText("You clicked b2");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			label2.setText("2nd Label");
		}
		if (ae.getSource() == list1) {
			items = list1.getSelectedItems();
			repaint();
		}

	}

	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == choice) {
			msg = "";
			msg += choice.getSelectedItem();
			repaint();
		}
		if (ie.getSource() == choice1) {
			msg += "  " + choice1.getSelectedItem();
			repaint();
		}
		if (ie.getSource() == cb1) {
			tf1.getSelectedText();
			setFont(new Font("Sans Serif", Font.BOLD, 16));
			repaint();
		}
		if (ie.getSource() == cb2) {
			tf1.getSelectedText();
			setFont(new Font("Sans Serif", Font.ITALIC, 16));
			repaint();
		}

	}

	public void paint(Graphics g) {
		g.drawString(msg, 200, 100);
		int x = 200;
		for (int i = 0; i < items.length; i++)
			g.drawString(items[i] + "  ", x + items[i].length(), 200);

	}

	public Insets getInsets() {
		return new Insets(50, 50, 50, 50);
	}

}