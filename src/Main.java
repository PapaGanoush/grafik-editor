import augabe.Display;
import augabe.Zeichnung;
import formen.*;

public class Main {
    private static final Display display = new Display();

    public static void main(String[] args) {
        Kreis k1 = new Kreis(130, 170, 40, true);
        Kreis k2 = new Kreis(130, 270, 60, false);
        Linie l1 = new Linie(220, 450, 250, 280);
        Rechteck r1 = new Rechteck(300, 110, 100, 200, true);
        Rechteck r2 = new Rechteck(500, 260, 100, 200, false);
        Text t1 = new Text(100, 100, "Tylko jedno w głowie mam oksu pięć gram odlecieć sam krainę zapomnienia");

        Zeichnung z1 = new Zeichnung();
        z1.hinzufuegen(k1);
        z1.hinzufuegen(k2);
        z1.hinzufuegen(l1);
        z1.hinzufuegen(r1);
        z1.hinzufuegen(r2);
        z1.hinzufuegen(t1);

        k1.vergroessere(400);

        display.setZeichnung(z1);
    }
}
