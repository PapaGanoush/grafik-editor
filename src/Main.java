import ausgabe.Display;
import ausgabe.Zeichnung;
import formen.*;
import org.json.simple.parser.ParseException;
import speichernundladen.FigurLoader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final Display display = new Display();


    public static void main(String[] args) throws IOException, ParseException {
        Zeichnung z = new Zeichnung();
        FigurLoader f = new FigurLoader();
        f.leseFigurenAus();
        z.figuren = f.erhalteFiguren();

        /*
        Kreis k1 = new Kreis(130, 170, 40, true);
        Kreis k2 = new Kreis(130, 270, 60, false);
        Linie l1 = new Linie(220, 450, 250, 280);
        Rechteck r1 = new Rechteck(300, 110, 100, 200, true);
        Rechteck r2 = new Rechteck(500, 260, 100, 200, false);
        Text t1 = new Text(100, 100, "Tylko jedno w głowie mam oksu pięć gram odlecieć sam krainę zapomnienia");

        z.hinzufuegen(k1);
        z.hinzufuegen(k2);
        z.hinzufuegen(l1);
        z.hinzufuegen(r1);
        z.hinzufuegen(r2);
        z.hinzufuegen(t1);*/

        display.setZeichnung(z);

    }
}
