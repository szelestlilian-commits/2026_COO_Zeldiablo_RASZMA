package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Jeu simple dans lequel un personnage se déplace librement.
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

        labyrinthe = new Labyrinthe();

        pj = new Personnage(
                labyrinthe.getSpawnHeroX(),
                labyrinthe.getSpawnHeroY()
        );

        monstres = new ArrayList<>();
    }

    @Override
    public void evoluer(Commande c) {

        boolean aBouge = pj.deplacer(c, labyrinthe);

        if (aBouge) {
            for (Monstre m : monstres) {
                m.deplacer(pj, labyrinthe, monstres);
            }
        }
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Personnage getPj() {
        return pj;
    }

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public List<Monstre> getMonstres() {
        return monstres;
    }
}