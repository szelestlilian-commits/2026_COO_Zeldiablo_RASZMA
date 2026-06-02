package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * moteurJeu.Jeu simple dans lequel un personnage se déplace librement.
 * Implémente l'interface moteurJeu.Jeu pour fonctionner avec le moteurJeu.MoteurGraphique.
 */
public class JeuPerso implements Jeu {

    /** Le personnage contrôlé par le joueur */
    private Personnage pj;
    private Labyrinthe labyrinthe;
    private List<Monstre> monstres;

    /**
     * Construit le jeu et initialise le personnage.
     */
    public JeuPerso() throws IOException {
        this.labyrinthe = new Labyrinthe("niveaux/niveau1.txt");
        this.pj = new Personnage(
                labyrinthe.getSpawnHeroX(),
                labyrinthe.getSpawnHeroY()
        );
    }

    @Override
    /**
     * Fait évoluer le jeu : déplace le personnage en fonction de la commande.
     * @param c commande utilisateur fournie par le moteur
     */
    public void evoluer(Commande c) {

        boolean aBouge = pj.deplacer(c, labyrinthe);

        if (aBouge) {
            for (Monstre m : monstres) {
                m.deplacer(pj, labyrinthe, monstres);
            }
        }
    }

    @Override
    /**
     * Le jeu ne se termine jamais dans cette version simple.
     * @return toujours false
     */
    public boolean etreFini() {
        return false;
    }

    /**
     * @return le personnage joueur
     */
    public Personnage getPj() {
        return pj;
    }


    public Labyrinthe getLabyrinthe() { return labyrinthe; }

    public List<Monstre> getMonstres() { return monstres; }
}
