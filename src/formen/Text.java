package formen;

import java.awt.*;

public class Text extends Figur {
    String eingabe;

    public Text(int x, int y, String eingabe) {
        super(x, y);
        this.eingabe = eingabe;
    }

    @Override
    public void zeichne(Graphics g) {
        g.drawString(eingabe, super.x, super.y);
    }
}
