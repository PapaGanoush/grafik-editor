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

    @Override
    public String[] erhalteInformationen() {
        String positionX = String.valueOf(super.x);
        String positionY = String.valueOf(super.y);
        String radius = String.valueOf(this.radius);
        String istGefuellt = String.valueOf(this.istGefuellt);

        String[] formInformationen = {"Kreis", positionX, positionY, radius, istGefuellt};
        return  formInformationen;
    }

}
