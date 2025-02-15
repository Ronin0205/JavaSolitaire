public class Essai {

    public static void main(String[] args) {

        Table table = new Table();
        Paquet paquet = new Paquet();
        table.remplirPileTableAvecCartes(paquet);
        table.afficherTable();
    }
}
