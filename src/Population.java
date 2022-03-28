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


    protected Herbe herbes;

    private ArrayList<Animal> individus = new ArrayList<>();


    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        herbes= herbe;


    }

    @Override
    public int getNombreProies () {
        int nombreProies=0;
        for (Animal animal : individus)
            if (animal.estProie() && animal.estVivant())
                nombreProies++;

        return nombreProies;
    }

    @Override
    public int getNombrePredateurs () {
        int nombrePredateurs=0;
        for (Animal animal : individus) {
            if (animal.estPredateur() && animal.estVivant()) {
                nombrePredateurs++;
            }
        }
        return nombrePredateurs;
    }

    @Override
    public int getNombreProiesMatures () {
        int nombreProiesMatures=0;
        for (Animal animal : individus ) {
            if (animal.estProie() && animal.estMature() && animal.estVivant()) {
                nombreProiesMatures++;
            }
        }
        return nombreProiesMatures;
    }

    @Override
    public int getNombrePredateursMatures () {
        int nombrePredateursMatures=0;
        for (Animal animal : individus) {
            if (animal.estPredateur() && animal.estMature() && animal.estVivant()) {
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
    public double masseProies () {
        double masseProies=0;
        for (Animal animal:individus)
            if(animal.estProie()){
                masseProies=masseProies+ animal.getMasse();
            }
        return masseProies;
    }

    @Override
    public double massePredateurs () {
        double massePredateurs=0;
        for (Animal animal:individus)
            if(animal.estPredateur()) {
                massePredateurs = massePredateurs + animal.getMasse();
            }
        return massePredateurs;
    }

    @Override
    public void vieillir () {
        for (Animal animal : individus) {
            animal.vieillir();
            // si l'animal est pas vivant il sera enlevé de la liste
        }
    }

    @Override
    //faire un set pour  accéder à l'herbe;
    public void chasser () {
       int proiesAchasser= getNombreProiesChassables();
       int count=0;
       double masseHerbes=herbes.getMasseAnnuelle();
       melanger();

       for (Animal animal : individus) {
           if (animal.estProie() && animal.estVivant()) {
               if (masseHerbes >= animal.getMasse() * 2) {
                   masseHerbes -= animal.getMasse() * 2;
               }
               else  animal.mourir();
           }
           if (animal.estPredateur() && animal.estVivant()) {
               double masseMangee = 0;
               if (count < proiesAchasser) {
                   for (Animal value : individus)
                       if (masseMangee < animal.getMasse() * 2) {
                           if (value.estProie() && value.estVivant()) {
                               masseMangee = masseMangee + value.getMasse();
                               value.mourir();
                               count++;
                           }
                       } else {
                           break;
                       }
                   }
                    else{animal.mourir();}
           }
       }
    }

    @Override
    public void reproduire () {
        // ArrayList des bebe qui va être ajouté a individus
        ArrayList<Animal> bebes = new ArrayList<>();
        int countAntilope = 0;
        int countLion = 0;
        for(Animal parent: individus) {
            if (parent.estProie() && parent.estMature() && parent.estVivant()) {
                countAntilope++; // incrémente afin de parcourir dans la liste
                if (countAntilope == 2) {
                    bebes.add(parent.accoucher());
                    countAntilope = 0; // reinitialise le compteur après l'accouchement d'un bébé par 2 antilopes
                }
            }
            else if (parent.estPredateur() && parent.estMature() && parent.estVivant()) {
                countLion++;
                if (countLion == 2) {
                    bebes.add(parent.accoucher());
                    countLion = 0;
                    }
                }
            }
        individus.addAll(bebes);
        individus.removeIf(animal -> !animal.estVivant());// enlève animaux morts
    }


    @Override
    public void melanger () {
        individus.removeIf(animal -> !animal.estVivant());
        Collections.shuffle(this.individus, new Random(4));
    }


    @Override
    public Iterator<Animal> iterator() {
        return this.individus.iterator();
    }

    public ArrayList<Animal> getIndividus(){
        return this.individus;

    }
}
