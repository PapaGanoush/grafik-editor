package ausgabe;

import formen.Figur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {
    public List<Figur> figuren;

    public Zeichnung() {
        this.figuren = new ArrayList<>();
    }

    public void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    public void hinzufuegen(Figur f) {
        figuren.add(f);
        repaint();
    }

    public void loescheAlles() {
        figuren.clear();
        repaint();
    }

    public void loescheFigur(Figur f) {
        figuren.remove(f);
        repaint();
    }

    public void vergroessereFiguren(int anzahlPixel) {
        for (Figur f : figuren) {
            f.vergroessere(anzahlPixel);
        }
        repaint();
    }

    public void bewegeFiguren(int deltaX, int deltaY) {
        for (Figur f : figuren) {
            f.move(deltaX, deltaY);
        }
        repaint();
    }
}

