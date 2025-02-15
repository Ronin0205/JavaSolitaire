public class Essai {

    public static void main(String[] args) {

        Table table = new Table();
        Paquet paquet = new Paquet();
        System.out.println(paquet.getCartes().size());
        table.remplirPileTableAvecCartes(paquet);
        table.afficherTable();
        System.out.println(paquet.getCartes().size());
        table.remplirPileFaceCachee(paquet);
        System.out.println(paquet.getCartes().size());
        System.out.println(table.getPileFaceCachee().size());
    }
}
