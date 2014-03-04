package com.supinfo.projet.main;

/**
 * Created by Hugo on 25/02/14.
 */

import com.supinfo.projet.objets.Cases;
import com.supinfo.projet.objets.Joueur;
import com.supinfo.projet.objets.Plateau;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.omg.DynamicAny._DynEnumStub;

import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Projet de Java");
        System.out.println();

        int[] tabVar = new int [5];
        int numLvl = 1;
        int nbrLign2 = 0;
        int nbMouv = 0;


        Cases[][] gameMap = new Cases[20][20];
        Plateau currentLvl = new Plateau();
        Joueur player = new Joueur(tabVar[0],tabVar[1]);

        tabVar = currentLvl.loadMap(gameMap, numLvl);

        System.out.println("\tLevel " + numLvl);
        while(numLvl < 13)
        {
            while ((tabVar[2] != tabVar[3]))
            {

                currentLvl.displayMap(gameMap);
                System.out.println();
                player.MouvScan(gameMap, tabVar);
                nbMouv++;

                if(tabVar[4] == 1)
                {
                    tabVar = currentLvl.loadMap(gameMap, numLvl);
                    numLvl = 0;
                }
            }
            if((tabVar[2] == tabVar[3]) && (numLvl < 13))
            {
                numLvl++;
                System.out.println("\n\tYOU WIN !\n");
                System.out.println(nbMouv + " mouvement réalisés.\n");
                nbMouv = 0;
                System.out.println("\tLevel " + numLvl);
            }
            if(numLvl < 13)
            {
                tabVar = currentLvl.loadMap(gameMap, numLvl);
            }

        }

        System.out.println("Vous avez fini le jeu, bravo !");

    }
}