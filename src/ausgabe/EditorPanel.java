package ausgabe;

import adapter.EditorKeyAdapter;
import adapter.EditorMouseAdapter;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorPanel extends JPanel {
  private EditorControl editorControl;

  EditorPanel(EditorControl control) {
    editorControl = control;
    addKeyListener(new EditorKeyAdapter(editorControl));
    addMouseListener(new EditorMouseAdapter(editorControl));
  }

  // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
  // Methode beim EditorFrame oder beim EditorPanel aufruft.
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    editorControl.allesNeuZeichnen(g);
  }
}