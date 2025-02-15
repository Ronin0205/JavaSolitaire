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
        this.pileTable = new ArrayList<>(7);
    }

    public void remplirTable(Paquet paquet){
        for (int i = 0; i < pileTable.size(); i++){
            for (int j = 0; i < pileTable.get(i).size(); j++){
                pileTable.get(i).add(paquet.getCarte());
                paquet.enleverCarte();
            }
        }
    }

    public void afficherTable(){
        for (int i = 0; i < pileTable.size(); i++){
            for (int j = 0; i < pileTable.get(i).size(); j++){
                System.out.println(pileTable.get(i));
            }
        }
    }
}
