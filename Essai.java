public class Essai {

    public static void main(String[] args) {

        Paquet paquet1 = new Paquet();
        paquet1.remplirPaquet();
        Table table = new Table();
        table.remplirTable(paquet1);
        table.afficherTable();
    }
}
