import java.util.*;

/**
 * Metoderna bevaras vid den här klassen vid senare användning
 * Här körs logiken för alla metoder
 */
public class Registrera {
    List<Naturreservat> visitedList;

    /**
     *  Konstrutkor för arrayList för registrera klassen
     */
    public Registrera() {

        visitedList = new ArrayList<>();
    }

    /**
     * addVisited används för att skapa nya naturreservat som senare ska bevaras i visitedList
     * @param observation matas nya observationer enligt Naturreservat konstruktor
     */
    public void addVisisted(Naturreservat observation) {
        visitedList.add(observation);
    }

    /**
     * Hämtar hur många observationer som befinner sig i visitedList
     * @return Hämtar ut storleken av visitListed
     */
    public int getNumberOfVisited() {
        return visitedList.size();
    }

    /**
     * getOrt används för hämta specifika observationer inuti visitedList
     * @param inOrt inmatas önskade ort
     */
    public void getOrt(String inOrt) {
        for (Naturreservat obs : visitedList) {
               if(inOrt.equals(obs.getOrt())){ System.out.println("Följande naturreservat har du  besökt: " +  obs.getNamn());  }
        }
    }

    /**
     * noObsArt skriver ut ort baserade på vilket namn användaren vill det ska inte tillhöra
     * @param inNamn inmatas oönskade namn
     */
    public void noObsArt(String inNamn) {
        for (Naturreservat obs : visitedList) {
                if(!obs.getNamn().contains(inNamn) ){ System.out.println(obs.getOrt());  }
    }
}

}


