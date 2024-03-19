package src;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.List;

import javax.swing.JPanel;
import javax.swing.Timer;

//Main game Loop.
///Timer reruns program every x milliseconds

public class Screen extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(0, this);
    Player p = new Player(10, 10, 20, 20);
    Fruit a = new Fruit();
    Rectangle p1;
    Rectangle a1;
    int close = 0;
    public int run = 0;
    public int score;

    public Screen() {
        addKeyListener(this);
        setFocusable(true);
        t.start();

    }

    public void actionPerformed(ActionEvent arg0) {
        p.tick();
        repaint();

        p1 = new Rectangle(p.x, p.y, 20, 20);
        a1 = new Rectangle(a.x, a.y, 20, 20);

        if (p1.intersects(a1)) {
            p.length += 20;
            a.update();
        }
        if (p.x >= 380 || p.x <= 0) {
            t.stop();
        }
        if (p.y >= 355 || p.y <= 0) {
            t.stop();
            System.out.print("IDIT");
        }
        if (run == 1) {
            p.self_collision(t);
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        p.draw(g);
        a.draw(g);
        score = p.length / 20;
        g.drawString(Integer.toString(score), 10, 10);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int speed = 2;
        p.dy = 0;
        p.dx = 0;
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            p.dy = 0 - speed;
            run = 1;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            p.dy = speed;
            run = 1;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.dx = speed;
            run = 1;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            p.dx = 0 - speed;
            run = 1;
        }

    }

    public void keyReleased(KeyEvent event) {
        // stil not using this
    }

    public void keyTyped(KeyEvent arg0) {
        // not much use for this either
    }

}
