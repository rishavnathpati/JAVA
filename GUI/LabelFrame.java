package GUI;

import java.awt.*;
import javax.swing.*;

public class LabelFrame extends JFrame {
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;

    public LabelFrame() {
        super("Testing JLabel");
        setLayout(new FlowLayout());
        setFont(new Font("Sans Serif", Font.ITALIC + Font.BOLD, 18));

        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        add(label1);

        Icon trash = new ImageIcon("trash.png");
        label2 = new JLabel("Label with text and icon", trash, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        add(label2);

        label3 = new JLabel();
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(new ImageIcon("synchronize.png"));
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add(label3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocation(200, 100);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelFrame();
    }
}
