package test;

import formen.Kreis;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class KreisTest {
    private GraphicsStub g = new GraphicsStub();

    @Test
    void zeichne() {
        Kreis k = new Kreis(300, 350, 150, false);
        k.zeichne(g);
        assertEquals(1,g.numbOfDrawOvalCalls);
        assertEquals(0, g.numbOfFillOvalCalls);
        assertEquals(150, g.x);
        assertEquals(200, g.y);
        assertEquals(300, g.width);
        assertEquals(300, g.height);
    }
}