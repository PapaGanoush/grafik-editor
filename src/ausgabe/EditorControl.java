package ausgabe;

import dao.FigurFileDAO;
import dao.FigurParser;
import formen.*;

import java.awt.Graphics;
import java.awt.Point;

public final class EditorControl {
  EditorFrame editorFrame;
  private Zeichnung zeichnung = new Zeichnung();
  private char figurTyp = 'r';
  private Point ersterPunkt;
  private Point zweiterPunkt;
  private boolean istFigurGefuellt = false;

  public EditorControl(EditorFrame editorFrame) {
    this.editorFrame = editorFrame;
    FigurFileDAO fileDAO = new FigurFileDAO();
    FigurParser pp = new FigurParser(fileDAO);
    zeichnung.mehrereHinzufuegen(pp.parse());
    editorFrame.repaint();
    fileDAO.close();
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
    this.zweiterPunkt = zweiterPunkt;
    switch(figurTyp) {
      case 'r':
        erstelleRechteck();
        break;
      case 'l':
        erstelleLinie();
        break;
      case 'k':
        erstelleKreis();
        break;
    }
  }

  private void erstelleRechteck() {
    int x = Math.min(ersterPunkt.x, zweiterPunkt.x);
    int y = Math.min(ersterPunkt.y, zweiterPunkt.y);
    int breite = Math.abs(ersterPunkt.x - zweiterPunkt.x);
    int hoehe = Math.abs(ersterPunkt.y - zweiterPunkt.y);

    Rechteck r = new Rechteck(x, y, breite, hoehe, istFigurGefuellt);
    zeichnung.hinzufuegen(r);
    editorFrame.repaint();
  }

  private void erstelleLinie() {
    int x = ersterPunkt.x;
    int y = ersterPunkt.y;
    int endX = zweiterPunkt.x;
    int endY = zweiterPunkt.y;

    Linie l = new Linie(x, y, endX, endY);
    zeichnung.hinzufuegen(l);
    editorFrame.repaint();
  }

  private void erstelleKreis() {
    int x;
    int y;
    int xDifferenz = ersterPunkt.x - zweiterPunkt.x;
    int yDifferenz = ersterPunkt.y - zweiterPunkt.y;
    int radius = (int) Math.hypot(xDifferenz, yDifferenz);

    if(ersterPunkt.x > zweiterPunkt.x) {
      x = zweiterPunkt.x + radius;
    } else {
      x = ersterPunkt.x;
    }

    if(ersterPunkt.y > zweiterPunkt.y) {
      y = zweiterPunkt.y + radius;
    } else {
      y = ersterPunkt.y;
    }

    Kreis k = new Kreis(x, y, radius, istFigurGefuellt);
    zeichnung.hinzufuegen(k);
    editorFrame.repaint();
  }
}
