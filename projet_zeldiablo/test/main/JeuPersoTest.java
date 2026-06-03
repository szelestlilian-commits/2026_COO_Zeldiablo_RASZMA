package main;

import Personnage.JeuPerso;
import moteurJeu.Commande;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JeuPersoTest {

    private JeuPerso jeu;

    @BeforeEach
    public void setUp() {
        jeu = new JeuPerso();
    }

    @Test
    public void testInitialisation() {
        assertNotNull(jeu.getLabyrinthe(),
                "Le labyrinthe doit être initialisé.");

        assertNotNull(jeu.getPj(),
                "Le joueur doit être initialisé.");

        assertNotNull(jeu.getMonstre(),
                "Le monstre doit être initialisé.");

        assertFalse(jeu.isGameOver(),
                "La partie ne doit pas être terminée au démarrage.");
    }

    @Test
    public void testEtreFini() {
        assertFalse(
                jeu.etreFini(),
                "etreFini() doit retourner false."
        );
    }

    @Test
    public void testEvoluerSansCommande() {
        int xHero = jeu.getPj().getX();
        int yHero = jeu.getPj().getY();

        int xMonstre = jeu.getMonstre().getX();
        int yMonstre = jeu.getMonstre().getY();

        Commande cmd = new Commande();

        jeu.evoluer(cmd);

        assertEquals(xHero, jeu.getPj().getX());
        assertEquals(yHero, jeu.getPj().getY());

        assertEquals(xMonstre, jeu.getMonstre().getX());
        assertEquals(yMonstre, jeu.getMonstre().getY());
    }

    @Test
    public void testDeplacementDroite() {
        int xInitial = jeu.getPj().getX();

        Commande cmd = new Commande();
        cmd.droite = true;

        jeu.evoluer(cmd);

        assertTrue(
                jeu.getPj().getX() >= xInitial,
                "Le héros ne doit pas reculer lorsqu'on demande un déplacement à droite."
        );
    }

    @Test
    public void testMonstreExisteToujoursApresEvolution() {
        Commande cmd = new Commande();
        cmd.droite = true;

        jeu.evoluer(cmd);

        assertNotNull(
                jeu.getMonstre(),
                "Le monstre doit toujours exister après une évolution."
        );
    }

    @Test
    public void testLabyrintheExisteToujoursApresEvolution() {
        Commande cmd = new Commande();
        cmd.droite = true;

        jeu.evoluer(cmd);

        assertNotNull(
                jeu.getLabyrinthe(),
                "Le labyrinthe doit toujours exister après une évolution."
        );
    }
}