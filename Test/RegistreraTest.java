import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class RegistreraTest {
    private final Registrera registeraMetoder = new Registrera();
    Naturreservat testnaturreservat1, testnaturreservat2, testnaturreservat3;

    @BeforeEach
    void setUp() {
    }

    /**
     * TC01_addVisited() används för att lägga till nya observationer
     */
    @Test
    void TC01_addVisited() {

        registeraMetoder.addVisisted(new Naturreservat("Naturlig", "Rinkeby", "2026-02-02"));
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
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13");
        testnaturreservat2 = new Naturreservat("kaj", "dalarna", "2026-06-23");
        String resultat = testnaturreservat1.getOrt();
        String expected = "sköndal";
        assertEquals(expected, resultat);
    }

    /**
     * TC04_noObsArt() används för att hämta ut ort om namnet inte finns
     */
    @Test
    void TC04_noObsArt() {
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13");
        testnaturreservat2 = new Naturreservat("kaj", "dalarna", "2026-06-23");
        testnaturreservat3 = new Naturreservat("tjabbas", "gotland", "2024-09-30");
        registeraMetoder.noObsArt("rabbi");
        String expected = "dalarna";
    }

    /**
     *
     */
    @Test
    void TC05_getDate() {
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13");
        testnaturreservat2 = new Naturreservat("kaj", "dalarna", "2026-06-23");
        String result = testnaturreservat2.getDatum();
        String expected = "2026-06-23";
        System.out.println(result);;
        assertEquals(expected,result);

    }
    @Test
    void TC06_getName(){
        testnaturreservat1 = new Naturreservat("rabbi", "sköndal", "2026-03-13");
        testnaturreservat2 = new Naturreservat("kaj", "dalarna", "2026-06-23");
        String result = testnaturreservat2.getNamn();
        String expected = "kaj";
        System.out.println(result);;
        assertEquals(expected,result);
    }
    @Test
    void TC07_getNumberOfVisited(){
        registeraMetoder.addVisisted(new Naturreservat("Åsa", "Rinkeby", "2026-02-02"));
        registeraMetoder.addVisisted(new Naturreservat(null, null, null));
        int resultat = registeraMetoder.getNumberOfVisited();
        int expected = 1;
        assertEquals(expected, resultat);
    }
    @Test
    void TC08_getName(){
        registeraMetoder.addVisisted(new Naturreservat("Rinkeby", "Åsa", "2026-02-02"));
        String resultat = registeraMetoder.visitedList.getFirst().getNamn();
        String expected = "Åsa";
        assertEquals(expected,resultat);

    }
    @Test
    void TC09_getDate(){
        registeraMetoder.addVisisted(new Naturreservat("Åsa", "Rinkeby",  "2026 tjugotredje oktober"));
        String resultat = registeraMetoder.visitedList.getFirst().getDatum();
        String expected = "Åsa";
        assertEquals(expected,resultat);
    }

}