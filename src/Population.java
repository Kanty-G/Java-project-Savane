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
    protected int nombreProiesMatures=0;
    protected int nombrePredateursMatures=0;
    protected ArrayList<Animal> bebeLions = new ArrayList<>();
    protected ArrayList<Animal> bebeAntilopes = new ArrayList<>();

    private ArrayList<Animal> individus = new ArrayList<>();


    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);

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

        for(int i=0;i<=(individus.size()-1);i++){
            if(individus.get(i).estProie()&individus.get(i).estMature()){
                nombreProiesMatures++;
            }
        }
        return nombreProiesMatures;
    }

    @Override
    public int getNombrePredateursMatures () {
        for(int i=0;i<=(individus.size()-1);i++){
            if(individus.get(i).estPredateur()&individus.get(i).estMature()){
                nombrePredateursMatures++;
            }
        }
        return nombrePredateursMatures;
    }

    @Override
    public int getNombreProiesChassables () { // A VOIR : LE 20% C'EST SUR TOUT LES ANTILOPES OU BIEN SUR JUSTE LE DEBUT DE LA CHASSE AU ANTILOPES
        return (int)(0.2 * getNombreProies());// APRES AVOIR VIEILLIT
    }

    @Override
    public double masseProies () { // JE NE SAIS PAS TROP avec vieillir ou quoi???
        // pour debuger c'est la masse total de tout les proies ensemble, si veillit fit des changemnents, si nait, si meurt ...

        return 0;
    }

    @Override
    public double massePredateurs () {
        return 0;
    }

    @Override
    public void vieillir () {
        for (int i=0; i <= (individus.size()-1);i++){
            individus.get(i).vieillir();
        }
        // if vivant == false{ individus.remove(i--)}
        // bon de faire mourir si trop vieux ICI!!!!??

    }

    @Override
    public void chasser () {



    }

    @Override
    public void reproduire () {
        for(Animal animal: individus) {
            if (animal.estProie()) {
                nombreProiesMatures++;
                if (nombreProiesMatures == 2) {
                    bebeAntilopes.add(animal.accoucher());
                    nombreProiesMatures = 0;
                }
                if (animal.estProie()) {
                    nombrePredateursMatures++;
                    if (nombreProiesMatures == 2) {
                        bebeLions.add(animal.accoucher());
                        nombreProiesMatures = 0;
                    }
                }
            }
        }
        individus.addAll(bebeAntilopes);
        individus.addAll(bebeLions);
    }



    @Override
    public void melanger () {
        Collections.shuffle(this.individus, new Random(4));
    }

    @Override
    public Iterator<Animal> iterator() {
        return this.individus.iterator();
    }

    public ArrayList<Animal> getIndividus(){
        return this.individus;

    }

    // TO BE COMPLETED //

}
