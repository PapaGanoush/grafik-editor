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

    @Override
    public void move(int deltaX, int deltaY) {
        super.move(deltaX, deltaY);
        this.endX += deltaX;;
        this.endY += deltaY;
    }

    @Override
    public void vergroessere(int anzahlPixel) {
        super.vergroessere(anzahlPixel);
        endX += anzahlPixel;
        endY += anzahlPixel;
    }

}
