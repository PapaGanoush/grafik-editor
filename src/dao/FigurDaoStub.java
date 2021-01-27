package dao;

public class FigurDaoStub implements FigurDAO {
    private String[] testFiguren = {
            "Rechteck,200,250,100,100",
            "Kreis,300,300,150",
            "Linie,280,150,350,400"
    };
    private int currentFigur;
    @Override
    public String[] readNextFigurData() {
        if (currentFigur < testFiguren.length) {
            String[] figurData = testFiguren[currentFigur].split(",");
            currentFigur++;
            return figurData;
        } else {
            return null;
        }
    }
}
