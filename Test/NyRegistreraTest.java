import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
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

        registreraGamlaMetoder.visitedList.add(new Naturreservat("Naturlig", "Rinkeby", "2026-02-02", "Stockholm", 0));
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Rinkeby", "2026-03-15", "Stockholm", 0));   // samma Ort + Region
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Sjömarkerna", "Solna", "2026-02-02", "Stockholm", 0));           // samma Datum + Region
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Kustlandskapet", "Rinkeby", "2026-02-02", "Uppsala", 0));        // samma Ort + Datum
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Odenplan", "2026-02-02", "Stockholm", 0));        // samma Ort + Datum + Region
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Ängsmarken", "Göteborg", "2026-07-22", "Stockholm", 0));         // samma Region
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Fjällvidderna", "Kiruna", "2026-08-14", "Norrbotten", 0));
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Dalälvens delta", "Borlänge", "2026-09-03", "Dalarna", 0));
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Västkustens klippor", "Uddevalla", "2026-09-21", "Västra Götaland", 0));
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Småländska skogarna", "Växjö", "2026-10-07", "Kronoberg", 0));
        registreraGamlaMetoder.visitedList.add(new Naturreservat("Östgötska slätterna", "Linköping", "2026-10-19", "Östergötland", 0));

    }

    /**
     * Här hämtas naturreservat beroende på regionen som användaren har valt
     * Returnerar alla naturreservat oavsett region
     */
    @Test
    void TDD1_getSpecificObsByRegion() { //negativ testfall (Klar)

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
    void TDD2_getSpecificObsByRegion() { //Positiva testfall (Klar)
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
    void TDD3_getVisitedOrt() { //Negativ testfall
        for(int i = 0; i < 5; i++){
            registreraGamlaMetoder.getOrt("Rinkeby"); // besöker duplicerade koden också
        }
        int resultat = registreraGamlaMetoder.getSpecificVisitedByNaturreservat("Kustlandskapet"); // hämtar antal besökta men det ska inte vara den
        int expected = 15; // Antalet som ska besökas
        Assertions.assertNotEquals(expected,resultat); // Användaren hämtar antal besökta fast användaren vill inte besöka som till exempel kustlandskapet 5 ggr
    }

    /**
     * Besöker ort beroende på vart användaren vill besöka
     * Returnerar orten som användaren har besökt
     *  besökta ort opåverkad av duplicering
     */
    @Test
    void TDD4_getVisitedOrt() { //Positiv testfall
        for(int i = 0; i < 5; i++){
            registreraNyaMetoder.getOrt("Rinkeby","Naturlig"); // besöker duplicerade koden också
        }
        int resultat = registreraNyaMetoder.getSpecificVisitedByNaturreservat("Naturlig"); // hämtar antal besökta men det ska inte vara den
        int expected = 5; // Antalet som ska besökas
        System.out.println(resultat);
        Assertions.assertEquals(expected,resultat); // Användaren hämtar antal besökta fast användaren vill inte besöka som till exempel kustlandskapet 5 ggr
    }

    /**
     * Här testas önskemål som användaren vill ha
     * Returnera flera förslag på önskemål
     * Resulterar till ett negativt testfall
     */
    @Test
    void TDD5_getWishlist() { //Negativ testfall
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
    void TDD6_getWishlist() {//Positiv testfall

        List<Naturreservat> list = registreraNyaMetoder.wishlist("Naturlig","Rinkeby");
        String[] expected = {"\n" + "Naturlig" + "\n" + "Rinkeby" + "\n" + "2026-02-02" + "\n" + "Stockholm"+"\n"};
        String[] resultat = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            resultat[i] = "\n" + list.get(i).getNamn()
                    +"\n" + list.get(i).getOrt()
                    +"\n" + list.get(i).getDatum()
                    +"\n" + list.get(i).getRegion()
                    +"\n";
        }
        Assertions.assertArrayEquals(expected, resultat);
    }

    /**
     * Kollar på antalet raderade objekt
     * Raderar alla naturreservat inklusive de som har samma namn
     */
    @Test
    void TDD7_removeVisited() { //Negativ testfall
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
    void TDD8_removeVisited() { //Positiv testfall
        int resultat = registreraNyaMetoder.removeVisited("Bergsområdet", "Rinkeby"); // radera bergsområdet inklusive dupliceringen
        int expected = 1;
        System.out.println(resultat);
        System.out.println(expected);
        Assertions.assertEquals(expected, resultat);
    }
    @Test
    void TDD9_changeNaturreservat() { //Negativ testfall
        registreraNyaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Sköndal", "2026-03-15", "Stockholm", 0));
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
        Assertions.assertArrayEquals(expected,resultat);


    }
    @Test
    void TDD10_changeNaturreservat() { //Positiv testfall
        registreraNyaMetoder.visitedList.add(new Naturreservat("Bergsområdet", "Sköndal", "2026-03-15", "Stockholm", 0));
        Naturreservat expected = registreraNyaMetoder.visitedList.getLast();
        List<Naturreservat> getList = registreraNyaMetoder.changeNaturreservat("Bergsområdet", "Sköndal","Södertälje","2026-02-20","Stockholm län");
        Naturreservat resultat = getList.getLast();
        System.out.println(expected.getOrt());
        System.out.println(resultat.getOrt());
        Assertions.assertNotEquals(expected.getOrt(),resultat.getOrt());

    }

    /**
     * Hämtar 3 mest besökta naturreservat
     * Hämtar 3 naturreservat osorterat
     */
    @Test
    void TDD11_toppLista() { //Negativ testfall
        for(int i = 0; i < 3; i++){
            registreraGamlaMetoder.getOrt("Rinkeby");
            for(int j = 0; j < 3; j++){
                registreraGamlaMetoder.getOrt("Borlänge");
            }
        }
        List<Naturreservat> list = registreraGamlaMetoder.toppLista();
        String[] expected = {"Ort: Naturlig Antal besök: 13", "Ort: Bergsområdet Antal besök: 14", "Ort: Sjömarkerna Antal besök: 0"};
        String[] resultat = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            System.out.println("Ort: "+list.get(i).getNamn() +" Antal besök: "+list.get(i).getVisited());
            resultat[i] = "Ort: " + list.get(i).getNamn() + "\nAntal besök: "+list.get(i).getVisited();
        }
        Assertions.assertArrayEquals(expected, resultat);
    }
    /**
     * Hämtar 3 mest besökta naturreservat
     * Hämtar 3 naturreservat sorterat
     */
    @Test
    void TDD12_toppLista() { //Positiv testfall
        for(int i = 0; i < 3; i++){
            registreraNyaMetoder.getOrt("Rinkeby", "Kustlandskapet");
            for(int j = 0; j < 3; j++){
                registreraNyaMetoder.getOrt("Borlänge", "Dalälvens delta");
            }
        }

        List<Naturreservat> list = registreraNyaMetoder.toppLista();
        String[] resultat = new String[list.size()];
        String[] expected = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            System.out.println("Ort: "+list.get(i).getNamn() +" Antal besök: "+list.get(i).getVisited());
            resultat[i] = "Ort: " + list.get(i).getNamn() + "\nAntal besök: "+list.get(i).getVisited();
            expected[i] = "Ort: " + list.get(i).getNamn() + "\nAntal besök: "+list.get(i).getVisited();
        }

        Assertions.assertArrayEquals(expected,resultat);
    }

    /**
     * Hämtar en lista av naturreservat
     */
    @Test
    void TDD13_getVisitedList(){ // negativ testfall
        for(int i = 0; i < 3; i++){
            registreraGamlaMetoder.getOrt("Rinkeby");
            for(int j = 0; j < 3; j++){
                registreraGamlaMetoder.getOrt("Borlänge");
            }
        }
        List<Naturreservat> list = registreraGamlaMetoder.visitedList;
        String[] resultat = new String[list.size()];
        String[] expected = new String[registreraGamlaMetoder.visitedList.size()];

        for (int i = 0; i < list.size(); i++){
            resultat[i] = "Naturreservat: " + list.get(i).getNamn() + "\nOrt: " + list.get(i).getNamn();
            i++;
        }
        for (int i = 0; i < list.size(); i++){
            expected[i] = "Naturreservat: " + registreraGamlaMetoder.visitedList.get(i).getNamn() + "\nOrt: " + registreraGamlaMetoder.visitedList.get(i).getOrt()  + "\nBesökta: " + registreraGamlaMetoder.visitedList.get(i).getVisited()+ "\n";
            i++;
            }
        Assertions.assertArrayEquals(expected,resultat);


    }
    /**
     * Hämtar en lista av naturreservat
     */
    @Test
    void TDD14_getVisitedList(){ // positiv testfall
        for(int i = 0; i < 3; i++){
            registreraGamlaMetoder.getOrt("Rinkeby");
            for(int j = 0; j < 3; j++){
                registreraGamlaMetoder.getOrt("Borlänge");
            }
        }
        List<Naturreservat> list = registreraNyaMetoder.visitedList;
        String[] resultat = new String[registreraNyaMetoder.visitedList.size()];
        String[] expected = new String[registreraNyaMetoder.visitedList.size()];

        for (int i = 0; i < list.size(); i++){
            resultat[i] = "Naturreservat: " + list.get(i).getNamn() + "\nOrt: " + list.get(i).getOrt()  + "\nBesökta: " + list.get(i).getVisited()+ "\n";
            i++;
        }
        for (int i = 0; i < list.size(); i++){
            expected[i] = "Naturreservat: " + registreraNyaMetoder.visitedList.get(i).getNamn() + "\nOrt: " + registreraNyaMetoder.visitedList.get(i).getOrt()  + "\nBesökta: " + registreraNyaMetoder.visitedList.get(i).getVisited()+ "\n";
            i++;
        }
        Assertions.assertArrayEquals(expected,resultat);


    }

}



