import augabe.Display;
import formen.*;

public class Main {
    private static final Display display = new Display();

    public static void main(String[] args) {
        Kreis k1 = new Kreis(130, 170, 40, true);
        Kreis k2 = new Kreis(130, 270, 60, false);
        Linie l1 = new Linie(220, 450, 250, 280);
        Rechteck r1 = new Rechteck(300, 110, 100, 200);
        Text t1 = new Text(100, 100, "Tylko jedno w głowie mam oksu pięć gram odlecieć sam krainę zapomnienia");

        Gruppe g1 = new Gruppe();
        g1.fuegeFigurHinzu(k1);
        g1.fuegeFigurHinzu(k2);
        g1.fuegeFigurHinzu(l1);
        g1.fuegeFigurHinzu(r1);
        g1.fuegeFigurHinzu(t1);

        display.hinzufuegen(g1);
    }
}
