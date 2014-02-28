package com.supinfo.projet.main;

/**
 * Created by Hugo on 25/02/14.
 */

import com.supinfo.projet.objets.Cases;
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

        int nbrLign2 =0;
        Plateau currentLvl = new Plateau();

        currentLvl.loadMap( gameMap);
        currentLvl.displayMap(gameMap);
    }
}