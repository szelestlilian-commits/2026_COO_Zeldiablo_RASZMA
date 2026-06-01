package Labyrinthe;

import java.util.Random;

public class Labyrinthe {

    public static final int LARGEUR = 30;
    public static final int HAUTEUR = 30;

    private boolean[][] mur;  // attribut direct

    public Labyrinthe() {
        mur = new boolean[LARGEUR][HAUTEUR];

        // murs sur les bordures
        for (int x = 0; x < LARGEUR; x++) {
            mur[x][0] = true;
            mur[x][HAUTEUR - 1] = true;
        }
        for (int y = 0; y < HAUTEUR; y++) {
            mur[0][y] = true;
            mur[LARGEUR - 1][y] = true;
        }
    }

    public boolean estMur(int x, int y) {
        return mur[x][y];
    }

    /**
     * Place un certain nombre de murs aléatoirement sur les cases intérieures de la carte.
     * @param nombre
     */
    public void placerMursAleatoires(int nombre){
        Random random = new Random();
        int places = 0;

        while (places < nombre){
            int x = 1 + random.nextInt(LARGEUR - 2);
            int y = 1 + random.nextInt(HAUTEUR - 2);

            //on évite de spawn sur le perso
            if (!mur[x][y] && !(x==5 && y==5)){
                mur[x][y] = true;
                places++;
            }
        }
    }
}