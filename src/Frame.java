package src;

import javax.swing.JFrame;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SNAKE");
        setSize(400, 400);
        setResizable(false);

        init();
    }

    public void init() {
        setLayout(new GridLayout(1, 1, 0, 0));
        Screen s = new Screen();
        add(s);
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
    }

}
