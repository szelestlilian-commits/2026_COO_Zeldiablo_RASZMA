package main;

import Labyrinthe.Labyrinthe;
import Personnage.Personnage;
import moteurJeu.Commande;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnageTest {

    private Labyrinthe laby;
    private Personnage pj;
    private Commande cmd;

    @BeforeEach
    public void setUp() {
        laby = new Labyrinthe();
        pj = new Personnage(5, 5); // On place le personnage en 5,5 (libre)
        cmd = new Commande();
    }

    @Test
    public void testDeplacementNormal() {
        cmd.droite = true;
        boolean aBouge = pj.deplacer(cmd, laby);

        assertTrue(aBouge, "Le personnage aurait dû bouger.");
        assertEquals(6, pj.getX(), "Le X devrait avoir augmenté de 1.");
        assertEquals(5, pj.getY(), "Le Y n'aurait pas dû changer.");
    }

    @Test
    public void testCollisionMur() {
        // On place le personnage juste à côté du mur de gauche (x=1)
        pj = new Personnage(1, 5);
        cmd.gauche = true; // On essaie d'aller dans le mur (x=0)

        boolean aBouge = pj.deplacer(cmd, laby);

        assertFalse(aBouge, "Le personnage ne doit pas pouvoir bouger dans un mur.");
        assertEquals(1, pj.getX(), "Le X doit rester le même.");
    }

    @Test
    public void testDeplacementDiagonaleEmpecheParLeCode() {
        // Avec votre code, si haut et droite sont à true, il gère l'un après l'autre
        cmd.haut = true;
        cmd.droite = true;

        pj.deplacer(cmd, laby);

        assertEquals(6, pj.getX(), "Il s'est déplacé à droite.");
        assertEquals(4, pj.getY(), "Il s'est déplacé en haut.");
    }
}