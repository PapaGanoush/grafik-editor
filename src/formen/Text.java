package formen;

import java.awt.*;

public class Text extends Figur {
    String eingabe;
    Graphics g;
    int schriftgroesse = 12;

    public Text(int x, int y, String eingabe) {
        super(x, y);
        this.eingabe = eingabe;
    }

    @Override
    public void zeichne(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, schriftgroesse));
        g.drawString(eingabe, super.x, super.y);
        this.g = g;
    }

    @Override
    public void vergroessere(int anzahlPixel) {
        super.vergroessere(anzahlPixel);
        schriftgroesse += anzahlPixel;
    }
}
