package formen;

import java.awt.*;

public class Rechteck extends Figur {
    private int breite;
    private int hoehe;
    private boolean istGefuellt;

    public Rechteck(int x, int y, int breite, int hoehe, boolean istGefuellt) {
        super(x, y);
        this.breite = breite;
        this.hoehe = hoehe;
        this.istGefuellt = istGefuellt;
        gebeInfos();
    }

    @Override
    public void zeichne(Graphics g) {
        if(istGefuellt) {
            g.fillRect(super.x, super.y, breite, hoehe);
        } else {
            g.drawRect(super.x, super.y, breite, hoehe);
        }
    }

    @Override
    public String gebeInfos() {
        return "Figurtyp: Rechteck, X: " + super.x + ", Y: " + super.y + ", Breite: " + breite + ", Hoehe: " + hoehe;
    }

}
