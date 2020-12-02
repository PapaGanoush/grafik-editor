package formen;

import java.awt.*;

public abstract class Figur {
    protected int x;
    protected int y;

    protected Figur(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void zeichne(Graphics g);
}
