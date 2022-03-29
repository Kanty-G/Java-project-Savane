// Fichier :     Lion.java
// Création:   2022.03.10
// Auteurs : Jasmine Livie & Kanty Gakima
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

import java.util.ArrayList;

/**
   class Lion
    extends Animal

**/

    // TO BE COMPLETED //
public class Lion extends Animal {
    public static final int ageMature = 5;
    public static final int AGEMAX = 50;
    int masse = 10;
    private ArrayList<Animal>nourriture;



    public Lion(double facteurCroissance) { // si regarde dans savanes Lions c'est Lions( double facteurCroissanceLions)
        this.facteurCroissance = facteurCroissance;
        naitre();
        setProie(false);
        setPredateur(true);
    }
    @Override
    public int getAgeMax(){
        return AGEMAX;
    }
    @Override
    public int getAgeMature(){
        return ageMature;
    }
    @Override
    public void setNourriture(ArrayList<Animal> nourriture){
        this.nourriture= nourriture;
    }
}
