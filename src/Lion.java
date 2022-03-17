// Fichier :     Lion.java
// Création:     
// Auteurs :
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Lion
    extends Animal

**/

    // TO BE COMPLETED //
public class Lion extends Animal {
    public static final int ageMature = 5;
    public static final int AGEMAX = 50;
    int masse = 10;

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
}
