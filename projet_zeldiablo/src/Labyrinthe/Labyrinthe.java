package Labyrinthe;

public class Labyrinthe {

    public static final int LARGEUR = 15;
    public static final int HAUTEUR = 15;

    private boolean[][] mur;

    private int spawnHeroX;
    private int spawnHeroY;

    public Labyrinthe() {

        mur = new boolean[LARGEUR][HAUTEUR];

        // Murs sur les bordures
        for (int x = 0; x < LARGEUR; x++) {
            mur[x][0] = true;
            mur[x][HAUTEUR - 1] = true;
        }

        for (int y = 0; y < HAUTEUR; y++) {
            mur[0][y] = true;
            mur[LARGEUR - 1][y] = true;
        }

        // Héros au centre
        spawnHeroX = LARGEUR / 2;
        spawnHeroY = HAUTEUR / 2;
    }

    /**
     * Retourne true si la case est un mur.
     */
    public boolean estMur(int x, int y) {

        // Hors limites = mur
        if (x < 0 || x >= LARGEUR || y < 0 || y >= HAUTEUR) {
            return true;
        }

        return mur[x][y];
    }

    public int getSpawnHeroX() {
        return spawnHeroX;
    }

    public int getSpawnHeroY() {
        return spawnHeroY;
    }
}