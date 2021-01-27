package ausgabe;

import formen.Figur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung extends JFrame {
    private List<Figur> figuren = new ArrayList<>();

    public void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    public void hinzufuegen(Figur f) {
        figuren.add(f);
    }

    public void mehrereHinzufuegen(List<Figur> figuren) {
        for (Figur f : figuren) {
            this.figuren.add(f);
        }
    }

    public void loescheAlles() {
        figuren.clear();
    }

    public void loescheFigur(Figur f) {
        figuren.remove(f);
    }
}

