import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
                obs.setVisited(+1);
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

    public List<Naturreservat> changeNaturreservat(String inName, String ortChoice, String inOrt, String getDatum, String setRegion){
        // Kollar inte efter null eller blank
        // Kan dupliceras med samma naturreservat namn
        List<Naturreservat> newList = new ArrayList<>();
        for(Naturreservat naturreservat : visitedList){
            if (inName.equals(naturreservat.getNamn()) && ortChoice.equals(naturreservat.getOrt())){
                naturreservat.setOrt(inOrt);
                if (!getDatum.isEmpty()){
                    naturreservat.setDatum(getDatum);
                }
                if (!setRegion.isEmpty()){
                    naturreservat.setRegion(setRegion);
                }
                newList = visitedList;
            }
        }
        return newList;
    }

    public List<Naturreservat> toppLista(){
        List<Naturreservat> newList = new ArrayList<>();

        for (int i = 1; i < visitedList.size(); i++) {
            Naturreservat current = visitedList.get(i);
            int j = i - 1;

            // Shift elements greater than current to the right
            while (j >= 0 && visitedList.get(j).getVisited() > current.getVisited()) {
                visitedList.set(j + 1, visitedList.get(j));
                j--;
            }

            // Place current in its correct position
            visitedList.set(j + 1, current);
        }

        for ( int i = 0; i < 3; i++){
            newList.add(visitedList.get(i));
        }


        return newList;
    }

}
