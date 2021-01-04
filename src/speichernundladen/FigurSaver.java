package speichernundladen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import formen.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FigurSaver {
    private List<Figur> zuSpeicherndeFiguren;
    JSONArray jsonFigurListe = new JSONArray();

    public FigurSaver(List<Figur> figurenAufZeichnung) {
        zuSpeicherndeFiguren = figurenAufZeichnung;
    }

    public void speichereZeichnung() throws IOException {
        for(Figur f : zuSpeicherndeFiguren) {
            switch (f.erhalteInformationen()[0]){
                case "Kreis":
                    schreibeKreisObjekt(f.erhalteInformationen());
                    break;
                case "Linie":
                    schreibeLinieObjekt(f.erhalteInformationen());
                    break;
                case "Rechteck":
                    schreibeRechteckObjekt(f.erhalteInformationen());
                    break;
                case "Text":
                    schreibeTextObjekt(f.erhalteInformationen());
                    break;
            }
        }
        erstelleDatei();
    }

    private void schreibeKreisObjekt(String[] objektInformationen) {
        int positionX = Integer.parseInt(objektInformationen[1]);
        int positionY = Integer.parseInt(objektInformationen[2]);
        int radius = Integer.parseInt(objektInformationen[3]);
        Boolean istGefuellt = Boolean.parseBoolean(objektInformationen[4]);

        JSONObject kreisObjekt = new JSONObject();
        kreisObjekt.put("formTyp", "Kreis");
        kreisObjekt.put("positionX", positionX);
        kreisObjekt.put("positionY", positionY);
        kreisObjekt.put("radius", radius);
        kreisObjekt.put("istGefuellt", istGefuellt);

        jsonFigurListe.add(kreisObjekt);
    }

    private void schreibeLinieObjekt(String[] objektInformationen) {
        int positionX = Integer.parseInt(objektInformationen[1]);
        int positionY = Integer.parseInt(objektInformationen[2]);
        int endX = Integer.parseInt(objektInformationen[3]);
        int endY = Integer.parseInt(objektInformationen[4]);

        JSONObject linieObjekt = new JSONObject();
        linieObjekt.put("formTyp", "Linie");
        linieObjekt.put("positionX", positionX);
        linieObjekt.put("positionY", positionY);
        linieObjekt.put("endX", endX);
        linieObjekt.put("endY", endY);

        jsonFigurListe.add(linieObjekt);
    }

    private void schreibeRechteckObjekt(String[] objektInformationen) {
        int positionX = Integer.parseInt(objektInformationen[1]);
        int positionY = Integer.parseInt(objektInformationen[2]);
        int breite = Integer.parseInt(objektInformationen[3]);
        int hoehe = Integer.parseInt(objektInformationen[4]);
        Boolean istGefuellt = Boolean.parseBoolean(objektInformationen[5]);

        JSONObject rechteckObjekt = new JSONObject();
        rechteckObjekt.put("formTyp", "Rechteck");
        rechteckObjekt.put("positionX", positionX);
        rechteckObjekt.put("positionY", positionY);
        rechteckObjekt.put("breite", breite);
        rechteckObjekt.put("hoehe", hoehe);
        rechteckObjekt.put("istGefuellt", istGefuellt);

        jsonFigurListe.add(rechteckObjekt);
    }

    private void schreibeTextObjekt(String[] objektInformationen) {
        int positionX = Integer.parseInt(objektInformationen[1]);
        int positionY = Integer.parseInt(objektInformationen[2]);
        String text = objektInformationen[3];

        JSONObject textObjekt = new JSONObject();
        textObjekt.put("formTyp", "Text");
        textObjekt.put("positionX", positionX);
        textObjekt.put("positionY", positionY);
        textObjekt.put("text", text);

        jsonFigurListe.add(textObjekt);
    }

    private void erstelleDatei() {
        String generatedString = RandomStringUtils.randomAlphanumeric(15);
        String dateipfad = ("Gespeicherte_Zeichnungen/" + generatedString + ".json");
        System.out.println("Dateipfad: " + dateipfad);

        try (FileWriter file = new FileWriter(dateipfad)) {

            file.write(jsonFigurListe.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
