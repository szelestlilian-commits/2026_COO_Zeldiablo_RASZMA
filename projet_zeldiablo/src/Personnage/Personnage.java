package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

/**
 * Représente un personnage et sa position dans le jeu.
 */
public class Personnage {

    /** Coordonnée x du personnage (les colones) */
    private int x;

    /** Coordonnée y du personnage (les ligne) */
    private int y;

    /**
     * Construit un personnage positionné au centre d'une grille 10x10.
     */
    public Personnage() {
        this.x = 5;
        this.y = 5;
    }

    /**
     * Déplace le personnage en fonction de la commande utilisateur.
     * @param c la commande issue du moteur de jeu
     */
    public boolean deplacer(Commande c, Labyrinthe laby) {
        int ancienX = x;
        int ancienY = y;

        if (c.gauche && !laby.estMur(x - 1, y))
            x--;
        if (c.droite && !laby.estMur(x + 1, y))
            x++;
        if (c.haut && !laby.estMur(x, y - 1))
            y--;
        if (c.bas && !laby.estMur(x, y + 1))
            y++;

        return x != ancienX || y != ancienY;
    }

    /**
     * @return la coordonnée x du personnage
     */
    public int getX() {
        return x;
    }

    /**
     * @return la coordonnée y du personnage
     */
    public int getY() {
        return y;
    }
}
