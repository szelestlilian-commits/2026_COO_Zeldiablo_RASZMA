package Personnage;

import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

public class Personnage extends PersoZeldiablo {

    public Personnage(int x, int y) {
        super(x, y);
    }

    @Override
    public void deplacer(Labyrinthe laby) {}

    public boolean deplacer(Commande c, Labyrinthe laby) {
        int ancienX = x;
        int ancienY = y;

        if (c.gauche  && !laby.estMur(x - 1, y))
            x--;
        if (c.droite  && !laby.estMur(x + 1, y))
            x++;
        if (c.haut    && !laby.estMur(x, y - 1))
            y--;
        if (c.bas     && !laby.estMur(x, y + 1))
            y++;

        return x != ancienX || y != ancienY;
    }
}