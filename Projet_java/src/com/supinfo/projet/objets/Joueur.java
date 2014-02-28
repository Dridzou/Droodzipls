package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */
public class Joueur
{
    public int coordx;
    public int coordy;

    public Joueur(int coordx, int coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
    }

    public int getCoordx() {
        return coordx;
    }

    public void setCoordx(int coordx) {
        this.coordx = coordx;
    }

    public int getCoordy() {
        return coordy;
    }

    public void setCoordy(int coordy) {
        this.coordy = coordy;
    }
}
