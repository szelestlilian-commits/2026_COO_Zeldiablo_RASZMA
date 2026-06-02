package main;

import Personnage.JeuPerso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JeuPersoTest {

    @Test
    public void testInitialisationJeu() {
        JeuPerso jeu = new JeuPerso();

        assertNotNull(jeu.getPj(), "Le personnage doit être initialisé");
        assertNotNull(jeu.getLabyrinthe(), "Le labyrinthe doit être initialisé");
    }

    @Test
    public void testJeuJamaisFini() {
        JeuPerso jeu = new JeuPerso();

        assertFalse(jeu.etreFini(), "Dans cette version, le jeu ne doit jamais se terminer");
    }
}