package formen;

import java.awt.*;

public class Linie extends Figur {
    private int endX;
    private int endY;

    public Linie(int x, int y, int endX, int endY) {
        super(x, y);
        this.endX = endX;
        this.endY = endY;
        gebeInfos();
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawLine(super.x, super.y, endX, endY);
    }

    @Override
    public String gebeInfos() {
        return "Figurtyp: Linie, X: " + super.x + ", Y: " + super.y + ", EndX: " + endX + ", EndY: " + endY;
    }

}
