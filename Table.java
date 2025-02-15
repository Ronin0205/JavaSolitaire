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
        this.pileGroupe = new ArrayList<>(4);

        for (int i = 0; i < 4; i++){
            this.pileGroupe.add(new ArrayList<>());
        }
        this.pileTable = new ArrayList<>(7);

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
            System.out.println(pileTable.get(i));
        }
    }

    public void remplirPileFaceCachee(Paquet paquet){
        for (int i = 0; i < 24; i++){
            pileFaceCachee.add(paquet.retirerCarte());
        }
    }

    public ArrayList<ArrayList<Carte>> getPileTable(){
        return this.pileTable;
    }

    public ArrayList<Carte> getPileFaceCachee(){
        return this.pileFaceCachee;
    }

    public void deplacerCarte(int ligneInit,int colInit,int ligne, int col ,ArrayList<ArrayList<Carte>> pileTable){
        String couleurInit, couleur;

        if (getCarteOnIndicePileTable(ligneInit,colInit).getCouleur() == "Trefle" || getCarteOnIndicePileTable(ligneInit,colInit).getCouleur() == "Pique"){
            couleurInit = "noir";
        }
        else {
            couleurInit = "rouge";
        }
        if (getCarteOnIndicePileTable(ligne,col).getCouleur() == "Trefle" || getCarteOnIndicePileTable(ligne,col).getCouleur() == "Pique"){
            couleur = "noir";
        }
        else {
            couleur = "rouge";
        }

        if ((getCarteOnIndicePileTable(ligneInit,colInit).getValeur() == getCarteOnIndicePileTable(ligne,col).getValeur()) && (couleurInit != couleur)){
            System.out.println("Deplacement possible !");
        }
        else {
            System.out.println("Deplacement impossible !");
        }
    }

    public void deplacerCartePileGroupe(int indPileGroupe, int ligneInit, int colInit){

    }

    public Carte getCarteOnIndicePileTable(int ligne, int col){
        return this.pileTable.get(ligne).get(col);
    }

    public Carte getCarteOnIndicePileGroupe(int ligne){
        return this.pileGroupe.get(ligne).get(pileGroupe.size() - 1);
    }
}
