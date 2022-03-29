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

    //Liste de tous les individus de la population
    private final ArrayList<Animal> individus = new ArrayList<>();
    private final Herbe herbeSavane;

    public Population(Herbe herbe, ArrayList < Animal > proies, ArrayList < Animal > predateurs) {

        individus.addAll(proies);
        individus.addAll(predateurs);
        herbeSavane= herbe;
    }

    @Override
    public int getNombreProies () {
        int nombreProies = 0; //compteur de nombre de proies dans individus
        for (Animal animal : individus)
            //si l'animal est une proie et est vivant on incrémente le compteur
            if (animal.estProie() && animal.estVivant()) {
                nombreProies++;
            }
        return nombreProies;
    }

    @Override
    public int getNombrePredateurs () {
        int nombrePredateurs = 0; //compteur du nombre de prédatuers dans individus
        for (Animal animal : individus) {
            //si l'animal est un predateur et est vivant on incrémente le compteur
            if (animal.estPredateur()) {
                nombrePredateurs++;
            }
        }
        return nombrePredateurs;
    }

    @Override
    public int getNombreProiesMatures () {
        int nombreProiesMatures=0; //compteur du nombre de proies matures dans individus
        for (Animal animal : individus) {
            //si l'animal est une proie et mature on incrémente le compteur
            if (animal.estProie() & animal.estMature()) {
                nombreProiesMatures++;
            }
        }
        return nombreProiesMatures;
    }

    @Override
    public int getNombrePredateursMatures () {
        int nombrePredateursMatures=0; //compteur du nombre de prédateurs matures dans individus
        for(Animal animal : individus){
            //si l'animal est un prédateur et mature on incrémente le compteur
            if(animal.estPredateur()&& animal.estMature()){
                nombrePredateursMatures++;
            }
        }
        return nombrePredateursMatures;
    }

    @Override
    //donne le nombre de proies qu'on peut chasser, soit 20% de proies
    public int getNombreProiesChassables () {
        return (int)(0.2 * getNombreProies());
    }

    @Override
    //donne la masse totale de toutes les proies
    public double masseProies () {
        double masseProies=0;
        for (Animal animal:individus)
            if(animal.estProie() ){
                masseProies=masseProies+ animal.getMasse();
            }
        return masseProies;
    }

    // masse total de tous les predateurs
    @Override
    //donne la masse totale de tous les prédateurs
    public double massePredateurs () {
        double massePredateurs=0;
        for (Animal animal:individus)
            if(animal.estPredateur()) {
                massePredateurs = massePredateurs + animal.getMasse();
            }
        return massePredateurs;
    }

    @Override
    //fait viellir l'herbe et la population(les individus) d'une savane
    public void vieillir () {
        herbeSavane.vieillir();
        for (Animal animal : individus) {
            animal.vieillir();
        }
        //si l'animal n'est pas vivant, il est enlevé de la liste des individus
        individus.removeIf(animal -> !animal.estVivant());
    }

    @Override
    //méthode qui fait chasser les individus,les prédateurs mangent des proies
    //et les proies mangent de l'herbe
    public void chasser () {
       int proiesAchasser = getNombreProiesChassables();// variable de stockage du nombre de proies chassables
       int count=0; //compteur des proies qui ont été chassées
       double masseHerbe = herbeSavane.getMasseAnnuelle(); //masse totale de l'herbe au début de la chasse
       melanger();
       for (Animal animal : individus) {
           //si l'animal est une proie et qu'elle est vivante, il mange une masse d'herbe
           //égale au double de sa masse
           if (animal.estProie() && animal.estVivant()) {
               if (masseHerbe >= animal.getMasse() * 2) {
                   animal.manger();
                   masseHerbe -= animal.getMasse() * 2;
               }
               //si la masse d'herbe restante est inférieure au double de la masse de l'animal,il meurt
               else animal.mourir();
           }
           //si l'animal est un prédateur et qu'il est encore vivant, il mange des proies
           //jusqu'à atteindre la masse de nourriture dont il a besoin
           if (animal.estPredateur() && animal.estVivant()) {

               //variable de stockage de la masse de proies déjà mangée par un prédateur
               double masseMangee = 0;

               for (Animal value : individus) {
                   //si le nombre de proies déjà chassées est supérieur ou égal au nombre de
                   // proies chassables, le prédateur meurt;
                   if (count >= proiesAchasser) {
                       animal.mourir();
                       break;
                   }
                   //si la masse déjà mangée par le prédateur est inférieur au double de sa masse
                   //il mange une  proie
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
        // liste des bebes qui vont naitre,elle est initialement vide
        ArrayList<Animal> bebes = new ArrayList<>();
        int bebesProies = getNombreProiesMatures() / 2;
        int bebesPredateurs = getNombrePredateursMatures() / 2;
        for (Animal parent : individus) {
            //si l'animal parent n'est pas vivant ou n'est pas mature,on parcourt la liste pour
            //chercher un autre qui remplit la condition
            if (!parent.estVivant() || !parent.estMature()) continue;
            if (parent.estProie()) {
                //si le nombre de bébes restant à naitre est >0, l'animal proie accouche.
                if (bebesProies > 0) {
                    //ajout du nouvau bébé dans liste
                    bebes.add(parent.accoucher());
                    bebesProies--;
                }
            } else if (parent.estPredateur()) {
                //si le nombre de bébes restant à naitre est >0, l'animal prédateur accouche.
                if (bebesPredateurs> 0) {
                    bebes.add(parent.accoucher());
                    bebesPredateurs--;
                }
            }
            //sinon il faut arrêter la boucle
            if (bebesPredateurs == 0 && bebesProies == 0) break;
        }
        //Ajout de la liste bebes à individus
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
