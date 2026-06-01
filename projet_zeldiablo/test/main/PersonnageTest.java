package main;

import Labyrinthe.Labyrinthe;
import Personnage.Personnage;
import moteurJeu.Commande;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnageTest {

    private Personnage personnage;
    private Labyrinthe labyrinthe;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage();
        labyrinthe = new Labyrinthe();
    }

    @Test
    public void testConstructeur_positionInitiale() {
        assertEquals(5, personnage.getX());
        assertEquals(5, personnage.getY());
    }

    @Test
    public void testDeplacer_versGauche() {
        Commande c = new Commande();
        c.gauche = true;
        int xAvant = personnage.getX();
        personnage.deplacer(c, labyrinthe);
        assertEquals(xAvant - 1, personnage.getX());
    }

    @Test
    public void testDeplacer_versDroite() {
        Commande c = new Commande();
        c.droite = true;
        int xAvant = personnage.getX();
        personnage.deplacer(c, labyrinthe);
        assertEquals(xAvant + 1, personnage.getX());
    }

    @Test
    public void testDeplacer_versHaut() {
        Commande c = new Commande();
        c.haut = true;
        int yAvant = personnage.getY();
        personnage.deplacer(c, labyrinthe);
        assertEquals(yAvant - 1, personnage.getY());
    }

    @Test
    public void testDeplacer_versBas() {
        Commande c = new Commande();
        c.bas = true;
        int yAvant = personnage.getY();
        personnage.deplacer(c, labyrinthe);
        assertEquals(yAvant + 1, personnage.getY());
    }

    @Test
    public void testDeplacer_sansCommande_resterEnPlace() {
        Commande c = new Commande();
        int xAvant = personnage.getX();
        int yAvant = personnage.getY();
        personnage.deplacer(c, labyrinthe);
        assertEquals(xAvant, personnage.getX());
        assertEquals(yAvant, personnage.getY());
    }

    @Test
    public void testDeplacer_blocageParMurGauche() {
        // Placer le personnage contre le bord gauche (x=1, le mur est en x=0)
        Commande c = new Commande();
        c.gauche = true;
        // On déplace jusqu'à x=1
        while (personnage.getX() > 1) {
            personnage.deplacer(c, labyrinthe);
        }
        // Maintenant x=1, tenter d'aller à gauche => mur en x=0 => bloqué
        personnage.deplacer(c, labyrinthe);
        assertEquals(1, personnage.getX(), "Le personnage ne doit pas traverser le mur gauche");
    }

    @Test
    public void testDeplacer_blocageParMurHaut() {
        Commande c = new Commande();
        c.haut = true;
        while (personnage.getY() > 1) {
            personnage.deplacer(c, labyrinthe);
        }
        personnage.deplacer(c, labyrinthe);
        assertEquals(1, personnage.getY(), "Le personnage ne doit pas traverser le mur haut");
    }

    @Test
    public void testDeplacer_blocageParMurBas() {
        Commande c = new Commande();
        c.bas = true;
        while (personnage.getY() < Labyrinthe.HAUTEUR - 2) {
            personnage.deplacer(c, labyrinthe);
        }
        personnage.deplacer(c, labyrinthe);
        assertEquals(Labyrinthe.HAUTEUR - 2, personnage.getY(), "Le personnage ne doit pas traverser le mur bas");
    }

    @Test
    public void testDeplacer_blocageParMurDroite() {
        Commande c = new Commande();
        c.droite = true;
        while (personnage.getX() < Labyrinthe.LARGEUR - 2) {
            personnage.deplacer(c, labyrinthe);
        }
        personnage.deplacer(c, labyrinthe);
        assertEquals(Labyrinthe.LARGEUR - 2, personnage.getX(), "Le personnage ne doit pas traverser le mur droit");
    }

    @Test
    public void testDeplacer_YNeBougePasAvecCommandeGauche() {
        Commande c = new Commande();
        c.gauche = true;
        int yAvant = personnage.getY();
        personnage.deplacer(c, labyrinthe);
        assertEquals(yAvant, personnage.getY(), "Y ne doit pas changer avec une commande gauche");
    }

    @Test
    public void testDeplacer_XNeBougePasAvecCommandeHaut() {
        Commande c = new Commande();
        c.haut = true;
        int xAvant = personnage.getX();
        personnage.deplacer(c, labyrinthe);
        assertEquals(xAvant, personnage.getX(), "X ne doit pas changer avec une commande haut");
    }
}