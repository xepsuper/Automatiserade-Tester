import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NyRegistreraTest {
    private final NyRegistrera registreraNyaMetoder = new NyRegistrera();
    private final GamlaRegistrera registreraGamlaMetoder = new GamlaRegistrera();
    private final Registrera registreraMetoder = new Registrera();


    @BeforeEach
    void setUp() {
        registreraNyaMetoder.visitedList.add(new Naturreservat("Naturlig", "Rinkeby", "2026-02-02", "Stockholm", 0));
        registreraNyaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Rinkeby", "2026-03-15", "Stockholm", 0));   // samma Ort + Region
        registreraNyaMetoder.visitedList.add(new Naturreservat("Sjömarkerna", "Solna", "2026-02-02", "Stockholm", 0));           // samma Datum + Region
        registreraNyaMetoder.visitedList.add(new Naturreservat("Kustlandskapet", "Rinkeby", "2026-02-02", "Uppsala", 0));        // samma Ort + Datum
        registreraNyaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Odenplan", "2026-02-02", "Stockholm", 0));        // samma Ort + Datum + Region
        registreraNyaMetoder.visitedList.add(new Naturreservat("Ängsmarken", "Göteborg", "2026-07-22", "Stockholm", 0));         // samma Region
        registreraNyaMetoder.visitedList.add(new Naturreservat("Fjällvidderna", "Kiruna", "2026-08-14", "Norrbotten", 0));
        registreraNyaMetoder.visitedList.add(new Naturreservat("Dalälvens delta", "Borlänge", "2026-09-03", "Dalarna", 0));
        registreraNyaMetoder.visitedList.add(new Naturreservat("Västkustens klippor", "Uddevalla", "2026-09-21", "Västra Götaland", 0));
        registreraNyaMetoder.visitedList.add(new Naturreservat("Småländska skogarna", "Växjö", "2026-10-07", "Kronoberg", 0));
        registreraNyaMetoder.visitedList.add(new Naturreservat("Östgötska slätterna", "Linköping", "2026-10-19", "Östergötland", 0));



    }

    /**
     * Här hämtas naturreservat beroende på regionen som användaren har valt
     * Returnerar alla naturreservat oavsett region
     */
    @Test
    void TDD10_getSpecificObsByRegion() { //negativ testfall (Klar)

        List<Naturreservat> list = registreraGamlaMetoder.getSpecificNameByRegion("Stockholm");
        String[] expected = {
                "Naturlig",
                "Bergsområdet",
                "Sjömarkerna",
                "Bergsområdet",
                "Ängsmarken"};

        String[] resultat = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultat[i] = list.get(i).getOrt();
        }
        System.out.println(Arrays.toString(resultat));
        Assertions.assertArrayEquals(expected, resultat);
    }

    /**
     * Här hämtas naturreservat beroende på regionen som användaren har valt
     * Returnerar alla naturreservat beroende på region
     */
    @Test
    void TDD11_getSpecificObsByRegion() { //Positiva testfall (Klar)
        List<Naturreservat> list = registreraNyaMetoder.getSpecificNameByRegion("Stockholm");
        String[] expected = {
                "Naturlig",
                "Bergsområdet",
                "Sjömarkerna",
                "Bergsområdet",
                "Ängsmarken"};


        String[] resultat = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultat[i] = list.get(i).getNamn();
        }
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(resultat));
        Assertions.assertArrayEquals(expected, resultat);
    }

    /**
     * Besöker ort beroende på vart användaren vill besöka
     * Returnerar orten som användaren har besökt
     * besökta ort påverkas av duplicering
     */
    @Test
    void TDD12_getVisitedOrt() { //Negativ testfall
        for(int i = 0; i < 5; i++){
            registreraGamlaMetoder.getOrt("Rinkeby"); // besöker duplicerade koden också
        }
        int resultat = registreraGamlaMetoder.getSpecificVisitedByNaturreservat("Kustlandskapet"); // hämtar antal besökta men det ska inte vara den
        int expected = 5; // Antalet som ska besökas
        Assertions.assertNotEquals(expected,resultat); // Användaren hämtar antal besökta fast användaren vill inte besöka som till exempel kustlandskapet 5 ggr
    }

    /**
     * Besöker ort beroende på vart användaren vill besöka
     * Returnerar orten som användaren har besökt
     *  besökta ort opåverkad av duplicering
     */
    @Test
    void TDD13_getVisitedOrt() { //Positiv testfall
        for(int i = 0; i < 5; i++){
            registreraNyaMetoder.getOrt("Rinkeby","Sjömarkerna"); // besöker duplicerade koden också
        }
        int resultat = registreraNyaMetoder.getSpecificVisitedByNaturreservat("Sjömarkerna"); // hämtar antal besökta men det ska inte vara den
        int expected = 5; // Antalet som ska besökas
        Assertions.assertEquals(expected,resultat); // Användaren hämtar antal besökta fast användaren vill inte besöka som till exempel kustlandskapet 5 ggr
    }

    /**
     * Här testas önskemål som användaren vill ha
     * Returnera flera förslag på önskemål
     * Resulterar till ett negativt testfall
     */
    @Test
    void TDD14_getWishlist() { //Negativ testfall
        List<Naturreservat> list = registreraGamlaMetoder.wishlist("Stockholm");
        String[] expected = {"\n" + "Naturlig" + "\n" + "Rinkeby" + "\n" + "2026-02-02" + "\n" + "Stockholm" + "\n" + 0};
        String[] resultat = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultat[i] = "\n" + list.get(i).getNamn() + "\n" + list.get(i).getOrt() + "\n" + list.get(i).getDatum() + "\n" + list.get(i).getRegion();
        }
        System.out.println(Arrays.toString(resultat));
        Assertions.assertArrayEquals(expected, resultat);
    }

    /**
     * Här testas önskemål som användaren vill ha
     * Returnerar specifika önskemål
     * Resulterar till ett positiv testfall
     */
    @Test
    void TDD15_getWishlist() {//Positiv testfall

        List<Naturreservat> list = registreraNyaMetoder.wishlist("");
        String[] expected = {};
        System.out.println(Arrays.toString(expected));
        String[] resultat = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultat[i] = list.get(i).getNamn()
                    + "\n" + list.get(i).getOrt()
                    + "\n" + list.get(i).getDatum()
                    + "\n" + list.get(i).getRegion()
                    + "\n";
        }
        System.out.println(Arrays.toString(resultat));
        Assertions.assertArrayEquals(expected, resultat);
    }

    /**
     * Kollar på antalet raderade objekt
     * Raderar alla naturreservat inklusive de som har samma namn
     */
    @Test
    void TDD16_removeVisited() { //Negativ testfall
        registreraMetoder.addVisited(new Naturreservat("Bergsområdet","Sköndal","2026-02-09","Stockholm",0)); // Duplicera nya naturreservat med samma namn i olika ort
       int resultat = registreraGamlaMetoder.removeVisited("Bergsområdet"); // radera bergsområdet inklusive dupliceringen
        int expected = 1;
        Assertions.assertEquals(expected, resultat);
    }
    /**
     * Kollar på antalet raderade objekt
     * Raderar alla naturreservat exklusive de som har samma namn
     */
    @Test
    void TDD17_removeVisited() { //Positiv testfall
        registreraMetoder.addVisited(new Naturreservat("Bergsområdet","Sköndal","2026-02-09","Stockholm",0)); // Duplicera nya naturreservat med samma namn i olika ort
        int resultat = registreraNyaMetoder.removeVisited("Bergsområdet", "Rinkeby"); // radera bergsområdet inklusive dupliceringen
        int expected = 1;
        System.out.println(resultat);
        System.out.println(expected);
        Assertions.assertEquals(expected, resultat);
    }
    @Test
    void TDD18_changeNaturreservat() { //Negativ testfall
        registreraMetoder.addVisited(new Naturreservat("Bergsområdet","Sköndal","2026-02-09","Stockholm",0));
        List<Naturreservat> getList = registreraGamlaMetoder.changeNaturreservat("Bergsområdet","Södertälje","2026-02-20","Stockholm län");
        Naturreservat expectedNaturreservat = registreraNyaMetoder.visitedList.get(1);
        String[] expected = {expectedNaturreservat.getNamn() +"\n"+  expectedNaturreservat};
        String[] resultat = new String[getList.size()];

        for (int i = 0; i < getList.size(); i++) {
            resultat[i] = getList.get(i).getNamn()
                    + "\n" + getList.get(i).getOrt()
                    + "\n" + getList.get(i).getDatum()
                    + "\n" + getList.get(i).getRegion()
                    + "\n";
        }

    }
    @Test
    void TDD19_changeNaturreservat() { //Positiv testfall
        registreraMetoder.addVisited(new Naturreservat("Bergsområdet","Sköndal","2026-02-09","Stockholm",0));
        List<Naturreservat> getList = registreraNyaMetoder.changeNaturreservat("Bergsområdet","","Södertälje","2026-02-20","Stockholm län");
        Naturreservat expectedNaturreservat = registreraNyaMetoder.visitedList.get(1);
    }
    @Test
    void TDD20_toppLista() { //Negativ testfall


       List<Naturreservat> lista = registreraGamlaMetoder.toppLista();
       for(Naturreservat naturreservat : lista){
           System.out.println("Ort: "+naturreservat.getNamn() +" Antal besök: "+naturreservat.getVisited());
       }
    }
    @Test
    void TDD21_toppLista() { //Positiv testfall
        for(int i = 0; i < 3; i++){
            registreraNyaMetoder.getOrt("Rinkeby", "Kustlandskapet");
            for(int j = 0; j < 3; j++){
                registreraNyaMetoder.getOrt("Borlänge", "Dalälvens delta");
            }
        }

        List<Naturreservat> lista = registreraNyaMetoder.toppLista();
        for(Naturreservat naturreservat : lista){
            System.out.println("Ort: "+naturreservat.getNamn() +" Antal besök: "+naturreservat.getVisited());
        }
    }


}




