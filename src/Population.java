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

    // TO BE COMPLETED //


    public Population( Herbe herbe, ArrayList<Animal> proies, ArrayList<Animal> predateurs ) {


	// TO BE COMPLETED //
	
    }

    @Override
    public int getNombreProies() {
        return 0;
    }

    @Override
    public int getNombrePredateurs() {
        return 0;
    }

    @Override
    public int getNombreProiesMatures() {
        return 0;
    }

    @Override
    public int getNombrePredateursMatures() {
        return 0;
    }

    @Override
    public int getNombreProiesChassables() {
        return 0;
    }

    @Override
    public double masseProies() {
        return 0;
    }

    @Override
    public double massePredateurs() {
        return 0;
    }

    @Override
    public void vieillir() {

    }

    @Override
    public void chasser() {

    }

    @Override
    public void reproduire() {

    }

    @Override
    public void melanger() {

    }

    // TO BE COMPLETED //
    
}
