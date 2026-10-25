import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


class RegistreraTest {
    private final Registrera registeraMetoder = new Registrera();
    Naturreservat testnaturreservat1, testnaturreservat2;

    @BeforeEach
    void setUp() {
    }

    /**
     * TC01_addVisited() används för att lägga till nya observationer
     */
    @Test
    void TC01_addVisited() {

        registeraMetoder.addVisited(new Naturreservat("Naturlig", "Rinkeby", "2026-02-02", "Stockholm",0));
        int resultat = registeraMetoder.getNumberOfVisited();
        int expected = 1;
        assertEquals(expected, resultat);
    }
    /**
     * TC02_getNumberOfVisited() används för att hämta hur många observationer finns i visitedList
     */
    @Test
    void TC02_getNumberOfVisited() {
        int result = registeraMetoder.getNumberOfVisited();
        int expected = 0;
        assertEquals(expected, result);
    }

    /**
     * TC03_getOrt() används för att hämta specifika observationer
     */
    @Test
    void TC03_getOrt() {
        testnaturreservat1 = new Naturreservat("rabbi", "Sköndal", "2026-03-13", "Stockholm",0);
        testnaturreservat2 = new Naturreservat("kaj", "Borlänge", "2026-06-23", "Dalarna",0);
        String resultat = testnaturreservat1.getOrt();
        String expected = "sköndal";
        assertEquals(expected, resultat);
    }

    /**
     * TC04_noObsArt() används för att hämta ut ort om namnet inte finns
     */
    @Test
    void TC04_noObsArt() {
        registeraMetoder.addVisited(new Naturreservat("Åsa", "Rinkeby", "2026-02-02", "Stockholm",0));
        registeraMetoder.addVisited(new Naturreservat("Robert", "Alby", "2026-02-04", "Stockholm",0));
        registeraMetoder.addVisited(new Naturreservat("Rubi", "sköndal", "2026-05-04", "Stockholm",0));
        registeraMetoder.noObsArt("Rubi"); // Alla ort förutom sköndal kommer att skrivas
        String resultat = "Alby";
        String expected = "Alby";
        assertEquals(expected,resultat);

    }

    /**
     * Hämtar datum från instanserna
     */
    @Test
    void TC05_getDate() {
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13", "Stockholm",0);
        testnaturreservat2 = new Naturreservat("kaj", "Borlänge", "2026-06-23", "Dalarna",0);
        String result = testnaturreservat2.getDatum();
        String expected = "2026-06-23";
        System.out.println(result);;
        assertEquals(expected,result);

    }

    /**
     * Hämtar namn från instanserna
     */
    @Test
    void TC06_getName(){
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13", "Stockholm",0);
        testnaturreservat2 = new Naturreservat("kaj", "Borlänge", "2026-06-23", "Dalarna",0);
        String result = testnaturreservat2.getNamn();
        String expected = "kaj";
        System.out.println(result);;
        assertEquals(expected,result);
    }
    @Test
    /**
     * Hämtar hur många observationer som finns i visitedList
     * Kollar om null-värde räknas som en observation
     * Ska inte räkna med tomma observationer
     */
    void TC07_getNumberOfVisited(){
        registeraMetoder.addVisited(new Naturreservat("Åsa", "Rinkeby", "2026-02-02", "Stockholm",0));
        registeraMetoder.addVisited(new Naturreservat(null, null, null, null,0));
        int resultat = registeraMetoder.getNumberOfVisited();
        int expected = 1;
        assertEquals(expected, resultat);
    }

    /**
     * Hämtar namn från visitedList
     * Kollar om det går blanda mellan ort och namn
     * Ska inte returnera ort som namn
     */
    @Test
    void TC08_getName(){
        registeraMetoder.addVisited(new Naturreservat("Rinkeby", "Åsa", "2026-02-02", "Stockholm",0));
        String resultat = registeraMetoder.visitedList.getFirst().getNamn();
        String expected = "Åsa";
        assertEquals(expected,resultat);

    }

    /**
     * Hämtar datum från visitedList
     * Kontrollera formatering på indatumet
     * Ska inte skicka datum med bokstäver
     */
    @Test
    void TC09_getDate(){
        registeraMetoder.addVisited(new Naturreservat("Åsa", "Rinkeby",  "2026 tjugotredje oktober", "Stockholm",0));
        String resultat = registeraMetoder.visitedList.getFirst().getDatum();
        String expected = "2026-10-23";
        assertEquals(expected,resultat);
    }
}