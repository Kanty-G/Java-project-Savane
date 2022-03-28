// Fichier :     Animal.java
// Création:     
// Auteurs :      
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

    // TO BE COMPLETED //

abstract class Animal implements ProiePredateur {
        protected int age = 0;
        protected int ageMature;
        protected boolean proie;
        protected double facteurCroissance;
        protected double masse = 10;
        protected int AGEMAX;
        protected double masseAManger;
        protected boolean vivant;
        protected boolean predateur;
        protected Herbe herbe;
        protected ArrayList<Animal> individus;

        public void  setNourriture(Herbe nourriture){

        }
        public void setNourriture(ArrayList<Animal> nourriture){

        }

        @Override
        public void naitre () {
            vivant = true;
        }

        @Override
        public void vieillir (){
            age ++;
            masse *= facteurCroissance;
            if (age > getAgeMax()){
                mourir();
            }
        }

        @Override
        public void manger(){ // besoin savoir se que tu mange , la quantite et l<actualise
                if (estProie()){
                   setNourriture(herbe);
                }
                if(estPredateur()) {
                    setNourriture(individus);
                }
        }

        @Override
        public Animal accoucher () {

            if (estProie()){
                Animal bebeAntilope= new Antilope(facteurCroissance);
               bebeAntilope.naitre();
               return bebeAntilope;
            }
            else {
                Animal bebeLion = new Lion(facteurCroissance);
                bebeLion.naitre();
                return bebeLion;
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
        public void setProie ( boolean proie){

            this.proie = proie;
        }

        @Override
        public boolean estProie () {
            return proie;
        }

        @Override
        public boolean estPredateur(){
            return predateur;
        }
        @Override
        public void setPredateur( boolean predateur ){// set animal mode to predator
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
