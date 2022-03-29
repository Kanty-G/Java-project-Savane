// Fichier :     Lion.java
// Création:   2022.03.10
// Auteurs : Jasmine Livie & Kanty Louange Gakima
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

public class Lion extends Animal {
    public static final int ageMature = 5;
    public static final int AGEMAX = 50;
    private ArrayList<Animal> nourriture;



    public Lion(double facteurCroissance) {
        this.facteurCroissance = facteurCroissance;
        naitre(); // appelle la methode naitre pour que toute les antilopes soit originalement vivante = true
        setProie(false); // lion est false pour proie
        setPredateur(true); // lion est true pour predateur
    }
    // Override getAgeMax(), getAgemature() et setNourriture pour le mettre propre aux lions
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
