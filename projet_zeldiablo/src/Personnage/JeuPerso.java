package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

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
    public JeuPerso() {
        this.labyrinthe = new Labyrinthe();
        this.labyrinthe.placerMursAleatoires(100);
        this.pj = new Personnage();
        this.monstres = new ArrayList<>();

        monstres.add(new Monstre(1, 1));
        monstres.add(new Monstre(8, 1));
        monstres.add(new Monstre(1, 8));
        monstres.add(new Monstre(8, 8));

        for (Monstre m : monstres) {
            m.deplacer(pj, labyrinthe);
        }
    }

    @Override
    /**
     * Fait évoluer le jeu : déplace le personnage en fonction de la commande.
     * @param c commande utilisateur fournie par le moteur
     */
    public void evoluer(Commande c) {
        pj.deplacer(c, labyrinthe);
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
