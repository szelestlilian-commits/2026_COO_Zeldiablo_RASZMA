
import Labyrinthe.Labyrinthe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabyrintheTest {

    private Labyrinthe labyrinthe;

    @BeforeEach
    public void setUp() {
        labyrinthe = new Labyrinthe();
    }

    @Test
    public void testBordureHaute_estMur() {
        for (int x = 0; x < Labyrinthe.LARGEUR; x++) {
            assertTrue(labyrinthe.estMur(x, 0), "La bordure haute doit être un mur en x=" + x);
        }
    }

    @Test
    public void testBordureBasse_estMur() {
        for (int x = 0; x < Labyrinthe.LARGEUR; x++) {
            assertTrue(labyrinthe.estMur(x, Labyrinthe.HAUTEUR - 1), "La bordure basse doit être un mur en x=" + x);
        }
    }

    @Test
    public void testBordureGauche_estMur() {
        for (int y = 0; y < Labyrinthe.HAUTEUR; y++) {
            assertTrue(labyrinthe.estMur(0, y), "La bordure gauche doit être un mur en y=" + y);
        }
    }

    @Test
    public void testBordureDroite_estMur() {
        for (int y = 0; y < Labyrinthe.HAUTEUR; y++) {
            assertTrue(labyrinthe.estMur(Labyrinthe.LARGEUR - 1, y), "La bordure droite doit être un mur en y=" + y);
        }
    }

    @Test
    public void testCentreLibre_pasUnMur() {
        // La case centrale ne doit pas être un mur
        int centreX = Labyrinthe.LARGEUR / 2;
        int centreY = Labyrinthe.HAUTEUR / 2;
        assertFalse(labyrinthe.estMur(centreX, centreY));
    }

    @Test
    public void testCaseInterieure_pasUnMur() {
        // Quelques cases intérieures ne doivent pas être des murs
        assertFalse(labyrinthe.estMur(5, 5));
        assertFalse(labyrinthe.estMur(10, 10));
        assertFalse(labyrinthe.estMur(1, 1));
    }

    @Test
    public void testConstantes_dimensionsCorrectes() {
        assertEquals(30, Labyrinthe.LARGEUR);
        assertEquals(30, Labyrinthe.HAUTEUR);
    }

    @Test
    public void testCoins_sontDesMurs() {
        assertTrue(labyrinthe.estMur(0, 0));
        assertTrue(labyrinthe.estMur(Labyrinthe.LARGEUR - 1, 0));
        assertTrue(labyrinthe.estMur(0, Labyrinthe.HAUTEUR - 1));
        assertTrue(labyrinthe.estMur(Labyrinthe.LARGEUR - 1, Labyrinthe.HAUTEUR - 1));
    }
}