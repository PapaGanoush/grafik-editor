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
    public void vergroessere(int anzahlPixel) {
        super.vergroessere(anzahlPixel);
        breite += anzahlPixel;
        hoehe += anzahlPixel;
    }

    @Override
    public String[] erhalteInformationen() {
        String positionX = String.valueOf(super.x);
        String positionY = String.valueOf(super.y);
        String breite = String.valueOf(this.breite);
        String hoehe = String.valueOf(this.hoehe);
        String istGefuellt = String.valueOf(this.istGefuellt);

        String[] formInformationen = {"Rechteck", positionX, positionY, breite, hoehe, istGefuellt};
        return  formInformationen;
    }

}
