import java.util.ArrayList;

public class Table {

    // Attributs de la classe Table
    private ArrayList<Carte> pileFaceCachee;
    private ArrayList<Carte> pileFace;
    private ArrayList<ArrayList<Carte>> pileGroupe;
    private ArrayList<ArrayList<Carte>> pileTable;


    // Methodes

    public Table(){
        this.pileFaceCachee = new ArrayList<>(24);
        this.pileFace = new ArrayList<>();
        this.pileGroupe = new ArrayList<>();
        pileTable = new ArrayList<>(7);

        for (int i = 0; i < 7; i++){
            this.pileTable.add(new ArrayList<>());
        }
    }

    public void remplirPileTableAvecCartes(Paquet paquet){
        int nombreCartes = 1;

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < nombreCartes; j++){
                Carte carte = paquet.retirerCarte();
                if (carte != null){
                    placerCarte(i,carte);
                }
            }
            nombreCartes++;
        }
    }

    public void placerCarte(int indice, Carte carte){
        if (indice >= 0 && indice <= 7 ){
            pileTable.get(indice).add(carte);
        }
        else{
            System.out.println("Indice invalide! ");
        }
    }

    public void afficherTable(){
        for (int i = 0; i < pileTable.size(); i++){
            for (int j = 0; j < pileTable.get(i).size(); j++){
                System.out.println(pileTable.get(i));
            }
        }
    }
}
