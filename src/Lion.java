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
    int ageMature = 5;
    static final public int AGEMAX = 50;
    int masse = 10;

    public Lion(double facteurCroissance) { // si regarde dans savanes Lions c'est Lions( double facteurCroissanceLions)
        this.facteurCroissance = facteurCroissance;
        naitre();
        setProie(false);
    }
}
