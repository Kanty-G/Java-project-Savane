// Fichier :     Animal.java
// Création:     
// Auteurs :      
//
// Ce code n'est pas protégé par un copyright.
// 
// Historique :
//  Créé pour le cours IFT1025 H22
//

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


        @Override
        public void naitre () {
            vivant = true;
        }

        @Override
        public void vieillir (){

            age = age + 1;
            masse = masse * facteurCroissance; //
            if (age > getAgeMax()){
                mourir();

            }

        }

        @Override
        public void manger(){ // besoin savoir se que tu mange , la quanite et l<actualise
            masseAManger = masse * 2; // REVOIR MARCHE PAS defenir dans lion et antilope
        }

        @Override
        public Animal accoucher () {
            // TODO:faire
            return null;
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
            if (age < getAgeMature()) {
                return false;
            } return true;
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
        public void setPredateur(boolean predateur){
            this.predateur = predateur;
        }

        @Override
        public boolean estPredateur(){
            return predateur;
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
