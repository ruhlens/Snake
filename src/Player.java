package src;

import java.awt.ArrayList;
import java.awt.List;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.Timer;

public class Player extends Rectangle {
    public int dx, dy;
    public int snake_lenght;
    public ArrayList<ArrayList> piece = new ArrayList<ArrayList>();
    int length = 10;

    public Player(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.width = width;
        this.height = height;
    }

    public void body() {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        int Lx = (int) this.getX();
        int Ly = (int) this.getY();
        coords.add(Lx);
        coords.add(Ly);
        piece.add(0, coords);
        int index = piece.size() - 1;
        if (piece.size() > length) {
            piece.remove(index);
        }
    }

    public void tick() {
        this.x += dx;
        this.y += dy;
        this.body();
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
        for (int i = 0; i < piece.size() - 1; i++) {
            Object x1, y1;
            int x2, y2;
            x1 = piece.get(i).get(0);
            y1 = piece.get(i).get(1);
            x2 = (int) x1;
            y2 = (int) y1;
            g.fillRect(x2, y2, 20, 20);

        }
    }

    public void self_collision(Timer time_var) {
        int current_x, current_y;
        ArrayList<Integer> current_coords = new ArrayList<Integer>();
        current_x = (int) this.getX() + this.dx;
        current_y = (int) this.getY() + this.dy;
        current_coords.add(current_x);
        current_coords.add(current_y);
        if (piece.contains(current_coords)) {
            time_var.stop();
        }
    }

    public void setDx(int dx) {
        // this.dx = dx;
    }

    public void setDy(int dy) {
        // this.dy = dy;
    }

}
