package formen;

import java.awt.*;
import java.util.List;

public abstract class Figur {
    protected int x;
    protected int y;

    protected Figur(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void zeichne(Graphics g);

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public void  vergroessere(int anzahlPixel) {
        double verschiebeXY = anzahlPixel / 2;
        x -= verschiebeXY;
        y -= verschiebeXY;
    }

}
