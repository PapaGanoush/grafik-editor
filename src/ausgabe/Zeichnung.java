package ausgabe;

import formen.Figur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {
    public List<Figur> figuren = new ArrayList<>();

    public Zeichnung() {}

    public void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    public void hinzufuegen(Figur f) {
        figuren.add(f);
    }

    public void loescheAlles() {
        figuren.clear();
    }

    public void loescheFigur(Figur f) {
        figuren.remove(f);
    }

    public void vergroessereFiguren(int anzahlPixel) {
        for (Figur f : figuren) {
            f.vergroessere(anzahlPixel);
        }
    }

    public void bewegeFiguren(int deltaX, int deltaY) {
        for (Figur f : figuren) {
            f.move(deltaX, deltaY);
        }
    }
}

