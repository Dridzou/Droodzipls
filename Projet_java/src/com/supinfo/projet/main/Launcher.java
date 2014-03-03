package com.supinfo.projet.main;

/**
 * Created by Hugo on 25/02/14.
 */

import com.supinfo.projet.objets.Cases;
import com.supinfo.projet.objets.Joueur;
import com.supinfo.projet.objets.Plateau;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.Scanner;
import java.io.*;


public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Projet de Java");
        System.out.println();
        Cases[][] gameMap = new Cases[20][20];
        int[] tabCoord = new int [2];
        boolean win = false;
        int nbrLign2 = 0;
        Plateau currentLvl = new Plateau();

        tabCoord = currentLvl.loadMap(gameMap);

        Joueur player = new Joueur(tabCoord[0],tabCoord[1]);

        while (win == false)
        {
            currentLvl.displayMap(gameMap);
            //splayer.input();
            player.MouvScan(gameMap,tabCoord);
        }


        //System.out.println();
        player.MouvScan(gameMap,tabCoord);
    }
}