package adapter;

import ausgabe.EditorControl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyAdapter extends KeyAdapter {
    EditorControl editorControl;

    public EditorKeyAdapter(EditorControl editorControl) {
        this.editorControl = editorControl;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        editorControl.setFigurTyp(e.getKeyChar());
    }
}
