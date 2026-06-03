package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;


/**
 * Jeu simple dans lequel un personnage se déplace librement.
 */
public class JeuPerso implements Jeu {

    /**
     * Le personnage contrôlé par le joueur
     */

    private Personnage pj;
    private Labyrinthe labyrinthe;


    private Monstre monstre;

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


        monstre = new Monstre(
                labyrinthe.getSpawnMonstreX(),
                labyrinthe.getSpawnMonstreY()
        );
        gameOver = false;

    }

    @Override
    public void evoluer(Commande c) {
        boolean aBouge = pj.deplacer(c, labyrinthe);
        if (aBouge) {
            monstre.deplacer(labyrinthe);

        }
    }



    //future itération pour une fin de partie
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

    public Monstre getMonstre() {
        return monstre;
    }

    }