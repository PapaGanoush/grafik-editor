package formen;

import java.awt.*;

public class Kreis extends Figur {
    private int radius;
    private boolean istGefuellt;

    public Kreis(int x, int y, int radius, boolean istGefuellt) {
        super(x, y);
        this.radius = radius;
        this.istGefuellt = istGefuellt;
        gebeInfos();
    }

    @Override
    public void zeichne(Graphics g) {
        int x = super.x-radius;
        int y = super.y-radius;
        if(istGefuellt) {
            g.fillOval(x, y, radius*2, radius*2);
        } else {
            g.drawOval(x, y, radius*2, radius*2);
        }
        System.out.println(x + " " + y + " " + radius*2);
    }

    @Override
    public String gebeInfos() {
        return "Figurtyp: Kreis, X: " + super.x + ", Y: " + super.y + ", Radius: " + radius;
    }

}
