// Fichier :  Population.java
// Création:  20.03.2022
// Auteurs :  Jasmine Livie & Kanty Louange Gakima
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

    protected Herbe herbeSavane;

    private ArrayList<Animal> individus = new ArrayList<>();


    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        herbeSavane = herbe;
    }

    @Override
    public int getNombreProies () {
        int nombreProies = 0;
        for (Animal animal : individus)
            if (animal.estProie() && animal.estVivant()) {
                nombreProies++;
            }

        return nombreProies;
    }

    @Override
    public int getNombrePredateurs () {
        int nombrePredateurs = 0;
        for (Animal animal : individus) {
            if (animal.estPredateur()) {
                nombrePredateurs++;
            }
        }
        return nombrePredateurs;
    }

    @Override
    public int getNombreProiesMatures () {
        int nombreProiesMatures=0;
        for (Animal animal : individus) {
            if (animal.estProie() & animal.estMature()) {
                nombreProiesMatures++;
            }
        }
        return nombreProiesMatures;
    }

    @Override
    public int getNombrePredateursMatures () {
        int nombrePredateursMatures=0;
        for(int i=0;i<=(individus.size()-1);i++){
            if(individus.get(i).estPredateur()&individus.get(i).estMature()){
                nombrePredateursMatures++;
            }
        }
        return nombrePredateursMatures;
    }

    @Override
    public int getNombreProiesChassables () {
        return (int)(0.2 * getNombreProies());
    }

    @Override
    public double masseProies () {
        double masseProies=0;
        for (Animal animal:individus)
            if(animal.estProie() ){
                masseProies=masseProies+ animal.getMasse();
            }
        return masseProies;
    }

    // masse total de tout les predateurs
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
        herbeSavane.vieillir();
        for (Animal animal : individus) {
            animal.vieillir();
            // si l'animal est pas vivant il sera enlevé de la liste
        }
        individus.removeIf(animal -> !animal.estVivant());
    }

    @Override
    //faire un set pour  accéder à l'herbe;
    public void chasser () {
       int proiesAchasser = getNombreProiesChassables();
       int count=0;
       double masseHerbe = herbeSavane.getMasseAnnuelle();
       melanger();
       for (Animal animal : individus) {
           if (animal.estProie() && animal.estVivant()) {
               if (masseHerbe >= animal.getMasse() * 2) {
                   animal.manger();
                   masseHerbe -= animal.getMasse() * 2;
               }
               else animal.mourir();
           }
           if (animal.estPredateur() && animal.estVivant()) {
               double masseMangee = 0;
                   // reparcours liste pour tuer les Antilopes nescessaire au lion en question
               for (Animal value : individus) {
                   if (count >= proiesAchasser) {
                       animal.mourir();
                       break;
                   }
                   if (masseMangee < animal.getMasse() * 2) {
                       if (value.estProie() && value.estVivant()) {
                           animal.manger();
                           masseMangee += value.getMasse();
                           value.mourir();
                           count++;
                       }
                   }
                   if (masseMangee >= animal.getMasse() * 2) break;
               }
           }
       }
       individus.removeIf(animal -> !animal.estVivant());
    }


    @Override
    public void reproduire () {
        // ArrayList des bebe qui va être ajouté a individus
        ArrayList<Animal> bebes = new ArrayList<>();
        int bebesAntilopes= getNombreProiesMatures()/2;
        int bebesLions= getNombrePredateursMatures()/2;
        for(Animal parent: individus) {
            if (!parent.estVivant() || !parent.estMature()) continue;
            if (parent.estProie()) {
               // incrémente afin de parcourir dans la liste
                if (bebesAntilopes>0) {
                    bebes.add(parent.accoucher()); // add le bebe Antilope
                    bebesAntilopes--; // reinitialise le compteur après l'accouchement d'un bébé par 2 antilopes
                }
            }
            else if (parent.estPredateur()) {
                if (bebesLions>0) {
                    bebes.add(parent.accoucher());
                    bebesLions--;
                }
            }

            if (bebesLions == 0 && bebesAntilopes == 0) break;
        }
        individus.addAll(bebes);
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
}
