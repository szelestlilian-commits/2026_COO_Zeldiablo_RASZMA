package Labyrinthe;

public class Labyrinthe {

    public static final int LARGEUR = 15;
    public static final int HAUTEUR = 15;

    private boolean[][] mur;

    private int spawnHeroX;
    private int spawnHeroY;

    private final String[] PLAN = {
            "###############",
            "#H....#.......#",
            "#.###.#.#####.#",
            "#...#.#.....#.#",
            "###.#.#####.#.#",
            "#...#.....#.#.#",
            "#.#######.#.#.#",
            "#.......#.#...#",
            "#####.#.#.#####",
            "#.....#.#.....#",
            "#.#####.#####.#",
            "#.....#.......#",
            "#.###.#######.#",
            "#.............#",
            "###############"
    };

    public Labyrinthe() {

        mur = new boolean[LARGEUR][HAUTEUR];

        for (int y = 0; y < HAUTEUR; y++) {
            for (int x = 0; x < LARGEUR; x++) {

                char c = PLAN[y].charAt(x);
                switch (c) {
                    case '#':
                        mur[x][y] = true;
                        break;
                    case 'H':
                        spawnHeroX = x;
                        spawnHeroY = y;
                        break;
                }
            }
        }
    }

    public boolean estMur(int x, int y) {

        if (x < 0 || x >= LARGEUR ||
                y < 0 || y >= HAUTEUR) {
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