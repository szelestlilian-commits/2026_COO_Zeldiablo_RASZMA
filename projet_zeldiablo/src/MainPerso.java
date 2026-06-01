import moteurJeu.MoteurGraphique;

public class MainPerso {
    JeuPerso jeu = new JeuPerso();
    DessinPerso dessin = new DessinPerso(jeu);
    MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
    moteur.lancerJeu(400, 400);
}
