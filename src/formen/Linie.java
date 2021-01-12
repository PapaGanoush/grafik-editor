package formen;

import java.awt.*;

public class Linie extends Figur {
    private int endX;
    private int endY;

    public Linie(int x, int y, int endX, int endY) {
        super(x, y);
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawLine(super.x, super.y, endX, endY);
    }

}
