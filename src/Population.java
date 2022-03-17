// Fichier :     Population.java
// Création:     
// Auteurs :     
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

/**
   class Population
    implements EcoSysteme, Iterable<Animal>

**/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;


// Defines a population of herb and animals (preys and predators), iterable
public class Population implements EcoSysteme, Iterable<Animal> {

    protected int nombreProies=0;
    protected int nombrePredateurs=0;
    private ArrayList<Animal> individus = new ArrayList<>();


    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);

        // vieillir pour une annee:
        for (int i=0; i <= (individus.size()-1);i++){
            individus.get(i).vieillir();
        }

    }

    @Override
    public int getNombreProies () {
        for (int i=0;i <= (individus.size()-1);i++){
            if(individus.get(i).estProie()){
                nombreProies++;
            }
        }
        return nombreProies;
    }

    @Override
    public int getNombrePredateurs () {
        for(int i=0;i<=(individus.size()-1);i++){
            if(individus.get(i).estPredateur()){
                nombrePredateurs++;
            }
        }
        return nombrePredateurs;
    }

    @Override
    public int getNombreProiesMatures () {
        return 0;
    }

    @Override
    public int getNombrePredateursMatures () {
        return 0;
    }

    @Override
    public int getNombreProiesChassables () { // A VOIR : LE 20% C'EST SUR TOUT LES ANTILOPES OU BIEN SUR JUSTE LE DEBUT DE LA CHASSE AU ANTILOPES
        return int(0,2 * getNombreProies());// REVOIR POUR NOMBRE A VIRGULE
    }

    @Override
    public double masseProies () { // JE NE SAIS PAS TROP




        return 0;
    }

    @Override
    public double massePredateurs () {
        return 0;
    }

    @Override
    public void vieillir () {

    }

    @Override
    public void chasser () {

    }

    @Override
    public void reproduire () {

    }

    @Override
    public void melanger () {
        Collections.shuffle(this.individus, new Random(4));
    }

    @Override
    public Iterator<Animal> iterator() {
        return null;
    }

    // TO BE COMPLETED //

}
