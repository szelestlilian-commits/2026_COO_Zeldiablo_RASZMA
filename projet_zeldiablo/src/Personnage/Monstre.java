package Personnage;

import Labyrinthe.Labyrinthe;

import java.util.List;


/**
 * Représente un monstre qui se déplace vers le héros
 * en réduisant sa distance de Manhattan à chaque tour.
 */
public class Monstre {

    private int x;
    private int y;

    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Déplace le monstre vers le héros en choisissant parmi les 4 directions
     * celle qui minimise la distance de Manhattan, sans traverser les murs.
     * Si toutes les directions sont bloquées, le monstre reste sur place.
     *
     * @param heros     le personnage à pourchasser
     * @param labyrinthe la carte avec les murs
     */
    public void deplacer(Personnage heros, Labyrinthe labyrinthe, List<Monstre> monstres) {
        int distanceActuelle = distanceManhattan(heros);

        // Les 4 déplacements possibles : [dx, dy]
        int[][] directions = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

        int meilleurX = x;
        int meilleurY = y;
        int meilleureDist = distanceActuelle;

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // Vérifie qu'il n'y a pas de mur et que la case est dans la grille
            if (!labyrinthe.estMur(nx, ny) &&  !caseOccupee(nx, ny, monstres)) {
                int dist = Math.abs(nx - heros.getX()) + Math.abs(ny - heros.getY());
                if (dist < meilleureDist) {
                    meilleureDist = dist;
                    meilleurX = nx;
                    meilleurY = ny;
                }
            }
        }

        x = meilleurX;
        y = meilleurY;
    }

    /**
     * 
     * @param nx
     * @param ny
     * @param monstres
     * @return
     */
    private boolean caseOccupee(int nx, int ny, List<Monstre> monstres) {
        for (Monstre m : monstres) {
            if (m != this && m.getX() == nx && m.getY() == ny) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcule la distance de Manhattan entre ce monstre et le héros.
     */
    private int distanceManhattan(Personnage heros) {
        return Math.abs(x - heros.getX()) + Math.abs(y - heros.getY());
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
