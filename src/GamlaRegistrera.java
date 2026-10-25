import java.util.ArrayList;
import java.util.List;

/**
 * Här bevaras gamla koden som fick negativa testfall
 */
public class GamlaRegistrera {
    Registrera registrera = new Registrera();
    List<Naturreservat> visitedList = registrera.visitedList;

    /**
     * getSpecificRegion används för att hämtar ut specifika orter i samma region
     * @param inRegion Användaren matar in data för regionen de har valt
     * @return Returnerar en lista av naturreservat baserat på regionen man har valt
     */
    public List<Naturreservat> getSpecificNameByRegion(String inRegion){
        List<Naturreservat> newVisitedList = new ArrayList<>();
        for( int i = 0; i < visitedList.size(); i++){
            newVisitedList.add(visitedList.get(i));
        }
        return newVisitedList;
    }

    /**
     * En önskelista som användaren vill vara med om
     * @param inWish önskemål som användaren kan ha
     * @return returnerar naturreservat som användaren vill ta med
     */
    public List<Naturreservat> wishlist(String inWish){
        List<Naturreservat> newVisitedList = new ArrayList<>();
        for( int i = 0; i < visitedList.size(); i++){
            if (inWish.equals(visitedList.get(i).getRegion())
                    || inWish.equals(visitedList.get(i).getNamn())
                    || inWish.equals(visitedList.get(i).getOrt())
                    || inWish.equals(visitedList.get(i).getDatum()))
            {
                newVisitedList.add(visitedList.get(i));
            }
        }
        System.out.println(newVisitedList.size());
        return newVisitedList;
    }

    int visitedCount = 0;
    /**
     * Hämtar en ort som användaren vill besöka
     * @param inOrt Orten som anvädnaren besöker
     */
    public void getOrt(String inOrt) {

        for (Naturreservat obs : visitedList) {
            if(inOrt.equals(obs.getOrt()))
            {
                visitedCount++;
                obs.setVisited(visitedCount);
            }
        }
    }

    /**
     * Hämtar antal besökningar beroende på naturreservatet
     * @param inNamn Naturreservat som användaren besöker
     * @return returnerar antal besökningar
     */
    public int getSpecificVisitedByNaturreservat(String inNamn) { // Gammal inkludera antal besökta i duplicering av kod
        int antalVisited = 0;
        for (int i = 0; i < visitedList.size(); i++) {
            if (inNamn.equals(visitedList.get(i).getNamn())){
                antalVisited = visitedList.get(i).getVisited();
            }

        }
        return antalVisited;
    }

    /**
     * Raderar antal naturreservat beroende på namn.
     * Räknar hur många naturreservat som raderades
     * @param inNamn Naturreservat som användaren vill radera
     * @return antal naturreservat raderad
     */
    public int removeVisited(String inNamn){
        int antalRaderas = 0;
        for ( int i = 0; i < visitedList.size(); i++) {
            if(inNamn.equals(visitedList.get(i).getNamn())){
                visitedList.remove(i);
                antalRaderas++;
            }
        }
        return antalRaderas;
    }

    /**
     * Ändra attributer för naturreservatet
     * @param inName Ändrade namn som matas in
     * @param inOrt Ändrade ort som matas in
     * @param getDatum Datum som läggs till
     * @param setRegion Region som läggs till
     */
    public List<Naturreservat> changeNaturreservat(String inName, String inOrt, String getDatum, String setRegion){
        // Kollar inte efter null eller blank
        // Kan dupliceras med samma naturreservat namn
        List<Naturreservat> newList = new ArrayList<>();
        for(Naturreservat naturreservat : visitedList){
            if (inName.equals(naturreservat.getNamn())){
                naturreservat.setOrt(inOrt);
                naturreservat.setDatum(getDatum);
                naturreservat.setRegion(setRegion);
                newList = visitedList;
            }
        }
        return newList;
    }

    /**
     * Topplista hämtar de 3 mest besökta naturreservat
     * @return Hämtar de tre mest besökta naturreservat
     */
    public List<Naturreservat> toppLista(){
        List<Naturreservat> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            newList.add(visitedList.get(i));
        }
        return newList;
    }


}