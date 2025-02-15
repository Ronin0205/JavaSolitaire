public class Carte {

    //Attributs pour la classe Carte

    private String valeur;
    private String couleur;

    // Methodes

    public Carte(String valeur, String couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }


    public String getValeur(){
        return this.valeur;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public String toString(){
        return this.couleur + " : " + this.valeur;
    }
}
