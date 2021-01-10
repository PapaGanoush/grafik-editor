package ausgabe;

import formen.*;

import java.awt.Graphics;
import java.awt.Point;

public final class EditorControl {
  EditorFrame editorFrame;
  private Zeichnung zeichnung = new Zeichnung();
  private char figurTyp = 'r';
  private Point ersterPunkt;
  private boolean istFigurGefuellt = false;

  public EditorControl(EditorFrame editorFrame) {
    this.editorFrame = editorFrame;
  }

  public void allesNeuZeichnen(Graphics g) {
    zeichnung.zeichneFiguren(g);
  }

  public void setFigurTyp(char keyPressed) {
    if(keyPressed == 'r' || keyPressed == 'l' || keyPressed == 'k') {
      this.figurTyp = keyPressed;
      System.out.println("FigurTyp: " + figurTyp);
    } else if(keyPressed == 'g') {
      changeGefuellt();
    } else {
      System.out.println("\n" +"Folgende Tasten sind möglich:" + "\n" + "R-Taste: Rechteck" + "\n" + "L-Taste: Linie" + "\n" + "K-Taste: Kreis" + "\n" + "G-Taste: Figur gefüllt ein / aus" + "\n");
    }
  }

  public void changeGefuellt() {
    if(istFigurGefuellt == false) {
      istFigurGefuellt = true;
      System.out.println("Figuren werden jetzt Gefüllt.");
    } else {
      istFigurGefuellt = false;
      System.out.println("Figuren werden jetzt nicht mehr Gefüllt.");
    }
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
    switch(figurTyp) {
      case 'r':
        erstelleRechteck(zweiterPunkt);
        break;
      case 'l':
        erstelleLinie(zweiterPunkt);
        break;
      case 'k':
        erstelleKreis(zweiterPunkt);
        break;
    }
  }

  private void erstelleRechteck(Point zweiterPunkt) {
    int x = Math.min(ersterPunkt.x, zweiterPunkt.x);
    int y = Math.min(ersterPunkt.y, zweiterPunkt.y);
    int breite = Math.abs(ersterPunkt.x - zweiterPunkt.x);
    int hoehe = Math.abs(ersterPunkt.y - zweiterPunkt.y);

    Rechteck r = new Rechteck(x, y, breite, hoehe, istFigurGefuellt);
    zeichnung.hinzufuegen(r);
    editorFrame.repaint();
  }

  private void erstelleLinie(Point zweiterPunkt) {
    int x = ersterPunkt.x;
    int y = ersterPunkt.y;
    int endX = zweiterPunkt.x;
    int endY = zweiterPunkt.y;

    Linie l = new Linie(x, y, endX, endY);
    zeichnung.hinzufuegen(l);
    editorFrame.repaint();
  }

  private void erstelleKreis(Point zweiterPunkt) {
    int x = Math.min(ersterPunkt.x, zweiterPunkt.x);
    int y = Math.min(ersterPunkt.y, zweiterPunkt.y);
    int xDifferenz = zweiterPunkt.x - ersterPunkt.x;
    int yDifferenz = zweiterPunkt.y - ersterPunkt.y;
    int radius = (int) Math.hypot(xDifferenz, yDifferenz);

    Kreis k = new Kreis(x, y, radius, istFigurGefuellt);
    zeichnung.hinzufuegen(k);
    editorFrame.repaint();
  }
}
