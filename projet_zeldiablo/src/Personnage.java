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
    public void deplacer(Commande c) {
        if (c.gauche) {
            this.x--;
        }
        if (c.droite) {
            this.x++;
        }
        if (c.haut) {
            this.y--;
        }
        if (c.bas) {
            this.y++;
        }
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
