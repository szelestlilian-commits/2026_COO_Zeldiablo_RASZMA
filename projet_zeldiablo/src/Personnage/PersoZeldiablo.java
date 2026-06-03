package Personnage;

import Labyrinthe.Labyrinthe;

public abstract class PersoZeldiablo {

    protected int x;
    protected int y;

    public PersoZeldiablo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void deplacer(Labyrinthe laby);

    public int getX() { return x; }
    public int getY() { return y; }
}