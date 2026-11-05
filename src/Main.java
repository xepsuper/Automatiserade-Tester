import java.util.Scanner;

/**
 * Här utförs operationen
 * Initierar koden i main klassen
 */
public class Main {
    static Registrera visited = new Registrera();
    static NyRegistrera newVisited = new NyRegistrera();
    static Scanner inUser = new Scanner(System.in);

    public static void main(String[] args) {


        Naturreservat obs1 = new Naturreservat("Vildsvin", "Åkersberga", "2026-01-04", "Stockholm", 0);
        Naturreservat obs2 = new Naturreservat("Älg", "Härnösand", "2026-01-07", "Västernorrland", 0);
        Naturreservat obs3 = new Naturreservat("Älg", "Falun", "2026-04-10", "Dalarna", 0);
        Naturreservat obs4 = new Naturreservat("Lo", "Östersund", "2026-04-11", "Jämtland Härjedalen", 0);
        Naturreservat obs5 = new Naturreservat("Vildsvin", "Östersund", "2026-05-23", "Jämtland Härjedalen", 0);

        visited.addVisited(obs1);
        visited.addVisited(obs2);
        visited.addVisited(obs3);
        visited.addVisited(obs4);
        visited.addVisited(obs5);
        visited.addVisited(new Naturreservat("Får", "Sköndal", "2026-10-24", "Stockholm", 0));

        visited.getOrt("Östersund");

        int totalReports = visited.getNumberOfVisited();


        Scanner in = new Scanner(System.in);
        boolean inputLoop = true;

        while (inputLoop) {
            System.out.println("\n-------------------------------\nViltLogg!\n");
            System.out.println("Vad vill du göra?");
            System.out.println("1. Lista antal besökta naturreservat.");
            System.out.println("2. Lista vilka naturreservat som finns på samma ort.");
            System.out.println("3. Lista naturreservat som har besökts ett visst datum.");
            System.out.println("4. Hämta naturreservat beroende på region.");
            System.out.println("5. Lägg till önskat naturreservat (wishlist).");
            System.out.println("6. Hämta specifik ort och namn.");
            System.out.println("7. Lista besökta naturreservat via namn.");
            System.out.println("8. Ta bort ett besökt naturreservat.");
            System.out.println("9. Ändra ett naturreservat.");
            System.out.println("10. Visa topplista över mest besökta platser.");
            System.out.println("11. Avsluta ViltLogg");
            System.out.println("-------------------------------");
            System.out.print("\nAnge ditt val: ");

            int choice;
            if (!in.hasNextInt()) {
                System.out.println("Felaktigt val, vänligen ange en siffra.");
                in.next(); // discard bad token
                continue;
            }
            choice = in.nextInt();
            in.nextLine(); // consume trailing newline

            switch (choice) {
                case 1:
                    registeredPlaces();
                    break;

                case 2:
                    System.out.print("Ange ort: ");
                    String chOrt = in.nextLine();
                    if (chOrt.isEmpty()) {
                        System.out.println("Ort får inte vara tom.");
                        break;
                    }
                    ortPlace(chOrt);
                    break;

                case 3:
                    System.out.print("Ange datum (ÅÅÅÅ-MM-DD): ");
                    String chDate = in.nextLine();
                    if (!chDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        System.out.println("Felaktigt datumformat. Använd ÅÅÅÅ-MM-DD.");
                        break;
                    }
                    noneObs(chDate);
                    break;

                case 4:
                    System.out.print("Ange region: ");
                    String region = in.nextLine();
                    if (region.isEmpty()) {
                        System.out.println("Region får inte vara tom.");
                        break;
                    }
                    getSpecificNaturreservat(region);
                    break;

                case 5:
                    System.out.print("Ange naturreservat (namn): ");
                    String wishName = in.nextLine();
                    if (wishName.isEmpty()) {
                        System.out.println("Namn får inte vara tomt.");
                        break;
                    }
                    System.out.print("Ange ort: ");
                    String wishOrt = in.nextLine();
                    if (wishOrt.isEmpty()) {
                        System.out.println("Ort får inte vara tom.");
                        break;
                    }
                    wishListMethod(wishName, wishOrt);
                    break;

                case 6:
                    System.out.print("Ange ort: ");
                    String specOrt = in.nextLine();
                    if (specOrt.isEmpty()) {
                        System.out.println("Ort får inte vara tom.");
                        break;
                    }
                    System.out.print("Ange namn: ");
                    String specNamn = in.nextLine();
                    if (specNamn.isEmpty()) {
                        System.out.println("Namn får inte vara tomt.");
                        break;
                    }
                    getSpecficOrt(specOrt, specNamn);
                    break;

                case 7:
                    System.out.print("Ange naturreservat (namn): ");
                    String visitedName = in.nextLine();
                    if (visitedName.isEmpty()) {
                        System.out.println("Namn får inte vara tomt.");
                        break;
                    }
                    visitedNaturreservat(visitedName);
                    break;

                case 8:
                    System.out.print("Ange ort: ");
                    String removeOrt = in.nextLine();
                    if (removeOrt.isEmpty()) {
                        System.out.println("Ort får inte vara tom.");
                        break;
                    }
                    System.out.print("Ange namn: ");
                    String removeNamn = in.nextLine();
                    if (removeNamn.isEmpty()) {
                        System.out.println("Namn får inte vara tomt.");
                        break;
                    }
                    removeVisted(removeOrt, removeNamn);
                    break;

                case 9:
                    System.out.print("Ange namn: ");
                    String chName = in.nextLine();
                    if (chName.isEmpty()) {
                        System.out.println("Namn får inte vara tomt.");
                        break;
                    }
                    System.out.print("Ange ort (val): ");
                    String chOrtChoice = in.nextLine();
                    if (chOrtChoice.isEmpty()) {
                        System.out.println("Ort får inte vara tom.");
                        break;
                    }
                    System.out.print("Ange ny ort: ");
                    String chNewOrt = in.nextLine();
                    if (chNewOrt.isEmpty()) {
                        System.out.println("Ny ort får inte vara tom.");
                        break;
                    }
                    System.out.print("Ange nytt datum (ÅÅÅÅ-MM-DD): ");
                    String chDatum = in.nextLine();
                    if (!chDatum.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        System.out.println("Felaktigt datumformat. Använd ÅÅÅÅ-MM-DD.");
                        break;
                    }
                    System.out.print("Ange ny region: ");
                    String chRegion = in.nextLine();
                    if (chRegion.isEmpty()) {
                        System.out.println("Region får inte vara tom.");
                        break;
                    }
                    changeNaturreservat(chName, chOrtChoice, chNewOrt, chDatum, chRegion);
                    break;

                case 10:
                    toppLista();
                    break;

                case 11:
                    System.out.println("Avslutar ViltLogg...");
                    inputLoop = false;
                    break;

                default:
                    System.out.println("Felaktigt val, vänligen ange ett korrekt menyval (1–11).");
            }
        }
        in.close();
    }

