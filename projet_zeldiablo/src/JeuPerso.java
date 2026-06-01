/**
 * Jeu simple dans lequel un personnage se déplace librement.
 * Implémente l'interface Jeu pour fonctionner avec le MoteurGraphique.
 */
public class JeuPerso implements Jeu {

    /** Le personnage contrôlé par le joueur */
    private Personnage pj;

    /**
     * Construit le jeu et initialise le personnage.
     */
    public JeuPerso() {
        this.pj = new Personnage();
    }

    @Override
    /**
     * Fait évoluer le jeu : déplace le personnage en fonction de la commande.
     * @param c commande utilisateur fournie par le moteur
     */
    public void evoluer(Commande c) {
        this.pj.deplacer(c);
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
}
