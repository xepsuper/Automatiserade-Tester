import java.util.List;
import java.util.Scanner;

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

            while (choice > 6) ;

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