    /**
     * Antal registrerade Naturreservat
     */
    static private void registeredPlaces(){
        System.out.println("Antalet besökta naturreservat är: " + visited.getNumberOfVisited() + " st.");
    }

    /**
     * Besöker ett specifikt ort
     * @param inPlace ort som användaren besöker
     */
    static public void ortPlace(String inPlace){
        visited.getOrt(inPlace);
    }

    /**
     * Orten som inte kommer att tas med
     * @param inArt oönskade ort som användaren inmatas
     */
    static public void noneObs(String inArt){
        visited.printOrtForNonMatchingReservat(inArt);

    }

    /**
     * Hämtar naturreservat beroende på specifik region
     * @param Region Regionen som inmatas av användaren
     */
    public static void getSpecificNaturreservat(String Region){
        newVisited.getSpecificNameByRegion(Region);
    }

    /**
     *
     * @param inNameWish Naturreservat som användaren önskar
     * @param ortWish Ort som användaren önskar
     */
    public static void wishListMethod(String inNameWish, String ortWish){
        newVisited.wishlist(inNameWish,ortWish);
    }

    /**
     *
     * @param inOrt Ort som använderen väljer
     * @param inNamn Namn som användaren väljer
     */
    public static void getSpecficOrt(String inOrt, String inNamn){
        newVisited.getOrt(inOrt, inNamn);
    }

