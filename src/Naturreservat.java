import java.time.LocalDate;

public class Naturreservat { // konstruktor

    private String namn;
    private String ort;
    private String datum;

    public Naturreservat(String inNamn, String inOrt, String inDatum) {
        this.namn = inNamn;
        this.ort = inOrt;
        this.datum = inDatum;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String inNamn) {
        this.namn = namn;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String inOrt) {
        this.ort = ort;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String inDatum) {
        this.datum = datum;
    }
}
