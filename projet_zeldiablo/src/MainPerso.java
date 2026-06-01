import moteurJeu.MoteurGraphique;

public class MainPerso {
    JeuPerso jeu = new JeuPerso();
    DessinPerso dessin = new DessinPerso(jeu);
    MoteurGraphique m = new MoteurGraphique(jeu, dessin);
}
