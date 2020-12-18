package speichernundladen;

import formen.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FigurLoader {
    String dateiPfad = "V:\\Schule\\Modul 226-2\\Grafik Editor\\Auslesbare_Zeichnungen\\Zeichnung1.json";
    JSONParser jsonParser = new JSONParser();
    JSONArray formenArray = (JSONArray) jsonParser.parse(new FileReader(dateiPfad));
    Iterator i = formenArray.iterator();
    public List<Figur> figuren;

    public FigurLoader() throws IOException, ParseException {
        leseFigurenAus();
    }

    private void leseFigurenAus() {


        while (i.hasNext()) {
            JSONObject form = (JSONObject) i.next();
            String formTyp = (String) form.get("formTyp");

            switch (formTyp) {
                case "Kreis":
                    erstelleKreis(form);
                    break;
                case "Linie":
                    erstelleLinie(form);
                    break;
                case "Rechteck":
                    erstelleRechteck(form);
                    break;
                case "Text":
                    erstelleText(form);
                    break;
            }
        }
        JSONObject formeee = (JSONObject) formenArray.get(0);
        System.out.println(formeee);
    }

    private void erstelleKreis(JSONObject form) {
        int positionX = (int) form.get("positionX");
        int positionY = (int) form.get("positionY");
        int radius = (int) form.get("radius");
        boolean istGefuellt = (boolean) form.get("istGefuellt");

        Kreis k = new Kreis(positionX, positionY, radius, istGefuellt);
        figuren.add(k);
    }

    private void erstelleLinie(JSONObject form) {
        int positionX = (int) form.get("positionX");
        int positionY = (int) form.get("positionY");
        int endX = (int) form.get("endX");
        int endY = (int) form.get("endY");

        Linie l = new Linie(positionX, positionY, endX, endY);
        figuren.add(l);
    }

    private void erstelleRechteck(JSONObject form) {
        int positionX = (int) form.get("positionX");
        int positionY = (int) form.get("positionY");
        int breite = (int) form.get("breite");
        int hoehe = (int) form.get("hoehe");
        boolean istGefuellt = (boolean) form.get("istGefuellt");

        Rechteck r = new Rechteck(positionX, positionY, breite, hoehe, istGefuellt);
        figuren.add(r);
    }

    private void erstelleText(JSONObject form) {
        int positionX = (int) form.get("positionX");
        int positionY = (int) form.get("positionY");
        String text = (String) form.get("text");

        Text t = new Text(positionX, positionY, text);
        figuren.add(t);
    }

    public List<Figur> erhalteFiguren() {
        return figuren;
    }
}