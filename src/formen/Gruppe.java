package formen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gruppe extends Figur {
    private List<Figur> figuren;

    public Gruppe() {
        super(0, 0);
        this.figuren = new ArrayList<>();
    }

    @Override
    public void zeichne(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    public void fuegeFigurHinzu(Figur f) {
        figuren.add(f);
    }

    public void loescheFigur(Figur f) {
        figuren.remove(f);
    }
}

