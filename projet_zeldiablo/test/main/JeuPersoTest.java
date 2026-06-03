package main;

import Personnage.JeuPerso;
import Personnage.Monstre;
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
        assertNotNull(jeu.getLabyrinthe(), "Le labyrinthe doit être initialisé.");
        assertNotNull(jeu.getPj(), "Le personnage joueur (pj) doit être initialisé.");
        assertNotNull(jeu.getMonstres(), "La liste des monstres doit être initialisée.");
        assertTrue(jeu.getMonstres().isEmpty(), "La liste des monstres devrait être vide au départ.");
    }

    @Test
    public void testEtreFini() {
        assertFalse(jeu.etreFini(), "Le jeu ne devrait jamais être fini dans cette version (etreFini retourne toujours false).");
    }

    @Test
    public void testEvoluerFaitBougerPjEtMonstres() {
        // On récupère la position initiale du héros
        int xInitial = jeu.getPj().getX();
        int yInitial = jeu.getPj().getY();

        // On ajoute artificiellement un monstre pour tester la cascade de mouvements
        // On le place un peu plus loin pour qu'il ne bloque pas le héros
        Monstre monstreTest = new Monstre(xInitial + 2, yInitial + 2);
        jeu.getMonstres().add(monstreTest);
        int mXInitial = monstreTest.getX();
        int mYInitial = monstreTest.getY();

        // On crée une commande valide (aller à droite)
        Commande cmd = new Commande();
        cmd.droite = true;

        // On fait évoluer le jeu
        jeu.evoluer(cmd);

        // Vérifications
        assertNotEquals(xInitial, jeu.getPj().getX(), "Le héros aurait dû bouger en X.");

        // Puisque le héros a bougé (aBouge = true), le monstre a dû bouger pour se rapprocher
        boolean monstreABouge = (mXInitial != monstreTest.getX()) || (mYInitial != monstreTest.getY());
        assertTrue(monstreABouge, "Le monstre aurait dû se déplacer car le héros a bougé.");
    }

    @Test
    public void testEvoluerMurEmpecheMouvementMonstres() {
        // On ajoute un monstre
        Monstre monstreTest = new Monstre(3, 3);
        jeu.getMonstres().add(monstreTest);
        int mXInitial = monstreTest.getX();
        int mYInitial = monstreTest.getY();

        // On crée une commande vide (le joueur ne touche à rien) ou une commande qui va dans un mur.
        // Ici, pas de touche = pas de mouvement.
        Commande cmdVide = new Commande();

        // On fait évoluer le jeu
        jeu.evoluer(cmdVide);

        // Le héros n'a pas bougé, donc aBouge est false, donc la boucle des monstres ne s'exécute pas.
        assertEquals(mXInitial, monstreTest.getX(), "Le monstre ne doit pas bouger si le héros ne bouge pas.");
        assertEquals(mYInitial, monstreTest.getY(), "Le monstre ne doit pas bouger si le héros ne bouge pas.");
    }
}