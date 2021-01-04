package formen;

import java.awt.*;

public class Text extends Figur {
    String eingabe;
    int schriftgroesse = 12;
    Graphics g;

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

    @Override
    public String[] erhalteInformationen() {
        String positionX = String.valueOf(super.x);
        String positionY = String.valueOf(super.y);

        String[] formInformationen = {"Text", positionX, positionY, eingabe};
        return  formInformationen;
    }

}
