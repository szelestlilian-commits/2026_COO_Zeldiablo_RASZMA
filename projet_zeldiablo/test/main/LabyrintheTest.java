package main;

import Labyrinthe.Labyrinthe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class  LabyrintheTest {

    @Test
    public void testInitialisationBordures() {
        Labyrinthe laby = new Labyrinthe();

        // Vérification des coins
        assertTrue(laby.estMur(0, 0), "Le coin haut-gauche doit être un mur.");
        assertTrue(laby.estMur(Labyrinthe.LARGEUR - 1, Labyrinthe.HAUTEUR - 1), "Le coin bas-droite doit être un mur.");

        // Vérification d'un point hors limites
        assertTrue(laby.estMur(-1, 5), "L'extérieur gauche doit être considéré comme un mur.");
        assertTrue(laby.estMur(5, Labyrinthe.HAUTEUR + 5), "L'extérieur bas doit être considéré comme un mur.");
    }

    @Test
    public void testEspaceLibreAuCentre() {
        Labyrinthe laby = new Labyrinthe();

        // Le point de spawn ne doit pas être un mur
        int spawnX = laby.getSpawnHeroX();
        int spawnY = laby.getSpawnHeroY();

        assertFalse(laby.estMur(spawnX, spawnY), "Le point d'apparition du héros ne doit pas être un mur.");
    }
}