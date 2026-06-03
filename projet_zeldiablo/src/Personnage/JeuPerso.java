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
    private Personnage pj;
    private Labyrinthe labyrinthe;
    private List<Monstre> monstres;
    private boolean gameOver = false;

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
        monstres.add(new Monstre(1, 1));
        monstres.add(new Monstre(13, 1));
        monstres.add(new Monstre(1, 13));

        gameOver = false;
    }

    @Override
    public void evoluer(Commande c) {
        if (gameOver) return;  // on gèle le jeu si c'est terminé
        boolean aBouge = pj.deplacer(c, labyrinthe);
        if (aBouge) {
            for (Monstre m : monstres) {
                m.deplacer(labyrinthe, monstres);  // ← nouvelle signature sans heros
                if (m.toucheHeros(pj)) {
                    gameOver = true;
                    return;
                }
            }
        }
    }
    }

    @Override
    public boolean etreFini() {
        return gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
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