// Fichier :     Population.java
// Création:     
// Auteurs :   Jasmine Livie & Kanty Gakima
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
    protected Herbe herbes;

    private ArrayList<Animal> individus = new ArrayList<>();


    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        herbes= herbe;


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
    public int getNombreProiesChassables () {
        return (int)(0.2 * getNombreProies());
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
        for (int i = 0; i < individus.size(); i++) {
            Animal animal = individus.get(i);
            animal.vieillir();
            // si l'animal est pas vivant il sera enlevé de la liste
            if (!animal.estVivant())
                individus.remove(i--);
        }
    }

    @Override
    //faire un set pour  accéder à l'herbe;
    public void chasser () {
       int proiesAchasser = getNombreProiesChassables();
       int count=0;
       double masseHerbes = herbes.getMasseAnnuelle();
       melanger();
       for (Animal animal : individus) {
           if (animal.estProie() && animal.estVivant()) {
               if (masseHerbes >= animal.getMasse() * 2) {
                   animal.manger();
                   masseHerbes = masseHerbes - animal.getMasse() * 2;
               }
               else {animal.mourir();}
           }
           if (animal.estPredateur() && animal.estVivant()) {
               double masseMangees = 0;
               if (count < proiesAchasser) {
                   // reparcours liste pour tuer les Antilopes nescessaire au lion en question
                   for (Animal value : individus)
                       if (masseMangees < animal.getMasse() * 2) {
                           if (value.estProie() && value.estVivant()) {
                               animal.manger();
                               masseMangees = masseMangees + value.getMasse();
                               value.mourir();
                               count = count + 1;
                           }
                       } else {
                           break;
                       }

                   }
                    else{animal.mourir();}
           }
       }
       individus.removeIf(animal -> !animal.estVivant());
    }


    @Override
    public void reproduire () {
        // ArrayList des bebe qui va être ajouté a individus
        ArrayList<Animal> bebes = new ArrayList<>();
        int countAntilope = 0;
        int countLion = 0;
        for(Animal parent: individus) {
            if (parent.estProie() && parent.estMature()) {
                countAntilope++; // incrémente afin de parcourir dans la liste
                if (countAntilope == 2) {
                    bebes.add(parent.accoucher());
                    countAntilope = 0; // reinitialise le compteur après l'accouchement d'un bébé par 2 antilopes
                }
            }
            else if (parent.estPredateur() && parent.estMature()) {
                countLion++;
                if (countLion == 2) {
                    bebes.add(parent.accoucher());
                    countLion = 0;
                    }
                }
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
