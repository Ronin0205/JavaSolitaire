import java.util.ArrayList;
import java.util.Collections;


public class Paquet {

    // Attributs de la classe Paquet
    private ArrayList<Carte> cartes;
    private static final String[] couleurs = {"Pique", "Carreau","Trefle","Coeur"};
    private static final int[] valeurs = {1,2,3,4,5,6,7,8,9,10,11,12,13};


    // Methodes
    public Paquet(){
        this.cartes = new ArrayList<>(52);
        remplirPaquet();
        melangerCartes();
    }

    public void remplirPaquet(){
        for (String couleurs : couleurs){
            for (int valeurs : valeurs){
                cartes.add(new Carte(valeurs,couleurs));
            }
        }
    }

    public void melangerCartes(){
        Collections.shuffle(cartes);
    }

    public void afficherCartes(){
        for (Carte carte: this.cartes){
            System.out.println(carte.toString());
        }
    }

    public Carte retirerCarte(){
        Carte carte = this.cartes.get(this.cartes.size() - 1);
        this.cartes.remove(this.cartes.size() - 1);
        return carte;
    }

    public ArrayList<Carte> getCartes(){
        return this.cartes;
    }

}
