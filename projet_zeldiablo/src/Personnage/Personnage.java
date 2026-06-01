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
    public void deplacer(Commande c, Labyrinthe laby) {
        // c.gauche : si la touche gauche est appuyée et qu'il n'y a pas de mur à gauche, on enleve un a x.
        if (c.gauche && !laby.estMur(x - 1, y))
            x--;
        //c.droite : si la touche droite est appuyée et qu'il n'y a pas de mur à droite, on ajoute un a x.
        if (c.droite && !laby.estMur(x + 1, y))
            x++;
        //c.haut : si la touche haut est appuyée et qu'il n'y a pas de mur au-dessus, on on enleve un a y.
        if (c.haut && !laby.estMur(x, y - 1))
            y--;
        //c.bas : si la touche bas est appuyée et qu'il n'y a pas de mur en dessous, on ajoute un a y.
        if (c.bas && !laby.estMur(x, y + 1))
            y++;
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
