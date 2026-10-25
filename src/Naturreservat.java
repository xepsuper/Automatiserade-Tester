/**
 * I det här koden är det en konstruktor som bevara specifika typvärde som tillhör till denna klassen
 */
public class Naturreservat { // konstruktor

    private String namn;
    private String ort;
    private String datum;
    private String region;
    private int visited;
// addera unik identifierare för att få fram alla klasser som unika (Kanske)


    /**
     *
     * @param inNamn Inmatas namn
     * @param inOrt Inmatas ort
     * @param inDatum Inmatas datum
     */
    public Naturreservat(String inNamn, String inOrt, String inDatum, String region, int visited) {
        this.namn = inNamn;
        this.ort = inOrt;
        this.datum = inDatum;
        this.region = region;
        this.visited = visited;
    }

    /**
     * Hämtar ut namnet enligt naturreservatet
     * @return returnerar namn
     */
    public String getNamn() {
        return namn;
    }

    /**
     * Ändrar namnet enligt naturreservatet
     * @param inNamn namnet som inmatas
     */
    public void setNamn(String inNamn) {
        this.namn = namn;
    }

    /**
     * Hämtar ut ort enligt naturreservatet
     * @return returnerar orten
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Ändrar orten enligt naturreservatet
     * @param inOrt orten som inmatas
     */
    public void setOrt(String inOrt) {
        this.ort = ort;
    }

    /**
     * Hämtar ut datum enligt naturreservatet
     * @return returnerar datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Ändrar datum enligt naturreservatet
     * @param inDatum datum som inmatas
     */
    public void setDatum(String inDatum) {
        this.datum = datum;
    }

    public String getRegion() {return region;}

    public void setRegion(String region) {this.region = region;}

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }
}
