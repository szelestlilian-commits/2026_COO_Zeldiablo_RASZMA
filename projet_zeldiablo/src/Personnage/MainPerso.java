package Personnage;

import moteurJeu.MoteurGraphique;

public class MainPerso {
    public static void main(String[] args) throws InterruptedException {
    JeuPerso jeu = new JeuPerso();
    DessinPerso dessin = new DessinPerso(jeu);
    MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
        moteur.lancerJeu(450, 450);
    }
}
