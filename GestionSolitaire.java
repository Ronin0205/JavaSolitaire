import java.util.*;

public class GestionSolitaire {



    public static void affichageMenuPrincipal(){
        System.out.println("   _____  ____  _      _____ _______       _____ _____  ______ \n" +
                "  / ____|/ __ \\| |    |_   _|__   __|/\\   |_   _|  __ \\|  ____|\n" +
                " | (___ | |  | | |      | |    | |  /  \\    | | | |__) | |__   \n" +
                "  \\___ \\| |  | | |      | |    | | / /\\ \\   | | |  _  /|  __|  \n" +
                "  ____) | |__| | |____ _| |_   | |/ ____ \\ _| |_| | \\ \\| |____ \n" +
                " |_____/ \\____/|______|_____|  |_/_/    \\_\\_____|_|  \\_\\______|");
        System.out.print("1. Jouer\n" +
                           "2. Regles\n" +
                           "3. Quitter\n" +
                            "Votre choix : ");
    }

    public static void affichageMenuAction(){
        System.out.print("\n1. Placer une carte\n" +
                "2. Placer carte pile cachée -> pile face\n"+
                "3. Placer carte dans pile groupe\n" +
                "4. Placer carte pile face -> pile table\n" +
                "5. Quitter\n"+
                "Votre choix : ");
    }

    public static void menuAction(Table table){
        int choix = 0;
        int ligneInit;
        int ligne;
        boolean partieGagnee = partieGagnee(table);

        Scanner sc = new Scanner(System.in);

        table.afficherTable();

        do{
            affichageMenuAction();
            choix = sc.nextInt();

            switch(choix){
                case 1:
                    table.afficherTable();

                    System.out.print("\nEntrez la ligne de la carte initiale puis de la carte finale : ");

                    ligneInit = sc.nextInt()-1;
                    ligne = sc.nextInt()-1;

                    table.deplacerCarte(ligneInit,ligne,table.getPileTable());
                    table.afficherTable();
                    partieGagnee = partieGagnee(table);
                    break;
                case 2:
                    table.afficherTable();

                    table.placerCartePileFace();

                    table.afficherTable();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }while (choix != 5 || partieGagnee);

    }

    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        affichageMenuPrincipal();
        int choix;
        choix = sc.nextInt();

        while (choix != 1 && choix != 2 && choix != 3){
            System.out.print("Choix invalide\n" +
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


    public static void gestionPartie(){
        Table table = new Table();
        Paquet paquet = new Paquet();
        table.remplirTable(paquet);

        menuAction(table);

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
