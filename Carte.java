public class Carte {

    //Attributs pour la classe Carte

    private int valeur;
    private String couleur;

    // Methodes

    public Carte(int valeur, String couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }


    public int getValeur(){
        return this.valeur;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public String toString(){
        return this.couleur + " : " + this.valeur;
    }
 
}
