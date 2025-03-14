import java.util.ArrayList;
import java.util.Scanner;

public class Table {

    // Attributs de la classe Table
    private ArrayList<Carte> pileFaceCachee;
    private ArrayList<Carte> pileFace;
    private ArrayList<ArrayList<Carte>> pileGroupe;
    private ArrayList<ArrayList<Carte>> pileTable;


    // Methodes


    public static Scanner sc = new Scanner(System.in);

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
                    placerCartePileTable(i,carte);
                }
            }
            nombreCartes++;
        }
    }

    public void placerCartePileTable(int indice, Carte carte){
        if (indice >= 0 && indice <= 6 ){
            this.pileTable.get(indice).add(carte);
        }
        else{
            System.out.println("Indice invalide! ");
        }
    }

    public void afficherTable(){
        System.out.println();
        for (int i = 0; i < pileTable.size(); i++){
            for (int j = 0; j < pileTable.get(i).size(); j++){
                if (j == pileTable.get(i).size() - 1) {
                    System.out.print(pileTable.get(i).get(j).toString() + " ");
                }
                else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
        System.out.println("Pile Face Cachée : " + this.pileFaceCachee);
        if (!this.pileFace.isEmpty()){
            System.out.print("\tPile Face : " + this.pileFace.get(this.pileFace.size() - 1).toString());
        }
        else {
            System.out.print("\tPile Face : ");
        }
    }

    public void remplirPileFaceCachee(Paquet paquet){
        for (int i = 0; i < 24; i++){
            this.pileFaceCachee.add(paquet.retirerCarte());
        }
    }

    public ArrayList<ArrayList<Carte>> getPileTable(){
        return this.pileTable;
    }

    public ArrayList<ArrayList<Carte>> getPileGroupe(){
        return this.pileGroupe;
    }

    public ArrayList<Carte> getPileFaceCachee(){
        return this.pileFaceCachee;
    }

    public void deplacerCarte(int ligneInit,int ligne, ArrayList<ArrayList<Carte>> pileTable){
        String couleurInit, couleur;

        if (getCarteOnIndicePileTable(ligneInit,pileTable.get(ligneInit).size()-1).getCouleur().equals("Trefle") || getCarteOnIndicePileTable(ligneInit,pileTable.get(ligneInit).size()-1).getCouleur().equals("Pique")){
            couleurInit = "noir";
        }
        else {
            couleurInit = "rouge";
        }
        if (getCarteOnIndicePileTable(ligne,pileTable.get(ligne).size()-1).getCouleur().equals("Trefle") || getCarteOnIndicePileTable(ligne,pileTable.get(ligne).size()-1).getCouleur().equals("Pique")){
            couleur = "noir";
        }
        else {
            couleur = "rouge";
        }

        if ((getCarteOnIndicePileTable(ligneInit,pileTable.get(ligneInit).size()-1).getValeur() == (getCarteOnIndicePileTable(ligne,pileTable.get(ligne).size()-1).getValeur())-1 && (!couleurInit.equals(couleur)))){
            pileTable.get(ligne).add(pileTable.get(ligneInit).get(pileTable.get(ligneInit).size()-1));
            pileTable.get(ligneInit).remove(pileTable.get(ligneInit).get(pileTable.get(ligneInit).size()-1));
        }
        else {
            System.out.println("Deplacement impossible !");
        }
    }

    public void deplacerCartePileFace(ArrayList<Carte> pileFace){
        int ligne1;
        String couleurInit,couleur;


        System.out.print("Entrez la ligne ou vous voulez placer votre carte : ");
        ligne1 = sc.nextInt();

        if (this.pileFace.get(this.pileFace.size()-1).getCouleur().equals("Trefle") || this.pileFace.get(this.pileFace.size()-1).getCouleur().equals("Pique")){
            couleurInit = "noir";
        }
        else {
            couleurInit = "rouge";
        }
        if (getCarteOnIndicePileTable(ligne1,pileTable.get(ligne1).size()-1).getCouleur().equals("Trefle") || getCarteOnIndicePileTable(ligne1,pileTable.get(ligne1).size()-1).getCouleur().equals("Pique")){
            couleur = "noir";
        }
        else {
            couleur = "rouge";
        }

        if ((this.pileFace.get(this.pileFace.size()-1).getValeur() == getCarteOnIndicePileTable(ligne1,pileTable.get(ligne1).size()-1).getValeur()) && (!couleurInit.equals(couleur))){
            pileTable.get(ligne1).add(pileFace.get(pileFace.size()-1));
            pileFace.remove(pileFace.size()-1);
        }
        else {
            System.out.println("Deplacement impossible !");
        }
    }

    public void deplacerCartePileGroupe(int indPileGroupe, int ligneInit, int colInit){
        String couleurInit;

        if (getCarteOnIndicePileGroupe(indPileGroupe) == null && getCarteOnIndicePileTable(ligneInit,colInit).getValeur() == 1){
            pileGroupe.get(indPileGroupe).add(getCarteOnIndicePileTable(ligneInit,colInit));
        }
    }

    public void placerCartePileFace(){
        if (!this.pileFaceCachee.isEmpty()) {
            this.pileFace.add(this.pileFaceCachee.get(this.pileFaceCachee.size()-1));
            this.pileFaceCachee.remove(this.pileFaceCachee.get(this.pileFaceCachee.size()-1));
        }
        else {
            this.pileFaceCachee = this.pileFace;
            this.pileFace.clear();
        }
    }

    public Carte getCarteOnIndicePileTable(int ligne, int col){
        return this.pileTable.get(ligne).get(col);
    }

    public Carte getCarteOnIndicePileGroupe(int ligne){
        return this.pileGroupe.get(ligne).get(pileGroupe.size() - 1);
    }


    public void remplirTable(Paquet paquet){
        remplirPileTableAvecCartes(paquet);
        remplirPileFaceCachee(paquet);
    }
}
