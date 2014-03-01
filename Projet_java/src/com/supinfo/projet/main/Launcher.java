package com.supinfo.projet.main;

/**
 * Created by Hugo on 25/02/14.
 */

import com.supinfo.projet.objets.Cases;
import com.supinfo.projet.objets.Joueur;
import com.supinfo.projet.objets.Plateau;

import java.io.*;
import java.util.Scanner;
import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Projet de Java");
        System.out.println();
        Cases[][] gameMap = new Cases[20][20];
        int[] tabCoord = new int [2];

        int nbrLign2 =0;
        Plateau currentLvl = new Plateau();

        tabCoord = currentLvl.loadMap( gameMap);

        Joueur player = new Joueur(tabCoord[0],tabCoord[1]);

        currentLvl.displayMap(gameMap);

        player.input();
    }
}