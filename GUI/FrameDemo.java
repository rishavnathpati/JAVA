package GUI;

import java.awt.*;
import java.awt.event.*;

public class FrameDemo extends Frame {
      Label label1, label2;
      Button b1, b2;

      FrameDemo(String title) {
            super(title);
            setBackground(Color.white);
            setForeground(Color.blue);
            setFont(new Font("Arial", Font.ITALIC, 20));
            setLayout(new FlowLayout());
            setSize(400, 200);
            setLocation(100, 100);
            setVisible(true);
            label1 = new Label("First label");
            label2 = new Label("Second label");

            add(label1);
            add(label2);

            b1 = new Button("Button b1");
            b2 = new Button("Button b2");

            add(b1);
            add(b2);

            // event registration
            addWindowListener(new WindowAdapter() {// start of AIC
                  public void windowClosing(WindowEvent we) {
                        dispose();
                  }
            }// end of AIC

            );

            pack();
      }

      public static void main(String[] args) {
            new FrameDemo("Frame demo");
      }
}

/*
 * class WindowAdapter1 extends WindowAdapter {
 * public void windowClosing(WindowEvent we) {
 * System.exit(0);
 * }
 * }
 */
