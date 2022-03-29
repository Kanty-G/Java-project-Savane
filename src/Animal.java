// Fichier :     Animal.java
// Création: 2022.03.10
// Auteurs : Jasmine Livie & Kanty Louange Gakima
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

import java.util.ArrayList;

/**
   class Animal
    implements the Prey/Predator relationship

**/

abstract class Animal implements ProiePredateur {
        protected int age = 0;
        protected int ageMature;
        protected boolean proie;
        protected double facteurCroissance;
        protected double masse = 10;
        protected int AGEMAX;
        protected boolean vivant;
        protected boolean predateur;
        protected Herbe herbe;
        protected ArrayList<Animal> individus;

        //set la ourriture que les individus peuvent manger selon que c'est des proies ou prédateurs
        public void  setNourriture(Herbe nourriture){
        }
        public void setNourriture(ArrayList<Animal> nourriture){
        }

        @Override
        public void naitre () {
            vivant = true;
        }

        @Override
        // augmente l'age de l'animal de 1 et multiplie sa masse avec le facteur de croissance
        // si l'age depasse AGEMAX alors l'animal meurt
        public void vieillir (){
            age ++;
            masse *= facteurCroissance;
            if (age > getAgeMax()){
                mourir();
            }
        }

        @Override
        //indique ce que les proies et les prédateurs mangent
        public void manger(){
                if (estProie()){
                   setNourriture(herbe);
                }
                if(estPredateur()) {
                    setNourriture(individus);
                }
        }

        @Override
        //fait accoucher l'animal
        public Animal accoucher () {
            // instanciation du nouveau bébé en lion ou en Antilope;
            if (estProie()){
                return new Antilope(facteurCroissance);
            }
            else {
                return new Lion(facteurCroissance);
            }
        }
        @Override
        public void mourir () {
            vivant = false;
        }

        @Override
        public boolean estVivant () {
            return vivant;
        }

        @Override
        public boolean estMature () {
            return age >= getAgeMature();
        }

        @Override
        public void setProie ( boolean proie){this.proie = proie;}

        @Override
        public boolean estProie () {
            return proie;
        }

        @Override
        public boolean estPredateur(){
            return predateur;
        }
        @Override
        public void setPredateur( boolean predateur ){ // set animal mode to predator
            this.predateur = predateur;
        }

        @Override
        public double getMasse () {
            return masse;
        }

        @Override
        public void setMasse ( double masse){
            this.masse = masse;
        }

        @Override
        public void setAge ( int age){
            this.age = age;
        }
        @Override
        public int getAge () {
            return age;
        }

        @Override
        public int getAgeMax () {
            return AGEMAX;
        }

        @Override
        public int getAgeMature () {
            return ageMature;
        }
    }
