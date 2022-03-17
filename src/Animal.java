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


        @Override
        public void naitre () {// est ce que ou on dit age de depart et masse de depart???, parce que bebe = 0 ans
            public void naitre ( int age, double masse){
                // ajouter l<element
            }
        }

        @Override
        public void vieillir ( double masse, int age){
            this.age = age + 1;
            this.masse = masse * facteurCroissance;

        }

        @Override
        public void manger ( double masse){
            masseAManger = masse * 2; //PAS CERTAINE; preciser si antilope ou bien herbe que l'animal mange?


        }

        @Override
        public Animal accoucher () {

            return null;
        }

//        @Override
//        public void mourir () { // à modifier, mourir pour toutes les conditions? trop vieux, pas assez mangé...
//            if (age > AGEMAX) {
//            }
//            if
//
//        }

        @Override
        public boolean estVivant () {
            return false;
        } // a modifier

        @Override
        public boolean estMature () {
            if (age <= ageMature) {
                return false;
            }
        }

        @Override
        public void setProie ( boolean proie){
            this.proie = proie;
        }

        @Override
        public boolean estProie () {
            return proie;
        }
        //  estpredateur???

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
}