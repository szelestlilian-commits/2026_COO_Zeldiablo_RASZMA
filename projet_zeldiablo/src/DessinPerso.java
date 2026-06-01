import moteurJeu.DessinJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



public class DessinPerso implements DessinJeu {

    public static final int TAILLE = 40;

    private JeuPerso jeuEnCours;

    public DessinPerso(JeuPerso jeuPerso){
        this.jeuEnCours = jeuPerso;
    }

    public void dessiner(BufferedImage image){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

        Personnage pj = this.jeuEnCours.getPj();
        g.setColor(Color.BLUE);
        g.fillOval(pj.getX() * TAILLE, pj.getY() * TAILLE, TAILLE, TAILLE);

        g.dispose();
    }
}
