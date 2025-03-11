import java.util.*;

public class GestionSolitaire {



    public static void affichageMenuPrincipal(){
        System.out.println("   _____  ____  _      _____ _______       _____ _____  ______ \n" +
                "  / ____|/ __ \\| |    |_   _|__   __|/\\   |_   _|  __ \\|  ____|\n" +
                " | (___ | |  | | |      | |    | |  /  \\    | | | |__) | |__   \n" +
                "  \\___ \\| |  | | |      | |    | | / /\\ \\   | | |  _  /|  __|  \n" +
                "  ____) | |__| | |____ _| |_   | |/ ____ \\ _| |_| | \\ \\| |____ \n" +
                " |_____/ \\____/|______|_____|  |_/_/    \\_\\_____|_|  \\_\\______|");
        System.out.println("1. Jouer\n" +
                           "2. Regles\n" +
                           "3. Quitter\n" +
                            "Votre choix : ");
    }

    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        affichageMenuPrincipal();
        int choix;
        choix = sc.nextInt();

        while (choix != 1 && choix != 2 && choix != 3){
            System.out.println("Choix invalide\n" +
                              "Saisir a nouveau: ");
            choix = sc.nextInt();
        }

        switch (choix){
            case 1:
                gestionPartie();
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }

    public static Table preparationPartie(){
        Table table = new Table();
        Paquet paquet = new Paquet();
        table.remplirTable(paquet);

        return table;
    }

    public static void gestionPartie(){
        Table table = preparationPartie();
        table.afficherTable();
    }

    public static boolean partieGagnee(Table table){
        boolean valide = true;
        int i = 0;
        int j = 0;
        int n = 0;

        while(i < 4 && valide){
            if (table.getPileGroupe().get(i).size() == 13){
                while (j < 13 && valide){
                    if (table.getCarteOnIndicePileGroupe(j).getValeur() - 1 != table.getCarteOnIndicePileGroupe(j - 1).getValeur()){
                        valide = false;
                    }
                    j++;
                }
            }
            else {
                valide = false;
            }
            i++;
        }

        return valide;
    }
}
