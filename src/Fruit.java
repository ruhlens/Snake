package src;

import java.awt.*;
import java.util.Random;

public class Fruit extends Rectangle {
    public int x, y;

    public Fruit() {
        this.x = new Random().nextInt(50, 350);
        this.y = new Random().nextInt(50, 350);
        setBounds(x, y, 20, 20);
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(x, y, 20, 20);

    }

    public void update() {
        this.x = new Random().nextInt(50, 350);
        this.y = new Random().nextInt(50, 350);
        setBounds(x, y, 20, 20);
    }
}
