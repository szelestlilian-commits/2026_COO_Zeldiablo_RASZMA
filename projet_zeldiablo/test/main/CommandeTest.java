package main;

import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {

    @Test
    public void testConstructeurParDefaut() {
        Commande cmd = new Commande();

        // Par défaut, les booléens sont initialisés à false en Java
        assertFalse(cmd.haut, "La commande haut doit être false par défaut.");
        assertFalse(cmd.bas, "La commande bas doit être false par défaut.");
        assertFalse(cmd.gauche, "La commande gauche doit être false par défaut.");
        assertFalse(cmd.droite, "La commande droite doit être false par défaut.");
    }

    @Test
    public void testConstructeurParCopie() {
        // Création et modification d'une commande initiale
        Commande cmdOriginale = new Commande();
        cmdOriginale.haut = true;
        cmdOriginale.droite = true;

        // Création de la copie
        Commande cmdCopie = new Commande(cmdOriginale);

        // Vérification que les valeurs ont bien été copiées
        assertTrue(cmdCopie.haut, "La copie devrait avoir 'haut' à true.");
        assertTrue(cmdCopie.droite, "La copie devrait avoir 'droite' à true.");
        assertFalse(cmdCopie.bas, "La copie devrait avoir 'bas' à false.");
        assertFalse(cmdCopie.gauche, "La copie devrait avoir 'gauche' à false.");

        // Vérification de l'indépendance des deux objets (modifier l'un ne modifie pas l'autre)
        cmdOriginale.haut = false;
        assertTrue(cmdCopie.haut, "La copie doit rester indépendante de l'originale après la copie.");
    }
}