// Fichier :     Antilope.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Antilope
    extends Animal

**/

    // TO BE COMPLETED //
public class Antilope extends Animal{
    public static final int ageMature = 2;
    static final public int AGEMAX = 15;
    int masse = 10;
    private Herbe nourriture;

    public Antilope(double facteurCroissance) {
        this.facteurCroissance = facteurCroissance;
        naitre();
        setProie(true);
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
    public void  setNourriture(Herbe nourriture){
        this. nourriture=nourriture;
    }

}

