package speichernundladen;

import java.lang.*;
import formen.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigurLoader {
    String dateiPfad = "V:\\Schule\\Modul 226-2\\Grafik Editor\\Auslesbare_Zeichnungen\\Zeichnung1.json";
    JSONParser jsonParser = new JSONParser();
    JSONArray formenArray = (JSONArray) jsonParser.parse(new FileReader(dateiPfad));
    Iterator i = formenArray.iterator();
    public List<Figur> dokumentFiguren = new ArrayList<>();

    public FigurLoader() throws IOException, ParseException {}

    public void leseFigurenAus() {

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
    }

    private void erstelleKreis(JSONObject form) {
        int positionX = ((Long)form.get("positionX")).intValue();
        int positionY = ((Long)form.get("positionY")).intValue();
        int radius = ((Long)form.get("radius")).intValue();
        boolean istGefuellt = (boolean) form.get("istGefuellt");

        Kreis k = new Kreis(positionX, positionY, radius, istGefuellt);
        dokumentFiguren.add(k);
    }

    private void erstelleLinie(JSONObject form) {
        int positionX = ((Long)form.get("positionX")).intValue();
        int positionY = ((Long)form.get("positionY")).intValue();
        int endX = ((Long)form.get("endX")).intValue();
        int endY = ((Long)form.get("endY")).intValue();

        Linie l = new Linie(positionX, positionY, endX, endY);
        dokumentFiguren.add(l);
    }

    private void erstelleRechteck(JSONObject form) {
        int positionX = ((Long)form.get("positionX")).intValue();
        int positionY = ((Long)form.get("positionY")).intValue();
        int breite = ((Long)form.get("breite")).intValue();
        int hoehe = ((Long)form.get("hoehe")).intValue();
        boolean istGefuellt = (boolean) form.get("istGefuellt");

        Rechteck r = new Rechteck(positionX, positionY, breite, hoehe, istGefuellt);
        dokumentFiguren.add(r);
    }

    private void erstelleText(JSONObject form) {
        int positionX = ((Long)form.get("positionX")).intValue();
        int positionY = ((Long)form.get("positionY")).intValue();
        String text = (String) form.get("text");

        Text t = new Text(positionX, positionY, text);
        dokumentFiguren.add(t);
    }

    public List<Figur> erhalteFiguren() {
        System.out.println("Figuren FigurLoader: " + dokumentFiguren);
        return dokumentFiguren;
    }
}