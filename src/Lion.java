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
    int maxAge = 50;
    int masse = 10;

    public Lion(double facteurCroissance) {
        this.facteurCroissance = facteurCroissance;
        setProie(false);
    }
}
