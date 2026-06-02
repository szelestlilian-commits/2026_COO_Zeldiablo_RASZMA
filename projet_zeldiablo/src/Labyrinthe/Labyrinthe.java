package Labyrinthe;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Labyrinthe {

    private boolean[][] mur;
    private int spawnHeroX;
    private int spawnHeroY;


    public Labyrinthe(String fichier) throws IOException{

        List<String> lignes = Files.readAllLines(Paths.get(fichier));

        int Hauteur = lignes.size();
        int Largeur = lignes.get(0).length();

        mur = new boolean[Largeur][Hauteur];

        for(int y = 0; y < Hauteur; y++){
            String ligne = lignes.get(y);

            for (int x = 0; x < Largeur; x++){
                char c = ligne.charAt(x);

                switch (c){
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
    public int getSpawnHeroX() {
        return spawnHeroX;
    }

    public int getSpawnHeroY() {
        return spawnHeroY;
    }

    public boolean estMur(int x, int y) {
        return mur[x][y];
    }


}