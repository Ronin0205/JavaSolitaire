import java.util.ArrayList;
import java.util.Collections;


public class Paquet {

    // Attributs de la classe Paquet
    private ArrayList<Carte> cartes;
    private static final String[] couleurs = {"Pique", "Carreau","Trefle","Coeur"};
    private static final String[] valeurs = {"As","2","3","4","5","6","7","8","9","10","Valet","Reine","Roi"};


    // Methodes
    public Paquet(){
        this.cartes = new ArrayList<>(52);
        remplirPaquet();
        melangerCartes();
    }

    public void remplirPaquet(){
        for (String couleurs : couleurs){
            for (String valeurs : valeurs){
                cartes.add(new Carte(couleurs,valeurs));
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

    public Carte getCarte(){
        return this.cartes.get(this.cartes.size());
    }

    public void enleverCarte(){
        this.cartes.remove(this.cartes.size());
    }

}
