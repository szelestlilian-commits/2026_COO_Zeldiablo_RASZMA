package Personnage;

import moteurJeu.MoteurGraphique;

import java.io.IOException;

public class MainPerso {
    public static void main(String[] args) throws InterruptedException, IOException {
    JeuPerso jeu = new JeuPerso();
    DessinPerso dessin = new DessinPerso(jeu);
    MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
        moteur.lancerJeu(450, 450);
    }
}
