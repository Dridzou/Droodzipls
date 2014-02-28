package com.supinfo.projet.objets;

/**
 * Created by Hugo on 27/02/14.
 */
public class Cases
{
    public String statut = " ";  //Case vide : " ", Mur : "=", Caisse : "B", Joueur : "X", Cible : "O", Caisse sur cible : "8"

    public Cases(String statut)
    {
        this.statut = statut;
    }

    String changeStatut(String newStatut)
    {
        return this.statut = newStatut;
    }

    public String getStatut()
    {
        return statut;
    }

    public void setStatut(String statut)
    {
        this.statut = statut;
    }



}