    /**
     *
     * @param naturreservat
     */
    public static void visitedNaturreservat(String naturreservat){
        newVisited.getSpecificVisitedByNaturreservat(naturreservat);
    }

    /**
     *
     * @param inOrt Ort som använderen väljer
     * @param inNamn Namn som användaren väljer
     */
    public static void removeVisted(String inOrt, String inNamn){
        newVisited.removeVisited(inOrt, inNamn);
    }

    /**
     *
     * @param inName Naturreservat som användaren väljer
     * @param ortChoice Ort som användaren väljer
     * @param inOrt Ort som användaren vill ändra
     * @param getDatum Datum som användaren vill ändra
     * @param setRegion Region som användaren vill ändra
     */
    public static void changeNaturreservat(String inName, String ortChoice, String inOrt, String getDatum, String setRegion){
        newVisited.changeNaturreservat(inName, ortChoice, inOrt, getDatum, setRegion);
    }

    /**
     *  Hämtar en topplista av de mest besökta platser i en ordning
     */
    public static void toppLista(){
        newVisited.toppLista();
    }

}



/*

public class Main {
    static Registrera visited = new Registrera();
    static Scanner inUser = new Scanner(System.in);

    public static void main(String[] args) {


        Naturreservat obs1 = new Naturreservat("Vildsvin", "Åkersberga", "2026-01-04", "Stockholm", 0);
        Naturreservat obs2 = new Naturreservat("Älg", "Härnösand", "2026-01-07", "Västernorrland", 0);
        Naturreservat obs3 = new Naturreservat("Älg", "Falun", "2026-04-10", "Dalarna", 0);
        Naturreservat obs4 = new Naturreservat("Lo", "Östersund", "2026-04-11", "Jämtland Härjedalen", 0);
        Naturreservat obs5 = new Naturreservat("Vildsvin", "Östersund", "2026-05-23","Jämtland Härjedalen", 0);

        visited.addVisited(obs1);
        visited.addVisited(obs2);
        visited.addVisited(obs3);
        visited.addVisited(obs4);
        visited.addVisited(obs5);
        visited.addVisited(new Naturreservat("Får", "Sköndal", "2026-10-24", "Stockholm",0));

        visited.getOrt("Östersund");

        int totalReports = visited.getNumberOfVisited();



        Scanner inUser = new Scanner(System.in);
        Scanner inOrtChoice = new Scanner(System.in);
        Scanner inDateChoice = new Scanner(System.in);
        boolean inputLoop = true;

        int choice;
        while(inputLoop = true) {
            System.out.println("\n-------------------------------\n" +"ViltLogg!\n");
            System.out.print("Vad vill du göra? \n");
            System.out.print("1. Lista antal besökta naturreservat.\n");
            System.out.print("2. Lista vilka naturreservat som finns på samma ort.\n");
            System.out.print("3. Lista naturreservat som har besökts ett visst datum.\n");
            System.out.print("4. Ny funktionalitet....\n");
            System.out.print("5. Avsluta ViltLogg\n"+ "-------------------------------\n");
            System.out.print("\nAnge ditt val: ");

            choice = inUser.nextInt();

            while (choice > 6);

            switch (choice) {
                case 1:
                    antalReg();
                    break;

                case 2:
                    String chOrt = inOrtChoice.next().toString();
                    artPlats(chOrt);
                    break;

                case 3:
                    String chDate = inDateChoice.next().toString();
                    noneObs(chDate);
                    break;

                case 4:
                    System.out.println("Ny funktionalitet...");
                    break;

                case 5:
                    System.out.println("Avslutar KryssLista...");
                    System.exit(0);
                    break;


            }

            if (choice > 5 || choice < 1) {
                System.out.println("Felaktigt val, vänligen ange ett korrekt menyval.");
                do {
                    choice = inUser.nextInt();
                }
                while (choice < 7);
            }
        }
    }


    static private void antalReg(){
        System.out.println("Antalet besökta naturreservat är: " + visited.getNumberOfVisited() + " st.");
    }


    static public void artPlats(String inPlats){
        visited.getOrt(inPlats);
    }


    static public void noneObs(String inArt){
        visited.noObsArt(inArt);

    }

}



*/