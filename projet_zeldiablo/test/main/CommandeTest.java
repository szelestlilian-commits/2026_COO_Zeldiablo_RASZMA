package main;

import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {

    @Test
    public void testConstructeurCopie() {
        Commande cmdOriginale = new Commande();
        cmdOriginale.haut = true;
        cmdOriginale.droite = true;

        Commande cmdCopie = new Commande(cmdOriginale);

        assertTrue(cmdCopie.haut, "La copie doit avoir 'haut' à true");
        assertTrue(cmdCopie.droite, "La copie doit avoir 'droite' à true");
        assertFalse(cmdCopie.bas, "La copie doit avoir 'bas' à false");
        assertFalse(cmdCopie.gauche, "La copie doit avoir 'gauche' à false");
    }
}