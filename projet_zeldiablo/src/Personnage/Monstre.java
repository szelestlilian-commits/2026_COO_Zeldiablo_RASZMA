package Personnage;

import Labyrinthe.Labyrinthe;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monstre extends PersoZeldiablo {

    private static final Random random = new Random();

    public Monstre(int x, int y) {
        super(x, y);
    }

    @Override
    public void deplacer(Labyrinthe laby) {
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        List<int[]> possibles = new ArrayList<>();
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (!laby.estMur(nx, ny)) {
                possibles.add(new int[]{nx, ny});
            }
        }

        if (!possibles.isEmpty()) {
            int[] choix = possibles.get(random.nextInt(possibles.size()));
            x = choix[0];
            y = choix[1];
        }
    }
}