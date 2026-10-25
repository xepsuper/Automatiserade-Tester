import java.util.ArrayList;
import java.util.List;
/**
 * Här bevaras gamla koden som fick positiva testfall
 */
public class NyRegistrera {
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
            if (inRegion.equals(visitedList.get(i).getRegion())) {
                newVisitedList.add(visitedList.get(i));
            }
        }
        return newVisitedList;
    }
    /**
     * En önskelista som användaren vill vara med om
     * @param inNameWish önskemål som användaren kan ha
     * @return returnerar naturreservat som användaren vill ta med
     */
    public List<Naturreservat> wishlist(String inNameWish, String ortWish){
        List<Naturreservat> newVisitedList = new ArrayList<>();
        for( int i = 0; i < visitedList.size(); i++){
            if (inNameWish.equals(visitedList.get(i).getNamn()) && ortWish.equals(visitedList.get(i).getOrt()))
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
    public void getOrt(String inOrt, String inNamn) {
        if (inOrt.isEmpty()){
            System.out.println("Orten är tom");
            return;
        }
        for (Naturreservat obs : visitedList) {
            if(inOrt.equals(obs.getOrt()) && (inNamn.equals(obs.getNamn())))
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
    public int getSpecificVisitedByNaturreservat(String inNamn) {
        int antalVisited = 0;
        for (int i = 0; i < visitedList.size(); i++) {
            if (inNamn.equals(visitedList.get(i).getNamn())){
                antalVisited = visitedList.get(i).getVisited();
            }
        }
        return antalVisited;
    }

    /**
     * Raderar naturreservat baserat på användarens önskemål
     * @param inNamn Namnet som söks
     * @param inOrt Orten som söks
     * @return Antal raderade naturreservat
     */
    public int removeVisited(String inNamn, String inOrt){
        int antalRaderas = 0;
        for ( int i = 0; i < visitedList.size(); i++) {
            if(inNamn.equals(visitedList.get(i).getNamn()) && inOrt.equals(visitedList.get(i).getOrt()))
            {
                visitedList.remove(i);
                antalRaderas++;
            }
        }
        return antalRaderas;
    }
    /**
     * Ändra attributer för naturreservatet
     * @param inName Väljer en specifik naturreservat
     * @param ortChoice väljer en specifik ort
     * @param inOrt Ändrade ort som matas in
     * @param getDatum Datum som läggs till
     * @param setRegion Region som läggs till
     */
    public List<Naturreservat> changeNaturreservat(String inName, String ortChoice, String inOrt, String getDatum, String setRegion){
        // Kollar inte efter null eller blank
        // Kan dupliceras med samma naturreservat namn
        for(Naturreservat naturreservat : visitedList){
            if (inName.equals(naturreservat.getNamn()) && ortChoice.equals(naturreservat.getOrt())){
                naturreservat.setOrt(inOrt);
                if (!inName.isEmpty() && ortChoice.isEmpty() && inOrt.isEmpty() && getDatum.isEmpty() && setRegion.isEmpty()){
                    naturreservat.setDatum(getDatum);
                    naturreservat.setOrt(inOrt);
                    naturreservat.setRegion(setRegion);
                }

            }
        }
        return visitedList;
    }

    /**
     * Topplista hämtar de 3 mest besökta naturreservat
     * Sorteras innan det skickas in
     * @return Hämtar de tre mest besökta naturreservat
     */
    public List<Naturreservat> toppLista() {
        List<Naturreservat> newList = new ArrayList<>();
        visitedList.sort((a, b) -> Integer.compare(b.getVisited(), a.getVisited()));

        for(int i = 0; i < 3; i++){
            newList.add(visitedList.get(i));
        }
        return newList;
    }



}