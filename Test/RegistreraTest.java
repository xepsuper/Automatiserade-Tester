import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class RegistreraTest {
    private final Registrera registeraMetoder = new Registrera();

    @BeforeEach
    void setUp() {

    }

    /**
     * addVisited Kollar om addVisited adderas i visitedList
     */
    @Test
    void TC01_addVisisted() {

        registeraMetoder.addVisisted(new Naturreservat("Naturlig", "Rinkeby", "2026-02-02"));
        Naturreservat naturreservat = registeraMetoder.visitedList.getFirst();
        int resultat = registeraMetoder.getNumberOfVisited();
        int expected = 1;
        assertEquals(expected, resultat);
    }

    /**
     * getNumberOfVisited Hämtar ut hur många naturreservat som befinner sig i visitedList
     */
    @Test
    void TC02_getNumberOfVisited() {
    }

    /**
     * getOrt hämtar ut specifika ort från visitedList
     */
    @Test
    void TC03_getOrt() {
    }

    /**
     *
     */
    @Test
    void TC04_noObsArt() {
    }
}