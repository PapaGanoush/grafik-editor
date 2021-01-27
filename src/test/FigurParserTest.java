package test;

import dao.FigurDAO;
import dao.FigurDaoStub;
import dao.FigurParser;
import formen.Figur;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FigurParserTest {

    private FigurDAO dao = new FigurDaoStub();
    private FigurParser pp = new FigurParser(dao);


    @Test
    public void test() {
        List<Figur> figuren = pp.parse();
        assertEquals(3, figuren.size());
        assertEquals("Figurtyp: Rechteck, X: 200, Y: 250, Breite: 100, Hoehe: 100", figuren.get(0).gebeInfos());
        assertEquals("Figurtyp: Kreis, X: 300, Y: 300, Radius: 150", figuren.get(1).gebeInfos());
        assertEquals("Figurtyp: Linie, X: 280, Y: 150, EndX: 350, EndY: 400", figuren.get(2).gebeInfos());
    }
}