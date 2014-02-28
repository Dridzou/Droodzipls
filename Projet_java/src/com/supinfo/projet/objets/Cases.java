package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */
public class Cases
{
    public char statut;  //Case vide : " ", Mur : "=", Caisse : "B", Joueur : "X", Cible : "O", Caisse sur cible : "8"

    public Cases(char statut)
    {
        this.statut = statut;
    }

    int changeStatut(char newStatut)
    {
        return this.statut = newStatut;
    }

    public char getStatut()
    {
        return statut;
    }

    public void setStatut(char statut)
    {
        this.statut = statut;
    }
}