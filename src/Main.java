import ausgabe.Display;
import ausgabe.Zeichnung;
import formen.*;
import org.json.simple.parser.ParseException;
import speichernundladen.*;
import speichernundladen.FigurSaver;

import java.io.IOException;


public class Main {
    private static final Display display = new Display();


    public static void main(String[] args) throws IOException, ParseException {
        Zeichnung z = new Zeichnung();

        /*FigurLoader fl = new FigurLoader();
        fl.leseFigurenAus();
        z.figuren = fl.erhalteFiguren();*/

        Kreis k1 = new Kreis(330, 170, 90, false);
        Linie l1 = new Linie(220, 450, 450, 180);
        Linie l2 = new Linie(160, 222, 111, 90);
        Rechteck r1 = new Rechteck(100, 420, 40, 177, true);
        Rechteck r2 = new Rechteck(500, 400, 200, 200, false);
        Text t1 = new Text(200, 200, "Des Hasses");

        z.hinzufuegen(k1);
        z.hinzufuegen(l1);
        z.hinzufuegen(l2);
        z.hinzufuegen(r1);
        z.hinzufuegen(r2);
        z.hinzufuegen(t1);

        display.setZeichnung(z);

        FigurSaver fs = new FigurSaver(z.figuren);
        fs.speichereZeichnung();

    }
}
