import java.util.*;

public class Registrera {
    List<Naturreservat> visitedList;

    public Registrera() {

        visitedList = new ArrayList<>();
    }

    public void addVisisted(Naturreservat observation) {
        visitedList.add(observation);
    }

    public int getNumberOfVisited() {
        return visitedList.size();

    }

    public void getOrt(String inOrt) {
        for (Naturreservat obs : visitedList) {
               if(inOrt.equals(obs.getOrt())){ System.out.println("Följande naturreservat har du  besökt: " +  obs.getNamn());  }
        }
    }

    public void noObsArt(String inNamn) {
        for (Naturreservat obs : visitedList) {
                if(!obs.getNamn().contains(inNamn) ){ System.out.println(obs.getOrt());  }
    }
}

}


