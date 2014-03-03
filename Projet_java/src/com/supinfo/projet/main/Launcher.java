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
        int[] tabVar = new int [5];
        int verifReset = 0;
        int nbrLign2 = 0;
        Plateau currentLvl = new Plateau();

        tabVar = currentLvl.loadMap(gameMap);

        Joueur player = new Joueur(tabVar[0],tabVar[1]);


        while ((tabVar[2] != tabVar[3]))
        {
            currentLvl.displayMap(gameMap);
            player.MouvScan(gameMap,tabVar);

            if(tabVar[4] == 1)
            {
                tabVar = currentLvl.loadMap(gameMap);
            }
        }
        System.out.println("YOU WIN MOFO");
    }
}