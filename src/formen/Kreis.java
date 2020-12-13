package formen;

import java.awt.*;

public class Kreis extends Figur {
    private int radius;
    private boolean istGefuellt;

    public Kreis(int x, int y, int radius, boolean istGefuellt) {
        super(x, y);
        this.radius = radius;
        this.istGefuellt = istGefuellt;
    }

    @Override
    public void zeichne(Graphics g) {
        if(istGefuellt) {
            g.fillOval(super.x, super.y, radius, radius);
        } else {
            g.drawOval(super.x, super.y, radius, radius);
        }
    }

    @Override
    public void vergroessere(int anzahlPixel) {
        radius += anzahlPixel;
    }
}
